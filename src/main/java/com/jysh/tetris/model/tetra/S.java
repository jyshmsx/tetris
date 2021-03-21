package com.jysh.tetris.model.tetra;

public class S extends Tetra{
    public S(int rotateFlag, int color){
        super();
        this.color = color;
        this.rotateFlag = rotateFlag;
        switch (rotateFlag) {
            case 0:
            case 2:
                cubes[0] = new Cube(4, 0);
                cubes[1] = new Cube(5, 0);
                cubes[2] = new Cube(3, 1);
                cubes[3] = new Cube(4, 1);
                break;
            case 1:
            case 3:
                cubes[0] = new Cube(4, 1);
                cubes[1] = new Cube(4, 0);
                cubes[2] = new Cube(5, 1);
                cubes[3] = new Cube(5, 2);
                break;
            default:
                break;
        }

        rotateX = new int[][] { { 0, 0, 0, 0 }, { 1, -1, 1, -1 }, { -2, 2, -2, 2 }, { -1, 1, -1, 1 } };
        rotateY = new int[][] { { 0, 0, 0, 0 }, { 1, -1, 1, -1 }, { 1, -1, 1, -1 }, { 0, 0, 0, 0 } };
    }
}
