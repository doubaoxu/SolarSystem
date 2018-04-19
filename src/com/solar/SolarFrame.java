package com.solar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import com.util.Constant;
import com.util.GameUtil;
import com.util.MyFrame;

public class SolarFrame extends MyFrame{
	private Image offScreenImage;
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	Planet mercury = new Planet("images/mercury.jpg", 40, 35, 0.1,sun);
	Planet venus = new Planet("images/venus.jpg", 85, 65, 0.04,sun);
	Planet earth = new Planet("images/earth.jpg", 150, 100, 0.025,sun);
	Planet moon = new Planet("images/moon.jpg", 30, 10, 0.3,earth,true);
	Planet mars = new Planet("images/mars.jpg", 200, 130, 0.012,sun);
	
	
	public void paint(Graphics g){
		g.drawImage(bg, 0, 0,null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
		mercury.draw(g);
		venus.draw(g);
	}
	
	public void update(Graphics g){
		//1.得到缓冲图像
		if(this.offScreenImage == null){
			this.offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		}
		
		//2.得到缓冲图像的画笔
		Graphics gOffScreen = this.offScreenImage.getGraphics();
		//3.绘制缓冲图像
		gOffScreen.fillRect(0, 0, Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		//4.调用paint()。将缓冲图像的画笔传入
		paint(gOffScreen);
		//5.再将此缓冲图像一次性绘制到代表屏幕的Graphics对象，即该方法传入的“g”上
		g.drawImage(offScreenImage, 0, 0, null);

	}
	
	

//	
	public static void main(String[] args) {
		new SolarFrame().lauchFrame();
	}

}
