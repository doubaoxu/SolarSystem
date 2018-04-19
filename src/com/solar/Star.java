package com.solar;

import java.awt.Graphics;
import java.awt.Image;

import com.util.GameUtil;
import com.util.MyFrame;

public class Star {
	
	Image img;
	double x,y;
	int width;
	int height;
	
	
	public void draw(Graphics g){
		g.drawImage(img, (int)x, (int)y,null);	
	}
	
	public Star(Image img,double x,double y){
		this(img);
		this.x = x;
		this.y = y;
		
	}
	public Star(){
		
	}
	public Star(Image img){
		this.img = img;
		this.height = img.getHeight(null);
		this.width = img.getWidth(null);
		
	}
	
	public Star(String imgPath,double x,double y){
		this(GameUtil.getImage(imgPath),x,y);
	}

}
