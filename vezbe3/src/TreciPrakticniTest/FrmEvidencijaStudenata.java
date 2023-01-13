package TreciPrakticniTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geo.Circle;
import geo.Point;
import test1.DlgKrug;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmEvidencijaStudenata extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm= new DefaultListModel<>();
	private JList list;
	private int brojac=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEvidencijaStudenata frame = new FrmEvidencijaStudenata();
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
	public FrmEvidencijaStudenata() {
		
		setTitle("Sarenac Vedrana MH20-2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Evidencija studenata - grupa B");
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelNorth.add(lblNaslov);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(128, 128, 128));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JLabel lblBrojac = new JLabel("Studenata u listi:"+brojac);
		panelSouth.add(lblBrojac);
		
		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					DlgStudent dlg = new DlgStudent();
					dlg.setVisible(true);
					if(dlg.isCheck()) {
						dlm.add(brojac,"Broj indeksa: "+dlg.getSmer()+" "+dlg.getIndeks()+"/"+dlg.getGodina()+", Prezime: "+dlg.getPrezime()+", Ime: "+dlg.getIme());
						brojac++;
						lblBrojac.setText("Broj krugova u listi:"+brojac);
					}
			}
			}
		}
		);
		list.setModel(dlm);
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(128, 128, 128));
		scrollPane.setViewportView(list);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(192, 192, 192));
		panelLeft.setForeground(new Color(255, 255, 255));
		contentPane.add(panelLeft, BorderLayout.WEST);
		GridBagLayout gbl_panelLeft = new GridBagLayout();
		gbl_panelLeft.columnWidths = new int[]{0, 0};
		gbl_panelLeft.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelLeft.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelLeft.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelLeft.setLayout(gbl_panelLeft);
		
		JLabel lblPanel = new JLabel("Panel akcija");
		lblPanel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblPanel = new GridBagConstraints();
		gbc_lblPanel.insets = new Insets(0, 0, 5, 0);
		gbc_lblPanel.gridx = 0;
		gbc_lblPanel.gridy = 3;
		panelLeft.add(lblPanel, gbc_lblPanel);
		
		
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStudent dlg = new DlgStudent();
				dlg.setVisible(true);
				if(dlg.isCheck()) {
					dlm.add(brojac,"Broj indeksa: "+dlg.getSmer()+" "+dlg.getIndeks()+"/"+dlg.getGodina()+", Prezime: "+dlg.getPrezime()+", Ime: "+dlg.getIme());
					brojac++;
					lblBrojac.setText("Broj krugova u listi:"+brojac);
				}
				
				
			}
		});
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 0);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 5;
		panelLeft.add(btnDodaj, gbc_btnDodaj);
		
		JPanel panelRight = new JPanel();
		contentPane.add(panelRight, BorderLayout.EAST);
		
		JButton btnUkloni = new JButton("Ukloni");
		btnUkloni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.isSelectionEmpty()) {
					dlm.remove(0);
					brojac--;
				}
				else if(!list.isSelectionEmpty()) {
					dlm.remove(list.getSelectedIndex());
					brojac--;
				}
				if(brojac==0) {
					JOptionPane.showMessageDialog(null, "Lista je prazna", "Greska pri brisanju", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		panelRight.add(btnUkloni);
		
		
	}

}
