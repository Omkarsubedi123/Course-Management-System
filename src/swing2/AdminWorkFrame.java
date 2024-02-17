package swing2;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import swing3.CourseWork;
import swing3.StudentDashBoard;



public class AdminWorkFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWorkFrame frame = new AdminWorkFrame();
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
	public AdminWorkFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(314, 10, 885, 628);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton TotalStdButton = new JButton("Total Students");
		TotalStdButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminStudentMode().setVisible(true);
			}
		});
		TotalStdButton.setBounds(82, 210, 724, 190);
		TotalStdButton.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(TotalStdButton);
		
		JButton TotalCourseButton = new JButton("Total Courses\r\n");
		TotalCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminCourse().setVisible(true);
			}
		});
		TotalCourseButton.setBounds(82, 10, 724, 190);
		TotalCourseButton.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(TotalCourseButton);
		
		JButton TotalTutorButton = new JButton("Total Tutors");
		TotalTutorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new AdminTutorMode().setVisible(true);
			}
		});
		TotalTutorButton.setBounds(82, 410, 724, 190);
		TotalTutorButton.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(TotalTutorButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminWorkFrame.class.getResource("/Images/Blue2.jpg")));
		lblNewLabel.setBounds(0, 0, 885, 628);
		panel.add(lblNewLabel);
		
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
	}
}
