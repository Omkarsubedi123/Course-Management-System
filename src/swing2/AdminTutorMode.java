package swing2;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import swing3.CourseWork;
import swing3.SignUp;
import swing3.StudentDashBoard;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminTutorMode extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField UserTextField;
	private JTextField EmailTextField;
	private JPasswordField PasswordTextField;
	private JPasswordField ConfPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminTutorMode frame = new AdminTutorMode();
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
	public AdminTutorMode() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(314, 10, 885, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tutor Panel");
		lblNewLabel.setBounds(375, 10, 196, 74);
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		JComboBox ComboBox = new JComboBox();
		ComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select mode", "Instructor"}));
		ComboBox.setFont(new Font("Arial", Font.BOLD, 15));
		ComboBox.setBounds(128, 330, 185, 44);
		panel.add(ComboBox);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 450, 865, 168);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton ShowDetailButton = new JButton("Show Details");
		ShowDetailButton.setBounds(10, 389, 170, 51);
		ShowDetailButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/student";
				
				try {
					// making the connections
					con = DriverManager.getConnection(url, Username, Passwords);
					Statement st = con.createStatement();
					String selectQuery = "SELECT Username, Email, Mode FROM users WHERE MODE = 'Instructor'";
					ResultSet rs = st.executeQuery(selectQuery);
					// method for getData form the database.
					ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
					
					//created a DefaultTable object
					DefaultTableModel mode  = new DefaultTableModel();
					int columnCount = rsmd.getColumnCount();
					//using for loop to add the columns and rows
					for(int i = 1; i<=columnCount; i++) {
						mode.addColumn(rsmd.getColumnName(i));
					}
					while (rs.next()) {
						Object[]row = new Object[columnCount];
						// for loop to count the rows
						for(int i=1; i<=columnCount; i++) {
							row[i-1] = rs.getObject(i);
						}
						mode.addRow(row);
					}
					table.setModel(mode);
					
				}
				catch(SQLException e1) {
					System.out.println(e1);
				}
			}
		});
		ShowDetailButton.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(ShowDetailButton);
		
		JButton AddButton = new JButton("ADD\r\n");
		JComboBox<String> comboSelectMode = ComboBox;
		AddButton.setBounds(705, 179, 170, 51);
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String User = UserTextField.getText().trim();
				String Email = EmailTextField.getText().trim();
				String Password = PasswordTextField.getText().trim();
				String ConPass = ConfPasswordTextField.getText().trim(); 
				String combo = ((String)comboSelectMode.getSelectedItem()).trim();
				
			
				if(!User.equals("") && (!Email.equals("")) && (!Password.equals("")) && (!ConPass.equals("")) && (!combo.equals(""))) {
					
					// validation using 
					 if (Pattern.matches("[A-Z][a-zA-Z]*\s[A-Z][a-z]*$", User) && Pattern.matches("[a-z0-9]+[@][a-z]+[.][a-z]+", Email) && Pattern.matches("[A-Z][a-zA-Z0-9@#$]+", Password)) {
						if (Password.equals(ConPass)) {		              
					JOptionPane.showMessageDialog(null, "Successfully New Tutor Added!!!");
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
						    UserTextField.setText("");
							EmailTextField.setText("");
							PasswordTextField.setText("");
							ConfPasswordTextField.setText("");
					}
				}
				else 
					JOptionPane.showMessageDialog(null, "Regex invalid Error!!!");
					    UserTextField.setText("");
						EmailTextField.setText("");
						PasswordTextField.setText("");
						ConfPasswordTextField.setText("");
			}
				else {
					JOptionPane.showMessageDialog(null, "Null Value Login Denied!!!");
					UserTextField.setText("");
					EmailTextField.setText("");
					PasswordTextField.setText("");
					ConfPasswordTextField.setText("");
				}
				
			}
		});
		AddButton.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(AddButton);
		
		JButton DeleteButton = new JButton("Delete\r\n");
		DeleteButton.setBounds(705, 254, 170, 51);
		DeleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
                String Username = "root";
                String Passwords = "";
                String url = "jdbc:mysql://localhost:3306/student";
                
                try {
                    con = DriverManager.getConnection(url, Username, Passwords);
                    Statement st = con.createStatement();

                    // Assuming you want to delete based on the Course Code
                    String UsernameToDelete = UserTextField.getText();
                    String EmailToDelete = EmailTextField.getText();

                    // SQL query to delete data
                    String deleteQuery = "DELETE FROM users WHERE Username = '" + UsernameToDelete + "' AND Email = '" + EmailToDelete + "'";

                    // Execute the delete statement
                    int rowsAffected = st.executeUpdate(deleteQuery);

                    if (rowsAffected > 0) {
                    	 JOptionPane.showMessageDialog(null, "Instructor Deleted Successfully!!!");
                    		UserTextField.setText("");
            				EmailTextField.setText("");
            				
                    } else {
                    	 JOptionPane.showMessageDialog(null, "Username or Email didnot matched!!!");
                    		UserTextField.setText("");
            				EmailTextField.setText("");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                
                }
                }
		});
		DeleteButton.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(DeleteButton);
		
		JLabel Username = new JLabel("Username\r\n");
		Username.setBounds(20, 81, 114, 31);
		Username.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(Username);
		
		UserTextField = new JTextField();
		UserTextField.setBounds(128, 75, 185, 44);
		UserTextField.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(UserTextField);
		UserTextField.setColumns(10);
		
		JLabel Email = new JLabel("Email\r\n");
		Email.setBounds(20, 135, 96, 31);
		Email.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(Email);
		
		EmailTextField = new JTextField();
		EmailTextField.setBounds(128, 129, 250, 44);
		EmailTextField.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(EmailTextField);
		EmailTextField.setColumns(10);
		
		JCheckBox ShowPassword = new JCheckBox("Show Password");
		ShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShowPassword.isSelected()) {
					PasswordTextField.setEchoChar((char)0);
					ConfPasswordTextField.setEchoChar((char)0);
					}
			
				else {
					PasswordTextField.setEchoChar('*');
					ConfPasswordTextField.setEchoChar('*');
				}
			}
		});
		ShowPassword.setFont(new Font("Arial", Font.BOLD, 12));
		ShowPassword.setBounds(193, 287, 120, 31);
		panel.add(ShowPassword);
		
		PasswordTextField = new JPasswordField();
		PasswordTextField.setFont(new Font("Arial", Font.BOLD, 15));
		PasswordTextField.setBounds(128, 183, 185, 44);
		panel.add(PasswordTextField);
		
		ConfPasswordTextField = new JPasswordField();
		ConfPasswordTextField.setFont(new Font("Arial", Font.BOLD, 15));
		ConfPasswordTextField.setBounds(128, 237, 185, 44);
		panel.add(ConfPasswordTextField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblPassword.setBounds(20, 187, 96, 31);
		panel.add(lblPassword);
		
		JLabel lblConfpassword = new JLabel("ConfPassword");
		lblConfpassword.setFont(new Font("Arial", Font.BOLD, 16));
		lblConfpassword.setBounds(20, 237, 96, 31);
		panel.add(lblConfpassword);
				
		JPanel MenuPanel = new JPanel();
		MenuPanel.setBounds(10, 10, 294, 628);
		contentPane.add(MenuPanel);
		MenuPanel.setBackground(SystemColor.activeCaption);
		MenuPanel.setLayout(null);
		
		JLabel CMSHeading = new JLabel("Course Management System");
		CMSHeading.setBounds(10, 10, 264, 22);
		MenuPanel.add(CMSHeading);
		CMSHeading.setFont(new Font("Arial", Font.BOLD, 18));
		
		Button DashBoardButton = new Button("DashBoard");
		DashBoardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminWorkFrame().setVisible(true);
			}
		});
		DashBoardButton.setBackground(new Color(10,223,23));
		DashBoardButton.setBounds(57, 242, 128, 35);
		MenuPanel.add(DashBoardButton);
		DashBoardButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button AdminCourses = new Button("Courses");
		AdminCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminCourse().setVisible(true);
			}
		});
		AdminCourses.setBackground(new Color(10,223,23));
		AdminCourses.setBounds(57, 310, 128, 35);
		MenuPanel.add(AdminCourses);
		
		AdminCourses.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Tutors = new Button("Tutors");
		Tutors.setBackground(new Color(10,223,23));
		Tutors.setBounds(57, 441, 128, 35);
		MenuPanel.add(Tutors);
		Tutors.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Student = new Button("Students");
		Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminStudentMode().setVisible(true);
			}
		});
		Student.setBackground(new Color(10,223,23));
		Student.setBounds(57, 375, 128, 35);
		MenuPanel.add(Student);
		Student.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Logout = new Button("Logout");
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CourseWork().setVisible(true);
			}
		});
		Logout.setBackground(new Color(238, 75, 43));
		Logout.setBounds(57, 559, 128, 35);
		MenuPanel.add(Logout);
		Logout.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel CMSimage = new JLabel("");
		CMSimage.setIcon(new ImageIcon(StudentDashBoard.class.getResource("/Images/CMSPic.png")));
		CMSimage.setBounds(20, 42, 254, 177);
		MenuPanel.add(CMSimage);
	}
}
