package com.jysh.tetris.model.tetra;

/**
 * 下Tetra类，作为model，控制tetra的行为
 */
public class Tetra{
    protected Cube [] cubes;        //每个俄罗斯方块
    protected int [][] rotateX;     //四次旋转时，每个Cube.X的相对改变坐标
    protected int [][] rotateY;     //同上，Cube.y
    protected int rotateFlag;       //当前旋转状态
    protected int color;

    public Tetra(){
        cubes = new Cube[4];
    }

    public Tetra(Cube[] cubes){     //用于获取一个新的Tetra
        this.cubes = cubes;
        this.rotateFlag = -1;
        this.rotateX = null;
        this.rotateY = null;
    }

    public Cube[] getCubes(){
        return this.cubes;
    }

    public int getColor(){ return this.color; }

    public void moveRight(){        //右移
        for(Cube cube : cubes){
            cube.setX(cube.getX() + 1);
        }
    }

    public Tetra getMoveRight(){        //获取右移之后的状态
        Cube [] cubesTemp =new Cube[4];
        for(int i = 0;i < 4; i++){
            cubesTemp[i] = new Cube(cubes[i].getX() + 1,
                    cubes[i].getY());
        }
        return new Tetra(cubesTemp);
    }

    public void moveLeft(){         //左移
        for(Cube cube : cubes){
            cube.setX(cube.getX() - 1);
        }
    }

    public Tetra getMoveLeft(){         //获取左移之后的状态
        Cube [] cubesTemp =new Cube[4];
        for(int i = 0;i < 4; i++){
            cubesTemp[i] = new Cube(cubes[i].getX() - 1,
                    cubes[i].getY());
        }
        return new Tetra(cubesTemp);
    }

    public void moveDown(){         //下移
        for(Cube cube : cubes){
            cube.setY(cube.getY() + 1);
        }
    }

    public Tetra getMoveDown(){     //获取下移之后的状态
        Cube [] cubesTemp =new Cube[4];
        for(int i = 0;i < 4; i++){
            cubesTemp[i] = new Cube(cubes[i].getX(),
                    cubes[i].getY() + 1);
        }
        return new Tetra(cubesTemp);
    }

    public void rotateRight(){      //顺时针（右旋）旋转
        rotateFlag++;
        rotateFlag %= 4;
        for(int i = 0; i < 4; i++){
            cubes[i].setX(cubes[i].getX() + rotateX[i][rotateFlag]);
            cubes[i].setY(cubes[i].getY() + rotateY[i][rotateFlag]);
        }
    }

    public Tetra getRotateRight(){      //获取旋转之后的状态
        int rotateFlagTemp = rotateFlag + 1;
        rotateFlagTemp %= 4;
        Cube [] cubesTemp =new Cube[4];
        for(int i = 0;i < 4; i++){
            cubesTemp[i] = new Cube(cubes[i].getX() + rotateX[i][rotateFlagTemp],
                    cubes[i].getY() + rotateY[i][rotateFlagTemp]);
        }
        return new Tetra(cubesTemp);
    }

}
