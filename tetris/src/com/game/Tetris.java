package com.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 程序窗体
 * @author leixiang
 *
 */
public class Tetris extends JPanel{
	/**
	 * 下一个下落对象
	 */
	protected Tetromino nextone;
	/**
	 * 当前下落对象
	 */
	protected Tetromino tetromino;
	/**
	 * 行，列
	 */
	protected static final int ROWS = 20;
	protected static final int COLS = 10;
	/**
	 * 提示信息
	 */
	protected int score = 0;
	protected int lines = 0;
	protected int level = 5;
	/**
	 * 墙
	 */
	protected Cell[][] wall = new Cell[ROWS][COLS];
	/**
	 * 各种状态，STATE 程序状态， BGI 背景图片状态
	 */
	protected boolean STATE = true;
	protected int BGI = 0;
	/**
	 * 格子长度的换算
	 */
	public static final int CELL_SIZE = 26;
	//各种形状
	public static BufferedImage Z;
	public static BufferedImage S;
	public static BufferedImage J;
	public static BufferedImage L;
	public static BufferedImage O;
	public static BufferedImage I;
	public static BufferedImage T;
	//程序背景图片
	public static BufferedImage[] bgi = new BufferedImage[4];
	//暂停时显示
	public static BufferedImage pause;//
	//程序背景
	public static BufferedImage tetris;
	//游戏结束图片
	public static BufferedImage gameover;
	static {
		try {
			Z = ImageIO.read(Tetris.class.getResource("image/Z.png"));
			//Z = ImageIO.read(Tetris.class.getResource("Z.png"));
			S = ImageIO.read(Tetris.class.getResource("image/S.png"));
			J = ImageIO.read(Tetris.class.getResource("image/J.png"));
			T = ImageIO.read(Tetris.class.getResource("image/T.png"));
			O = ImageIO.read(Tetris.class.getResource("image/O.png"));
			I = ImageIO.read(Tetris.class.getResource("image/I.png"));
			L = ImageIO.read(Tetris.class.getResource("image/L.png"));
			pause = ImageIO.read(Tetris.class.getResource("image/pause.png"));
			tetris = ImageIO.read(Tetris.class.getResource("image/tetris1.png"));
			gameover = ImageIO.read(Tetris.class.getResource("image/gameover.png"));
			for(int i = 0; i < bgi.length; i++) {
				String name = "bgi0"+i+".jpg";
				bgi[i] = ImageIO.read(Tetris.class.getResource("image/"+name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paint(java.awt.Graphics)
	 */
	public void paint(Graphics g) {
		
		g.drawImage(bgi[BGI], 0, 0, null);
		g.drawImage(tetris, 0, 0, null);
		g.translate(15, 15);
		
		//画墙
		paintWall(g);
		//画当前下落对象和预备下落对象
		paintTetromino(g);
		paintNextone(g);
		//画提示信息，得分，消除行数，等级
		paintTabs(g);
		//画暂停画面
		paintGamePause(g);
		//画GameOver画面
		paintGameOver(g);
	}
	/**
	 * 判断游戏是否结束
	 * @return
	 */
	public boolean isGameOver() {
		for(int col = 0; col < COLS; col++) {
			if (wall[0][col] != null)return true;
		}
		return false;
	}
	/**
	 * 画游戏结束
	 * @param g
	 */
	public void paintGameOver(Graphics g) {
		if (isGameOver()) {
			tetromino = null;
			g.drawImage(gameover, -15, -15, null);
			Color color = new Color(0,71,157);
			g.setColor(color);
			Font font = new Font(Font.SERIF,Font.BOLD,30);
			g.setFont(font);
			g.drawString(""+score, 260, 207);
			g.drawString(""+lines, 260, 253);
			g.drawString(""+level, 260, 300);
			STATE = false;
		}
	}
	/**
	 * 画暂停
	 * @param g
	 */
	public void paintGamePause(Graphics g){
		if (!STATE && !isGameOver()) {
			g.drawImage(pause, -15, -15, null);
		}
	}
	/**
	 * 画信息
	 * @param g
	 */
	public void paintTabs(Graphics g) {
		//确定绘制的地点
		int x = 410;
		int y = 160;
		//设置颜色
		Color color = new Color(240,234,34);
		g.setColor(color);
		//设置字体
		Font f = new Font(Font.SERIF,Font.BOLD,30);
		g.setFont(f);
		g.drawString(""+score, x, y);
		y+=56;
		g.drawString(""+lines, x, y);
		y+=56;
		g.drawString(""+level, x, y);
	}
	/**
	 * 画Nextone
	 * @param g
	 */
	public void paintNextone(Graphics g) {
		 if (nextone == null)return;
		 Cell[] cells = nextone.cells;
		 for(int i = 0; i < cells.length; i++){
			 Cell c = cells[i];
			 int row = c.getRow() ;
			 int col = c.getCol() + 9;
			 int x = col * CELL_SIZE;
			 int y = row * CELL_SIZE;
			 g.drawImage(c.getBgImage(), x, y, null);
		 }
	}
	/**
	 * 画当前tetromino
	 * @param g
	 */
	public void paintTetromino(Graphics g) {
		//cells 引用了正在下落方块的4个格子数组
		if(tetromino == null)return;
		
		//System.out.println(tetromino == null);
		Cell[] cells = tetromino.cells;
		for(int i=0; i < cells.length; i++){
			//c 是正在下落方块的每个格子的引用
			Cell c = cells[i];
			int col = c.getCol();
			int row = c.getRow();
			int x = col * CELL_SIZE;
			int y = row * CELL_SIZE;
			g.drawImage(c.getBgImage(), x, y, null);
		}
	}
	
	/**
	 * 画墙
	 * @param g
	 */
	public void paintWall(Graphics g) {
		for(int row = 0; row < ROWS; row++) {
			for(int col = 0; col < COLS; col++) {
				Cell cell = wall[row][col];
				int rows = row * CELL_SIZE;
				int cols = col * CELL_SIZE;
				//g.drawImage(O, rows, cols, null);
				if (cell == null) {
					//System.out.println(0);
				}else{
					g.drawImage(cell.getBgImage(), cols, rows, null);
				}
			}
		}
	}
	
}
