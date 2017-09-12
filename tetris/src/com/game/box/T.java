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
 *    ***    
 **/
public class T extends Tetromino {
	public T() {
		cells[0] = new Cell(0, 4, Tetris.T);
		cells[1] = new Cell(0, 6, Tetris.T);
		cells[2] = new Cell(0, 5, Tetris.T);
		cells[3] = new Cell(1, 5, Tetris.T);
	}
}
