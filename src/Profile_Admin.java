import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profile_Admin extends JFrame {

	private JPanel contentPane;
	private int user_id;
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private Statement myStatement;
	private PreparedStatement myPreparedStatement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile_Admin frame = new Profile_Admin();
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
	public Profile_Admin() throws Exception {
		Initialize();
	}
	
	public Profile_Admin(int user_id) throws Exception {
		this.user_id = user_id;
		Initialize();
		
	}
	
	
	void Initialize() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton(" ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					dispose();
					Admin_page myAdminPage = new Admin_page(user_id);
					myAdminPage.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(255, 102, 153));
		btnNewButton.setIcon(new ImageIcon(Profile_Admin.class.getResource("/photos/back button pink.png")));
		btnNewButton.setBounds(87, 37, 86, 61);
		contentPane.add(btnNewButton);
		
		JLabel NameAndSurname_label = new JLabel("Name and Surname here");
		NameAndSurname_label.setHorizontalAlignment(SwingConstants.CENTER);
		NameAndSurname_label.setForeground(new Color(220, 20, 60));
		NameAndSurname_label.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		NameAndSurname_label.setBounds(736, 139, 369, 68);
		contentPane.add(NameAndSurname_label);
		
		JLabel UserID_label = new JLabel("User ID is here");
		UserID_label.setHorizontalAlignment(SwingConstants.CENTER);
		UserID_label.setForeground(new Color(220, 20, 60));
		UserID_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		UserID_label.setBounds(736, 233, 369, 68);
		contentPane.add(UserID_label);
		
		JLabel PhoneNum_label = new JLabel("phone number here");
		PhoneNum_label.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNum_label.setForeground(new Color(220, 20, 60)); 
		PhoneNum_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		PhoneNum_label.setBounds(736, 339, 369, 68);
		contentPane.add(PhoneNum_label);
		
		JLabel Location_label = new JLabel("Location here");
		Location_label.setHorizontalAlignment(SwingConstants.CENTER);
		Location_label.setForeground(new Color(220, 20, 60));
		Location_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		Location_label.setBounds(636, 436, 502, 160);
		contentPane.add(Location_label);
		
		JLabel bloodBankNameLabel = new JLabel("Blood Bank Name");
		bloodBankNameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		bloodBankNameLabel.setForeground(new Color(255, 255, 255));
		bloodBankNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bloodBankNameLabel.setBounds(146, 151, 369, 68);
		contentPane.add(bloodBankNameLabel);
		
		JLabel UserIDFixed = new JLabel("User ID:");
		UserIDFixed.setHorizontalAlignment(SwingConstants.CENTER);
		UserIDFixed.setForeground(Color.WHITE);
		UserIDFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		UserIDFixed.setBounds(146, 245, 369, 68);
		contentPane.add(UserIDFixed);
		
		JLabel PhoneNumberFixed = new JLabel("Phone Number:");
		PhoneNumberFixed.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNumberFixed.setForeground(Color.WHITE);
		PhoneNumberFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		PhoneNumberFixed.setBounds(146, 336, 369, 68);
		contentPane.add(PhoneNumberFixed);
		
		JLabel LocationFixed = new JLabel("Location:");
		LocationFixed.setHorizontalAlignment(SwingConstants.CENTER);
		LocationFixed.setForeground(Color.WHITE);
		LocationFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		LocationFixed.setBounds(146, 451, 369, 68);
		contentPane.add(LocationFixed);
		
		JLabel lblNewLabel_1_4 = new JLabel("Profile");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_1_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1_4.setBounds(752, 58, 369, 68);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel template_lebal = new JLabel("");
		template_lebal.setIcon(new ImageIcon(Profile_Admin.class.getResource("/photos/Profile template.png")));
		template_lebal.setBounds(0, -13, 1233, 724);
		contentPane.add(template_lebal);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapacity.setForeground(Color.WHITE);
		lblCapacity.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		lblCapacity.setBounds(176, 565, 369, 68);
		contentPane.add(lblCapacity);
		
		JLabel LocationFixed_1 = new JLabel("Location:");
		LocationFixed_1.setHorizontalAlignment(SwingConstants.CENTER);
		LocationFixed_1.setForeground(Color.WHITE);
		LocationFixed_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		LocationFixed_1.setBounds(146, 546, 369, 68);
		contentPane.add(LocationFixed_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(250, 561, 46, 14);
		contentPane.add(lblNewLabel);
		
		String phonenumber = null;
		int address_id = 0;
		String name = null;
		String city = null;
		String district = null;
		String Neighborhood = null;
		
		
		
		Database_Connection = myDataBase.Connect_to_DataBase();
		myPreparedStatement = Database_Connection.prepareStatement("select Address_Id, Phone_no from User where User_Id = ?");
		myPreparedStatement.setInt(1, user_id);
		myResultset = myPreparedStatement.executeQuery();
		while(myResultset.next()) {
			address_id = myResultset.getInt("Address_Id");
			phonenumber = myResultset.getString("Phone_no");
		}
		
		myPreparedStatement = Database_Connection.prepareStatement("select Name from Blood_Bank where Bank_Id = ?");
		myPreparedStatement.setInt(1, user_id);
		myResultset = myPreparedStatement.executeQuery();
		while(myResultset.next()) {
			name = myResultset.getString("Name");
		}
		
		myPreparedStatement = Database_Connection.prepareStatement("select City, District, Neighborhood from Address where Address_Id = ?");
		myPreparedStatement.setInt(1, address_id);
		myResultset = myPreparedStatement.executeQuery();
		while(myResultset.next()) {
			city = myResultset.getString("City");
			district = myResultset.getString("District");
			Neighborhood = myResultset.getString("Neighborhood");
		}
		
		String location_string = Neighborhood + " " + district;
		
		NameAndSurname_label.setText(name);
		UserID_label.setText(Integer.toString(user_id));
		PhoneNum_label.setText(phonenumber);
		Location_label.setText(location_string);
		
		Database_Connection.close();
		myPreparedStatement.close();
		myResultset.close();
		
	
		
		
		
	
		
		
	}
}
