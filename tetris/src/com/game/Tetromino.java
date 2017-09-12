package com.game;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.game.box.I;
import com.game.box.J;
import com.game.box.L;
import com.game.box.O;
import com.game.box.S;
import com.game.box.T;
import com.game.box.Z;


public class Tetromino extends Cell{

	protected Cell[] cells = new Cell[4];
	
	/**
	 * Tetromino类中的移动方法，通过重写和向上调用父类中方法实现
	 * @see com.baishu.tetris.Cell#moveDown()
	 */
	public void moveDown() {
		for(int i = 0; i < cells.length; i++) {
			cells[i].moveDown();
		}
	}
	public void moveLeft() {
		for(int i = 0; i < cells.length; i++) {
			cells[i].moveLeft();
		}
	}
	public void moveRight() {
		for(int i = 0; i < cells.length; i++) {
			cells[i].moveRight();
		}
	}
	
	/**
	 * 随机生成方块形状
	 */
	public static Tetromino ranShape() {
		Random random = new Random();
		int index = random.nextInt(7);
		switch (index) {
		case 0:return new J();
		case 1:return new L();
		case 2:return new O();
		case 3:return new Z();
		case 4:return new S();
		case 5:return new I();
		case 6:return new T();
		}
		return null;
	}
	/**
	 * Tetromino对象旋转方法
	 * @return Tetromino对象旋转结果，以Cell数组形式返回，用以判定旋转结果是否合法
	 */
	public Cell[] spin() {
		//因为学的不多，暂时用下方法判断是否调用对象为O型对象,其他方法在类中重写toString(),equals()等
		if(this.getClass().equals(new O().getClass()))return null;
		Cell[] iCells = new Cell[4];
		int iRow = this.cells[2].getRow();
		int iCol = this.cells[2].getCol();
		for (int i = 0; i < this.cells.length; i++) {
			int nRow = this.cells[i].getRow();
			int nCol = this.cells[i].getCol();
			//对iCells内元素进行初始化，防止出现nullPointException异常
			iCells[i] = new Cell(iRow-iCol+nCol, iRow+iCol-nRow, this.cells[i].getBgImage());
		}
		return iCells;
	}
	/* 
	 * 重写toString() 方法，为了能够方便的测试
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < cells.length; i++){
			str = str + cells[i].getRow()+" "+cells[i].getCol()+"\n";
		}
		return str;
	}
}

