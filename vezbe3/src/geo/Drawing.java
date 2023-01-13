package geo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(1200,1000);
		Drawing drawing = new Drawing();
		frame.add(drawing);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
	
	public void paint(Graphics g) {
		Point p1 = new Point(100,100);
		Point p2 = new Point(200,200);
		//p1.draw(g);
		//p2.draw(g);
		Line l1 = new Line(p1,p2);
		//l1.draw(g);
		Rectangle r1 = new Rectangle(p1,50,50,true);
		Circle c1 = new Donut(p2,30,15,true);
		g.setColor(Color.RED);
		Point p3 = new Point(r1.getUpperLeft().getX()+25,r1.getUpperLeft().getY()+25);
		double a = (50*Math.sqrt(2))/2;
		Donut d1 = new Donut(p3,80,(int)a);
		r1.draw(g);
		c1.draw(g);
		//d1.draw(g);
		ArrayList<Shape> shapes = new ArrayList<>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(r1);
		shapes.add(c1);
		shapes.add(d1);
		
		/*for(Shape s: shapes) {
			s.draw(g);
		}*/
		//for(Shape s: shapes) {
		//	s.moveBy(10,0);
		//}
		
		//Iterator it = shapes.iterator();
		//while(it.hasNext()) {
		//	it.next();
		//}
		
		
		/*shapes.get(2).draw(g);
		shapes.get(shapes.size()-1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, l1);
		for(Shape s: shapes) {
			if(s instanceof Circle)
			s.draw(g);
			if(s instanceof Circle || s instanceof Rectangle)
				s.draw(g);
		}*/
		
	}
	
	public Drawing(){
	
	}

}
