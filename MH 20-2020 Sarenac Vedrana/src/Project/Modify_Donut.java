package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modify_Donut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldR;
	private JTextField textFieldIR;
	private JTextField textFieldBorder;
	private JTextField textFieldFill;
	private Color lineColor=Color.black;
	private Color fillColor=Color.white;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modify_Donut dialog = new Modify_Donut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modify_Donut() {
		setBounds(100, 100, 450, 300);
		setTitle("Modify Donut");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCenterX = new JLabel("Center point X coordinate:");
			GridBagConstraints gbc_lblCenterX = new GridBagConstraints();
			gbc_lblCenterX.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterX.gridx = 1;
			gbc_lblCenterX.gridy = 1;
			contentPanel.add(lblCenterX, gbc_lblCenterX);
		}
		{
			textFieldX = new JTextField();
			textFieldX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldX = new GridBagConstraints();
			gbc_textFieldX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldX.gridx = 3;
			gbc_textFieldX.gridy = 1;
			contentPanel.add(textFieldX, gbc_textFieldX);
			textFieldX.setColumns(10);
		}
		{
			JLabel lblCenterY = new JLabel("Center point Y coordinate:");
			GridBagConstraints gbc_lblCenterY = new GridBagConstraints();
			gbc_lblCenterY.insets = new Insets(0, 0, 5, 5);
			gbc_lblCenterY.gridx = 1;
			gbc_lblCenterY.gridy = 3;
			contentPanel.add(lblCenterY, gbc_lblCenterY);
		}
		{
			textFieldY = new JTextField();
			textFieldY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 3;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 5;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textFieldR = new JTextField();
			textFieldR.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldR = new GridBagConstraints();
			gbc_textFieldR.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldR.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldR.gridx = 3;
			gbc_textFieldR.gridy = 5;
			contentPanel.add(textFieldR, gbc_textFieldR);
			textFieldR.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Inner radius:");
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblInnerRadius.gridx = 1;
			gbc_lblInnerRadius.gridy = 7;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			textFieldIR = new JTextField();
			textFieldIR.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldIR = new GridBagConstraints();
			gbc_textFieldIR.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldIR.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIR.gridx = 3;
			gbc_textFieldIR.gridy = 7;
			contentPanel.add(textFieldIR, gbc_textFieldIR);
			textFieldIR.setColumns(10);
		}
		{
			JLabel lblColorB = new JLabel("Set border color:");
			GridBagConstraints gbc_lblColorB = new GridBagConstraints();
			gbc_lblColorB.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorB.gridx = 1;
			gbc_lblColorB.gridy = 9;
			contentPanel.add(lblColorB, gbc_lblColorB);
		}
		{
			textFieldBorder = new JTextField();
			textFieldBorder.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldBorder.setText("Current color:");
			textFieldBorder.setEnabled(false);
			textFieldBorder.setBackground(lineColor);
			GridBagConstraints gbc_textFieldBorder = new GridBagConstraints();
			gbc_textFieldBorder.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldBorder.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldBorder.gridx = 3;
			gbc_textFieldBorder.gridy = 9;
			contentPanel.add(textFieldBorder, gbc_textFieldBorder);
			textFieldBorder.setColumns(10);
		}
		{
			JButton btnColorB = new JButton("Set new color");
			btnColorB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(btnColorB, "Set New Color",textFieldBorder.getBackground());
					textFieldBorder.setBackground(lineColor);
				}
			});
			GridBagConstraints gbc_btnColorB = new GridBagConstraints();
			gbc_btnColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnColorB.gridx = 5;
			gbc_btnColorB.gridy = 9;
			contentPanel.add(btnColorB, gbc_btnColorB);
		}
		{
			JLabel lblColorFill = new JLabel("Set fill color:");
			GridBagConstraints gbc_lblColorFill = new GridBagConstraints();
			gbc_lblColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorFill.gridx = 1;
			gbc_lblColorFill.gridy = 11;
			contentPanel.add(lblColorFill, gbc_lblColorFill);
		}
		{
			textFieldFill = new JTextField();
			textFieldFill.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldFill.setText("Current color:");
			textFieldFill.setEnabled(false);
			textFieldFill.setBackground(fillColor);
			GridBagConstraints gbc_textFieldFill = new GridBagConstraints();
			gbc_textFieldFill.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldFill.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldFill.gridx = 3;
			gbc_textFieldFill.gridy = 11;
			contentPanel.add(textFieldFill, gbc_textFieldFill);
			textFieldFill.setColumns(10);
		}
		{
			JButton btnColorFill = new JButton("Set new color");
			btnColorFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(btnColorFill, "Set New Color",textFieldFill.getBackground());
					textFieldFill.setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnColorFill = new GridBagConstraints();
			gbc_btnColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_btnColorFill.gridx = 5;
			gbc_btnColorFill.gridy = 11;
			contentPanel.add(btnColorFill, gbc_btnColorFill);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldX.getText().isBlank() || textFieldY.getText().isBlank()
								|| textFieldR.getText().isBlank() || textFieldIR.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getRadius()==0  || getInnerRadius()==0) {
								JOptionPane.showMessageDialog(null, "Radius cannot have value 0","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getRadius()<=getInnerRadius()) {
								JOptionPane.showMessageDialog(null, "Radius must be greater then inner radius","Error",JOptionPane.WARNING_MESSAGE);
						}else {
							check=true;
							dispose();
							}
						}	
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setCenterX(String s) {
		textFieldX.setText(s);
	}
	public int getCenterX() {
		return Integer.valueOf(textFieldX.getText());
	}
	public void setCenterY(String s) {
		textFieldY.setText(s);
	}
	public int getCenterY() {
		return Integer.valueOf(textFieldY.getText());
	}
	public void setRadius(String s) {
		textFieldR.setText(s);
	}
	public int getRadius() {
		return Integer.valueOf(textFieldR.getText());
	}
	public void setInnerRadius(String s) {
		textFieldIR.setText(s);
	}
	public int getInnerRadius() {
		return Integer.valueOf(textFieldIR.getText());
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color c) {
		textFieldBorder.setBackground(c);
		lineColor=c;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color c) {
		textFieldFill.setBackground(c);
		fillColor=c;
	}
	public boolean isCheck() {
		return check;
	}
}
