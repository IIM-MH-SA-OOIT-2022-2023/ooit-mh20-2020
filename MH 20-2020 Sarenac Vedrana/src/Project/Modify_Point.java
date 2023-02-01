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

public class Modify_Point extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textCurrentColor;
	private Color color=Color.black;
	private boolean check;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Modify_Point dialog = new Modify_Point();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Modify_Point() {
		setBounds(100, 100, 450, 300);
		setTitle("Modify Point");
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
			JLabel lblXCo = new JLabel("X coordinate:");
			GridBagConstraints gbc_lblXCo = new GridBagConstraints();
			gbc_lblXCo.insets = new Insets(0, 0, 5, 5);
			gbc_lblXCo.gridx = 1;
			gbc_lblXCo.gridy = 1;
			contentPanel.add(lblXCo, gbc_lblXCo);
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
			JLabel lblYCo = new JLabel("Y coordinate:");
			GridBagConstraints gbc_lblYCo = new GridBagConstraints();
			gbc_lblYCo.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCo.gridx = 1;
			gbc_lblYCo.gridy = 3;
			contentPanel.add(lblYCo, gbc_lblYCo);
		}
		{
			textFieldY = new JTextField();
			GridBagConstraints gbc_textFieldY = new GridBagConstraints();
			gbc_textFieldY.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldY.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldY.gridx = 3;
			gbc_textFieldY.gridy = 3;
			contentPanel.add(textFieldY, gbc_textFieldY);
			textFieldY.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Set color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 5;
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
			gbc_textCurrentColor.gridy = 5;
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
			gbc_btnSetColor.gridy = 5;
			contentPanel.add(btnSetColor, gbc_btnSetColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldX.getText().isBlank() || textFieldY.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
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
	public void setTextX(String s) {
		textFieldX.setText(s);
	}
	public int getTextX() {
		return Integer.valueOf(textFieldX.getText());
	}
	public void setTextY(String s) {
		textFieldY.setText(s);
	}
	public int getTextY() {
		return Integer.valueOf(textFieldY.getText());
	}
	public void setColor(Color c) {
		textCurrentColor.setBackground(c);
		color=c;
	}
	public Color getColor() {
		return color;
	}
	public boolean isCheck() {
		return check;
	}
}
