package com.jysh.tetris.controller;

import com.jysh.tetris.model.TetraBoard;
import com.jysh.tetris.view.TetrisJPanel;

import static com.jysh.tetris.model.tetra.Board.BOARD_WIDTH;
import static com.jysh.tetris.model.tetra.Board.BOARD_HEIGHT;
import static com.jysh.tetris.view.TetrisJPanel.CELL_SIZE;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TetraBoardController {
    public static final int AUTO_DOWN_TIME = 500;

    private TetraBoard tetraBoard;

    private Timer updateUITimer;
    private Timer autoMoveDownTimer;
    private int autoMoveDownTime;
    
    KeyAdapter keyProcessor;
    TetrisJPanel tetrisJPanel;
    JFrame tetrisJFrame;

    public void start(){
        tetraBoard = new TetraBoard();
        tetrisJPanel.setTetraBoard(tetraBoard);

        autoMoveDownTimer.start();
        updateUITimer.start();
    }

    public void init(){
        tetrisJFrame = new JFrame("tetris");
        tetrisJPanel = new TetrisJPanel();
        tetrisJFrame.add(tetrisJPanel);
        tetrisJPanel.setPreferredSize(
                new Dimension((BOARD_WIDTH + 10) * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE));
        
        keyProcessor = new MyKeyAdapter();
        tetrisJFrame.addKeyListener(keyProcessor);

        tetrisJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tetrisJFrame.pack();
        tetrisJFrame.setVisible(true);

        updateUITimer = new Timer((int)(1000 / 60), new updateUIActionListener());

        autoMoveDownTime = AUTO_DOWN_TIME;
        autoMoveDownTimer = new Timer(autoMoveDownTime, new autoDownActionListener());

        this.start();
    }

    class autoDownActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tetraBoard.setTetraMoveDown();
        }
    }

    class updateUIActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tetrisJPanel.updateUI();
        }
    }

    class MyKeyAdapter extends KeyAdapter{

        public void keyPressed(KeyEvent ke){

            if(ke.getKeyCode() == KeyEvent.VK_UP){
                tetraBoard.setTetraRotateRight();
            }
            if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
                tetraBoard.setTetraMoveRight();
            }
            if(ke.getKeyCode() == KeyEvent.VK_LEFT){
                tetraBoard.setTetraMoveLeft();
            }
            if(ke.getKeyCode() == KeyEvent.VK_DOWN){
                tetraBoard.setTetraMoveDown();
                autoMoveDownTimer.restart();
            }
        }
    }
}
