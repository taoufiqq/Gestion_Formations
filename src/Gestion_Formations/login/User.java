package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;

public class User {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;
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
					User window = new User();
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
	public User() {
		initialize();
		 show();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);

		frame.setBounds(100, 100, 1344, 817);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 240));
		panel.setBounds(40, 132, 480, 653);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				

			}
		});
		textField.setToolTipText("");
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(200, 51, 246, 33);
		panel.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Last name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(63, 55, 106, 25);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
		
			}
		});
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(200, 122, 246, 33);
		panel.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(63, 126, 106, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(100, 201, 66, 25);
		panel.add(lblNewLabel_1_2);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
	
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(200, 197, 246, 33);
		panel.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
		
			}
		});
		passwordField.setBounds(200, 270, 246, 33);
		panel.add(passwordField);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(75, 272, 106, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm Password :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 345, 159, 25);
		panel.add(lblNewLabel_5);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
		
			}
		});
		passwordField_1.setBounds(200, 343, 246, 33);
		panel.add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
	
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(200, 413, 246, 33);
		panel.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("City :");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(115, 417, 48, 25);
		panel.add(lblNewLabel_1_4);
		
		JComboBox cmbType = new JComboBox();
		cmbType.setForeground(new Color(128, 0, 0));
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"Type :", "admin", "user"}));
		cmbType.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbType.setBounds(204, 478, 242, 33);
		panel.add(cmbType);
		
		JLabel lblNewLabel_9 = new JLabel("User Type :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(70, 478, 93, 33);
		panel.add(lblNewLabel_9);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(10, 541, 456, 95);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String nom = textField.getText();
				String prenom = textField_1.getText();
				String username = textField_2.getText();
				String mot_de_pass = passwordField.getText();
				String confirm_mot_de_pass = passwordField_1.getText();	
				String ville = textField_3.getText();
				String type = cmbType.getSelectedItem().toString();
			
//				 if (textField.getText().trim().isEmpty() && textField_1.getText().trim().isEmpty() && textField_2.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty() && passwordField_1.getText().trim().isEmpty()&& textField_3.getText().trim().isEmpty())

				

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
					 
					 String sql = "insert into employe(nom,prenom,login,password,confirm_password,ville,type_user) " + " values(?,?,?,?,?,?,?)";
					
					 
					 stmt = conn.prepareStatement(sql);
						
					 stmt.setString(1,nom);
					 stmt.setString(2,prenom);
					 stmt.setString(3,username);
					 stmt.setString(4,mot_de_pass);
					 stmt.setString(5,confirm_mot_de_pass);
					 stmt.setString(6,ville);
					 stmt.setString(7,type);
				
				  stmt.execute();
				
					 JOptionPane.showMessageDialog(btnAdd, "User Added Successfully");
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
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAdd.setBounds(10, 30, 120, 39);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				
			    
					try {
						
						    String nom = textField.getText();
							String prenom = textField_1.getText();
							String username = textField_2.getText();
							String mot_de_pass = passwordField.getText();
							String confirm_mot_de_pass = passwordField_1.getText();	
							String ville = textField_3.getText();
							String type = cmbType.getSelectedItem().toString();
							
							int id = Integer.parseInt(df.getValueAt(selectedIndex, 0).toString());

						
						 Class.forName("com.mysql.cj.jdbc.Driver");
						
						 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
						 
						 stmt = conn.prepareStatement("UPDATE employe SET " + "nom = '" + nom + "', prenom = '" + prenom + "', login = '" + username + "', password = '" + mot_de_pass + "', confirm_password = '" + confirm_mot_de_pass + "', ville = '" + ville+ "', type_user = '" + type + "' where idEmploye = '" + id + "'");
						 stmt.executeUpdate();
					  
					     JOptionPane.showMessageDialog(btnAdd, "User edited Successfully");
				
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(161, 30, 120, 39);
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
						 
					
					     stmt = conn.prepareStatement("DELETE from employe  where idEmploye = '" + id + "'");
						 stmt.executeUpdate();
						  
						 JOptionPane.showMessageDialog(btnAdd, "User Deleted Successfully");
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
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(315, 30, 120, 39);
		panel_1.add(btnDelete);
		
		JLabel lnom = new JLabel("");
		lnom.setForeground(new Color(255, 0, 0));
		lnom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lnom.setBounds(200, 92, 246, 19);
		panel.add(lnom);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(530, 205, 784, 332);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				}
		});
		scrollPane.setBounds(10, 72, 764, 249);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 DefaultTableModel df = (DefaultTableModel)table.getModel();	
			     int selectedIndex = table.getSelectedRow();
				 textField.setText(df.getValueAt(selectedIndex, 1).toString());
				 textField_1.setText(df.getValueAt(selectedIndex, 2).toString());
				 textField_2.setText(df.getValueAt(selectedIndex, 3).toString());
				 passwordField.setText(df.getValueAt(selectedIndex, 4).toString());
				 passwordField_1.setText(df.getValueAt(selectedIndex, 5).toString());
				 textField_3.setText(df.getValueAt(selectedIndex, 6).toString());
				 cmbType.setToolTipText(df.getValueAt(selectedIndex, 6).toString());
				
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID_user", "Last name", "First name", "Login", "Password", "ConfirmPassword", "City", "User Type"
			}
		));
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(97);
		
		
		JLabel lblNewLabel_10 = new JLabel("List Users ");
		lblNewLabel_10.setForeground(new Color(128, 0, 0));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_10.setBounds(10, 11, 170, 36);
		panel_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel = new JLabel("Management User");
		lblNewLabel.setBounds(40, 89, 179, 32);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(1169, 23, 115, 45);
		frame.getContentPane().add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg =new Login();
				frame.dispose();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnNewButton = new JButton("< Back");
		btnNewButton.setBounds(40, 23, 116, 45);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomeAdmin home =new HomeAdmin();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
	}
public void Clear() {
		
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		textField_3.setText("");
	
		textField.requestFocus();
		
		
		
	}
public void show() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
				 
		 stmt = conn.prepareStatement("SELECT * FROM employe");
			
		 ResultSet result = stmt.executeQuery();
		 

		 DefaultTableModel df = (DefaultTableModel)table.getModel();
		 
		 df.setRowCount(0);
		 
		 while(result.next()) {
			int id = result.getInt("idEmploye");
			String nom = result.getString("nom");
			String prenom = result.getString("prenom");
			String username = result.getString("login");
			String password = result.getString("password");
			String confirm_password = result.getString("confirm_password");
			String ville = result.getString("ville");
			String type = result.getString("type_user");
		
			
            df.addRow(new Object[] {id,nom,prenom,username,password,confirm_password,ville,type});
            
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
