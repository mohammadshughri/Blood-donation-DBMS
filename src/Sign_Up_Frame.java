import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Sign_Up_Frame extends JFrame {

	private JPanel contentPane;
	private JTextField surnameField;
	private JTextField phonenumberField;
	private JComboBox bloodtype_comboBox;
	private JLabel nameLabel;
	private JLabel surnameLabel;
	private JLabel passwordLabel;
	private JLabel phonenumberLabel;
	private JLabel cityLabel;
	private JLabel lblBloodType;
	private JPasswordField passwordField;
	private JButton signupButton;
	private JLabel districtLabel;
	private JComboBox comboBox_district;
	private JComboBox comboBox_neighbourhood;
	private JLabel neighborhoodLabel;
	private JButton backButton;
	private JLabel confirmpasswordLabel;
	private JPasswordField confirmpasswordField;
	private String city;
	private String [] district;
	private PreparedStatement myPreparedStatement;
	private ComboBox_Objects [] district_objects;
	private ComboBox_Objects [] neighbourhood_objects;
	private ComboBox_Objects myObject;
	private String district_name;
	private int capacity;
	private String neighborhood_name;
	private Random random = new Random();
	private int status_id;
	private Statement myStatement;
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private String bloodcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_Up_Frame frame = new Sign_Up_Frame();
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
	public Sign_Up_Frame() throws Exception {
		Initialize();
	}
	
	public Sign_Up_Frame(int status_id) throws Exception {
		
//		passing status id dynamically
		this.status_id = status_id;
		Initialize();
	}
	
	void Initialize() throws Exception {
//		initialisation function, make UI changes here
		setTitle("Donor and recipent sign up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 867, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start_Page myStart_Page = new Start_Page();
				myStart_Page.setVisible(true);
				dispose();
			}
		});
		backButton.setIcon(new ImageIcon("resources\\\\photos\\\\Backward arrow.png"));
		backButton.setBackground(new Color(220, 20, 60));
		backButton.setBounds(12, 13, 51, 42);
		panel.add(backButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setAutoscrolls(true);
		panel_1.setBounds(0, 451, 867, 58);
		contentPane.add(panel_1);
		
		JTextField nameField = new JTextField();
		nameField.setBounds(122, 89, 272, 41);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		surnameField.setBounds(596, 89, 255, 41);
		contentPane.add(surnameField);
		
		phonenumberField = new JTextField();
		phonenumberField.addKeyListener(new KeyAdapter() {
//			Allowing only digits to be types in our field
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		phonenumberField.setColumns(10);
		phonenumberField.setBounds(509, 336, 255, 41);
		contentPane.add(phonenumberField);
		
		bloodtype_comboBox = new JComboBox();
		bloodtype_comboBox.setBackground(new Color(255, 255, 255));
		bloodtype_comboBox.setBounds(122, 336, 108, 41);
		contentPane.add(bloodtype_comboBox);
		
		for(int i =0; i < getBloodTypeFromDB().size(); i++) {
			
//			Getting bloodtype from database and adding it to our comboBox

			bloodtype_comboBox.addItem(new ComboBox_Objects(getBloodTypeFromDB().get(i)));
		}
		
//		getting default comboBox value
		myObject = (ComboBox_Objects) bloodtype_comboBox.getItemAt(bloodtype_comboBox.getSelectedIndex());
		bloodcode = myObject.toString();
		
		bloodtype_comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				finding combobox value after it has been changed 
				myObject = (ComboBox_Objects) bloodtype_comboBox.getItemAt(bloodtype_comboBox.getSelectedIndex());
				bloodcode = myObject.toString();
				
			}
		});
		
		nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLabel.setBounds(21, 91, 69, 35);
		contentPane.add(nameLabel);
		
		surnameLabel = new JLabel("Surname");
		surnameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		surnameLabel.setBounds(486, 89, 100, 35);
		contentPane.add(surnameLabel);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		passwordLabel.setBounds(12, 161, 92, 35);
		contentPane.add(passwordLabel);
		
		phonenumberLabel = new JLabel("Phone number");
		phonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		phonenumberLabel.setBounds(355, 334, 134, 39);
		contentPane.add(phonenumberLabel);
		
		cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cityLabel.setBounds(37, 259, 46, 35);
		contentPane.add(cityLabel);
		
		lblBloodType = new JLabel("Blood type");
		lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBloodType.setBounds(21, 336, 100, 35);
		contentPane.add(lblBloodType);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 159, 272, 41);
		contentPane.add(passwordField);
		
		signupButton = new JButton("Sign up");
		signupButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				Basic manual form filling error checks 
				
				if(passwordField.getText().isEmpty() || confirmpasswordField.getText().isEmpty() || nameField.getText().isEmpty() || surnameField.getText().isEmpty() || phonenumberField.getText().isEmpty()) {
					JOptionPane myOption = new JOptionPane();
			    	myOption.showMessageDialog(null, "A Field can not be empty");
				
				}else if (!Arrays.equals(passwordField.getPassword(), confirmpasswordField.getPassword())) {
					JOptionPane myOption = new JOptionPane();
			    	myOption.showMessageDialog(null, "Your passwords are not the same");
				
				}else if(phonenumberField.getText().length() > 10 || phonenumberField.getText().length() < 10) {
					JOptionPane myOption = new JOptionPane();
			    	myOption.showMessageDialog(null, "Enter a valid phone number");
				}else {
					
					try {
						
//						Finding address id 
						boolean duplicate_id;
						int address_id = 0;
						Database_Connection = myDataBase.Connect_to_DataBase();
						myPreparedStatement = Database_Connection.prepareStatement("select Address_Id from Address where District = ? and Neighborhood = ?");
						myPreparedStatement.setString(1, district_name);
						myPreparedStatement.setString(2, neighborhood_name);
						myResultset = myPreparedStatement.executeQuery();
						
						while(myResultset.next()) {
							address_id = myResultset.getInt("Address_Id");
						}
						
						String User_Id;
						
//						Formating random user id 

						 DecimalFormat df = new DecimalFormat("0000");
//						 defining User id for donor and receipient 
						 int random_user_id = random.nextInt(11000);
						 User_Id = df.format(random_user_id);
						 if (status_id == 2) {
							 User_Id = "200" + User_Id;
						 }else if (status_id == 3) {
							 User_Id = "300" + User_Id;
						 }
						 
						 int blood_id = 0;
						 
//						 Finding blood id
						 
						 myPreparedStatement = Database_Connection.prepareStatement("select Blood_Id from Blood_Type where Blood_Code = ?");
						 myPreparedStatement.setString(1, bloodcode);
						 myResultset = myPreparedStatement.executeQuery();
						 
						 while(myResultset.next()) {
							 blood_id = myResultset.getInt("Blood_Id");
						 }
						 
//						 Checking for the off chance there is a duplicate User Id, unlikely for our sample size though
						 
						 
						 myPreparedStatement = Database_Connection.prepareStatement("select User_Id from User");
						 myResultset = myPreparedStatement.executeQuery();
						 
						 while(myResultset.next()) {
							 if(User_Id.equals(myResultset.getString("User_Id"))) {
								 random_user_id = random.nextInt(11000);
								 User_Id = df.format(random_user_id);
								 if (status_id == 2) {
									 User_Id = "200" + User_Id;
								 }else if (status_id == 3) {
									 User_Id = "300" + User_Id;
								 }
								 
							 }
							 
						 }
						 
						 
//					    Inserting values into user table
						 
						 myPreparedStatement = Database_Connection.prepareStatement("insert into User values(?, ?, ?, ?, ?)");
						 myPreparedStatement.setInt(1, Integer.parseInt(User_Id));
						 myPreparedStatement.setInt(2, status_id);
						 myPreparedStatement.setInt(3, address_id);
						 myPreparedStatement.setString(4, phonenumberField.getText());
						 myPreparedStatement.setString(5, passwordField.getText());
						 myPreparedStatement.executeUpdate();
						 
//						 inserting values into donor or recipient table based on status id 
						 
						 
						 if(status_id == 2) {
							 myPreparedStatement = Database_Connection.prepareStatement("insert into Donor values(?, ?, ?, ?)");
							 myPreparedStatement.setInt(1, Integer.parseInt(User_Id));
							 myPreparedStatement.setString(2, nameField.getText());
							 myPreparedStatement.setString(3, surnameField.getText());
							 myPreparedStatement.setInt(4, blood_id);
							 
							 myPreparedStatement.executeUpdate();
							 
						 }else if(status_id == 3) {
							 myPreparedStatement = Database_Connection.prepareStatement("insert into Recipient values(?, ?, ?, ?)");
							 myPreparedStatement.setInt(1, Integer.parseInt(User_Id));
							 myPreparedStatement.setString(2, nameField.getText());
							 myPreparedStatement.setString(3, surnameField.getText());
							 myPreparedStatement.setInt(4, blood_id);
							 
							 myPreparedStatement.executeUpdate();
						 }
						  
//						 closing mysql connection
						 
						 myPreparedStatement.close();
						 myResultset.close();
						 Database_Connection.close();
						 
//						 showing the user their id after they signed up
						 
				
						 
						 JOptionPane myOption = new JOptionPane();
						 myOption.showMessageDialog(null, "Signed Up Successfully, your User ID is " + User_Id);
						 
						 dispose();
						 
						 Start_Page myStart_Page = new Start_Page();
						 myStart_Page.setVisible(true);
						 
//						 Close this page and open the Start Page
						
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
				
			}
		});
		signupButton.setIcon(new ImageIcon("resources\\\\photos\\\\Next.png"));
		signupButton.setBounds(309, 397, 322, 41);
		contentPane.add(signupButton);
		
		JComboBox comboBox_city = new JComboBox();
		comboBox_city.setBackground(Color.WHITE);
		comboBox_city.setBounds(102, 259, 172, 41);
		contentPane.add(comboBox_city);

		city = getCityFromDB();
		comboBox_city.addItem(new ComboBox_Objects(city));
		contentPane.add(comboBox_city);
		
		
		districtLabel = new JLabel("District");
		districtLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		districtLabel.setBounds(284, 259, 85, 35);
		contentPane.add(districtLabel);
		
		comboBox_district = new JComboBox();
		comboBox_district.setBackground(Color.WHITE);
		comboBox_district.setBounds(357, 259, 172, 41);
		
		for(int i =0; i < getDistrictFromDB().size(); i++) {
			
//			adding items to district combobox

			comboBox_district.addItem(new ComboBox_Objects(getDistrictFromDB().get(i)));
		}
//		finding default combobox value
		
		myObject = (ComboBox_Objects) comboBox_district.getItemAt(comboBox_district.getSelectedIndex());
		district_name = myObject.toString();
		
		contentPane.add(comboBox_district);
		
		comboBox_neighbourhood = new JComboBox();
		comboBox_neighbourhood.setBackground(Color.WHITE);
		comboBox_neighbourhood.setBounds(677, 259, 172, 41);
		contentPane.add(comboBox_neighbourhood);
		

		for(int i =0; i < getNeighborhoodFromDB(district_name).size(); i++) {
//			adding items to neighbourhood combobox
			comboBox_neighbourhood.addItem(new ComboBox_Objects(getNeighborhoodFromDB(district_name).get(i)));
		}
		
//		finding default value
		myObject = (ComboBox_Objects) comboBox_neighbourhood.getItemAt(comboBox_neighbourhood.getSelectedIndex());
		neighborhood_name = myObject.toString();
		

		comboBox_neighbourhood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
//					finding value when it changes
					myObject = (ComboBox_Objects) comboBox_neighbourhood.getItemAt(comboBox_neighbourhood.getSelectedIndex());
					neighborhood_name = myObject.toString();
				}catch (Exception e2) {
					
				}
				
				
			}
		});
		
		
		
			comboBox_district.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				try {
//					Finding value when it chaanges 
			
						myObject = (ComboBox_Objects) comboBox_district.getItemAt(comboBox_district.getSelectedIndex());
						district_name = myObject.toString();
					comboBox_neighbourhood.removeAllItems();
					for(int i =0; i < getNeighborhoodFromDB(district_name).size(); i++) {
//					displaying new items in the combo box based on district selected
					comboBox_neighbourhood.addItem(new ComboBox_Objects(getNeighborhoodFromDB(district_name).get(i)));
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				
			}
		});
		
		
		neighborhoodLabel = new JLabel("Neighborhood");
		neighborhoodLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		neighborhoodLabel.setBounds(539, 259, 128, 35);
		contentPane.add(neighborhoodLabel);
		
		confirmpasswordLabel = new JLabel("Confirm Password");
		confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirmpasswordLabel.setBounds(422, 174, 164, 39);
		contentPane.add(confirmpasswordLabel);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(595, 171, 272, 41);
		contentPane.add(confirmpasswordField);
	}
	
	String getCityFromDB() throws Exception {
//		Finding city from DB
		String city = null;
		try {
			Database_Connection = myDataBase.Connect_to_DataBase();
			myStatement = Database_Connection.createStatement();
			myResultset = myStatement.executeQuery("select distinct City from Address"); 
			
			while(myResultset.next()) {
				city = myResultset.getString("City");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Database_Connection.close();
		myStatement.close();
		myResultset.close();
	  
		return city;
		
	}
	
	ArrayList<String> getDistrictFromDB() throws SQLException {
//		Finding List of Districts from DB
		ArrayList<String> district = new ArrayList<String>();
		try {
			Database_Connection = myDataBase.Connect_to_DataBase();
			myStatement = Database_Connection.createStatement();
			myResultset = myStatement.executeQuery("select distinct District from Address"); 
			
			int counter = 0;
			
			while(myResultset.next()) {
				district.add(myResultset.getString("District"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Database_Connection.close();
		myStatement.close();
		myResultset.close();
	  
		return district;
		
	}
	
	ArrayList<String> getNeighborhoodFromDB(String district) throws SQLException {
//		Finding List of NeighbourHood based on district from DB
		ArrayList<String> Neighborhood = new ArrayList<String>();
		try {
			Database_Connection = myDataBase.Connect_to_DataBase();
			myStatement = Database_Connection.createStatement();
			myPreparedStatement = Database_Connection.prepareStatement("select distinct Neighborhood from Address where Address.district = ?");
			
			myPreparedStatement.setString(1, district);
			myResultset = myPreparedStatement.executeQuery();
			
			
			while(myResultset.next()) {
				Neighborhood.add(myResultset.getString("Neighborhood"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Database_Connection.close();
		myStatement.close();
		myResultset.close();
	  
		return Neighborhood;
		
	}
	
	ArrayList<String> getBloodTypeFromDB() throws SQLException {
		
//		Finding blood type from DB
		ArrayList<String> bloodtype = new ArrayList<String>();
		try {
			Database_Connection = myDataBase.Connect_to_DataBase();
			myStatement = Database_Connection.createStatement();
			myResultset = myStatement.executeQuery("select Blood_Code from Blood_Type"); 
			
			
			
			while(myResultset.next()) {
				bloodtype.add(myResultset.getString("Blood_Code"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Database_Connection.close();
		myStatement.close();
		myResultset.close();
	  
		return bloodtype;
		
	}
}
