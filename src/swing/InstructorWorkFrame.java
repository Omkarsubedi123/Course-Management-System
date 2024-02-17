//package swing;
//
//import java.awt.Button;
//import java.awt.Color;
//import java.awt.EventQueue;
//
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.SystemColor;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class InstructorWorkFrame extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InstructorWorkFrame frame = new InstructorWorkFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public InstructorWorkFrame() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1223, 687);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JPanel panel = new JPanel();
//		panel.setBounds(314, 10, 885, 628);
//		contentPane.add(panel);
//		panel.setLayout(null);
//		
//		JButton TotalStdButton = new JButton("Total Students");
//		TotalStdButton.setBounds(82, 210, 724, 190);
//		TotalStdButton.setFont(new Font("Arial", Font.BOLD, 25));
//		panel.add(TotalStdButton);
//		
//		JButton TotalCourseButton = new JButton("Total Courses\r\n");
//		TotalCourseButton.setBounds(82, 10, 724, 190);
//		TotalCourseButton.setFont(new Font("Arial", Font.BOLD, 25));
//		panel.add(TotalCourseButton);
//		
//		JButton TotalTutorButton = new JButton("Total Tutors");
//		TotalTutorButton.setBounds(82, 410, 724, 190);
//		TotalTutorButton.setFont(new Font("Arial", Font.BOLD, 24));
//		panel.add(TotalTutorButton);
//		
//		JPanel MenuPanel = new JPanel();
//		MenuPanel.setBounds(10, 10, 294, 628);
//		contentPane.add(MenuPanel);
//		MenuPanel.setBackground(SystemColor.info);
//		MenuPanel.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("Course Management System");
//		lblNewLabel.setBounds(10, 10, 251, 22);
//		MenuPanel.add(lblNewLabel);
//		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
//		
//		Button DashBoard = new Button("DashBoard");
//		DashBoard.setBackground(new Color(10,223,23));
//		DashBoard.setBounds(57, 242, 128, 35);
//		MenuPanel.add(DashBoard);
//		DashBoard.setFont(new Font("Arial", Font.BOLD, 14));
//		
//		Button Courses = new Button("Courses");
//		Courses.setBackground(new Color(10,223,23));
//		Courses.setBounds(57, 320, 128, 35);
//		MenuPanel.add(Courses);
//		
//		Courses.setFont(new Font("Arial", Font.BOLD, 14));
//		
//		Button Tutors = new Button("Tutors");
//		Tutors.setBackground(new Color(10,223,23));
//		Tutors.setBounds(57, 395, 128, 35);
//		MenuPanel.add(Tutors);
//		Tutors.setFont(new Font("Arial", Font.BOLD, 14));
//		
//		Button Student = new Button("Students");
//		Student.setBackground(new Color(10,223,23));
//		Student.setBounds(57, 467, 128, 35);
//		MenuPanel.add(Student);
//		Student.setFont(new Font("Arial", Font.BOLD, 14));
//		
//		Button Logout = new Button("Logout");
//		Logout.setBackground(new Color(238, 75, 43));
//		Logout.setBounds(57, 570, 128, 35);
//		MenuPanel.add(Logout);
//		Logout.setFont(new Font("Arial", Font.BOLD, 15));
//		
//		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(StudentDashBoard.class.getResource("/Images/CMSPic.png")));
//		lblNewLabel_1.setBounds(20, 42, 254, 177);
//		MenuPanel.add(lblNewLabel_1);
//	}
//}

package swing;

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
import swing2.Results;
import swing3.CourseWork;
import swing3.StudentDashBoard;

public class InstructorWorkFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InstructorWorkFrame frame = new InstructorWorkFrame();
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
	public InstructorWorkFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 686);
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
		TotalStdButton.setBounds(82, 10, 724, 190);
		TotalStdButton.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(TotalStdButton);
		
		JButton TotalCourseButton = new JButton("Total Courses\r\n");
		TotalCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorCourses().setVisible(true);
			}
		});
		TotalCourseButton.setBounds(82, 210, 724, 190);
		TotalCourseButton.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(TotalCourseButton);
		
		JButton TotalTutorButton = new JButton("Total Tutors");
		TotalTutorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorsOnly().setVisible(true);
			}
		});
		TotalTutorButton.setBounds(82, 410, 724, 190);
		TotalTutorButton.setFont(new Font("Arial", Font.BOLD, 24));
		panel.add(TotalTutorButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(InstructorWorkFrame.class.getResource("/Images/Blue2.jpg")));
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
		DashBoardButton.setBounds(57, 225, 128, 35);
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
		Courses.setBounds(57, 291, 128, 35);
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
		Tutors.setBounds(57, 422, 128, 35);
		MenuPanel.add(Tutors);
		Tutors.setFont(new Font("Arial", Font.BOLD, 14));
		
		JButton btnNewButton = new JButton("Result");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new FinalResult().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(57, 484, 128, 35);
		MenuPanel.add(btnNewButton);
		
		Button Student = new Button("Students");
		Student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InstructorTotalStudents().setVisible(true);
			}
		});
		Student.setBackground(new Color(10,223,23));
		Student.setBounds(57, 353, 128, 35);
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

