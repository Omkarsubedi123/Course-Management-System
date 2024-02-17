package swing;

import java.awt.BorderLayout;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Table;

import swing3.CourseWork;
import swing3.StudentDashBoard;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class InstructorCourses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField CodeTextField;
	private JTextField NameTextField;
	private JTextField SeatTextField;
	private JTextField BatchTextField;
	private JTextField YearTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorCourses frame = new InstructorCourses();
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
	public InstructorCourses() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout());
		
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
		DashBoardButton.setBounds(57, 242, 128, 35);
		DashBoardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorWorkFrame().setVisible(true);
			}
		});
		DashBoardButton.setBackground(new Color(10,223,23));
		MenuPanel.add(DashBoardButton);
		DashBoardButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Courses = new Button("Courses");
		Courses.setBounds(57, 310, 128, 35);
		Courses.setBackground(new Color(10,223,23));
		MenuPanel.add(Courses);
		
		Courses.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Tutors = new Button("Tutors");
		Tutors.setBounds(57, 441, 128, 35);
		Tutors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorsOnly().setVisible(true);
			}
		});
		Tutors.setBackground(new Color(10,223,23));
		MenuPanel.add(Tutors);
		Tutors.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Student = new Button("Students");
		Student.setBounds(57, 375, 128, 35);
		Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorTotalStudents().setVisible(true);
			}
		});
		Student.setBackground(new Color(10,223,23));
		MenuPanel.add(Student);
		Student.setFont(new Font("Arial", Font.BOLD, 14));
		
		Button Logout = new Button("Logout");
		Logout.setBounds(57, 559, 128, 35);
		Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CourseWork().setVisible(true);
			}
		});
		Logout.setBackground(new Color(238, 75, 43));
		MenuPanel.add(Logout);
		Logout.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel CMSimage = new JLabel("");
		CMSimage.setBounds(20, 42, 254, 177);
		CMSimage.setIcon(new ImageIcon(StudentDashBoard.class.getResource("/Images/CMSPic.png")));
		MenuPanel.add(CMSimage);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(314, 10, 600, 628);
//		contentPane.add(panel);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane Tables = new JScrollPane();
		Tables.setBounds(313, 229, 864, 275);
		panel.add(Tables);
		
		table = new JTable();
		Tables.setViewportView(table);
		table.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel HeadingTable = new JLabel("Course Provided in the College");
		HeadingTable.setBounds(512, 0, 450, 80);
		HeadingTable.setForeground(SystemColor.textHighlight);
		HeadingTable.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(HeadingTable);
		
		JButton CourseDetails = new JButton("Show Details\r\n");
		CourseDetails.setBounds(313, 105, 170, 51);
		CourseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/student";
				
				try {
					// making the connections
					con = DriverManager.getConnection(url, Username, Passwords);
					Statement st = con.createStatement();
					String selectQuery = "SELECT * FROM courses";
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
		CourseDetails.setFont(new Font("Arial", Font.BOLD, 16));
		panel.add(CourseDetails);
	}
}
