package Project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;



public class PnlDrawing extends JPanel{
	ArrayList<Shape> shapes = new ArrayList<>();
	
	public PnlDrawing() {
		setSize(700,400);
		setBackground(Color.white);	
	}
		
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s: shapes) {
			s.draw(g);
		}
	}

}
