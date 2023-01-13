package TreciPrakticniTest;

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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DlgStudent extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textFieldIndeks;
	private boolean check;
	private String smer;
	private String godina;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStudent dialog = new DlgStudent();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStudent() {
		setModal(true);
		setTitle("Student");
		setBounds(100, 100, 200, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 20, 0, 0, 0, 0, 20, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{10, 14, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblIme = new JLabel("Ime:");
			lblIme.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblIme = new GridBagConstraints();
			gbc_lblIme.insets = new Insets(0, 0, 5, 5);
			gbc_lblIme.gridx = 5;
			gbc_lblIme.gridy = 1;
			contentPanel.add(lblIme, gbc_lblIme);
		}
		{
			textFieldIme = new JTextField();
			textFieldIme.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!((c>='A' && c<='Z') || (c>='a' && c<='z' || c==KeyEvent.VK_SPACE))) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldIme = new GridBagConstraints();
			gbc_textFieldIme.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldIme.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIme.gridx = 5;
			gbc_textFieldIme.gridy = 2;
			contentPanel.add(textFieldIme, gbc_textFieldIme);
			textFieldIme.setColumns(10);
		}
		{
			JLabel lblPrezime = new JLabel("Prezime:");
			lblPrezime.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblPrezime = new GridBagConstraints();
			gbc_lblPrezime.insets = new Insets(0, 0, 5, 5);
			gbc_lblPrezime.gridx = 5;
			gbc_lblPrezime.gridy = 3;
			contentPanel.add(lblPrezime, gbc_lblPrezime);
		}
		{
			textFieldPrezime = new JTextField();
			textFieldPrezime.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!((c>='A' && c<='Z') || (c>='a' && c<='z') || c==KeyEvent.VK_SPACE)) {
						e.consume();
					}
				}
			});
			GridBagConstraints gbc_textFieldPrezime = new GridBagConstraints();
			gbc_textFieldPrezime.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldPrezime.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldPrezime.gridx = 5;
			gbc_textFieldPrezime.gridy = 4;
			contentPanel.add(textFieldPrezime, gbc_textFieldPrezime);
			textFieldPrezime.setColumns(10);
		}
		{
			JLabel lblIndeks = new JLabel("Broj indeksa:");
			GridBagConstraints gbc_lblIndeks = new GridBagConstraints();
			gbc_lblIndeks.insets = new Insets(0, 0, 5, 5);
			gbc_lblIndeks.gridx = 5;
			gbc_lblIndeks.gridy = 5;
			contentPanel.add(lblIndeks, gbc_lblIndeks);
		}
		{
			JComboBox comboBox1 = new JComboBox();
			comboBox1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					smer = comboBox1.getSelectedItem().toString();
				}
			});
			comboBox1.setModel(new DefaultComboBoxModel(new String[] {"IM", "MH", "IIS"}));
			GridBagConstraints gbc_comboBox1 = new GridBagConstraints();
			gbc_comboBox1.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox1.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox1.gridx = 2;
			gbc_comboBox1.gridy = 6;
			contentPanel.add(comboBox1, gbc_comboBox1);
		}
		{
			textFieldIndeks = new JTextField();
			textFieldIndeks.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					char c = e.getKeyChar();
					if(!(c>='0' && c<='9')) {
						e.consume();
				}
				}
			});
			GridBagConstraints gbc_textFieldIndeks = new GridBagConstraints();
			gbc_textFieldIndeks.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldIndeks.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldIndeks.gridx = 5;
			gbc_textFieldIndeks.gridy = 6;
			contentPanel.add(textFieldIndeks, gbc_textFieldIndeks);
			textFieldIndeks.setColumns(10);
		}
		{
			JComboBox comboBox2 = new JComboBox();
			comboBox2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					godina = comboBox2.getSelectedItem().toString();
				}
			});
			comboBox2.setModel(new DefaultComboBoxModel(new String[] {"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022"}));
			GridBagConstraints gbc_comboBox2 = new GridBagConstraints();
			gbc_comboBox2.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox2.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox2.gridx = 7;
			gbc_comboBox2.gridy = 6;
			contentPanel.add(comboBox2, gbc_comboBox2);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_buttonPane.rowHeights = new int[]{0, 0, 0};
			gbl_buttonPane.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				JButton btnPotvrdi = new JButton("Potvrdi");
				btnPotvrdi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textFieldIme.getText().isBlank() || textFieldPrezime.getText().isBlank() || textFieldIndeks.getText().isBlank()
								|| godina==null || smer==null) {
							JOptionPane.showMessageDialog(null, "Nisu popunjena sva polja", "Greska pri unosu", JOptionPane.WARNING_MESSAGE);
						}else {
							check=true;
							dispose();
						}
					}
				});
				GridBagConstraints gbc_btnPotvrdi = new GridBagConstraints();
				gbc_btnPotvrdi.insets = new Insets(0, 0, 5, 5);
				gbc_btnPotvrdi.gridx = 2;
				gbc_btnPotvrdi.gridy = 0;
				buttonPane.add(btnPotvrdi, gbc_btnPotvrdi);
			}
			{
				JButton btnPonisti = new JButton("Ponisti");
				btnPonisti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				GridBagConstraints gbc_btnPonisti = new GridBagConstraints();
				gbc_btnPonisti.insets = new Insets(0, 0, 5, 5);
				gbc_btnPonisti.gridx = 8;
				gbc_btnPonisti.gridy = 0;
				buttonPane.add(btnPonisti, gbc_btnPonisti);
			}
		}
	}
	public String getSmer() {
		return smer;
	}
	public String getGodina() {
		return godina;
	}
	public String getIme() {
		return textFieldIme.getText();
	}
	public String getPrezime() {
		return textFieldPrezime.getText();
	}
	public String getIndeks() {
		return textFieldIndeks.getText();
	}
	public boolean isCheck() {
		return check;
	}
}
