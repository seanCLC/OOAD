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
 *     **    
 **/
public class L extends Tetromino {
	
	public L() {
		cells[0] = new Cell(2, 6, Tetris.L);
		cells[1] = new Cell(0, 5, Tetris.L);
		cells[2] = new Cell(2, 5, Tetris.L);
		cells[3] = new Cell(1, 5, Tetris.L);
	}
}
