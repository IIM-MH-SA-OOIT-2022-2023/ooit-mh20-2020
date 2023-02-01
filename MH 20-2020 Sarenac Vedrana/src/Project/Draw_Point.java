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
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Draw_Point extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCurrentColor;
	private boolean check;
	private Color color=Color.BLACK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Draw_Point dialog = new Draw_Point();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Draw_Point() {
		setBounds(100, 100, 300, 200);
		setTitle("Draw Point");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblColor = new JLabel("Set color:");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 1;
			gbc_lblColor.gridy = 1;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			textCurrentColor = new JTextField();
			textCurrentColor.setHorizontalAlignment(SwingConstants.CENTER);
			textCurrentColor.setFont(new Font("Tahoma", Font.BOLD, 12));
			textCurrentColor.setText("Current color");
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
			gbc_btnSetColor.insets = new Insets(0, 0, 5, 0);
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
