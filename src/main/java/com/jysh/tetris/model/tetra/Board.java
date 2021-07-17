package com.jysh.tetris.model.tetra;

import java.util.Arrays;

/**
 *
 */
public class Board {
    public static final int BOARD_WIDTH = 10;
    public static final int BOARD_HEIGHT = 25;

    private final boolean[][] placeholder = new boolean[BOARD_WIDTH][BOARD_HEIGHT]; //板上的tetra固定情况

    private final int[][] colorBoard = new int[BOARD_WIDTH][BOARD_HEIGHT];          //板上某个坐标的颜色

    public Board(){
        for(boolean[] temp : placeholder){
            Arrays.fill(temp, false);
        }
        for(int[] temp : colorBoard){
            Arrays.fill(temp, 0);
        }
    }

    /**
     * 清空板
     */
    public void cleanBoard()
    {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_HEIGHT; j++) {
                this.colorBoard[i][j] = 0;
                this.placeholder[i][j] = false;
            }
        }
    }

    /**
     * 传入一个tetra，将整个tetra所在的坐标在板上的位置固定为true
     * @param tetra
     */
    public void setPlaceholder(Tetra tetra){
        for(Cube cube : tetra.cubes){
            placeholder[cube.getX()][cube.getY()] = true;
            colorBoard[cube.getX()][cube.getY()] = tetra.color;
        }
    }

    public boolean[][] getAllPlaceholder(){
        return placeholder;
    }

    /**
     * 若传来的坐标超出边界或所在位置为true则返回true
     * @param x
     * @param y
     * @return
     */
    public boolean getPlaceholder(int x, int y){
        return (x >= 0 && x < BOARD_WIDTH) && (y >= 0 && y < BOARD_HEIGHT) ? placeholder[x][y] : true;
    }

    public int getColorBoard(int x, int y){
        return colorBoard[x][y];
    }

    /**
     * 检查消行
     */
    public void checkDestroy(){
        for(int line = BOARD_HEIGHT - 1; line >= 0; line--){
            if(this.checkLine(line)){
                this.destroyLine(line);
                line++;
            }
        }
    }

    public void destroyLine(int line){
        for(int i = 0; i < BOARD_WIDTH; i++){
            for(int j = line; j > 0; j--){
                this.placeholder[i][j] = this
                        .placeholder[i][j - 1];
                this.colorBoard[i][j] = this
                        .colorBoard[i][j - 1];
            }
        }
        for(int i = 0; i < BOARD_WIDTH; i++){
            this.placeholder[i][0] = false;
            this.colorBoard[i][0] = 0;
        }
    }

    public boolean checkLine(int line){
        for(int i = 0;i < BOARD_WIDTH; i++){
            if(!this.placeholder[i][line]){
                return false;
            }
        }
        return true;
    }

}
