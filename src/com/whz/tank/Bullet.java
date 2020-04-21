package com.whz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	
	private static int speed = 10; //子弹速度
	public static final int WIDTH = ResourceMgr.bulletL.getWidth();
	public static final int HEIGHT = ResourceMgr.bulletL.getHeight();
	private int x;
	private int y;
	
	//判断子弹是否存活（超出边界就在集合中减少一个，要不会造成内存溢出） 一定不能是static的 那样的话就变成了所有类所共享的了
	private boolean living = true;

	private TankFrame tankFrame;

	private Dir dir;//子弹方向

	public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame = tankFrame;
	}

	public void buttleMove() {
		System.out.println("buttle");
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
			System.out.println("yyyy");
			break;

		default:
			break;
		}
		if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void paint(Graphics g) {
		//如果当前的为假 那么在容器中删除这颗子弹
		if(!living) {
			tankFrame.bulletList.remove(this);
		}
//		Color color = g.getColor();
//		g.setColor(color.yellow);
//		g.fillOval(x, y, WIDTH, HEIGHT);
//		g.setColor(color);
		
		g.drawImage(ResourceMgr.bulletL, x, y, null);
		g.drawImage(ResourceMgr.bulletR, x, y, null);
		g.drawImage(ResourceMgr.bulletU, x, y, null);
		g.drawImage(ResourceMgr.bulletD, x, y, null);
		buttleMove();
	};
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void die() {
		this.living = false;
	}
	
	

}
