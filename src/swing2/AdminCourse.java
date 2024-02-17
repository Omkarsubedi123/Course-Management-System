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

public class AdminCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField CodeTextField;
	private JTextField CNameTextField;
	private JTextField SeatTextField;
	private JTextField BatchTextField;
	private JTextField YearTextField;
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
					AdminCourse frame = new AdminCourse();
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
	public AdminCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1447, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(314, 10, 1109, 628);
		contentPane.add(panel);
		panel.setLayout(null);

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
		
		Button Courses = new Button("Courses");;
		Courses.setBackground(new Color(10,223,23));
		Courses.setBounds(57, 310, 128, 35);
		MenuPanel.add(Courses);
		
		Courses.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Tutors = new Button("Tutors");
		Tutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminTutorMode().setVisible(true);
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
		
		JButton CourseDetails = new JButton("Next");
		CourseDetails.setBounds(10, 104, 170, 51);
		CourseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ModuleList().setVisible(true);
			}
		});
		CourseDetails.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(CourseDetails);
		
		JButton ADDButton = new JButton("ADD\r\n");
		ADDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				    Connection con;
	                String Username = "root";
	                String Passwords = "";
	                String url = "jdbc:mysql://localhost:3306/student";

	                try {
	                    con = DriverManager.getConnection(url, Username, Passwords);
	                    Statement st = con.createStatement();

	                    String code = CodeTextField.getText();
	                    String course = CNameTextField.getText();
	                    String seat = SeatTextField.getText();
	                    String batch = BatchTextField.getText();
	                    String year = YearTextField.getText();
	                    String L41 = textField.getText();
	                    String L42 = textField_1.getText();
	                    String L43 = textField_2.getText();
	                    String L51 = textField_3.getText();
	                    String L52 = textField_4.getText();
	                    String L53 = textField_5.getText();
	                    String L61 = textField_6.getText();
	                    String L62 = textField_7.getText();
	                    String L63 = textField_8.getText();

	                    // Check if the Course Code already exists
	                    String checkQuery = "SELECT * FROM courses WHERE `Course Code` = '" + code + "'";
	                    ResultSet resultSet = st.executeQuery(checkQuery);

	                    if (resultSet.next()) {
	                        // Course Code already exists, show a message or take appropriate action
	                        JOptionPane.showMessageDialog(null, "Course with this Course Code already exists. Cannot insert duplicate Course Code.");
	                        CodeTextField.setText("");
            				CNameTextField.setText("");
            				SeatTextField.setText("");
            				BatchTextField.setText("");
                            YearTextField.setText("");
                            textField.setText("");
                            textField_1.setText("");
                            textField_2.setText("");
                            textField_3.setText("");
                            textField_4.setText("");
                            textField_5.setText("");
                            textField_6.setText("");
                            textField_7.setText("");
                            textField_8.setText("");
                            
	                    } else {
	                        
	                    	String insertQuery = "INSERT INTO courses (`Course Code`, `Course Name`, Seats, Batch, `No of year`, `L4M1`, `L4M2`, `L4M3`, `L5M1`, `L5M2`, `L5M3`, `L6M1`, `L6M2`, `L6M3`) VALUES ('" + code + "', '" + course + "', '" + seat + "', '" + batch + "', '" + year + "', '"+L41+"', '"+L42+"', '"+L43+"', '"+L51+"', '"+L52+"', '"+L53+"', '"+L61+"', '"+L62+"', '"+L63+"')";


	                        // Execute the insert statement
	                        int rowsAffected = st.executeUpdate(insertQuery);

	                        if (rowsAffected > 0) {
	                            JOptionPane.showMessageDialog(null, "Course Added Successfully!!!");
	            				CodeTextField.setText("");
	            				CNameTextField.setText("");
	            				SeatTextField.setText("");
	            				BatchTextField.setText("");
	                            YearTextField.setText("");
	                            textField.setText("");
	                            textField_1.setText("");
	                            textField_2.setText("");
	                            textField_3.setText("");
	                            textField_4.setText("");
	                            textField_5.setText("");
	                            textField_6.setText("");
	                            textField_7.setText("");
	                            textField_8.setText("");
	                            
	                            dispose();
	                            new ModuleList().setVisible(true);
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Failed to insert course!!!");
	                            CodeTextField.setText("");
	            				CNameTextField.setText("");
	            				SeatTextField.setText("");
	            				BatchTextField.setText("");
	                            YearTextField.setText("");
	                            textField.setText("");
	                            textField_1.setText("");
	                            textField_2.setText("");
	                            textField_3.setText("");
	                            textField_4.setText("");
	                            textField_5.setText("");
	                            textField_6.setText("");
	                            textField_7.setText("");
	                            textField_8.setText("");
	                        }
	                    }
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            }
		});
		ADDButton.setFont(new Font("Arial", Font.BOLD, 16));
		ADDButton.setBounds(712, 39, 170, 51);
		panel.add(ADDButton);
		
		JLabel CourseCode = new JLabel("Course Code\r\n");
		CourseCode.setFont(new Font("Arial", Font.BOLD, 16));
		CourseCode.setBounds(10, 10, 119, 32);
		panel.add(CourseCode);
		
		CodeTextField = new JTextField();
		CodeTextField.setFont(new Font("Arial", Font.BOLD, 15));
		CodeTextField.setBounds(10, 43, 113, 44);
		panel.add(CodeTextField);
		CodeTextField.setColumns(10);
		
		JLabel CName = new JLabel("Course Name\r\n");
		CName.setFont(new Font("Arial", Font.BOLD, 16));
		CName.setBounds(139, 10, 119, 32);
		panel.add(CName);
		
		CNameTextField = new JTextField();
		CNameTextField.setFont(new Font("Arial", Font.BOLD, 15));
		CNameTextField.setColumns(10);
		CNameTextField.setBounds(133, 43, 179, 44);
		panel.add(CNameTextField);
		
		JLabel Seats = new JLabel("Seats\r\n");
		Seats.setFont(new Font("Arial", Font.BOLD, 16));
		Seats.setBounds(327, 10, 119, 32);
		panel.add(Seats);
		
		SeatTextField = new JTextField();
		SeatTextField.setFont(new Font("Arial", Font.BOLD, 15));
		SeatTextField.setColumns(10);
		SeatTextField.setBounds(322, 43, 113, 44);
		panel.add(SeatTextField);
		
		JLabel Batch = new JLabel("Batch\r\n");
		Batch.setFont(new Font("Arial", Font.BOLD, 16));
		Batch.setBounds(444, 10, 119, 32);
		panel.add(Batch);
		
		BatchTextField = new JTextField();
		BatchTextField.setFont(new Font("Arial", Font.BOLD, 15));
		BatchTextField.setColumns(10);
		BatchTextField.setBounds(444, 43, 113, 44);
		panel.add(BatchTextField);
		
		JLabel Year = new JLabel("No of Year");
		Year.setFont(new Font("Arial", Font.BOLD, 16));
		Year.setBounds(573, 10, 119, 32);
		panel.add(Year);
		
		YearTextField = new JTextField();
		YearTextField.setFont(new Font("Arial", Font.BOLD, 15));
		YearTextField.setColumns(10);
		YearTextField.setBounds(567, 43, 113, 44);
		panel.add(YearTextField);
		
		JButton DeleteCourseButton = new JButton("Delete Course\r\n");
		DeleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                
				    Connection con;
	                String Username = "root";
	                String Passwords = "";
	                String url = "jdbc:mysql://localhost:3306/student";
	                
	                try {
	                    con = DriverManager.getConnection(url, Username, Passwords);
	                    Statement st = con.createStatement();

	                    // Assuming you want to delete based on the Course Code
	                    String codeToDelete = CodeTextField.getText();

	                    // SQL query to delete data
	                    String deleteQuery = "DELETE FROM courses WHERE `Course Code` = '" + codeToDelete + "'";

	                    // Execute the delete statement
	                    int rowsAffected = st.executeUpdate(deleteQuery);

	                    if (rowsAffected > 0) {
	                    	 JOptionPane.showMessageDialog(null, "Course Deleted Successfully!!!");
	                    		CodeTextField.setText("");
	            				CNameTextField.setText("");
	            				SeatTextField.setText("");
	            				BatchTextField.setText("");
	                            YearTextField.setText("");
	                            textField.setText("");
	                            textField_1.setText("");
	                            textField_2.setText("");
	                            textField_3.setText("");
	                            textField_4.setText("");
	                            textField_5.setText("");
	                            textField_6.setText("");
	                            textField_7.setText("");
	                            textField_8.setText("");
	                            
	                            dispose();
	                            new ModuleList().setVisible(true);
	                    } else {
	                    	 JOptionPane.showMessageDialog(null, "No matching Code to delete course!!!");
	                    	 CodeTextField.setText("");
	            				CNameTextField.setText("");
	            				SeatTextField.setText("");
	            				BatchTextField.setText("");
	                            YearTextField.setText("");
	                            textField.setText("");
	                            textField_1.setText("");
	                            textField_2.setText("");
	                            textField_3.setText("");
	                            textField_4.setText("");
	                            textField_5.setText("");
	                            textField_6.setText("");
	                            textField_7.setText("");
	                            textField_8.setText("");
	                    }
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	            
				
			}
		});
		DeleteCourseButton.setFont(new Font("Arial", Font.BOLD, 17));
		DeleteCourseButton.setBounds(903, 39, 170, 51);
		panel.add(DeleteCourseButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 178, 350, 430);
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
		lblModule_1.setBounds(10, 203, 119, 32);
		panel_1.add(lblModule_1);
		
		JLabel lblModule_2 = new JLabel("Module 3");
		lblModule_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_2.setBounds(10, 317, 119, 32);
		panel_1.add(lblModule_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(125, 71, 179, 44);
		panel_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.BOLD, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(125, 195, 179, 44);
		panel_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.BOLD, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(125, 312, 179, 44);
		panel_1.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(379, 178, 350, 430);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel Level5 = new JLabel("Level 5");
		Level5.setBounds(111, 10, 110, 19);
		Level5.setFont(new Font("Arial", Font.BOLD, 22));
		panel_2.add(Level5);
		
		JLabel lblModule_3 = new JLabel("Module 1");
		lblModule_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_3.setBounds(10, 81, 119, 32);
		panel_2.add(lblModule_3);
		
		JLabel lblModule_4 = new JLabel("Module 2\r\n");
		lblModule_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_4.setBounds(10, 200, 119, 32);
		panel_2.add(lblModule_4);
		
		JLabel lblModule_5 = new JLabel("Module 3");
		lblModule_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_5.setBounds(10, 313, 119, 32);
		panel_2.add(lblModule_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.BOLD, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(125, 71, 179, 44);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.BOLD, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(125, 195, 179, 44);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.BOLD, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(125, 312, 179, 44);
		panel_2.add(textField_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_3.setBounds(739, 178, 350, 430);
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
		lblModule_7.setBounds(10, 200, 119, 32);
		panel_3.add(lblModule_7);
		
		JLabel lblModule_8 = new JLabel("Module 3");
		lblModule_8.setFont(new Font("Arial", Font.BOLD, 16));
		lblModule_8.setBounds(21, 317, 119, 32);
		panel_3.add(lblModule_8);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.BOLD, 15));
		textField_6.setColumns(10);
		textField_6.setBounds(125, 71, 179, 44);
		panel_3.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Arial", Font.BOLD, 15));
		textField_7.setColumns(10);
		textField_7.setBounds(125, 195, 179, 44);
		panel_3.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Arial", Font.BOLD, 15));
		textField_8.setColumns(10);
		textField_8.setBounds(125, 312, 179, 44);
		panel_3.add(textField_8);
	}
}
