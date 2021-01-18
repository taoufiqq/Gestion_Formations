package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeAdmin {

	private JLabel Label1;
	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAdmin window = new HomeAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */

	private JTable table;
	
	public HomeAdmin() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 1174, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		
		JPanel panel = new JPanel();
		panel.setBounds(53, 123, 1049, 344);
		panel.setBackground(new Color(255, 255, 240));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 94, 1002, 239);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setRowSelectionAllowed(false);
		table.setSurrendersFocusOnKeystroke(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"idEmploye", "Nom", "Prenom", "Formation"
			}
		));
		
		JLabel lblNewLabel = new JLabel("List de demande de Formations :");
		lblNewLabel.setBounds(26, 22, 334, 31);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(260, 495, 677, 95);
		panel_1.setBackground(new Color(128, 0, 0));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Management User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				User u = new User();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(10, 25, 188, 41);
		panel_1.add(btnNewButton);
		
		JButton btncrudformation = new JButton("Management Formation");
		btncrudformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formation f = new Formation();
				frame.dispose();
			}
		});
		btncrudformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btncrudformation.setBounds(231, 25, 211, 41);
		panel_1.add(btncrudformation);
		
		JButton btnSessioncrud = new JButton("Management Session");
		btnSessioncrud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Session session = new Session();
				frame.dispose();
			}
		});
		btnSessioncrud.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSessioncrud.setBounds(475, 25, 192, 41);
		panel_1.add(btnSessioncrud);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(987, 22, 115, 45);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(53, 35, 331, 53);
		frame.getContentPane().add(lblNewLabel_1);
	}



}
