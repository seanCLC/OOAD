package com.game.box;

import com.game.Cell;
import com.game.Tetris;
import com.game.Tetromino;

/** 
 * @author hui 
 * @version 1.0 
 * @shape
 * 
 *     **
 *     **    
 **/
public class O extends Tetromino {
	public O() {
		cells[0] = new Cell(0, 5, Tetris.O);
		cells[1] = new Cell(0, 6, Tetris.O);
		cells[2] = new Cell(1, 5, Tetris.O);
		cells[3] = new Cell(1, 6, Tetris.O);
	}
}
