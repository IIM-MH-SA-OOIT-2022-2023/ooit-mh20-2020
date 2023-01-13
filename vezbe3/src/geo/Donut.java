package geo;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius ,int r) {
		super(center,radius);
		this.innerRadius= r;
	}
	
	public Donut(Point center,int radius,int r,boolean selected) {
		this(center,radius,r);
		this.selected = selected;  
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		//g.drawOval(getCenter().getX()-getRadius(),getCenter().getY()- getRadius(), getRadius()*2, getRadius()*2);
		g.drawOval(getCenter().getX()-innerRadius,getCenter().getY()- innerRadius, innerRadius*2, innerRadius*2);
		if(selected== true) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX()-3, getCenter().getY()-3, 6, 6);
			g.drawRect(getCenter().getX()-innerRadius-3, getCenter().getY()-3, 6, 6);
			g.drawRect(getCenter().getX()-3, getCenter().getY()-innerRadius-3, 6, 6);
			g.drawRect(getCenter().getX()+innerRadius-3, getCenter().getY()-3, 6, 6);
			g.drawRect(getCenter().getX()-3, getCenter().getY()+innerRadius-3, 6, 6);
		
		}
	}
	
	public boolean contains(int x, int y) {
		return getCenter().distance(new Point(x,y)) <= getRadius() && getCenter().distance(new Point(x,y)) >= innerRadius ;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}
	
	@Override
	public String toString() {
		return "Center: (" +getCenter().getX() +", "+ getCenter().getY() + "), radius="+getRadius()+ ", inner radius="+innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp=(Donut)obj;
			if(temp.getCenter().equals(getCenter()) && temp.getRadius()==getRadius()  && temp.getInnerRadius()== innerRadius) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			Donut temp = (Donut)o;
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	
	
	
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public int getInnerRadius() {
	return innerRadius;
	}
	
	
}

