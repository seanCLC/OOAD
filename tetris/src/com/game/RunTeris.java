package com.game;

import javax.swing.JFrame;

public class RunTeris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			JFrame frame = new JFrame();
			
			TetrisAction tetris = new TetrisAction();
			frame.add(tetris);
			frame.setSize(525, 600);
			frame.setLocationRelativeTo(null);
			//frame.setUndecorated(true);
			frame.setDefaultCloseOperation(
					JFrame.EXIT_ON_CLOSE);
			//显示窗口时候会尽快调用面板的paint()方法
			//绘制显示的内容（绘制背景等）
			frame.setVisible(true);
			//被重写的paint（）方法绘制了图片！
			tetris.action();
		
	}

}
