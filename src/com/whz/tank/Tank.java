package com.whz.tank;

import java.awt.Graphics;

public class Tank {
	
	private int x = 200;
	private int y = 200;
	private static final int speed = 10;
	private boolean moveing = false;
	
	public static final int WIDTH = ResourceMgr.tankL.getWidth();
	public static final int HEIGHT = ResourceMgr.tankL.getHeight();
	
	private TankFrame tankFrame = null;
	
	

	public Tank(int x, int y, Dir dir, TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
	}




	public boolean isMoveing() {
		return moveing;
	}


	public void setMoveing(boolean moveing) {
		this.moveing = moveing;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}




	private Dir dir; //怎么处理tank静止
	
	
	public Dir getDir() {
		return dir;
	}


	public void setDir(Dir dir) {
		this.dir = dir;
	}



	public void paint(Graphics g) {
		//画tank图片
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			break;

		default:
			break;
		}
		//
		tankMove();
		
	}


	private void tankMove() {
		// TODO Auto-generated method stub
		if(!moveing) return;
		switch (dir) {
		case LEFT:
			x -= speed;
			break;
		case RIGHT:
			x += speed;
			break;
		case UP:
			y -= speed;
			break;
		case DOWN:
			y += speed;
			break;

		default:
			break;
		}
	}


	/**
	 * 使用ctrl后根据坦克当前位置发射出来一颗子弹。 
	 * 使用tankframe的引用来对buttle进行复制使用。
	 */
	public void fire() {
		//子弹打出位置
		int bX = this.x + WIDTH/2 - Bullet.WIDTH/2;
		int bY = this.y + HEIGHT/2 - Bullet.HEIGHT/2;
		tankFrame.bulletList.add(new Bullet(bX, bY, this.dir, this.tankFrame));
		// TODO Auto-generated method stub
	}


	
	

}
