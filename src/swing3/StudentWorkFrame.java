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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


public class StudentWorkFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentWorkFrame frame = new StudentWorkFrame();
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
	public StudentWorkFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(188,142,218,100));
		panel.setBounds(10, 10, 641, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Heading = new JLabel("Welcome to Student mode");
		Heading.setForeground(new Color(210, 43, 43));
		Heading.setFont(new Font("Arial", Font.BOLD, 24));
		Heading.setBounds(157, 10, 385, 85);
		panel.add(Heading);
		
		JLabel Courses = new JLabel("Courses\r\n");
		Courses.setFont(new Font("Arial", Font.BOLD, 20));
		Courses.setBounds(103, 123, 132, 46);
		panel.add(Courses);
		
		JComboBox CourseComboBox = new JComboBox();
		CourseComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Courses", "B.s.c(hons) Computer Science", "BIBM"}));
		CourseComboBox.setFont(new Font("Arial", Font.BOLD, 16));
		CourseComboBox.setBounds(102, 179, 420, 35);
		panel.add(CourseComboBox);
		
		Button NextButton = new Button("Next\r\n");
		JComboBox comboSelectMode = CourseComboBox;
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String combo = (String) comboSelectMode.getSelectedItem();
				// using if-else statement
				if(combo.equals("B.s.c(hons) Computer Science")) {
					dispose();
					new StudentDashBoard().setVisible(true);
				}
				else if(combo.equals("BIBM")) {
					JOptionPane.showMessageDialog(null, "The course is not registered!!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid selection!!!");
				}
//				dispose();
			}
		});
		NextButton.setBackground(new Color(10,223,23));
		NextButton.setFont(new Font("Arial", Font.BOLD, 16));
		NextButton.setActionCommand("NewButton");
		NextButton.setBounds(442, 293, 121, 35);
		panel.add(NextButton);
		
		Button BackButton = new Button("Go Back\r\n");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CourseWork().setVisible(true);
			}
		});
		BackButton.setBackground(new Color(238, 75, 43));
		BackButton.setForeground(SystemColor.activeCaptionText);
		BackButton.setFont(new Font("Arial", Font.BOLD, 16));
		BackButton.setBounds(103, 293, 121, 35);
		panel.add(BackButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentWorkFrame.class.getResource("/Images/Purple.jpg")));
		lblNewLabel.setBounds(0, 0, 641, 367);
		panel.add(lblNewLabel);
	}
}
