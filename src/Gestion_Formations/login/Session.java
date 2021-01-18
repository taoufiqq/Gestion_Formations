package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class Session {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	Connection conn;
	PreparedStatement stmt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session window = new Session();
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
	public Session() {
		initialize();
		show();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 1147, 665);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeAdmin home = new HomeAdmin();
				frame.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(28, 24, 116, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login lg = new Login();
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(976, 24, 115, 45);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblNewLabel = new JLabel("Management Session");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(28, 92, 216, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(28, 133, 367, 448);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("Session Date :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 91, 109, 23);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(22, 332, 326, 98);
		panel.add(panel_1);
		
		JComboBox<String> formationCmbx = new JComboBox<String>();
		formationCmbx.setBounds(155, 172, 193, 32);
		panel.add(formationCmbx);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
					 
			 stmt = conn.prepareStatement("SELECT * FROM formation");
				
			 ResultSet result = stmt.executeQuery();
			 



			 
			 while(result.next()) {
				String f = result.getString("libelle");
	            formationCmbx.addItem(f);
				 
	         }
			

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date_session =textField.getText();
				String Formation = formationCmbx.getSelectedItem().toString();


				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
					 
					 String sql = "insert into session (libelle,formation) " + " values(?,?) ";
					
					 
					 stmt = conn.prepareStatement(sql);
						
					 stmt.setString(1,date_session);
					 stmt.setString(2,Formation);

			
				      stmt.execute();
				
					 JOptionPane.showMessageDialog(btnAdd, "Session Added Successfully");
					  show();
					  Clear();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBounds(10, 11, 89, 32);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				
			    
					try {
						
						String date_session =textField.getText();
						String Formation = formationCmbx.getSelectedItem().toString();

							
							
							int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());

						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
						 
						 stmt = conn.prepareStatement("UPDATE session SET " + "libelle = '" + date_session+ "', formation = '" + Formation + "' where idSession = '" + id + "'");
						 stmt.executeUpdate();
					  
					     JOptionPane.showMessageDialog(btnAdd, "Session edited Successfully");
				
					     show();
						 Clear();
				

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdate.setBounds(109, 11, 108, 32);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int msg = JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(msg==0) {
					
			
				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();	
				
			
				
			     try {
						
						
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						
						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
						 
					
					     stmt = conn.prepareStatement("DELETE from session  where idSession = '" + id + "'");
						 stmt.executeUpdate();
						  
						 JOptionPane.showMessageDialog(btnAdd, "Session Deleted Successfully");
						 show();
			             Clear();
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDelete.setBounds(227, 11, 89, 32);
		panel_1.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(109, 54, 106, 32);
		panel_1.add(btnReset);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setColumns(10);
		textField.setBounds(155, 87, 193, 32);
		panel.add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("Formation :");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(34, 175, 92, 23);
		panel.add(lblNewLabel_1_2);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(441, 133, 670, 199);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("List Sessions :");
		lblNewLabel_3.setBounds(10, 11, 171, 22);
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 650, 133);
		panel_2.add(scrollPane);
		
	
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 textField.setText(df.getValueAt(selectedIndex, 1).toString());

				
				
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_Session", "Session Date", "Formation"
			}
		));
		scrollPane.setViewportView(table);
	}
	public void Clear() {
	    textField.setText("");

		
		textField.requestFocus();
		
		
		
	}


public void show() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
				 
		 stmt = conn.prepareStatement("SELECT * FROM session");
			
		 ResultSet result = stmt.executeQuery();
		 

		 DefaultTableModel df = (DefaultTableModel)table.getModel();
		 
		 df.setRowCount(0);
		 
		 while(result.next()) {
			 int idS = result.getInt("idSession");
			
			String libellé = result.getString("libelle");
			String description = result.getString("formation");

		
			
            df.addRow(new Object[] {idS,libellé,description});
            
         }
		

	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}	
	
	
	
	
}
}
