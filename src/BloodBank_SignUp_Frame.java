import java.awt.BorderLayout;
import java.util.Random;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BloodBank_SignUp_Frame extends JFrame {
	private int status_id;
	
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private Statement myStatement;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField capacityField;
	private JPasswordField passwordField;
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
	private JTextField phonenumberField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BloodBank_SignUp_Frame frame = new BloodBank_SignUp_Frame();
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
	public BloodBank_SignUp_Frame() throws Exception {
		Initialize();
	}
	
	public BloodBank_SignUp_Frame(int status_id) throws Exception {
//		Passing status id from start page
		this.status_id = status_id;
		Initialize();
	}
	
	void Initialize() throws Exception {
//		Initialise function, make UI changes here 
		setTitle("Admin Signup");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 20, 60));
		panel.setBounds(0, 0, 840, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start_Page myStart_Page = new Start_Page();
				myStart_Page.setVisible(true);
				dispose();
//    			Back button functionality, close Bloodbank sign up frame here
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("resources\\\\photos\\\\Backward arrow.png"));
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setBounds(12, 13, 51, 42);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setBounds(0, 450, 840, 68);
		contentPane.add(panel_1);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(178, 103, 652, 41);
		contentPane.add(nameField);
		
		capacityField = new JTextField();
		capacityField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
//				Allowing only digits be type for capacity field
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
			}
		});
		capacityField.setColumns(10);
		capacityField.setBounds(110, 246, 128, 41);
		contentPane.add(capacityField);
		
		JLabel nameLabel = new JLabel("Blood Bank Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		nameLabel.setBounds(7, 103, 201, 35);
		contentPane.add(nameLabel);
		
		JLabel capacityLabel = new JLabel("Capacity");
		capacityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		capacityLabel.setBounds(7, 246, 93, 41);
		contentPane.add(capacityLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		passwordLabel.setBounds(10, 177, 117, 35);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 177, 262, 41);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//		basic error checks for filling forms, least capacity value is 100
				
		if(passwordField.getText().isEmpty() || confirmpasswordField.getText().isEmpty() || nameField.getText().isEmpty() || capacityField.getText().isEmpty() || phonenumberField.getText().isEmpty()) {
			JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "A Field can not be empty");
		
		}else if (!Arrays.equals(passwordField.getPassword(), confirmpasswordField.getPassword())) {
			JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Your passwords are not the same");
		}else if(Integer.parseInt(capacityField.getText()) < 100) {
			JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Minimum allowed capacity is 100");
		}else if(phonenumberField.getText().length() > 10 || phonenumberField.getText().length() < 10) {
			JOptionPane myOption = new JOptionPane();
	    	myOption.showMessageDialog(null, "Enter a valid phone number");
		}else {
			
			try {
				
//				Finding address id
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
				
				String Bank_id;
//				Generating bank id
				 DecimalFormat df = new DecimalFormat("0000");
				 
				 int random_user_id = random.nextInt(11000);
				 Bank_id = df.format(random_user_id);
				 Bank_id = "100" + Bank_id;
				 
				 myPreparedStatement = Database_Connection.prepareStatement("select Bank_Id from Blood_Bank");
				 myResultset = myPreparedStatement.executeQuery();
				 
				 while(myResultset.next()) {
//					 Checking the off chance there is a duplicate bank id, unlikely
					 if(Bank_id.equals(myResultset.getString("Bank_Id"))) {
						 random_user_id = random.nextInt(11000);
						 Bank_id = df.format(random_user_id);
						 Bank_id = "100" + Bank_id;
					 }
					 
				 }
				 
				 
//				 Inserting into User table
				 
				 
				 myPreparedStatement = Database_Connection.prepareStatement("insert into User values(?, ?, ?, ?, ?)");
				 myPreparedStatement.setInt(1, Integer.parseInt(Bank_id));
				 myPreparedStatement.setInt(2, status_id);
				 myPreparedStatement.setInt(3, address_id);
				 myPreparedStatement.setString(4, phonenumberField.getText());
				 myPreparedStatement.setString(5, passwordField.getText());
				 myPreparedStatement.executeUpdate();
				 
//				 Inserting into blood bank table
				 
				 
				 myPreparedStatement = Database_Connection.prepareStatement("insert into Blood_Bank values(?, ?, ?)");
				 myPreparedStatement.setInt(1, Integer.parseInt(Bank_id));
				 myPreparedStatement.setString(2, nameField.getText());
				 myPreparedStatement.setInt(3, Integer.parseInt(capacityField.getText()));
				 myPreparedStatement.executeUpdate();
				 
				 myPreparedStatement.close();
				 myResultset.close();
				 Database_Connection.close();
				 
//				 Showing the user their bank id 
				 
				
			
				 JOptionPane myOption = new JOptionPane();
				 myOption.showMessageDialog(null, "Signed Up Successfully, your User ID is " + Bank_id);
				 
				 dispose();
				 
				 Start_Page myStart_Page = new Start_Page();
				 myStart_Page.setVisible(true);
				 
				 
//				 Close this page and open the Start Page
				 
				
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
			
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon("resources\\\\photos\\\\Next.png"));
		btnNewButton.setBounds(288, 380, 322, 41);
		contentPane.add(btnNewButton);
		
		JLabel cityLabel = new JLabel("City");
		cityLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cityLabel.setBounds(7, 298, 46, 35);
		contentPane.add(cityLabel);
		
		JComboBox comboBox_city = new JComboBox();
		comboBox_city.setBackground(Color.WHITE);
		comboBox_city.setBounds(65, 298, 172, 41);
		
		
		
		city = getCityFromDB();
		comboBox_city.addItem(new ComboBox_Objects(city));
		contentPane.add(comboBox_city);
		
		
		JLabel districtLabel = new JLabel("District");
		districtLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		districtLabel.setBounds(247, 298, 85, 35);
		contentPane.add(districtLabel);
		
		JComboBox comboBox_district = new JComboBox();
		comboBox_district.setBackground(Color.WHITE);
		comboBox_district.setBounds(318, 298, 172, 41);
		
		
		
		for(int i =0; i < getDistrictFromDB().size(); i++) {
			
//			Adding districts to combobox

			comboBox_district.addItem(new ComboBox_Objects(getDistrictFromDB().get(i)));
		}
		
//		getting default values
		myObject = (ComboBox_Objects) comboBox_district.getItemAt(comboBox_district.getSelectedIndex());
		district_name = myObject.toString();

		contentPane.add(comboBox_district);
		
		JLabel neighbourhoodLabel = new JLabel("Neighborhood");
		neighbourhoodLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		neighbourhoodLabel.setBounds(500, 298, 148, 35);
		contentPane.add(neighbourhoodLabel);
		
		JComboBox comboBox_neighbourhood = new JComboBox();
		comboBox_neighbourhood.setBackground(Color.WHITE);
		comboBox_neighbourhood.setBounds(658, 298, 172, 41);
		contentPane.add(comboBox_neighbourhood);
		
		
		
		for(int i =0; i < getNeighborhoodFromDB(district_name).size(); i++) {
//			adding neighbourhood to combobox

			comboBox_neighbourhood.addItem(new ComboBox_Objects(getNeighborhoodFromDB(district_name).get(i)));
		}
		
//		getting default values
		myObject = (ComboBox_Objects) comboBox_neighbourhood.getItemAt(comboBox_neighbourhood.getSelectedIndex());
		neighborhood_name = myObject.toString();
		comboBox_neighbourhood.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				getting values after it has been changed
				try {
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
			
						myObject = (ComboBox_Objects) comboBox_district.getItemAt(comboBox_district.getSelectedIndex());
						district_name = myObject.toString();
					comboBox_neighbourhood.removeAllItems();
					for(int i =0; i < getNeighborhoodFromDB(district_name).size(); i++) {
//					getting neighbourhood values based on district name selected
					comboBox_neighbourhood.addItem(new ComboBox_Objects(getNeighborhoodFromDB(district_name).get(i)));
					}
				} catch (SQLException e) {
					System.out.println("Problem");
					e.printStackTrace();
				}
				
				
			}
		});
		
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConfirmPassword.setBounds(382, 177, 178, 35);
		contentPane.add(lblConfirmPassword);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(570, 177, 262, 41);
		contentPane.add(confirmpasswordField);
		
		JLabel phonenumberLabel = new JLabel("Phone Number");
		phonenumberLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		phonenumberLabel.setBounds(382, 237, 178, 35);
		contentPane.add(phonenumberLabel);
		
		phonenumberField = new JTextField();
		phonenumberField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				Allowing only digits for phone numbers
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		phonenumberField.setColumns(10);
		phonenumberField.setBounds(570, 237, 260, 41);
		contentPane.add(phonenumberField);
		
	}
	
	String getCityFromDB() throws Exception {
//		Fetching city from db
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
//		Fetching districts from DB
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
//		Fetching NeighbourHood based on district selected from DB
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
}

