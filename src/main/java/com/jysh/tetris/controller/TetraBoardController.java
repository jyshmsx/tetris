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

/**
 * 控制整个俄罗斯方块游戏的进行
 * TODO 由于没实现加速下落功能，因此autoMoveDownTime变量显得没必要
 */
public class TetraBoardController {
    public static final int AUTO_DOWN_TIME = 500;       //最初的自动下落时间

    private TetraBoard tetraBoard;

    private Timer updateUITimer;
    private Timer autoMoveDownTimer;
    private int autoMoveDownTime;           //当前自动下落时间

    KeyAdapter keyProcessor;
    TetrisJPanel tetrisJPanel;
    JFrame tetrisJFrame;

    /**
     * 开始游戏，重置tetraBoard，启动updateUITimer，autoMoveDownTimer计时器
     */
    public void start(){
        tetraBoard = new TetraBoard();
        tetrisJPanel.setTetraBoard(tetraBoard);

        autoMoveDownTimer.start();
        updateUITimer.start();
    }

    /**
     * 初始化
     * 设置图形绘制
     * 初始化计时器
     */
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

    /**
     * 自动下落监听
     */
    class autoDownActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tetraBoard.setTetraMoveDown();
        }
    }

    /**
     * 自动更新ui监听
     */
    class updateUIActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            tetrisJPanel.updateUI();
        }
    }

    /**
     * 键盘监听
     */
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
