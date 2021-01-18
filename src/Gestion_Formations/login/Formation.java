package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;

import javax.swing.JScrollPane;
import javax.swing.JButton;
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

public class Formation {

	private JFrame frame;

	private JTable table;
	private JTable table_1;
	Connection conn;
	PreparedStatement stmt;
	private JTextField textField_1;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formation window = new Formation();
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
	public Formation() {
		initialize();
		  show();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(100, 100, 1137, 651);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(28, 141, 367, 448);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Libell\u00E9 :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(57, 86, 60, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Description :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(22, 176, 95, 23);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(22, 332, 326, 98);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				
				String libelle =textField.getText();
				String description =textField_1.getText();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
					 
					 String sql = "insert into formation(libelle,description) " + " values(?,?)";
					
					 
					 stmt = conn.prepareStatement(sql);
						
					 stmt.setString(1,libelle);
					 stmt.setString(2,description);
				
				
				      stmt.execute();
				
					 JOptionPane.showMessageDialog(btnAdd, "Formation Added Successfully");
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
			public void actionPerformed(ActionEvent arg0) {
				

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				
			    
					try {
						
						String libelle =textField.getText();
						String description =textField_1.getText();
						
							
							
							int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());

						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
						 
						 stmt = conn.prepareStatement("UPDATE formation SET " + "libelle = '" + libelle + "', description = '" + description + "' where idFormation = '" + id + "'");
						 stmt.executeUpdate();
					  
					     JOptionPane.showMessageDialog(btnAdd, "Formation edited Successfully");
				
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
			public void actionPerformed(ActionEvent arg0) {
				
				int msg = JOptionPane.showConfirmDialog(null, "Are you sure to delete", "Delete", JOptionPane.YES_NO_OPTION);
				if(msg==0) {
					
			
				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();	
				
			
				
			     try {
						
						
						int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());
						
						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
						 
					
					     stmt = conn.prepareStatement("DELETE from formation  where idFormation = '" + id + "'");
						 stmt.executeUpdate();
						  
						 JOptionPane.showMessageDialog(btnAdd, "Formation Deleted Successfully");
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
			public void actionPerformed(ActionEvent arg0) {
				
				Clear();
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(109, 54, 106, 32);
		panel_1.add(btnReset);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField_1.setBounds(140, 179, 193, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setBounds(140, 89, 193, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Management Formation");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(28, 100, 216, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeAdmin home = new HomeAdmin();
				frame.dispose();
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(28, 32, 116, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(976, 32, 115, 45);
		frame.getContentPane().add(btnLogOut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(441, 141, 670, 199);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 59, 650, 129);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 textField.setText(df.getValueAt(selectedIndex, 1).toString());
				 textField_1.setText(df.getValueAt(selectedIndex, 2).toString());
				
			}
		});
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Formation", "Libell\u00E9", "Description"
			}
		));
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("List Formations :");
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 11, 171, 22);
		panel_2.add(lblNewLabel_3);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(441, 390, 670, 199);
		frame.getContentPane().add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("List Demandes :");
		lblNewLabel_3_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(10, 11, 165, 22);
		panel_2_1.add(lblNewLabel_3_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 59, 650, 129);
		panel_2_1.add(scrollPane_2);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID User", "Last name", "First name", "ID Formation", "Libell\u00E9"
			}
		));
		scrollPane_2.setViewportView(table_1);
	}
	
	
public void Clear() {
	    textField.setText("");
		textField_1.setText("");
	
		textField.requestFocus();
		
		
		
	}
public void show() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
				 
		 stmt = conn.prepareStatement("SELECT * FROM formation");
			
		 ResultSet result = stmt.executeQuery();
		 

		 DefaultTableModel df = (DefaultTableModel)table.getModel();
		 
		 df.setRowCount(0);
		 
		 while(result.next()) {
			int id = result.getInt("idFormation");
			String libellé = result.getString("libelle");
			String description = result.getString("description");
		
			
            df.addRow(new Object[] {id,libellé,description});
            
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
