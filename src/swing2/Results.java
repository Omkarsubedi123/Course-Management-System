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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

import swing3.CourseWork;
import swing3.StudentDashBoard;


public class Results extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Results frame = new Results();
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
	public Results() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 686);
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 865, 285);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Results of All Students");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(290, 10, 343, 70);
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
		
		JButton ShowResultButton = new JButton("Show Results");
		ShowResultButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				String Username = "root";
				String Passwords = "";
				String url = "jdbc:mysql://localhost:3306/student";
				
				try {
					// making the connections
					con = DriverManager.getConnection(url, Username, Passwords);
					Statement st = con.createStatement();
					String selectQuery = "SELECT * FROM Reports";
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
		ShowResultButton.setFont(new Font("Arial", Font.BOLD, 16));
		ShowResultButton.setBounds(57, 210, 170, 51);
		MenuPanel.add(ShowResultButton);
		
		JButton GoBackButton = new JButton("Go Back");
		GoBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new StudentDashBoard().setVisible(true);
			}
		});
		GoBackButton.setFont(new Font("Arial", Font.BOLD, 16));
		GoBackButton.setBounds(57, 328, 170, 51);
		MenuPanel.add(GoBackButton);
	}
}
