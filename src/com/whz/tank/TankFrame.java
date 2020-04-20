package com.whz.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame{
	

	Tank tank = new Tank(200, 200, Dir.DOWN);
	Buttle buttle = new Buttle(300, 300, Dir.DOWN);
	public TankFrame() {
		this.setSize(600, 600);
		
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
	

	@Override
	public void paint(Graphics g) {
		tank.paint(g);
		buttle.paint(g);
		
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
