package com.jysh.tetris.model.tetra;

public class T extends Tetra{
    public T(int rotateFlag, int color){
        super();
        this.color = color;
        this.rotateFlag = rotateFlag;
        switch (rotateFlag) {
            case 0:
                cubes[0] = new Cube(4, 0);
                cubes[1] = new Cube(3, 0);
                cubes[2] = new Cube(4, 1);
                cubes[3] = new Cube(5, 0);
                break;
            case 1:
                cubes[0] = new Cube(4, 1);
                cubes[1] = new Cube(4, 0);
                cubes[2] = new Cube(3, 1);
                cubes[3] = new Cube(4, 2);
                break;
            case 2:
                cubes[0] = new Cube(4, 1);
                cubes[1] = new Cube(5, 1);
                cubes[2] = new Cube(4, 0);
                cubes[3] = new Cube(3, 1);
                break;
            case 3:
                cubes[0] = new Cube(4, 1);
                cubes[1] = new Cube(4, 2);
                cubes[2] = new Cube(5, 1);
                cubes[3] = new Cube(4, 0);
                break;
            default:
                break;
        }

        rotateX = new int[][] { { 0, 0, 0, 0 }, { -1, 1, 1, -1 }, { -1, -1, 1, 1 }, { 1, -1, -1, 1 } };
        rotateY = new int[][] { { 0, 0, 0, 0 }, { -1, -1, 1, 1 }, { 1, -1, -1, 1 }, { 1, 1, -1, -1 } };
    }
}
