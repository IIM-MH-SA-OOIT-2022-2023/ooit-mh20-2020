package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<>();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Aplikacija za bojenje");
		lblNaslov.setFont(new Font("Dialog", Font.BOLD, 20));
		panelNorth.add(lblNaslov);
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblCrvena = new JLabel("Crvena");
		lblCrvena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.fill = GridBagConstraints.VERTICAL;
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 1;
		panelCenter.add(lblCrvena, gbc_lblCrvena);
		
		JButton btnCrvena = new JButton("Oboji me");
		btnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNorth.setBackground(Color.RED);
				panelCenter.setBackground(Color.RED);
				dlm.add(0, lblCrvena.getText());
			}
		});
		GridBagConstraints gbc_btnCrvena = new GridBagConstraints();
		gbc_btnCrvena.fill = GridBagConstraints.VERTICAL;
		gbc_btnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrvena.gridx = 5;
		gbc_btnCrvena.gridy = 1;
		panelCenter.add(btnCrvena, gbc_btnCrvena);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 6;
		gbc_scrollPane.gridy = 1;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		
		JLabel lblZelena = new JLabel("Zelena");
		lblZelena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblZelena = new GridBagConstraints();
		gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
		gbc_lblZelena.gridx = 1;
		gbc_lblZelena.gridy = 2;
		panelCenter.add(lblZelena, gbc_lblZelena);
		
		JButton btnZelena = new JButton("Oboji me");
		btnZelena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNorth.setBackground(Color.GREEN);
				panelCenter.setBackground(Color.GREEN);
				dlm.add(0, lblZelena.getText());
			}
		});
		GridBagConstraints gbc_btnZelena = new GridBagConstraints();
		gbc_btnZelena.insets = new Insets(0, 0, 5, 5);
		gbc_btnZelena.gridx = 5;
		gbc_btnZelena.gridy = 2;
		panelCenter.add(btnZelena, gbc_btnZelena);
		
		JLabel lblPlava = new JLabel("Plava");
		lblPlava.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 3;
		panelCenter.add(lblPlava, gbc_lblPlava);
		
		JButton btnPlava = new JButton("Oboji me");
		btnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNorth.setBackground(Color.BLUE);
				panelCenter.setBackground(Color.BLUE);
				dlm.add(0, lblPlava.getText());
			}
		});
		GridBagConstraints gbc_btnPlava = new GridBagConstraints();
		gbc_btnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlava.gridx = 5;
		gbc_btnPlava.gridy = 3;
		panelCenter.add(btnPlava, gbc_btnPlava);
		
		JLabel lblUputstvo = new JLabel("Unesite boju u polje");
		lblUputstvo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblUputstvo = new GridBagConstraints();
		gbc_lblUputstvo.insets = new Insets(0, 0, 5, 5);
		gbc_lblUputstvo.gridx = 1;
		gbc_lblUputstvo.gridy = 5;
		panelCenter.add(lblUputstvo, gbc_lblUputstvo);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					dlm.add(0, textField.getText());
					textField.setText("");
				}
				
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 5;
		panelCenter.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Izaberite RGB boju");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlgrgb dlg= new Dlgrgb();
				dlg.setVisible(true);
				if(dlg.isCheck()) {
					
				panelCenter.setBackground(new Color(dlg.getR(),dlg.getG(),dlg.getB()));
				panelNorth.setBackground(new Color(dlg.getR(),dlg.getG(),dlg.getB()));
				panelSouth.setBackground(new Color(dlg.getR(),dlg.getG(),dlg.getB()));
				dlm.add(0, "Crvena "+dlg.getR()+", Zelena "+dlg.getG()+", Plava "+dlg.getB());
				}
				
			}
		});
		panelSouth.add(btnNewButton);
	}

}
