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

public class Modify_Line extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldStartX;
	private JTextField textFieldStartY;
	private JTextField textFieldEndX;
	private JTextField textFieldEndY;
	private JTextField textCurrentColor;
	private Color color=Color.black;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modify_Line dialog = new Modify_Line();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modify_Line() {
		setBounds(100, 100, 450, 300);
		setTitle("Modify Line");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblStartX = new JLabel("Start point X coordinate:");
			GridBagConstraints gbc_lblStartX = new GridBagConstraints();
			gbc_lblStartX.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartX.gridx = 1;
			gbc_lblStartX.gridy = 1;
			contentPanel.add(lblStartX, gbc_lblStartX);
		}
		{
			textFieldStartX = new JTextField();
			textFieldStartX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldStartX = new GridBagConstraints();
			gbc_textFieldStartX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldStartX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartX.gridx = 3;
			gbc_textFieldStartX.gridy = 1;
			contentPanel.add(textFieldStartX, gbc_textFieldStartX);
			textFieldStartX.setColumns(10);
		}
		{
			JLabel lblStartY = new JLabel("Start point Y coordinate:");
			GridBagConstraints gbc_lblStartY = new GridBagConstraints();
			gbc_lblStartY.insets = new Insets(0, 0, 5, 5);
			gbc_lblStartY.gridx = 1;
			gbc_lblStartY.gridy = 3;
			contentPanel.add(lblStartY, gbc_lblStartY);
		}
		{
			textFieldStartY = new JTextField();
			textFieldStartY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldStartY = new GridBagConstraints();
			gbc_textFieldStartY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldStartY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldStartY.gridx = 3;
			gbc_textFieldStartY.gridy = 3;
			contentPanel.add(textFieldStartY, gbc_textFieldStartY);
			textFieldStartY.setColumns(10);
		}
		{
			JLabel lblEndX = new JLabel("End point X coordinate:");
			GridBagConstraints gbc_lblEndX = new GridBagConstraints();
			gbc_lblEndX.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndX.gridx = 1;
			gbc_lblEndX.gridy = 5;
			contentPanel.add(lblEndX, gbc_lblEndX);
		}
		{
			textFieldEndX = new JTextField();
			textFieldEndX.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldEndX = new GridBagConstraints();
			gbc_textFieldEndX.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldEndX.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndX.gridx = 3;
			gbc_textFieldEndX.gridy = 5;
			contentPanel.add(textFieldEndX, gbc_textFieldEndX);
			textFieldEndX.setColumns(10);
		}
		{
			JLabel lblEndY = new JLabel("End point Y coordinate:");
			GridBagConstraints gbc_lblEndY = new GridBagConstraints();
			gbc_lblEndY.insets = new Insets(0, 0, 5, 5);
			gbc_lblEndY.gridx = 1;
			gbc_lblEndY.gridy = 7;
			contentPanel.add(lblEndY, gbc_lblEndY);
		}
		{
			textFieldEndY = new JTextField();
			textFieldEndY.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldEndY = new GridBagConstraints();
			gbc_textFieldEndY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldEndY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldEndY.gridx = 3;
			gbc_textFieldEndY.gridy = 7;
			contentPanel.add(textFieldEndY, gbc_textFieldEndY);
			textFieldEndY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Set color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 9;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			textCurrentColor = new JTextField();
			textCurrentColor.setFont(new Font("Tahoma", Font.BOLD, 11));
			textCurrentColor.setText("Current color:");
			textCurrentColor.setEnabled(false);
			textCurrentColor.setBackground(color);
			GridBagConstraints gbc_textCurrentColor = new GridBagConstraints();
			gbc_textCurrentColor.insets = new Insets(0, 0, 5, 5);
			gbc_textCurrentColor.fill = GridBagConstraints.HORIZONTAL;
			gbc_textCurrentColor.gridx = 3;
			gbc_textCurrentColor.gridy = 9;
			contentPanel.add(textCurrentColor, gbc_textCurrentColor);
			textCurrentColor.setColumns(10);
		}
		{
			JButton btnSetColor = new JButton("Set new color");
			btnSetColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(btnSetColor, "Set New Color",textCurrentColor.getBackground());
					textCurrentColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnSetColor = new GridBagConstraints();
			gbc_btnSetColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetColor.gridx = 5;
			gbc_btnSetColor.gridy = 9;
			contentPanel.add(btnSetColor, gbc_btnSetColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {if(textFieldStartX.getText().isBlank() || textFieldStartY.getText().isBlank()
							|| textFieldEndX.getText().isBlank() || textFieldStartY.getText().isBlank()) {
						JOptionPane.showMessageDialog(null,  "You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
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
	public void setStartX(String s) {
		textFieldStartX.setText(s);
	}
	public int getStartX() {
		return Integer.valueOf(textFieldStartX.getText());
	}
	public void setStartY(String s) {
		textFieldStartY.setText(s);
	}
	public int getStartY() {
		return Integer.valueOf(textFieldStartY.getText());
	}
	public void setEndX(String s) {
		textFieldEndX.setText(s);
	}
	public int getEndX() {
		return Integer.valueOf(textFieldEndX.getText());
	}
	public void setEndY(String s) {
		textFieldEndY.setText(s);
	}
	public int getEndY() {
		return Integer.valueOf(textFieldEndY.getText());
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c) {
		textCurrentColor.setBackground(c);
		color=c;
	}
	public boolean isCheck() {
		return check;
	}
}
