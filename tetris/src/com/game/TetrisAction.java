package com.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 程序按键操作
 * @author leixiang
 *
 */
public class TetrisAction extends Tetris {
	/**
	 * 按键操作
	 */
	public void action() {
		tetromino = Tetromino.ranShape();
		nextone = Tetromino.ranShape();
	
		KeyListener kl = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int k = e.getKeyCode();
				keyMoveAction(k);
				repaint();
			}
		};
		//Tetris 是面板类型 l 监听 面板的动作
		this.addKeyListener(kl);
		this.setFocusable(true);
		//request 请求  Focus 焦点  
		this.requestFocus();
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
		
			int moveIndex = 0;
			int bgiIndex = 0;
			int speed = 5*level;
			@Override
			public void run() {
				if (STATE) {
					//speed = speed*level;
					if (moveIndex % speed == 0) {
						moveDownAction();
						moveIndex = 0;
					}
				}
				//testAction();
				//isBottom();
				moveIndex++;
				bgiIndex++;
				repaint();
			}
		};
		timer.schedule(task, 10, 20);
	}

	/**
	 * @param k
	 */
	public void keyMoveAction(int k) {
		switch (k) {
			case KeyEvent.VK_RIGHT:moveRightAction();break;
			case KeyEvent.VK_LEFT:moveLeftAction();break;
			case KeyEvent.VK_DOWN:moveDownAction();break;
			case KeyEvent.VK_UP:spinCellAction();break;
			case KeyEvent.VK_I:moveInitAction();break;//重新开始游戏
			case KeyEvent.VK_P:STATE = false;break;//暂停游戏
			case KeyEvent.VK_C:STATE = true;break; //继续游戏
			case KeyEvent.VK_E:System.exit(0);break;//退出游戏
			
		}
	}
	/**
	 * 初始化方法
	 */
	public void moveInitAction() {
		STATE = false;
		wall = new Cell[ROWS][COLS];
		tetromino = Tetromino.ranShape();
		nextone = Tetromino.ranShape();
		score = 0;
		lines = 0;
		level = 0;
	}
	/**
	 * 旋转方法
	 */
	public void spinCellAction() {
		Cell[] nCells = tetromino.spin(); 
		if (nCells == null) return;
		for (int i = 0; i < nCells.length; i++) {
			int nRow = nCells[i].getRow();
			int nCol = nCells[i].getCol();
			//System.out.println(nRow+" "+nCol);
			if (nRow < 0 || nRow >= ROWS || nCol < 0 || nCol >= COLS || wall[nRow][nCol] != null) return;
		}
		//System.out.println(111);
		tetromino.cells = nCells;
	}
	/**
	 * 左移
	 */
	public void moveLeftAction() {
		if (canLeftMove()&&!isBottom()) {
			tetromino.moveLeft();
		}
	}
	/**
	 * 右移
	 */
	public void moveRightAction() {
		if (canRightMove()&&!isBottom()) {
			tetromino.moveRight();
		}
	}
	/**
	 * 下移
	 */
	public void moveDownAction() {
		if (tetromino == null) return;
		if (!isBottom()) {
			tetromino.moveDown();
		}
		
	}
	/**
	 * 
	 */
	public void removeLine() {
		boolean flag = true;
		int rowStart = 20;
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				if (wall[row][col] == null) {
					flag = false;
					break;
				}
			}
			if (flag) {
				for (int col = 0; col < COLS; col++) {
					wall[row][col] = null;
				} 
				rowStart = row;
				score += 10;
				lines += 1;
				level = lines%10 == 0?level == 1?level:level-1:level;
				for (int row1 = rowStart; row1 > 0; row1--) {
					for (int col1 = 0; col1 < COLS; col1++) {
						wall[row1][col1] = wall[row1-1][col1];
					}
				}
			}else {
				flag = true;
			}
		}
	}
	/**
	 * @return 是否可以继续下落
	 */
	public boolean isBottom() {
		if (tetromino == null) return false;
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell c = cells[i];
			int col = c.getCol();
			int row = c.getRow();
			//此处利用“||”的逻辑短路特点，减少代码量
			if ((row+1) == ROWS || wall[row+1][col] != null) {
				//当确定当前对象运动到底部即停止时，将该对象的cells内的格子元素存入wall内
				for(int j = 0; j < cells.length; j++) {
					Cell cell = cells[j];
					int col1 = cell.getCol();
					int row1 = cell.getRow();
					wall[row1][col1] = cell;
				}
				removeLine();
				//控制背景图片
				BGI = (BGI == 3)?0:BGI+1;
				tetromino = nextone;
				nextone = Tetromino.ranShape();
				return true;
			}
		}
		return false;
	}
	/**
	 * 判定是否可以右移
	 * @return
	 */
	public boolean canRightMove() {
		if (tetromino == null) return false;
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell c = cells[i];
			int row = c.getRow();
			int col = c.getCol();
			if ((col+1) == COLS || wall[row][col+1] != null) return false;
		}
		return true;
	}
	/**
	 * 判断是否可以左移
	 * @return
	 */
	public boolean canLeftMove() {
		if (tetromino == null) return false;
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell c = cells[i];
			int row = c.getRow();
			int col = c.getCol();
			if (col == 0 || wall[row][col-1] != null) return false;
		}
		return true;
	}
}
