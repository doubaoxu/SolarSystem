package com.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.util.GameUtil;

public class Planet extends Star{
	//轨道，椭圆长轴短轴还有运行的速度，绕着某个行星转
	double longAxis;
	double shortAxis;//椭圆的短轴
	double speed;  //绕行速度
	double degree;
	Star center;
	boolean satellite;
	
	public void draw(Graphics g){
		super.draw(g);
		move();
		if(!satellite){
			drawTrace(g);
		}
		
		
	}
	
	public void drawTrace(Graphics g){
		double _x,_y,_width,_height;
		_width = longAxis *2;
		_height = shortAxis * 2;
		_x = (center.x + center.width/2) -longAxis;
		_y = center.y + center.height/2 - shortAxis;
		Color c = g.getColor();
		g.setColor(Color.blue);
		g.drawOval((int)_x, (int)_y, (int)_width, (int)_height);
		g.setColor(c);
	}
	
	public void move(){
		x = (center.x + center.width/2) + longAxis * Math.cos(degree);
		y = (center.y + center.height/2) + shortAxis * Math.sin(degree);
		degree += speed;
	}
	
	public Planet(String imgPath, double longAxis,
			double shortAxis, double speed, Star center) {
		super(GameUtil.getImage(imgPath));
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		this.center = center;
		this.x = center.x + longAxis;
		this.y = center.y;
	}
	public Planet(String imgPath, double longAxis,
			double shortAxis, double speed, Star center,boolean satellite) {
		this(imgPath, longAxis, shortAxis, speed, center);
		this.satellite = satellite;
	}


	

	public Planet(Image img, double x, double y) {
		super(img, x, y);
		// TODO Auto-generated constructor stub
	}
	
	public Planet(String imgPath, double x, double y) {
		super(imgPath, x, y);
		// TODO Auto-generated constructor stub
	}

}
