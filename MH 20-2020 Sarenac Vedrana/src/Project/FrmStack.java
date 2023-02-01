package Project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmStack extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm= new DefaultListModel<>();
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
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
	public FrmStack() {

		setTitle("Stack Sarenac Vedrana MH20/2020");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitle = new JPanel();
		contentPane.add(panelTitle, BorderLayout.NORTH);
		GridBagLayout gbl_panelTitle = new GridBagLayout();
		gbl_panelTitle.columnWidths = new int[]{190, 45, 0, 0};
		gbl_panelTitle.rowHeights = new int[]{13, 0};
		gbl_panelTitle.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelTitle.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelTitle.setLayout(gbl_panelTitle);
		
		JLabel lblTitle = new JLabel("Circle list:");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 0, 5);
		gbc_lblTitle.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelTitle.add(lblTitle, gbc_lblTitle);
		
		JScrollPane scrollPaneCenter = new JScrollPane();
		contentPane.add(scrollPaneCenter, BorderLayout.CENTER);
		
		list = new JList();
		list.setModel(dlm);
		scrollPaneCenter.setViewportView(list);
		
		JPanel panelBtn = new JPanel();
		contentPane.add(panelBtn, BorderLayout.SOUTH);
		GridBagLayout gbl_panelBtn = new GridBagLayout();
		gbl_panelBtn.columnWidths = new int[]{100, 50, 0, 50, 100, 0};
		gbl_panelBtn.rowHeights = new int[]{21, 0};
		gbl_panelBtn.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBtn.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelBtn.setLayout(gbl_panelBtn);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAdd dlg = new DlgAdd();
				dlg.setVisible(true);
				if(dlg.isCheck()) {
					dlm.add(0,new Circle(new Point(dlg.getTextX(),dlg.getTextY()),dlg.getTextR()));
				}
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.gridx = 1;
		gbc_btnAdd.gridy = 0;
		panelBtn.add(btnAdd, gbc_btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgAdd dlg = new DlgAdd();
				Circle b = new Circle();
				if(list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "You need to select object!",
									"Error", JOptionPane.WARNING_MESSAGE);
				}else {
				b = dlm.getElementAt(list.getSelectedIndex());
				dlg.setX(Integer.toString(b.getCenter().getX()));
				dlg.setY(Integer.toString(b.getCenter().getY()));
				dlg.setR(Integer.toString(b.getRadius()));
				dlg.setVisible(true);
				}
				if(dlg.isCheck()) {
					dlm.remove(list.getSelectedIndex());
				}
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnDelete.gridx = 3;
		gbc_btnDelete.gridy = 0;
		panelBtn.add(btnDelete, gbc_btnDelete);
	}

}
