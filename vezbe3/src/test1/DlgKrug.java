package test1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOK;
	private JTextField textField;
	private boolean check;
	private String a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgKrug dialog = new DlgKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgKrug() {
		setTitle("Krug");
		setModal(true);
		setBounds(100, 100, 300, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPoluorecnik = new JLabel("Poluprecnik");
			GridBagConstraints gbc_lblPoluorecnik = new GridBagConstraints();
			gbc_lblPoluorecnik.insets = new Insets(0, 0, 5, 5);
			gbc_lblPoluorecnik.gridx = 1;
			gbc_lblPoluorecnik.gridy = 1;
			contentPanel.add(lblPoluorecnik, gbc_lblPoluorecnik);
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
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblBojaIvice = new JLabel("Boja Ivice");
			GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
			gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaIvice.gridx = 1;
			gbc_lblBojaIvice.gridy = 3;
			contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);
		}
		{
			JComboBox comboBoxivica = new JComboBox();
			comboBoxivica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				 a = comboBoxivica.getSelectedItem().toString();
				}
			});
			comboBoxivica.setModel(new DefaultComboBoxModel(new String[] {"Crvena", "Zuta", "Plava", "Zelena", "Bela", "Crna"}));
			GridBagConstraints gbc_comboBoxivica = new GridBagConstraints();
			gbc_comboBoxivica.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxivica.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxivica.gridx = 4;
			gbc_comboBoxivica.gridy = 3;
			contentPanel.add(comboBoxivica, gbc_comboBoxivica);
		}
		{
			JLabel lblBojaUnt = new JLabel("Boja unutrasnjosti");
			GridBagConstraints gbc_lblBojaUnt = new GridBagConstraints();
			gbc_lblBojaUnt.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaUnt.gridx = 1;
			gbc_lblBojaUnt.gridy = 5;
			contentPanel.add(lblBojaUnt, gbc_lblBojaUnt);
		}
		{
			JComboBox comboBoxunutra = new JComboBox();
			comboBoxunutra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//dlm.add(a,comboBox.getSelectedItem().toString());
					//a++;
				}
			});
			comboBoxunutra.setModel(new DefaultComboBoxModel(new String[] {"Crvena", "Zuta", "Plava", "Zelena", "Bela", "Crna"}));
			GridBagConstraints gbc_comboBoxunutra = new GridBagConstraints();
			gbc_comboBoxunutra.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxunutra.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBoxunutra.gridx = 4;
			gbc_comboBoxunutra.gridy = 5;
			contentPanel.add(comboBoxunutra, gbc_comboBoxunutra);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{35, 0, 100, 0, 0, 0, 0, 0, 0, 100, 0, 0, 0};
			gbl_buttonPane.rowHeights = new int[]{0, 0, 0};
			gbl_buttonPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				btnOK = new JButton("Potvrda");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "Poluprecnik ne sme biti neodredjen", "Greska pri unosu", JOptionPane.WARNING_MESSAGE);
						}else {
							check=true;
							dispose();
						}
						
					}
				});
				GridBagConstraints gbc_btnOK = new GridBagConstraints();
				gbc_btnOK.insets = new Insets(0, 0, 5, 5);
				gbc_btnOK.gridx = 2;
				gbc_btnOK.gridy = 0;
				buttonPane.add(btnOK, gbc_btnOK);
			}
			{
				JButton btnCancel = new JButton("Ponisti");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				GridBagConstraints gbc_btnCancel = new GridBagConstraints();
				gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
				gbc_btnCancel.gridx = 9;
				gbc_btnCancel.gridy = 0;
				buttonPane.add(btnCancel, gbc_btnCancel);
			}
		}
	}
	public String getA() {
		return a;
	}
	 public int getPoluprecnik() {
		 return Integer.valueOf(textField.getText());
	 }
	 
	public boolean isCheck() {
		return check;
	}
}
