package Gui;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dlgrgb extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCrvena;
	private JTextField textFieldZelena;
	private JTextField textFieldPlava;
	
	private int r,g,b;
	private boolean isCheck;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dlgrgb dialog = new Dlgrgb();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dlgrgb() {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblCrvena = new JLabel("Crvena");
			lblCrvena.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
			gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrvena.gridx = 1;
			gbc_lblCrvena.gridy = 1;
			contentPanel.add(lblCrvena, gbc_lblCrvena);
		}
		{
			textFieldCrvena = new JTextField();
			textFieldCrvena.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c>'9' || c == KeyEvent.VK_SPACE) {
						e.consume();
					}
				}
			});
			textFieldCrvena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_textFieldCrvena = new GridBagConstraints();
			gbc_textFieldCrvena.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldCrvena.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldCrvena.gridx = 3;
			gbc_textFieldCrvena.gridy = 1;
			contentPanel.add(textFieldCrvena, gbc_textFieldCrvena);
			textFieldCrvena.setColumns(10);
		}
		{
			JLabel lblZelena = new JLabel("Zelena");
			lblZelena.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblZelena = new GridBagConstraints();
			gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
			gbc_lblZelena.gridx = 1;
			gbc_lblZelena.gridy = 3;
			contentPanel.add(lblZelena, gbc_lblZelena);
		}
		{
			textFieldZelena = new JTextField();
			textFieldZelena.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c>'9' || c == KeyEvent.VK_SPACE) {
						e.consume();
					}
				}
			});
			textFieldZelena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_textFieldZelena = new GridBagConstraints();
			gbc_textFieldZelena.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldZelena.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldZelena.gridx = 3;
			gbc_textFieldZelena.gridy = 3;
			contentPanel.add(textFieldZelena, gbc_textFieldZelena);
			textFieldZelena.setColumns(10);
		}
		{
			JLabel lblPlava = new JLabel("Plava");
			lblPlava.setFont(new Font("Tahoma", Font.PLAIN, 13));
			GridBagConstraints gbc_lblPlava = new GridBagConstraints();
			gbc_lblPlava.insets = new Insets(0, 0, 0, 5);
			gbc_lblPlava.gridx = 1;
			gbc_lblPlava.gridy = 5;
			contentPanel.add(lblPlava, gbc_lblPlava);
		}
		{
			textFieldPlava = new JTextField();
			textFieldPlava.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(c < '0' || c>'9' || c == KeyEvent.VK_SPACE) {
						e.consume();
					}
				}
			});
			textFieldPlava.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_textFieldPlava = new GridBagConstraints();
			gbc_textFieldPlava.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPlava.gridx = 3;
			gbc_textFieldPlava.gridy = 5;
			contentPanel.add(textFieldPlava, gbc_textFieldPlava);
			textFieldPlava.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							r = Integer.parseInt(textFieldCrvena.getText());
							g = Integer.parseInt(textFieldZelena.getText());
							b = Integer.parseInt(textFieldPlava.getText());

							if((r>=0 && r<=255) && (g>=0 && g<=255) && (b>=0 && b<=255)) {
								isCheck=true;
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, "Vrednosti moraju da budu u rasponu od 0 do 255","Pogresan unos!",JOptionPane.WARNING_MESSAGE);
							
							}
							
							
						}catch(NumberFormatException e2) {
							JOptionPane.showMessageDialog(null, "Obavezan je unos brojeva","Pogresan unos!",JOptionPane.WARNING_MESSAGE);
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
	
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}
	public boolean isCheck() {
		return isCheck;
	}

}
