package com.jysh.tetris.model.tetra;

/**
 * tetra的一个块，一个tetra四个快
 */
public class Cube {
    private int x;
    private int y;
	public Cube(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
