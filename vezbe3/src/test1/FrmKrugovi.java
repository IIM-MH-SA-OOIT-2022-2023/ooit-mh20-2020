package test1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geo.Circle;
import geo.Point;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmKrugovi extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<>();
	private JList list;
	private int a=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKrugovi frame = new FrmKrugovi();
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
	public FrmKrugovi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Krugovi");
		lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaslov.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelNorth.add(lblNaslov);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(128, 128, 128));
		panelCenter.setForeground(new Color(128, 128, 128));
		contentPane.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JLabel lblBrojac = new JLabel("Broj krugova u listi:"+a);
		panelSouth.add(lblBrojac);
		
		list = new JList();
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()== KeyEvent.VK_ENTER) {
					String krug = dlm.get(list.getSelectedIndex());
					String[] razdvajanje = krug.split("=");
					int polu;
					double pov;
					String b=null;
					b=razdvajanje[1];
					polu=Integer.valueOf(b);
					pov=polu*polu*Math.PI;
					JOptionPane.showMessageDialog(null, "Povrsina selektovanog kruga je "+pov, "Povrsina", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		list.setModel(dlm);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == MouseEvent.BUTTON3) {
					DlgKrug dlg = new DlgKrug();
					dlg.setVisible(true);
					if(dlg.isCheck()) {
						Circle c=new Circle(new Point(-1,-1),dlg.getPoluprecnik());
						dlm.add(a,c.toString()+dlg.getA());
						a++;
						lblBrojac.setText("Broj krugova u listi:"+a);
					}
				}
				
			}
		});
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setForeground(new Color(255, 255, 255));
		list.setBackground(new Color(128, 128, 128));
		scrollPane.setViewportView(list);
		
		
		
		
	}

}
