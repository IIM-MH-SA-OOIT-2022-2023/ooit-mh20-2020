package Project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldR;
	private boolean check;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgAdd dialog = new DlgAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgAdd() {
		setModal(true);
		setTitle("Add/Delete");
		setBounds(100, 100, 350, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{20, 0, 20, 50, 50, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXCo = new JLabel("X coordinate:");
			lblXCo.setFont(new Font("Tahoma", Font.BOLD, 12));
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
			lblYCo.setFont(new Font("Tahoma", Font.BOLD, 12));
			GridBagConstraints gbc_lblYCo = new GridBagConstraints();
			gbc_lblYCo.insets = new Insets(0, 0, 5, 5);
			gbc_lblYCo.gridx = 1;
			gbc_lblYCo.gridy = 3;
			contentPanel.add(lblYCo, gbc_lblYCo);
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
			JLabel lblRadius = new JLabel("Radius");
			lblRadius.setFont(new Font("Tahoma", Font.BOLD, 12));
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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldX.getText().isBlank() || textFieldY.getText().isBlank() || textFieldR.getText().isBlank()) {
							JOptionPane.showMessageDialog(null,"You need to fill all fields","Error",JOptionPane.WARNING_MESSAGE);
						}else if(getTextR()==0) {
							JOptionPane.showMessageDialog(null,  "Radius cannot have value 0","Error",JOptionPane.WARNING_MESSAGE);
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
	
	public void setX(String x) {
		textFieldX.setText(x);
	}
	public void setY(String y) {
		textFieldY.setText(y);
	}
	public void setR(String r) {
		textFieldR.setText(r);
	}
	public int getTextX() {
		return Integer.valueOf(textFieldX.getText());
	}
	public int getTextY() {
		return Integer.valueOf(textFieldY.getText());
	}
	public int getTextR() {
		return Integer.valueOf(textFieldR.getText());
	}
	public boolean isCheck() {
		return check;
	}

}
