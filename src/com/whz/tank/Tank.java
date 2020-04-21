package com.whz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	
	private int x = 200;
	private int y = 200;
	private static final int speed = 10;
	private boolean moveing = false;
	
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
		g.drawImage(ResourceMgr.tankL, x, y, null);
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
		tankFrame.list.add(new Buttle(this.x, this.y, this.dir, this.tankFrame));
		// TODO Auto-generated method stub
	}


	
	

}
