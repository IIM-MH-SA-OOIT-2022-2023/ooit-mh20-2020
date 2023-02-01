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
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Draw_Line extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCurrentColor;
	private boolean check;
	private Color color=Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Draw_Line dialog = new Draw_Line();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Draw_Line() {
		setBounds(100, 100, 300, 200);
		setTitle("Draw Line");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSetColor = new JLabel("Set Color:");
			GridBagConstraints gbc_lblSetColor = new GridBagConstraints();
			gbc_lblSetColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblSetColor.gridx = 1;
			gbc_lblSetColor.gridy = 1;
			contentPanel.add(lblSetColor, gbc_lblSetColor);
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
			gbc_textCurrentColor.gridy = 1;
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
			gbc_btnSetColor.gridy = 1;
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
						check=true;
						dispose();
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
	public boolean isCheck() {
		return check;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color c) {
		color=c;
	}
}
