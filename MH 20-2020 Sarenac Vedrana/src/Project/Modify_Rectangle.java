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
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modify_Rectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldH;
	private JTextField textFieldW;
	private JTextField textFieldColorB;
	private JTextField textFieldColorFill;
	private Color lineColor=Color.black;
	private Color fillColor=Color.white;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modify_Rectangle dialog = new Modify_Rectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modify_Rectangle() {
		setBounds(100, 100, 450, 300);
		setTitle("Modify Rectangle");	
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
			JLabel lblUpperLX = new JLabel("Upper left point X coordinate:");
			GridBagConstraints gbc_lblUpperLX = new GridBagConstraints();
			gbc_lblUpperLX.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLX.gridx = 1;
			gbc_lblUpperLX.gridy = 1;
			contentPanel.add(lblUpperLX, gbc_lblUpperLX);
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
			JLabel lblUpperLY = new JLabel("Upper lefit point Y coordinate:");
			GridBagConstraints gbc_lblUpperLY = new GridBagConstraints();
			gbc_lblUpperLY.insets = new Insets(0, 0, 5, 5);
			gbc_lblUpperLY.gridx = 1;
			gbc_lblUpperLY.gridy = 3;
			contentPanel.add(lblUpperLY, gbc_lblUpperLY);
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
			JLabel lblHeight = new JLabel("Height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 5;
			contentPanel.add(lblHeight, gbc_lblHeight);
		} 
		{
			textFieldH = new JTextField();
			textFieldH.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldH = new GridBagConstraints();
			gbc_textFieldH.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldH.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldH.gridx = 3;
			gbc_textFieldH.gridy = 5;
			contentPanel.add(textFieldH, gbc_textFieldH);
			textFieldH.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 7;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			textFieldW = new JTextField();
			textFieldW.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldW = new GridBagConstraints();
			gbc_textFieldW.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldW.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldW.gridx = 3;
			gbc_textFieldW.gridy = 7;
			contentPanel.add(textFieldW, gbc_textFieldW);
			textFieldW.setColumns(10);
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
			textFieldColorB = new JTextField();
			textFieldColorB.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldColorB.setText("Current color:");
			textFieldColorB.setEnabled(false);
			textFieldColorB.setBackground(lineColor);
			GridBagConstraints gbc_textFieldColorB = new GridBagConstraints();
			gbc_textFieldColorB.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldColorB.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldColorB.gridx = 3;
			gbc_textFieldColorB.gridy = 9;
			contentPanel.add(textFieldColorB, gbc_textFieldColorB);
			textFieldColorB.setColumns(10);
		}
		{
			JButton btnSetColorB = new JButton("Set new color");
			btnSetColorB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(btnSetColorB, "Set New Color",textFieldColorB.getBackground());
					textFieldColorB.setBackground(lineColor);
				}
			});
			GridBagConstraints gbc_btnSetColorB = new GridBagConstraints();
			gbc_btnSetColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetColorB.gridx = 5;
			gbc_btnSetColorB.gridy = 9;
			contentPanel.add(btnSetColorB, gbc_btnSetColorB);
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
			textFieldColorFill = new JTextField();
			textFieldColorFill.setFont(new Font("Tahoma", Font.BOLD, 11));
			textFieldColorFill.setText("Current color:");
			textFieldColorFill.setEnabled(false);
			textFieldColorFill.setBackground(fillColor);
			GridBagConstraints gbc_textFieldColorFill = new GridBagConstraints();
			gbc_textFieldColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldColorFill.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldColorFill.gridx = 3;
			gbc_textFieldColorFill.gridy = 11;
			contentPanel.add(textFieldColorFill, gbc_textFieldColorFill);
			textFieldColorFill.setColumns(10);
		}
		{
			JButton btnFill = new JButton("Set new color");
			btnFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(btnFill, "Set New Color",textFieldColorFill.getBackground());
					textFieldColorFill.setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnFill = new GridBagConstraints();
			gbc_btnFill.insets = new Insets(0, 0, 5, 5);
			gbc_btnFill.gridx = 5;
			gbc_btnFill.gridy = 11;
			contentPanel.add(btnFill, gbc_btnFill);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldW.getText().isBlank() || textFieldH.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getTextHeight()==0) {
							JOptionPane.showMessageDialog(null, "Height cannot have value 0","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getTextWidth()==0) {
							JOptionPane.showMessageDialog(null, "Width cannot have value 0","Error",JOptionPane.WARNING_MESSAGE);
						}else{
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
	public void setUpperX(String s) {
		textFieldX.setText(s);
	}
	public int getUpperX() {
		return Integer.valueOf(textFieldX.getText());
	}
	public void setUpperY(String s) {
		textFieldY.setText(s);
	}
	public int getUpperY() {
		return Integer.valueOf(textFieldY.getText());
	}
	public void setTextHeight(String s) {
		textFieldH.setText(s);
	}
	public int getTextHeight() {
		return Integer.valueOf(textFieldH.getText());
	}
	public void setTextWidth(String s) {
		textFieldW.setText(s);
	}
	public int getTextWidth() {
		return Integer.valueOf(textFieldW.getText());
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color c) {
		textFieldColorB.setBackground(c);
		lineColor=c;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color c) {
		textFieldColorFill.setBackground(c);
		fillColor=c;
	}
	public boolean isCheck() {
		return check;
	}
}
