package com.jysh.tetris.model.tetra;

public class O extends Tetra{
    public O(int rotateFlag, int color) {
        super();
        this.color = color;
        this.rotateFlag = rotateFlag;
        switch (rotateFlag) {
            case 0:
            case 1:
            case 2:
            case 3:
                cubes[0] = new Cube(4, 0);
                cubes[1] = new Cube(4, 1);
                cubes[2] = new Cube(5, 0);
                cubes[3] = new Cube(5, 1);
                break;
            default:
                break;
        }

        rotateX = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        rotateY = new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
    }
}
