package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HomeUser {

	private JFrame frame;
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
					HomeUser window = new HomeUser();
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
	public HomeUser() {
		initialize();
		show();
		try {
		    String imageUrl =
		            "http://maps.google.com/staticmap?center=40,26&zoom=1&size=150x112&maptype=satellite&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
		    String destinationFile = "image.jpg";
		    String str = destinationFile;
		    URL url = new URL(imageUrl);
		    InputStream is = url.openStream();
		    OutputStream os = new FileOutputStream(destinationFile);

		    byte[] b = new byte[2048];
		    int length;

		    while ((length = is.read(b)) != -1) {
		        os.write(b, 0, length);
		    }

		    is.close();
		    os.close();
		} catch (IOException e) {
		    e.printStackTrace();
		    System.exit(1);
		}
		JLabel lp2_1 = null;
		lp2_1.setIcon(new ImageIcon((new ImageIcon("image.jpg")).getImage()
		        .getScaledInstance(630, 600, java.awt.Image.SCALE_SMOOTH)));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(SystemColor.controlHighlight);
		frame.setBounds(100, 100, 1309, 671);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(81, 149, 747, 330);
		panel.setBackground(new Color(255, 255, 240));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List Formations :");
		lblNewLabel.setBounds(33, 11, 169, 36);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 82, 688, 237);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.BOLD, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"IDFormation", "Libelle", "Description"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(81, 39, 377, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(168, 490, 586, 87);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Demander Formation");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String m = JOptionPane.showInputDialog("enter id of the formation ");
			        System.out.println(m);
			        
			        
			        
			        
			        
			        
			        
			        
			        
			        
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(38, 22, 232, 42);
		panel_1.add(btnNewButton);
		
		JButton btnDetailsFormation = new JButton("Details Formation");
		btnDetailsFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String url = "http://localhost:3000/Session/4";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnDetailsFormation.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDetailsFormation.setBounds(311, 22, 232, 42);
		panel_1.add(btnDetailsFormation);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login lg = new Login();
				frame.dispose();
				
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogOut.setBounds(1099, 27, 115, 45);
		frame.getContentPane().add(btnLogOut);
		
		JPanel map = new JPanel();
		map.setBounds(848, 103, 435, 409);
		frame.getContentPane().add(map);
		
//	     try {
//	            String imageUrl = "http://maps.google.com/staticmap?center=40,26&zoom=1&size=150x112&maptype=satellite&key=ABQIAAAAgb5KEVTm54vkPcAkU9xOvBR30EG5jFWfUzfYJTWEkWk2p04CHxTGDNV791-cU95kOnweeZ0SsURYSA&format=jpg";
//	            String destinationFile = "image.jpg";
//	            String str = destinationFile;
//	            URL url = new URL(imageUrl);
//	            InputStream is = url.openStream();
//	            OutputStream os = new FileOutputStream(destinationFile);
//
//	            byte[] b = new byte[2048];
//	            int length;
//
//	            while ((length = is.read(b)) != -1) {
//	                os.write(b, 0, length);
//	            }
//
//	            is.close();
//	            os.close();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	            System.exit(1);
//	        }
//
//	        frame.add(new JPanel(new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(630, 600,java.awt.Image.SCALE_SMOOTH))));
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
