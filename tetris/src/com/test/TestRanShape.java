package com.test;

import org.junit.Test;

import com.game.Tetromino;

public class TestRanShape {
	@Test
	public void TestRanShape1() {
		Tetromino t = Tetromino.ranShape();
		System.out.println(t);
	}
}
