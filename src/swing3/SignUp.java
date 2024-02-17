package swing3;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsertextField_2;
	private JTextField EmailText_2;
	private JPasswordField PasswordText_2;
	private JPasswordField ConfirmPasswordText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188,142,218,100));
		panel.setBounds(0, 0, 690, 610);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel User_2 = new JLabel("Enter Username");
		User_2.setBounds(122, 20, 206, 39);
		User_2.setFont(new Font("Arial", Font.BOLD, 18));
		panel.add(User_2);
		
		UsertextField_2 = new JTextField();
		UsertextField_2.setFont(new Font("Arial", Font.BOLD, 15));
		UsertextField_2.setBounds(122, 57, 430, 45);
		panel.add(UsertextField_2);
		UsertextField_2.setColumns(10);
		
		JSeparator UserSeparator_2 = new JSeparator();
		UserSeparator_2.setBounds(124, 127, 420, 0);
		panel.add(UserSeparator_2);
		
		JLabel Email_2 = new JLabel("Email");
		Email_2.setFont(new Font("Arial", Font.BOLD, 18));
		Email_2.setBounds(122, 112, 206, 39);
		panel.add(Email_2);
		
		EmailText_2 = new JTextField();
		EmailText_2.setFont(new Font("Arial", Font.BOLD, 15));
		EmailText_2.setColumns(10);
		EmailText_2.setBounds(122, 151, 430, 45);
		panel.add(EmailText_2);
		
		JSeparator EmailSeparator_2 = new JSeparator();
		EmailSeparator_2.setBounds(124, 250, 420, 0);
		panel.add(EmailSeparator_2);
		
		JLabel Password_2 = new JLabel("Password");
		Password_2.setFont(new Font("Arial", Font.BOLD, 18));
		Password_2.setBounds(122, 206, 206, 39);
		panel.add(Password_2);
		
		PasswordText_2 = new JPasswordField();
		PasswordText_2.setFont(new Font("Arial", Font.BOLD, 15));
		PasswordText_2.setBounds(122, 250, 430, 45);
		panel.add(PasswordText_2);
		
		JSeparator PasswordSeparator_2 = new JSeparator();
		PasswordSeparator_2.setBounds(122, 295, 430, 0);
		panel.add(PasswordSeparator_2);
		
		JLabel Confirm_Password = new JLabel("Confirm Password");
		Confirm_Password.setFont(new Font("Arial", Font.BOLD, 18));
		Confirm_Password.setBounds(122, 305, 206, 39);
		panel.add(Confirm_Password);
		
		ConfirmPasswordText = new JPasswordField();
		ConfirmPasswordText.setFont(new Font("Arial", Font.BOLD, 15));
		ConfirmPasswordText.setBounds(122, 341, 430, 45);
		panel.add(ConfirmPasswordText);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(122, 386, 420, 0);
		panel.add(separator);
		
		JComboBox ModeComboBox = new JComboBox();
		ModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecte User Mode", "Student ", "Admin", "Instructor"}));
		ModeComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		ModeComboBox.setBounds(122, 434, 430, 30);
		panel.add(ModeComboBox);
		
		JLabel Mode = new JLabel(" Modes");
		Mode.setFont(new Font("Arial", Font.BOLD, 18));
		Mode.setBounds(122, 398, 100, 25);
		panel.add(Mode);
		
		Button Add = new Button("Add");
		JComboBox<String> comboSelectMode = ModeComboBox;
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String User = UsertextField_2.getText().trim();
				String Email = EmailText_2.getText().trim();
				String Password = PasswordText_2.getText().trim();
				String ConPass = ConfirmPasswordText.getText().trim(); 
				String combo = ((String)comboSelectMode.getSelectedItem()).trim();
				
			
				if(!User.equals("") && (!Email.equals("")) && (!Password.equals("")) && (!ConPass.equals("")) && (!combo.equals(""))) {
					
					// validation using 
					 if (Pattern.matches("[A-Z][a-zA-Z]*\s[A-Z][a-z]*$", User) && Pattern.matches("[a-z0-9]+[@][a-z]+[.][a-z]+", Email) && Pattern.matches("[A-Z][a-zA-Z0-9@#$]+", Password)) {
						if (Password.equals(ConPass)) {		              
					JOptionPane.showMessageDialog(null, "Successfully created the account!!!");
					Connection con;		
					String Username = "root";
					String Passwords = "";
					String url = "jdbc:mysql://localhost:3306/student";
			        
						
					try {
						con = DriverManager.getConnection(url, Username, Passwords);
						Statement st = (Statement) con.createStatement();
						String insertQuery = "INSERT INTO users (Username, Email, Password, Mode) VALUES ('" + User + "', '" + Email + "', '" + Password + "', '" + combo + "')";

						st.execute(insertQuery);
						con.close();
					}
					catch (SQLException e1) {
						System.out.println(e1);
					}
					
					}
					else {
						 JOptionPane.showMessageDialog(null, "Password doesnot match!!!");
						    UsertextField_2.setText("");
							EmailText_2.setText("");
							PasswordText_2.setText("");
							ConfirmPasswordText.setText("");
					}
				}
				else 
					JOptionPane.showMessageDialog(null, "Regex invalid Error!!!");
					    UsertextField_2.setText("");
						EmailText_2.setText("");
						PasswordText_2.setText("");
						ConfirmPasswordText.setText("");
			}
				else {
					JOptionPane.showMessageDialog(null, "Null Value Login Denied!!!");
					UsertextField_2.setText("");
					EmailText_2.setText("");
					PasswordText_2.setText("");
					ConfirmPasswordText.setText("");
				}
			}
		});
		
		
		Add.setFont(new Font("Arial", Font.BOLD, 16));
		Add.setBackground(new Color(10,223,23));
		Add.setForeground(new Color(255, 255, 255));
		Add.setBounds(424, 526, 120, 35);
		panel.add(Add);
		
		Button Cancle = new Button("Go Back\r\n");
		Cancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CourseWork().setVisible(true);
			}
		});
		Cancle.setForeground(Color.WHITE);
		Cancle.setFont(new Font("Arial", Font.BOLD, 16));
		Cancle.setBackground(new Color(238, 75, 43));
		Cancle.setBounds(122, 526, 120, 35);
		panel.add(Cancle);
		
		JCheckBox showpassword = new JCheckBox("Show Password\r\n");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected()) {
					PasswordText_2.setEchoChar((char)0);
					ConfirmPasswordText.setEchoChar((char)0);
					}
			
				else {
					PasswordText_2.setEchoChar('*');
					ConfirmPasswordText.setEchoChar('*');
				}				
				}
		});
		showpassword.setBackground(SystemColor.inactiveCaption);
		showpassword.setFont(new Font("Arial", Font.BOLD, 12));
		showpassword.setBounds(432, 393, 120, 30);
		panel.add(showpassword);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/User_icon-removebg-preview.png")));
		lblNewLabel_1.setBounds(82, 57, 30, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Email icon.png")));
		lblNewLabel_1_1.setBounds(68, 151, 44, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Password icon.png")));
		lblNewLabel_1_2.setBounds(68, 262, 44, 30);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Password icon.png")));
		lblNewLabel_1_2_1.setBounds(68, 341, 44, 30);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Mode.png")));
		lblNewLabel_1_3.setBounds(82, 434, 30, 30);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/Images/Purple.jpg")));
		lblNewLabel.setBounds(0, 0, 680, 610);
		panel.add(lblNewLabel);
		
	}
}
