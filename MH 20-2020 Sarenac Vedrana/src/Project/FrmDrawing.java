package Project;

import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDrawing extends JFrame {

	private JPanel contentPane;
	private int number;
	private PnlDrawing pnlDrawing = new PnlDrawing();
	private Point firstPoint;
	private Point secondPoint;
	private boolean find=false;
	private boolean test=false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Drawing Sarenac Vedrana MH20/2020");
		setBounds(100, 100, 700, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorth = new GridBagLayout();
		gbl_panelNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelNorth.rowHeights = new int[]{0, 0, 0};
		gbl_panelNorth.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelNorth.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelNorth.setLayout(gbl_panelNorth);
		
		JButton btnPoint = new JButton("Point");
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=1;
			}
		});
		GridBagConstraints gbc_btnPoint = new GridBagConstraints();
		gbc_btnPoint.insets = new Insets(0, 0, 5, 5);
		gbc_btnPoint.gridx = 1;
		gbc_btnPoint.gridy = 0;
		panelNorth.add(btnPoint, gbc_btnPoint);
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=2;
			}
		});
		GridBagConstraints gbc_btnLine = new GridBagConstraints();
		gbc_btnLine.insets = new Insets(0, 0, 5, 5);
		gbc_btnLine.gridx = 3;
		gbc_btnLine.gridy = 0;
		panelNorth.add(btnLine, gbc_btnLine);
		
		JButton btnRetangle = new JButton("Rectangle");
		btnRetangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=3;
			}
		});
		GridBagConstraints gbc_btnRetangle = new GridBagConstraints();
		gbc_btnRetangle.insets = new Insets(0, 0, 5, 5);
		gbc_btnRetangle.gridx = 5;
		gbc_btnRetangle.gridy = 0;
		panelNorth.add(btnRetangle, gbc_btnRetangle);
		
		JButton btnCircle = new JButton("Circle");
		btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=4;
			}
		});
		GridBagConstraints gbc_btnCircle = new GridBagConstraints();
		gbc_btnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_btnCircle.gridx = 7;
		gbc_btnCircle.gridy = 0;
		panelNorth.add(btnCircle, gbc_btnCircle);
		
		JButton btnDonut = new JButton("Donut");
		btnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=5;
			}
		});
		GridBagConstraints gbc_btnDonut = new GridBagConstraints();
		gbc_btnDonut.insets = new Insets(0, 0, 5, 5);
		gbc_btnDonut.gridx = 9;
		gbc_btnDonut.gridy = 0;
		panelNorth.add(btnDonut, gbc_btnDonut);
		
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		pnlDrawing = new PnlDrawing();
		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(number==1) {
					Draw_Point dlg = new Draw_Point();
					dlg.setVisible(true);
					if(dlg.isCheck()) {
						pnlDrawing.shapes.add(new Point(e.getX(),e.getY()));
						((Point)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setColor(dlg.getColor());
						pnlDrawing.repaint();
					}
					number=0;
				}
				else if(number==2) {
					
						if(firstPoint == null) {
							firstPoint = new Point(e.getX(), e.getY());
						}
						else if(secondPoint == null) {
							secondPoint = new Point(e.getX(), e.getY());
						}
						if(firstPoint != null && secondPoint != null) {
							Draw_Line dlg = new Draw_Line();
							dlg.setVisible(true);
							if(dlg.isCheck()) {
							pnlDrawing.shapes.add(new Line(firstPoint, secondPoint));
							((Line)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setColor(dlg.getColor());
							pnlDrawing.repaint();
							firstPoint = null;
							secondPoint = null;
							}
							number=0;	
						}
						
				}
				else if(number==3) {
					Draw_Rectangle dlg = new Draw_Rectangle();
					dlg.setVisible(true);
					if(dlg.isCheck()) {
						pnlDrawing.shapes.add(new Rectangle(new Point(e.getX(),e.getY()),dlg.getTextHeight(),dlg.getTextWidth()));
						((Rectangle)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setLineColor(dlg.getLineColor());
						((Rectangle)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setFillColor(dlg.getFillColor());
						pnlDrawing.repaint();
					}
					number=0;
				}
				else if(number==4) {
					Draw_Circle dlg = new Draw_Circle();
					dlg.setVisible(true);
						if(dlg.isCheck()) {
							pnlDrawing.shapes.add(new Circle(new Point(e.getX(),e.getY()),dlg.getRadius()));
							((Circle)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setLineColor(dlg.getLineColor());
							((Circle)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setFillColor(dlg.getFillColor());
							pnlDrawing.repaint();
						}
					number=0;
				}
				else if(number==5) {
					Draw_Donut dlg = new Draw_Donut();
					dlg.setVisible(true);
					if(dlg.isCheck()) {
						pnlDrawing.shapes.add(new Donut(new Point(e.getX(),e.getY()),dlg.getRadius(),dlg.getInnerRadius()));
						((Donut)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setLineColor(dlg.getLineColor());
						((Donut)pnlDrawing.shapes.get(pnlDrawing.shapes.size()-1)).setFillColor(dlg.getFillColor());
						pnlDrawing.repaint();
					}
					number=0;
				}
				else if(number==6) {
					for(int i = pnlDrawing.shapes.size() - 1; i >= 0; i--) {
						if(pnlDrawing.shapes.get(i).contains(e.getX(), e.getY()) && !pnlDrawing.shapes.get(i).isSelected() && find==false) {
							pnlDrawing.shapes.get(i).setSelected(true);
							find=true;
							}
						else if(pnlDrawing.shapes.get(i).contains(e.getX(), e.getY()) && pnlDrawing.shapes.get(i).isSelected()) {
							pnlDrawing.shapes.get(i).setSelected(false);
							find=false;
						}
					}
					pnlDrawing.repaint();
					number=0;
				}
			}
		});
		panelCenter.add(pnlDrawing, BorderLayout.CENTER);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSouth = new GridBagLayout();
		gbl_panelSouth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelSouth.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelSouth.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelSouth.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelSouth.setLayout(gbl_panelSouth);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 4;
		gbc_separator.gridy = 0;
		panelSouth.add(separator, gbc_separator);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				number=6;
			}
		});
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelect.gridx = 3;
		gbc_btnSelect.gridy = 3;
		panelSouth.add(btnSelect, gbc_btnSelect);
		
		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Shape s: pnlDrawing.shapes) {
					if(s.isSelected()) {
						test=true;
						if(s instanceof Point) {
							Point temp = (Point)s;
							Modify_Point dlg = new Modify_Point();
							dlg.setTextX(Integer.toString(temp.getX()));
							dlg.setTextY(Integer.toString(temp.getY()));
							dlg.setColor(temp.getColor());
							dlg.setVisible(true);
							if(dlg.isCheck()) {
								((Point) s).setX(dlg.getTextX());
								((Point) s).setY(dlg.getTextY());
								((Point) s).setColor(dlg.getColor());
								s.setSelected(false);
								find=false;
							}
						} else if(s instanceof Line) {
							Line temp = (Line)s;
							Modify_Line dlg = new Modify_Line();
							dlg.setStartX(Integer.toString(temp.getStartPoint().getX()));
							dlg.setStartY(Integer.toString(temp.getStartPoint().getY()));
							dlg.setEndX(Integer.toString(temp.getEndPoint().getX()));
							dlg.setEndY(Integer.toString(temp.getEndPoint().getY()));
							dlg.setColor(temp.getColor());
							dlg.setVisible(true);
							if(dlg.isCheck()) {
								((Line) s).setStartPoint(new Point(dlg.getStartX(),dlg.getStartY()));
								((Line) s).setEndPoint(new Point(dlg.getEndX(),dlg.getEndY()));
								((Line) s).setColor(dlg.getColor());
								s.setSelected(false);
								find=false;
							}
						} else if(s instanceof Rectangle) {
							Rectangle temp = (Rectangle)s;
							Modify_Rectangle dlg = new Modify_Rectangle();
							dlg.setUpperX(Integer.toString(temp.getUpperLeft().getX()));
							dlg.setUpperY(Integer.toString(temp.getUpperLeft().getY()));
							dlg.setTextHeight(Integer.toString(temp.getHeight()));
							dlg.setTextWidth(Integer.toString(temp.getWidth()));
							dlg.setLineColor(temp.getLineColor());
							dlg.setFillColor(temp.getFillColor());
							dlg.setVisible(true);
							if(dlg.isCheck()) {
								((Rectangle) s).setUpperLeft(new Point(dlg.getUpperX(),dlg.getUpperY()));
								((Rectangle) s).setHeight(dlg.getTextHeight());
								((Rectangle) s).setWidth(dlg.getTextWidth());
								((Rectangle) s).setLineColor(dlg.getLineColor());
								((Rectangle) s).setFillColor(dlg.getFillColor());
								s.setSelected(false);
								find=false;
							}
						}  else if(s instanceof Donut) {
							Donut temp = (Donut)s;
							Modify_Donut dlg = new Modify_Donut();
							dlg.setCenterX(Integer.toString(temp.getCenter().getX()));
							dlg.setCenterY(Integer.toString(temp.getCenter().getY()));
							dlg.setRadius(Integer.toString(temp.getRadius()));
							dlg.setInnerRadius(Integer.toString(temp.getInnerRadius()));
							dlg.setLineColor(temp.getLineColor());
							dlg.setFillColor(temp.getFillColor());
							dlg.setVisible(true);
							if(dlg.isCheck()) {
								((Donut)s).setCenter(new Point(dlg.getCenterX(),dlg.getCenterY()));
								try {
									((Donut)s).setRadius(dlg.getRadius());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								((Donut)s).setInnerRadius(dlg.getInnerRadius());
								((Donut)s).setLineColor(dlg.getLineColor());
								((Donut)s).setFillColor(dlg.getFillColor());
								s.setSelected(false);
								find=false;
							}
						} else if(s instanceof Circle) {
							Circle temp = (Circle)s;
							Modify_Circle dlg = new Modify_Circle();
							dlg.setCenterX(Integer.toString(temp.getCenter().getX()));
							dlg.setCenterY(Integer.toString(temp.getCenter().getY()));
							dlg.setRadius(Integer.toString(temp.getRadius()));
							dlg.setLineColor(temp.getLineColor());
							dlg.setFillColor(temp.getFillColor());
							dlg.setVisible(true);
							if(dlg.isCheck()) {
								((Circle)s).setCenter(new Point(dlg.getCenterX(),dlg.getCenterY()));
								try {
									((Circle)s).setRadius(dlg.getRadius());
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								((Circle)s).setLineColor(dlg.getLineColor());
								((Circle)s).setFillColor(dlg.getFillColor());
								s.setSelected(false);
								find=false;
							}
						}
					}
				}
				if(test==true) {
					test=false;
				}else {
					JOptionPane.showMessageDialog(null, "You need to select object!","Error",JOptionPane.WARNING_MESSAGE);	
				}
				pnlDrawing.repaint();
				number=0;
			}
		});
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 5);
		gbc_btnModify.gridx = 6;
		gbc_btnModify.gridy = 3;
		panelSouth.add(btnModify, gbc_btnModify);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				for(int i = pnlDrawing.shapes.size() - 1; i >= 0; i--) {
					if(pnlDrawing.shapes.get(i).isSelected()) {
						test=true; 
						int input = JOptionPane.showConfirmDialog(null, "Are you sure?", "Delete", JOptionPane.YES_NO_OPTION);
					if(input == 0) {
						pnlDrawing.shapes.get(i).setSelected(false);
						find=false;
						pnlDrawing.shapes.remove(i);
						pnlDrawing.repaint();
					}
				}
				}
				if(test==true) {
					test=false;
				}else {
					JOptionPane.showMessageDialog(null, "You need to select object!","Error",JOptionPane.WARNING_MESSAGE);	
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_btnDelete.gridx = 10;
		gbc_btnDelete.gridy = 3;
		panelSouth.add(btnDelete, gbc_btnDelete);
	}

}
