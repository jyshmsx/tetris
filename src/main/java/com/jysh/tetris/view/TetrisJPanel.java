package com.jysh.tetris.view;

import com.jysh.tetris.model.TetraBoard;

import javax.swing.*;
import java.awt.*;

import static com.jysh.tetris.model.tetra.Board.BOARD_HEIGHT;
import static com.jysh.tetris.model.tetra.Board.BOARD_WIDTH;

public class TetrisJPanel extends JPanel {

    public static final int CELL_SIZE = 20;

    private static final long serialVersionUID = 1L;

    private TetraBoard tetraBoard;

    private static final Color[] allColors = new Color[]{
            Color.gray, Color.red, Color.green, Color.PINK,
            Color.yellow, Color.orange, Color.MAGENTA, Color.BLUE
    };

    public void setTetraBoard(TetraBoard tetraBoard){
        this.tetraBoard = tetraBoard;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, BOARD_HEIGHT * CELL_SIZE,BOARD_WIDTH * CELL_SIZE);

        for (int i = 0; i < BOARD_WIDTH; i++) { // 画背景
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                if (tetraBoard.getBoard().getColorBoard(i, j) == 0) {
                    g.setColor(Color.white);
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    g.setColor(allColors[0]);
                    g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                } else {
                    g.setColor(allColors[tetraBoard.getBoard().getColorBoard(i, j)]);
                    g.fillRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    g.setColor((allColors[0]));
                    g.drawRect(i * CELL_SIZE, j * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            g.setColor(allColors[tetraBoard.getTetra().getColor()]);
            g.fillRect(tetraBoard.getTetra().getCubes()[i].getX() * CELL_SIZE,
                    tetraBoard.getTetra().getCubes()[i].getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
        }

        for (int i = 0; i < 4; i++) {
            g.setColor(allColors[tetraBoard.getNextTetra().getColor()]);
            g.fillRect((tetraBoard.getNextTetra().getCubes()[i].getX() + 10) * CELL_SIZE,
                    (tetraBoard.getNextTetra().getCubes()[i].getY() + 5) * CELL_SIZE,
                    CELL_SIZE, CELL_SIZE);
        }

    }

}
