package Project;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeft;
	private int width;
	private int height;
	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft,int width, int height) {
		this.upperLeft=upperLeft;
		this.width=width;
		this.height=height;
	}
	
	public Rectangle(Point upperLeft,int width, int height,boolean selected) {
		this(upperLeft,width,height);
		this.selected=selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(lineColor);
		g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
		g.setColor(fillColor);
		g.fillRect(upperLeft.getX()+1, upperLeft.getY()+1, width-1, height-1);
		if(selected== true) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()-3, 6, 6);
			g.drawRect(upperLeft.getX()-3, upperLeft.getY()+height-3, 6, 6);
			g.drawRect(upperLeft.getX()+width-3, upperLeft.getY()+height-3, 6, 6);
		
		}
	}
	
	public boolean contains(int x, int y) {
		return upperLeft.getX()+width >= x && upperLeft.getY()+height >= y && upperLeft.getX()<x && upperLeft.getY()<y;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}
	
	@Override
	public String toString() {
		return "Upper left point: ("+ upperLeft.getX() + ", " + upperLeft.getY() + "), width="+width+", height="+height;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle temp=(Rectangle)obj;
			if(temp.getUpperLeft().equals(upperLeft) && temp.getWidth()==width && temp.getHeight()==height ) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y); 
		
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle)o;
			return (this.area()- temp.area());
		}
		return 0;
	}
	public int area() {
		return width*height;
	}
	
	public int circumference() {
		return 2*(width+height);
	}
	
	public void setUpperLeft(Point a) {
		this.upperLeft=a;
	}
	
	public Point getUpperLeft() {
		return upperLeft;
	}
	
	public void setWidth(int a) {
		this.width=a;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int a) {
		this.height=a;
	}
	
	public int getHeight() {
		return height;
	}

	public void setLineColor(Color c) {
		lineColor=c;
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setFillColor(Color c) {
		fillColor=c;
	}
	public Color getFillColor() {
		return fillColor;
	}

	

	
	
	
}
