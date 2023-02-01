package Project;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{
	private Point center;
	private int radius;
	private Color lineColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	
	
	public Circle() {
		
	}
	
	public Circle(int x,int y, int radius) {
		center.setX(x);
		center.setY(y);
		this.radius=radius;
	}
	
	public Circle(Point center, int radius) {
		this.center=center;
		this.radius=radius;
	}
	
	public Circle(Point center, int radius,boolean selected) {
		this(center,radius);
		this.selected=selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(lineColor);
		g.drawOval(center.getX()-radius,center.getY()- radius, radius*2, radius*2);
		g.setColor(fillColor);
		g.fillOval(center.getX()-radius,center.getY()- radius, radius*2, radius*2);
		if(selected== true) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX()-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()-radius-3, 6, 6);
			g.drawRect(center.getX()+radius-3, center.getY()-3, 6, 6);
			g.drawRect(center.getX()-3, center.getY()+radius-3, 6, 6);
		
		}
	}
	
	public boolean contains(int x, int y) {
		return center.distance(new Point(x,y)) <= radius;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}
	
	@Override
	public String toString() {
		return "Center: (" +center.getX() +", "+ center.getY() + "), radius="+radius;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp=(Circle)obj;
			if(temp.getCenter().equals(center) && temp.getRadius()==radius) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
	}

	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	public double circumference() {
		return 2*radius*Math.PI;
	}
	
	public void setCenter(Point a) {
		this.center=a;
	}
	public Point getCenter() {
		return center;
	}
	public void setRadius(int a) throws Exception {
		if(a<0) {
			throw new Exception("Negativan poluprecnik");
		}else {
		this.radius=a;
		}
	}
	public int getRadius() {
		return radius;
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
