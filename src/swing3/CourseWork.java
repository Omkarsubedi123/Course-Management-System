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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import swing.InstructorWorkFrame;
import swing2.AdminWorkFrame;

public class CourseWork extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserTextField1;
	private JLabel Username1;
	private JSeparator PasswordSeparator_1;
	private JLabel Namaste;
	private JLabel Heading;
	private JLabel UserIcon_1;
	private JLabel PasswordIcon_1;
	private JPasswordField PasswordTextField1;
	

	/**
	 * Launch the application.
	 */
	private static CourseWork frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CourseWork();
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
	@SuppressWarnings("unchecked")
	public CourseWork() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 680, 639);
		panel.setBackground(new Color(188,142,218,100));
		contentPane.add(panel);
		panel.setLayout(null);
		
		Namaste = new JLabel("");
		Namaste.setBounds(300, 57, 100, 157);
		Namaste.setIcon(new ImageIcon(CourseWork.class.getResource("/Images/Namaste-removebg-preview.png")));
		panel.add(Namaste);
		
		Heading = new JLabel("     Welcome to LogIn Pannel");
		Heading.setBounds(122, 20, 473, 55);
		Heading.setVerticalAlignment(SwingConstants.TOP);
		Heading.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(Heading);
		
		Username1 = new JLabel(" Enter Username");
		Username1.setBounds(122, 186, 168, 28);
		panel.add(Username1);
		Username1.setVerticalAlignment(SwingConstants.TOP);
		Username1.setFont(new Font("Arial", Font.BOLD, 18));
		
		UserTextField1 = new JTextField();
		UserTextField1.setFont(new Font("Arial", Font.BOLD, 15));
		UserTextField1.setBounds(122, 213, 430, 45);
		panel.add(UserTextField1);
		UserTextField1.setColumns(10);
		
		JSeparator UserSeparator1 = new JSeparator();
		UserSeparator1.setBounds(122, 250, 430, 2);
		panel.add(UserSeparator1);
		
		JLabel Password = new JLabel("Enter password");
		Password.setBounds(122, 280, 168, 25);
		panel.add(Password);
		Password.setVerticalAlignment(SwingConstants.TOP);
		Password.setFont(new Font("Arial", Font.BOLD, 18));
		
		PasswordTextField1 = new JPasswordField();
		PasswordTextField1.setFont(new Font("Arial", Font.BOLD, 15));
		PasswordTextField1.setBounds(122, 315, 430, 45);
		panel.add(PasswordTextField1);
		
		PasswordSeparator_1 = new JSeparator();
		PasswordSeparator_1.setBounds(122, 357, 430, 2);
		panel.add(PasswordSeparator_1);
		
		UserIcon_1 = new JLabel("");
		UserIcon_1.setVerticalAlignment(SwingConstants.TOP);
		UserIcon_1.setIcon(new ImageIcon(CourseWork.class.getResource("/Images/User_icon-removebg-preview.png")));
		UserIcon_1.setBounds(68, 222, 30, 30);
		panel.add(UserIcon_1);
		
		PasswordIcon_1 = new JLabel("");
		PasswordIcon_1.setIcon(new ImageIcon(CourseWork.class.getResource("/Images/Password icon.png")));
		PasswordIcon_1.setBounds(68, 315, 40, 30);
		panel.add(PasswordIcon_1);
		
		
		JComboBox ModeComboBox = new JComboBox();
		ModeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecte User Mode", "Student ", "Admin", "Instructor"}));
		ModeComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		ModeComboBox.setBounds(122, 424, 430, 30);
		panel.add(ModeComboBox);
		
		JLabel Mode = new JLabel(" Modes");
		Mode.setFont(new Font("Arial", Font.BOLD, 18));
		Mode.setBounds(122, 389, 100, 25);
		panel.add(Mode);
		
		Button SignUp1 = new Button("SignUp");
		SignUp1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SignUp().setVisible(true); // to show Frame to link the frame.
			}
		});
		SignUp1.setFont(new Font("Arial", Font.BOLD, 16));
		SignUp1.setBackground(new Color(10,223,23));
		SignUp1.setForeground(new Color(255, 255, 255));
		SignUp1.setBounds(122, 550, 120, 35);
		panel.add(SignUp1);
		
		Button LogIn = new Button("LogIn");
		JComboBox<String> comboSelectMode = ModeComboBox;
		LogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				UserTextField1.setText("");
//				PasswordTextField1.setText("");
				
				String User = UserTextField1.getText().trim();
				String Password = PasswordTextField1.getText().trim();
				String combo = ((String) comboSelectMode.getSelectedItem()).trim();
				
				if(!User.equals("") && (!Password.equals("")) && (!combo.equals(""))) {
					// variable for the database connection
					Connection con;
					String Username = "root";
					String Passwords = "";
					String url = "jdbc:mysql://localhost:3306/student";
					
					
					try {
						// making the connections
						con = DriverManager.getConnection(url, Username, Passwords);
						Statement st = con.createStatement();
						String selectQuery = "SELECT * FROM users WHERE Username = '" + User + "' AND Password = '" + Password + "' AND Mode = '" + combo + "'";
						ResultSet rs = st.executeQuery(selectQuery);


						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null, "LogIn successful!!!");
							
							// using switch case statement for different page redirecting.
							switch(combo) {
							case "Student":
//								dispose();
								new StudentWorkFrame().setVisible(true);
								break;
								
							case "Admin":
//								dispose();
								new AdminWorkFrame().setVisible(true);
								break;
								
							case "Instructor":
//								dispose();
								new InstructorWorkFrame().setVisible(true);
								break;
								
								default:
									JOptionPane.showMessageDialog(null, "Unsupported User Mode: " +combo);
							}
							 ((JFrame) SwingUtilities.getWindowAncestor(LogIn)).dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Invalid username or password!");
						}
					}
					
					catch(SQLException e1) {
						System.out.println(e1);
					}
					}
				
//				}
				else {
					JOptionPane.showMessageDialog(null, "LogIn Denied!!!");
				}
			}
		});

		LogIn.setForeground(Color.WHITE);
		LogIn.setFont(new Font("Arial", Font.BOLD, 16));
		LogIn.setBackground(new Color(10, 223, 23));
		LogIn.setBounds(432, 550, 120, 35);
		panel.add(LogIn);
		
		JLabel ModeIcon = new JLabel("");
		ModeIcon.setIcon(new ImageIcon(CourseWork.class.getResource("/Images/Mode.png")));
		ModeIcon.setBounds(68, 419, 35, 35);
		panel.add(ModeIcon);
		
		JSeparator ModeSeparator = new JSeparator();
		ModeSeparator.setBounds(122, 430, 430, 0);
		panel.add(ModeSeparator);
		
		JCheckBox showpassword = new JCheckBox("Show Password\r\n");
		showpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(showpassword.isSelected()) {
					PasswordTextField1.setEchoChar((char)0);
					}
			
				else {
						PasswordTextField1.setEchoChar('*');
				}				
				}
		});
		showpassword.setBackground(SystemColor.inactiveCaption);
		showpassword.setFont(new Font("Arial", Font.BOLD, 12));
		showpassword.setBounds(432, 366, 120, 30);
		panel.add(showpassword);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CourseWork.class.getResource("/Images/Purple.jpg")));
		lblNewLabel.setBounds(0, 0, 680, 639);
		panel.add(lblNewLabel);
		
	
	}
}
