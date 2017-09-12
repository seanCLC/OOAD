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
 *     *
 *    **    
 **/
public class J extends Tetromino {
	public J() {
		cells[0] = new Cell(2, 5, Tetris.J);
		cells[1] = new Cell(0, 6, Tetris.J);
		cells[2] = new Cell(2, 6, Tetris.J);
		cells[3] = new Cell(1, 6, Tetris.J);
	}
}
