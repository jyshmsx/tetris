package com.jysh.tetris.model;

import com.jysh.tetris.model.tetra.*;
import static com.jysh.tetris.model.tetra.Board.BOARD_WIDTH;

import java.util.Random;

/**
 *
 */
public class TetraBoard {

    private Tetra tetra;
    private Board board;
    private Tetra nextTetra;


    public TetraBoard(){
        this.board = new Board();
        this.randomSetNextTetra();
        this.tetra = nextTetra;
        this.randomSetNextTetra();
    }

    /**
     * 重新设置board, tetra, nextTetra
     */
    public void reStart(){
        this.board = new Board();
        this.randomSetNextTetra();
        this.tetra = nextTetra;
        this.randomSetNextTetra();
    }

    /**
     * 若tetra可以右移，右移
     */
    public void setTetraMoveRight(){
        Tetra tetra = this.tetra.getMoveRight();
        if(this.findInBoard(tetra)){
            this.tetra.moveRight();
        }
    }

    /**
     * 若tetra可以左移，左移
     */
    public void setTetraMoveLeft(){
        Tetra tetra = this.tetra.getMoveLeft();
        if(this.findInBoard(tetra)){
            this.tetra.moveLeft();
        }
    }

    /**
     * 若tetra可以右旋转，右旋
     */
    public void setTetraRotateRight(){
        Tetra tetra = this.tetra.getRotateRight();
        if(this.findInBoard(tetra)){
            this.tetra.rotateRight();
        }
    }

    /**
     * 若tetra可以下落，下落
     * 若不可下落，切换方块，查询消行，查询失败
     */
    public void setTetraMoveDown(){
        Tetra tetra = this.tetra.getMoveDown();
        if(this.findInBoard(tetra)){
            this.tetra.moveDown();
        }else{
            this.stopTetra();
            this.board.checkDestroy();;
            this.checkLose();
        }
    }

    /**
     * 在板上对传入的tetra进行是否处于固定位置的查找，若是，返回false；
     * @param tetra
     * @return
     */
    public boolean findInBoard(Tetra tetra){
        for(Cube cube : tetra.getCubes()){
            if(board.getPlaceholder(cube.getX(), cube.getY())){
                return false;
            }
        }
        return true;
    }

    /**
     * 查询是否失败，即board中最高行（0行(列，行)）有值为true的
     */
    public void checkLose(){
        for(int i = 0; i < BOARD_WIDTH; i++){
            if(this.board.getPlaceholder(i, 0)){
                this.reStart();
            }
        }
    }

    public Board getBoard(){
        return board;
    }

    public Tetra getTetra(){
        return this.tetra;
    }

    public Tetra getNextTetra(){
        return this.nextTetra;
    }

    /**
     * 切换方块
     */
    public void stopTetra(){
        this.setTetraInBoard();
        this.tetra = nextTetra;
        this.randomSetNextTetra();
    }

    /**
     * 固定当前tetra至board
     */
    public void setTetraInBoard(){  //灏嗗綋鍓嶇殑tetra鐨勫�煎浐瀹氬湪board涓�
        board.setPlaceholder(tetra);
    }

    /**
     * 随机获得一个tetra，并将nextTetra设为整个tetra
     */
    public void randomSetNextTetra(){
        Tetra nextTetra = null;
        Random rd = new Random();
        switch (rd.nextInt(7)){
            case 0:
                nextTetra = new I(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 1:
                nextTetra = new J(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 2:
                nextTetra = new L(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 3:
                nextTetra = new O(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 4:
                nextTetra = new S(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 5:
                nextTetra = new T(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
            case 6:
                nextTetra = new Z(rd.nextInt(4), rd.nextInt(7) + 1);
                break;
        }
        this.nextTetra = nextTetra;
    }
}
