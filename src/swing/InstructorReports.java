package swing;

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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import swing3.CourseWork;
import swing3.StudentDashBoard;


public class InstructorReports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable TutorTable;
	private JTextField UsernameTextField;
	private JTextField EmailTextField;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorReports frame = new InstructorReports();
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
	public InstructorReports() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1433, 687);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
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
				new InstructorWorkFrame().setVisible(true);
			}
		});
		DashBoardButton.setBackground(new Color(10,223,23));
		DashBoardButton.setBounds(57, 242, 128, 35);
		MenuPanel.add(DashBoardButton);
		DashBoardButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Courses = new Button("Courses");
		Courses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorCourses().setVisible(true);
			}
		});
		Courses.setBackground(new Color(10,223,23));
		Courses.setBounds(57, 310, 128, 35);
		MenuPanel.add(Courses);
		
		Courses.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Tutors = new Button("Tutors");
		Tutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorsOnly().setVisible(true);
			}
		});
		Tutors.setBackground(new Color(10,223,23));
		Tutors.setBounds(57, 441, 128, 35);
		MenuPanel.add(Tutors);
		Tutors.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Student = new Button("Students");
		Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorTotalStudents().setVisible(true);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(314, 10, 1109, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 178, 350, 430);
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel Level4 = new JLabel("Level 4\r\n");
		Level4.setBounds(118, 10, 114, 25);
		Level4.setFont(new Font("Arial", Font.BOLD, 22));
		panel_1.add(Level4);
		
		JLabel lblModule = new JLabel("Module 1");
		lblModule.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule.setBounds(10, 84, 119, 32);
		panel_1.add(lblModule);
		
		JLabel lblModule_1 = new JLabel("Module 2");
		lblModule_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_1.setBounds(10, 209, 119, 32);
		panel_1.add(lblModule_1);
		
		JLabel lblModule_2 = new JLabel("Module 3");
		lblModule_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_2.setBounds(10, 334, 119, 32);
		panel_1.add(lblModule_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(93, 71, 170, 51);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(93, 201, 170, 51);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(93, 326, 170, 51);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(379, 178, 350, 430);
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Level5 = new JLabel("Level 5");
		Level5.setBounds(111, 10, 110, 19);
		Level5.setFont(new Font("Arial", Font.BOLD, 22));
		panel_2.add(Level5);
		
		JLabel lblModule_3 = new JLabel("Module 1");
		lblModule_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_3.setBounds(10, 74, 119, 32);
		panel_2.add(lblModule_3);
		
		JLabel lblModule_4 = new JLabel("Module 2\r\n");
		lblModule_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_4.setBounds(10, 210, 119, 32);
		panel_2.add(lblModule_4);
		
		JLabel lblModule_5 = new JLabel("Module 3");
		lblModule_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_5.setBounds(10, 332, 119, 32);
		panel_2.add(lblModule_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(93, 66, 170, 51);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(93, 201, 170, 51);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(93, 326, 170, 51);
		panel_2.add(textField_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(739, 178, 350, 430);
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel Level6 = new JLabel("Level 6\r\n");
		Level6.setBounds(111, 10, 115, 19);
		Level6.setFont(new Font("Arial", Font.BOLD, 22));
		panel_3.add(Level6);
		
		JLabel lblModule_6 = new JLabel("Module 1");
		lblModule_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_6.setBounds(10, 76, 119, 32);
		panel_3.add(lblModule_6);
		
		JLabel lblModule_7 = new JLabel("Module 2");
		lblModule_7.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_7.setBounds(10, 212, 119, 32);
		panel_3.add(lblModule_7);
		
		JLabel lblModule_8 = new JLabel("Module 3");
		lblModule_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_8.setBounds(10, 327, 119, 32);
		panel_3.add(lblModule_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(93, 69, 170, 51);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(93, 201, 170, 51);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(93, 326, 170, 51);
		panel_3.add(textField_8);
		
		JButton btnNewButton_1 = new JButton("Delete Result");
		btnNewButton_1.setBounds(939, 9, 150, 51);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				UsernameTextField.setText("");
//				EmailTextField.setText("");
//				textField.setText("");
//                textField_1.setText("");
//                textField_2.setText("");
//                textField_3.setText("");
//                textField_4.setText("");
//                textField_5.setText("");
//                textField_6.setText("");
//                textField_7.setText("");
//                textField_8.setText("");				

				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/student";

				try {
				    con = DriverManager.getConnection(url, Username, Passwords);

				    // Assuming you want to delete based on the Username and Email
				    String UsernameToDelete = UsernameTextField.getText();
				    String EmailToDelete = EmailTextField.getText();

				    // SQL query to delete data
				    String deleteQuery = "DELETE FROM Reports WHERE Username = '" + UsernameToDelete + "' AND Email = '" + EmailToDelete + "'";

				    // Execute the delete statement
				    try (Statement st = con.createStatement()) {
				        int rowsAffected = st.executeUpdate(deleteQuery);

				        if (rowsAffected > 0) {
				            JOptionPane.showMessageDialog(null, "Result Deleted Successfully!!!");
				            UsernameTextField.setText("");
							EmailTextField.setText("");
				        } else {
				            JOptionPane.showMessageDialog(null, "Username or Email did not match!!!");
				        }
				    }
				} catch (SQLException e1) {
				    e1.printStackTrace();
				}
			}
			
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(404, 9, 150, 51);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/student";

				try {
				    con = DriverManager.getConnection(url, Username, Passwords);
				    Statement st = con.createStatement();

				    String User = UsernameTextField.getText().trim();
				    String Email = EmailTextField.getText().trim();
				    String L41 = textField.getText();
				    String L42 = textField_1.getText();
				    String L43 = textField_2.getText();
				    String L51 = textField_3.getText();
				    String L52 = textField_4.getText();
				    String L53 = textField_5.getText();
				    String L61 = textField_6.getText();
				    String L62 = textField_7.getText();
				    String L63 = textField_8.getText();

				    // Check if the username and email already exist
				    String userQuery = "SELECT * FROM users WHERE Username = '" + User + "' AND Email = '" + Email + "'";

				    ResultSet userResult = st.executeQuery(userQuery);

				    if (userResult.next()) {
				        // User exists, proceed to get data from the users table
				        User = userResult.getString("Username");
				        Email = userResult.getString("Email");

				        // Proceed with the insert
				        String insertQuery = "INSERT INTO reports (Username, Email, L4M1, L4M2, L4M3, L5M1, L5M2, L5M3, L6M1, L6M2, L6M3) " +
				                "VALUES ('" + User + "', '" + Email + "', '" + L41 + "', '" + L42 + "', '" + L43 + "', '" + L51 + "', '" +
				                L52 + "', '" + L53 + "', '" + L61 + "', '" + L62 + "', '" + L63 + "')";

				       

				        // Execute the insert query and check the number of rows affected
				        int rowsAffected = st.executeUpdate(insertQuery);

				        if (rowsAffected > 0) {
				            JOptionPane.showMessageDialog(null, "Result Updated Successfully!");
				            dispose();
				            new FinalResult().setVisible(true);
				        } else {
				            JOptionPane.showMessageDialog(null, "Failed to Update result!");
				        }
				    } else {
				        JOptionPane.showMessageDialog(null, "User does not exist!");
				    }
				} catch (SQLException e1) {
				    e1.printStackTrace(); // Print the stack trace for detailed error information
				}


			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		
		EmailTextField = new JTextField();
		EmailTextField.setBounds(105, 71, 255, 51);
		panel.add(EmailTextField);
		EmailTextField.setFont(new Font("Arial", Font.BOLD, 15));
		EmailTextField.setColumns(10);
		
		UsernameTextField = new JTextField();
		UsernameTextField.setBounds(105, 10, 170, 51);
		panel.add(UsernameTextField);
		UsernameTextField.setFont(new Font("Arial", Font.BOLD, 15));
		UsernameTextField.setColumns(10);
		
		JLabel Email_1 = new JLabel("Email");
		Email_1.setBounds(10, 79, 89, 33);
		panel.add(Email_1);
		Email_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel Username_1 = new JLabel("Username");
		Username_1.setBounds(10, 18, 89, 33);
		panel.add(Username_1);
		Username_1.setFont(new Font("Arial", Font.BOLD, 16));
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FinalResult().setVisible(true);
			}
		});
		btnNewButton_2.setBounds(404, 87, 150, 51);
		panel.add(btnNewButton_2);
		
		
		
	}
}
