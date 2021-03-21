package com.jysh.tetris.model;

import com.jysh.tetris.model.tetra.*;
import static com.jysh.tetris.model.tetra.Board.BOARD_WIDTH;

import java.util.Random;

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

    public void reStart(){
        this.board = new Board();
        this.randomSetNextTetra();
        this.tetra = nextTetra;
        this.randomSetNextTetra();
    }

    public void setTetraMoveRight(){
        Tetra tetra = this.tetra.getMoveRight();
        if(this.findInBoard(tetra)){
            this.tetra.moveRight();
        }
    }

    public void setTetraMoveLeft(){
        Tetra tetra = this.tetra.getMoveLeft();
        if(this.findInBoard(tetra)){
            this.tetra.moveLeft();
        }
    }

    public void setTetraRotateRight(){
        Tetra tetra = this.tetra.getRotateRight();
        if(this.findInBoard(tetra)){
            this.tetra.rotateRight();
        }
    }

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

    public boolean findInBoard(Tetra tetra){
        for(Cube cube : tetra.getCubes()){
            if(board.getPlaceholder(cube.getX(), cube.getY())){
                return false;
            }
        }
        return true;
    }

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

    public void stopTetra(){    //鍋滄tetra
        this.setTetraInBoard();
        this.tetra = nextTetra;
        this.randomSetNextTetra();
    }

    public void setTetraInBoard(){  //灏嗗綋鍓嶇殑tetra鐨勫�煎浐瀹氬湪board涓�
        board.setPlaceholder(tetra);
    }

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
