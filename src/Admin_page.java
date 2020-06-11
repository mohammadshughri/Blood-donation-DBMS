import java.awt.BorderLayout;
import net.proteanit.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_page extends JFrame {

	private JPanel contentPane;
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private Statement myStatement;
	private int user_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_page frame = new Admin_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Admin_page() throws Exception {
		Initialize();
	}
	
	public Admin_page(int user_id) throws Exception {
		this.user_id = user_id;
		Initialize();
	}
	
	void Initialize() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel side_panels = new JPanel();
		side_panels.setBackground(new Color(220, 20, 60));
		side_panels.setBounds(0, 0, 231, 583);
		contentPane.add(side_panels);
		side_panels.setLayout(null);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile_Admin myProfileAdmin;
				try {
					myProfileAdmin = new Profile_Admin(user_id);
					myProfileAdmin.setVisible(true);
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnProfile.setBackground(new Color(245, 245, 245));
		btnProfile.setBounds(88, 54, 100, 50);
		side_panels.add(btnProfile);
		
		JLabel profile_icon = new JLabel("");
		profile_icon.setIcon(new ImageIcon(Admin_page.class.getResource("/photos/profile_icon.png")));
		profile_icon.setBounds(17, 42, 59, 67);
		side_panels.add(profile_icon);
		
		JLabel saveLifeLabel = new JLabel("Save a life!");
		saveLifeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveLifeLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		saveLifeLabel.setForeground(new Color(255, 255, 255));
		saveLifeLabel.setBounds(12, 469, 199, 67);
		side_panels.add(saveLifeLabel);
		
		JLabel welcom_label = new JLabel("Welcome Admin!");
		welcom_label.setForeground(new Color(220, 20, 60));
		welcom_label.setFont(new Font("Segoe Print", Font.BOLD, 36));
		welcom_label.setHorizontalAlignment(SwingConstants.CENTER);
		welcom_label.setBounds(235, 0, 399, 90);
		contentPane.add(welcom_label);
		
		JLabel users_label = new JLabel("Users");
		users_label.setForeground(new Color(220, 20, 60));
		users_label.setFont(new Font("Tahoma", Font.BOLD, 33));
		users_label.setHorizontalAlignment(SwingConstants.CENTER);
		users_label.setBounds(432, 105, 231, 72);
		contentPane.add(users_label);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(220, 20, 60));
		separator.setBackground(new Color(220, 20, 60));
		separator.setBounds(235, 224, 722, 2);
		contentPane.add(separator);
		
		JScrollPane infoPane = new JScrollPane();
		infoPane.setBounds(235, 238, 729, 345);
		contentPane.add(infoPane);
		
		JTable table = new JTable();
		
		Database_Connection = myDataBase.Connect_to_DataBase();
		myStatement = Database_Connection.createStatement();
		myResultset = myStatement.executeQuery("select User_Id , concat(First_Name , \" \" , Last_Name) as Name , Status , Blood_Code as Blood_Type , City ,  District ,  Neighborhood, Phone_No \r\n" + 
				"from User , Status , Address , Donor , Blood_Type\r\n" + 
				"where Donor.Donor_Id = User.User_Id and User.Status_Id = Status.Status_Id and User.Address_Id = Address.Address_Id and Donor.Blood_Id = Blood_Type.Blood_Id\r\n" + 
				"Union\r\n" + 
				"select User_Id , concat(First_Name , \" \" , Last_Name) as Name , Status , Blood_Code as Blood_Type , City , District , Neighborhood, Phone_No \r\n" + 
				"from User , Status , Address , Recipient , Blood_Type\r\n" + 
				"where Recipient.Recipient_Id = User.User_Id and User.Status_Id = Status.Status_Id and User.Address_Id = Address.Address_Id and Recipient.Blood_Id = Blood_Type.Blood_Id\r\n" + 
				"order by User_Id");
		
		infoPane.setViewportView(table);
		
		table.setModel(DbUtils.resultSetToTableModel(myResultset)); 
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start_Page myStartPage = new Start_Page();
				myStartPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setIcon(new ImageIcon(Admin_page.class.getResource("/photos/exit.png")));
		btnNewButton.setBounds(882, 11, 75, 67);
		contentPane.add(btnNewButton);
		
		Database_Connection.close();
		myStatement.close();
		myResultset.close();
		
	}
}
