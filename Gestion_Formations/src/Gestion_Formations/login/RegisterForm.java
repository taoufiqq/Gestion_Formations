package Gestion_Formations.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.SystemColor;
import javax.swing.UIManager;



import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class RegisterForm {

	private JFrame frmRegisterForm;
	private JLabel lblNewLabel_5;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textLogin;
	private JTextField textVille;
    private JPasswordField textPassword;
	private JPasswordField Confirmpassword;
	private JButton btnRegister;
	private JButton btnReset;
	private JButton btnClose;
	
	Connection connexion;
	PreparedStatement stmt;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JComboBox cmbType;
	private JLabel lblNewLabel_10;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterForm window = new RegisterForm();
					window.frmRegisterForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisterForm = new JFrame();
		frmRegisterForm.setResizable(false);
		frmRegisterForm.setVisible(true);
	
		frmRegisterForm.setTitle("Register_Form");
		frmRegisterForm.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 12));
		frmRegisterForm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmRegisterForm.getContentPane().setForeground(SystemColor.info);
		frmRegisterForm.getContentPane().setBackground(UIManager.getColor("activeCaption"));
		frmRegisterForm.setBounds(100, 100, 507, 751);
		frmRegisterForm.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register form");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(153, 11, 186, 52);
		frmRegisterForm.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(61, 108, 96, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("First name :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(61, 179, 90, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Login  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(98, 254, 59, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(73, 325, 84, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("City:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(110, 470, 54, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_1_4);
		
		lblNewLabel_5 = new JLabel("Confirm Password :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 398, 145, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_5);
		
		textNom = new JTextField();
		textNom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				lblNewLabel_2.setText("");
			}
		});
		textNom.setFont(new Font("Tahoma", Font.BOLD, 15));
		textNom.setToolTipText("");
		textNom.setBounds(230, 104, 223, 33);
		frmRegisterForm.getContentPane().add(textNom);
		textNom.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_3.setText("");
			}
		});
		textPrenom.setFont(new Font("Tahoma", Font.BOLD, 15));
		textPrenom.setColumns(10);
		textPrenom.setBounds(230, 175, 223, 33);
		frmRegisterForm.getContentPane().add(textPrenom);
		
		textLogin = new JTextField();
		textLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_4.setText("");
			}
		});
		textLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		textLogin.setColumns(10);
		textLogin.setBounds(230, 250, 223, 33);
		frmRegisterForm.getContentPane().add(textLogin);
		
		textPassword = new JPasswordField();
		textPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_6.setText("");
			}
		});
		textPassword.setBounds(230, 323, 220, 33);
		frmRegisterForm.getContentPane().add(textPassword);
		
		Confirmpassword = new JPasswordField();
		Confirmpassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_7.setText("");
			}
		});
		Confirmpassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				ValidatePassword();
			}
		});
		Confirmpassword.setBounds(230, 396, 223, 33);
		frmRegisterForm.getContentPane().add(Confirmpassword);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ValidatePassword();
            
                Register();

      
	    }	
		});
		
		textVille = new JTextField();
		textVille.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblNewLabel_8.setText("");
			}
		});
		textVille.setFont(new Font("Tahoma", Font.BOLD, 15));
		textVille.setColumns(10);
		textVille.setBounds(230, 466, 223, 33);
		frmRegisterForm.getContentPane().add(textVille);
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegister.setBounds(70, 612, 99, 33);
		frmRegisterForm.getContentPane().add(btnRegister);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				Clear();
				
				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnReset.setBounds(199, 612, 106, 33);
		frmRegisterForm.getContentPane().add(btnReset);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmRegisterForm.dispose();

			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(331, 612, 106, 33);
		frmRegisterForm.getContentPane().add(btnClose);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(240, 142, 213, 22);
		frmRegisterForm.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(240, 214, 213, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(240, 287, 213, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(240, 359, 210, 26);
		frmRegisterForm.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(240, 437, 241, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(240, 504, 213, 25);
		frmRegisterForm.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login();
				
				
				
				frmRegisterForm.dispose();
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(199, 656, 106, 33);
		frmRegisterForm.getContentPane().add(btnNewButton);
		
		lblNewLabel_9 = new JLabel("User Type:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(68, 531, 99, 33);
		frmRegisterForm.getContentPane().add(lblNewLabel_9);
		
		cmbType = new JComboBox();
		cmbType.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				 lblNewLabel_10.setText("");
			}
		});
		cmbType.setFont(new Font("Tahoma", Font.BOLD, 15));
		cmbType.setModel(new DefaultComboBoxModel(new String[] {"admin", "user"}));
		cmbType.setBounds(234, 531, 219, 33);
		frmRegisterForm.getContentPane().add(cmbType);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(244, 575, 209, 26);
		frmRegisterForm.getContentPane().add(lblNewLabel_10);
	}
	
	public void Clear() {
		
		textNom.setText("");
		textPrenom.setText("");
		textLogin.setText("");
		textPassword.setText("");
		Confirmpassword.setText("");
		textVille.setText("");
		
		textNom.requestFocus();
		
		
		
	}
	public void Register() {
		

		String nom = textNom.getText();
		String prenom = textPrenom.getText();
		String login = textLogin.getText();
		String ville = textVille.getText();
		String password = textPassword.getText();
		String confirmpassword = Confirmpassword.getText();
		String type = cmbType.getSelectedItem().toString();

		

		 if (textNom.getText().trim().isEmpty() && textPrenom.getText().trim().isEmpty() && textLogin.getText().trim().isEmpty() && textPassword.getText().trim().isEmpty() && Confirmpassword.getText().trim().isEmpty()&& textVille.getText().trim().isEmpty())
		 {

			 lblNewLabel_2.setText("* le champ nom est vide !!");
			 lblNewLabel_3.setText("* le champ prenom est vide !!");
			 lblNewLabel_4.setText("* le champ login est vide !!");
			 lblNewLabel_6.setText("* le champ password est vide !!");
			 lblNewLabel_7.setText("* le champ confirmpassword est vide !!");
			 lblNewLabel_8.setText("* le champ ville est vide !!");
		
			
     
          }
		 else if(textNom.getText().trim().isEmpty()) {
			 lblNewLabel_2.setText("le champ nom est vide !!");
		 }
         else if(textPrenom.getText().trim().isEmpty()) {
        	 lblNewLabel_3.setText("le champ prenom est vide !!");
		 }
         else if(textLogin.getText().trim().isEmpty()) {
        	 lblNewLabel_4.setText("le champ login est vide !!");
         }
         else if(textPassword.getText().trim().isEmpty()) {
        	 lblNewLabel_6.setText("le champ password est vide !!");
         }
         else if(Confirmpassword.getText().trim().isEmpty()) {
        	 lblNewLabel_7.setText("le champ confirmpassword est vide !!");
         }
         else if(textVille.getText().trim().isEmpty()){
        	 lblNewLabel_8.setText("le champ ville est vide !!");
         }	 
        
		 
        else
          {
			 
	try {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
			
		connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_formations", "root", "");
		
	

      
             
         	stmt = connexion.prepareStatement("insert into employe(nom, prenom, login, password, confirm_password, ville, type_user)values(?,?,?,?,?,?,?)");
   		 
   		    stmt.setString(1,nom);
   		    stmt.setString(2,prenom);
   		    stmt.setString(3,login);
   		    stmt.setString(4,password);
   		    stmt.setString(5,confirmpassword);
   		    stmt.setString(6,ville);
   		    stmt.setString(7,type);
   		    
            stmt.execute();
            
            JOptionPane.showMessageDialog(btnRegister, "You have been successfully registered");

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
	
	public void ValidatePassword() {
		
		String password = textPassword.getText();
		String confirmpassword = Confirmpassword.getText();
		
		if(!password.equals(confirmpassword)) {
			  JOptionPane.showMessageDialog(btnRegister, "Password does not match, please check");
			  Confirmpassword.requestFocus();
		}
		
		
	}
}
