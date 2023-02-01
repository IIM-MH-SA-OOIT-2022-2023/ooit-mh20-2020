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

public class Draw_Rectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldH;
	private JTextField textFieldW;
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
			Draw_Rectangle dialog = new Draw_Rectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Draw_Rectangle() {
		setBounds(100, 100, 450, 300);
		setTitle("Draw Rectangle");
		setModal(true);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblHeight = new JLabel("Set height");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 1;
			gbc_lblHeight.gridy = 1;
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
			gbc_textFieldH.gridy = 1;
			contentPanel.add(textFieldH, gbc_textFieldH);
			textFieldH.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Set width");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 1;
			gbc_lblWidth.gridy = 3;
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
			gbc_textFieldW.gridy = 3;
			contentPanel.add(textFieldW, gbc_textFieldW);
			textFieldW.setColumns(10);
		}
		{
			JLabel lblColorB = new JLabel("Set border color:");
			GridBagConstraints gbc_lblColorB = new GridBagConstraints();
			gbc_lblColorB.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorB.gridx = 1;
			gbc_lblColorB.gridy = 5;
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
			gbc_textFieldBorder.gridy = 5;
			contentPanel.add(textFieldBorder, gbc_textFieldBorder);
			textFieldBorder.setColumns(10);
		}
		{
			JButton btnSetColorB = new JButton("Set new color");
			btnSetColorB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(btnSetColorB, "Set New Color",textFieldBorder.getBackground());
					textFieldBorder.setBackground(lineColor);
				}
			});
			GridBagConstraints gbc_btnSetColorB = new GridBagConstraints();
			gbc_btnSetColorB.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetColorB.gridx = 5;
			gbc_btnSetColorB.gridy = 5;
			contentPanel.add(btnSetColorB, gbc_btnSetColorB);
		}
		{
			JLabel lblColorFill = new JLabel("Set fill color:");
			GridBagConstraints gbc_lblColorFill = new GridBagConstraints();
			gbc_lblColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_lblColorFill.gridx = 1;
			gbc_lblColorFill.gridy = 7;
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
			gbc_textFieldFill.gridy = 7;
			contentPanel.add(textFieldFill, gbc_textFieldFill);
			textFieldFill.setColumns(10);
		}
		{
			JButton btnSetColorFill = new JButton("Set new color");
			btnSetColorFill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fillColor = JColorChooser.showDialog(btnSetColorFill, "Set New Color",textFieldFill.getBackground());
					textFieldFill.setBackground(fillColor);
				}
			});
			GridBagConstraints gbc_btnSetColorFill = new GridBagConstraints();
			gbc_btnSetColorFill.insets = new Insets(0, 0, 5, 5);
			gbc_btnSetColorFill.gridx = 5;
			gbc_btnSetColorFill.gridy = 7;
			contentPanel.add(btnSetColorFill, gbc_btnSetColorFill);
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
	public int getTextHeight() {
		return Integer.valueOf(textFieldH.getText());
	}
	public int getTextWidth() {
		return Integer.parseInt(textFieldW.getText());
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
