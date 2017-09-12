package com.test;

import org.junit.Test;

import com.game.Tetromino;

public class TetrominoTest {

	@Test
	public void test() {
		//Tetromino t = new O();
		Tetromino t = new Tetromino();
		t.spin();
		System.out.println(10*20);
	}

}
