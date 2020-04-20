package com.whz.tank;

import java.awt.Color;
import java.awt.Graphics;

public class Buttle {
	
	private static int speed = 1; //子弹速度
	private int x;
	private int y;
	private static final int WIDTH = 30;
	private static final int HEIGHT = 30;
	
	private Dir dir;//子弹方向
	
	public Buttle(int x, int y, Dir dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	};
	
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(color.yellow);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		buttleMove();
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
	}
	
	

}
