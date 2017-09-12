package com.game.box;

import com.game.Cell;
import com.game.Tetris;
import com.game.Tetromino;

/** 
 * @author hui 
 * @version 1.0 
 * @shape
 *   
 *    *
 *    *
 *    *
 *    *   
 **/
public class I extends Tetromino {
	public I() {
		cells[0] = new Cell(0, 5, Tetris.I);
		cells[1] = new Cell(1, 5, Tetris.I);
		cells[2] = new Cell(2, 5, Tetris.I);
		cells[3] = new Cell(3, 5, Tetris.I);
	}
}
