package com.game.box;

import com.game.Cell;
import com.game.Tetris;
import com.game.Tetromino;

/** 
 * @author hui 
 * @version 1.0 
 * @shape
 * 
 *     *
 *    ** 
 *    *   
 **/
public class Z extends Tetromino {
	/*
	 * 实现cells中的四个格子的特殊排列
	 * Tetris.Z代表特例图片（颜色）——来自Tetris类中加载的静态资源
	 */
	public Z() {
		cells[0] = new Cell(0, 4, Tetris.Z);
		cells[1] = new Cell(0, 5, Tetris.Z);
		cells[2] = new Cell(1, 5, Tetris.Z);
		cells[3] = new Cell(1, 6, Tetris.Z);
	}
}
