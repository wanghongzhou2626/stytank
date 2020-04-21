package com.whz.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;


public class TankFrame extends Frame{
	
	static final int GAME_WIDTH = 800;
	static final int GAME_HEIGHT = 600;
	
	//自己的tank
	Tank tank = new Tank(200, 400, Dir.DOWN, this);
	
	//子弹容器
	List<Bullet> bulletList = new ArrayList<>();
	
	//敌人的tank
	List<Tank> tankList = new ArrayList<>();
	
	public TankFrame() {	
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		
		this.setResizable(false);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		this.addKeyListener(new MyKeyEvent());
	}
	
	/**
	 * 处理双缓冲
	 */
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		Color color = g.getColor();
		g.setColor(color.white);
		g.drawString("子弹的数量："+bulletList.size(), 10, 60);
		g.drawString("敌人的数量:" + tankList.size(), 10, 80);
		g.setColor(color);
		//画自己的tank
		tank.paint(g);
		//画子弹
		for(int i=0; i<bulletList.size(); i++) {
			bulletList.get(i).paint(g);
		}
		
		//画敌人
		for(int i=0; i<tankList.size(); i++) {
			tankList.get(i).paint(g);
		}
		
		//子弹与敌人进行碰撞检测
		for (int i=0; i<tankList.size(); i++) {
			for(int j=0; j<bulletList.size(); j++) {
				tankList.get(i).collideWith(bulletList.get(j));
					
			}
		}
		
	}
	
	class MyKeyEvent extends KeyAdapter {
		boolean bl = false;
		boolean br = false;
		boolean bu = false;
		boolean bd = false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			//tank.tankMove(e);
			int key = e.getExtendedKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = true;
				break;
			case KeyEvent.VK_RIGHT:
				br = true;
				break;
			case KeyEvent.VK_UP:
				bu = true;
				break;
			case KeyEvent.VK_DOWN:
				bd = true;
				break;

			default:
				break;
			}
			SetMainTankDir();
			
			//x += 50;
			//repaint();
			System.out.println("press");
		}

		

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("reless");
			int key = e.getExtendedKeyCode();
			switch (key) {
			case KeyEvent.VK_LEFT:
				bl = false;
				break;
			case KeyEvent.VK_RIGHT:
				br = false;
				break;
			case KeyEvent.VK_UP:
				bu = false;
				break;
			case KeyEvent.VK_DOWN:
				bd = false;
				break;
			case KeyEvent.VK_CONTROL://抬起ctrl发射一颗子弹.
				tank.fire();
				break;
			default:
				break;
			}
			SetMainTankDir();
		}
		
		private void SetMainTankDir() {
			if(!bl && !br && !bu && !bd) tank.setMoveing(false);
			else {
				tank.setMoveing(true);
				if(bl) tank.setDir(Dir.LEFT); 
				if(br) tank.setDir(Dir.RIGHT); 
				if(bu) tank.setDir(Dir.UP); 
				if(bd) tank.setDir(Dir.DOWN);
			}
		}
	}
}
