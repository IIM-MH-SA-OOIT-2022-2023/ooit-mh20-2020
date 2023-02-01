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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Draw_Circle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textFieldBorder;
	private JTextField textFieldFill;
	private boolean check;
	private Color lineColor=Color.BLACK;
	private Color fillColor=Color.WHITE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Draw_Circle dialog = new Draw_Circle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Draw_Circle() {
		setBounds(100, 100, 450, 300);
		setTitle("Draw Circle");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRadius = new JLabel("Set radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 1;
			gbc_lblRadius.gridy = 1;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblSetColorB = new JLabel("Set border color:");
			GridBagConstraints gbc_lblSetColorB = new GridBagConstraints();
			gbc_lblSetColorB.insets = new Insets(0, 0, 5, 5);
			gbc_lblSetColorB.gridx = 1;
			gbc_lblSetColorB.gridy = 3;
			contentPanel.add(lblSetColorB, gbc_lblSetColorB);
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
			gbc_textFieldBorder.gridy = 3;
			contentPanel.add(textFieldBorder, gbc_textFieldBorder);
			textFieldBorder.setColumns(10);
		}
		{
			JButton btnSetBorder = new JButton("Set new color");
			btnSetBorder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(btnSetBorder, "Set New Color",textFieldBorder.getBackground());
					textFieldBorder.setBackground(lineColor);
				}
			});
			GridBagConstraints gbc_btnSetBorder = new GridBagConstraints();
			gbc_btnSetBorder.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetBorder.gridx = 5;
			gbc_btnSetBorder.gridy = 3;
			contentPanel.add(btnSetBorder, gbc_btnSetBorder);
		}
		{
			JLabel lblSetColorFill = new JLabel("Set fill color:");
			GridBagConstraints gbc_lblSetColorFill = new GridBagConstraints();
			gbc_lblSetColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_lblSetColorFill.gridx = 1;
			gbc_lblSetColorFill.gridy = 5;
			contentPanel.add(lblSetColorFill, gbc_lblSetColorFill);
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
			gbc_textFieldFill.gridy = 5;
			contentPanel.add(textFieldFill, gbc_textFieldFill);
			textFieldFill.setColumns(10);
		}
		{
			JButton btnSetFill = new JButton("Set new color");
			btnSetFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(btnSetFill, "Set New Color",textFieldFill.getBackground());
					textFieldFill.setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnSetFill = new GridBagConstraints();
			gbc_btnSetFill.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetFill.gridx = 5;
			gbc_btnSetFill.gridy = 5;
			contentPanel.add(btnSetFill, gbc_btnSetFill);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getRadius()==0) {
							JOptionPane.showMessageDialog(null, "Radius cannot have value 0","Error",JOptionPane.WARNING_MESSAGE);
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
	public int getRadius() {
		return Integer.valueOf(textField.getText());
	}
	public boolean isCheck() {
		return check;
	}
	public Color getLineColor() {
		return lineColor;
	}
	public void setLineColor(Color c) {
		lineColor=c;
	}
	public Color getFillColor() {
		return fillColor;
	}
	public void setFillColor(Color c) {
		fillColor=c;
	}

}
