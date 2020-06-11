import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Update_Donor_Recipient_Frame extends JFrame{
	private JPanel contentPane;
	private JTextField surnameField;
	private JTextField phonenumberField;
	private JComboBox bloodtype_comboBox;
	private JLabel nameLabel;
	private JLabel surnameLabel;
	private JLabel passwordLabel;
	private JLabel phonenumberLabel;
	private JLabel lblBloodType;
	private JPasswordField passwordField;
	private JButton signupButton;
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
	private int user_id;
	private Statement myStatement;
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private String bloodcode;
	private int status_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Donor_Recipient_Frame frame = new Update_Donor_Recipient_Frame();
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
	public Update_Donor_Recipient_Frame() throws Exception {
		Initialize();
	}
	
	public Update_Donor_Recipient_Frame(int user_id, int status_id) throws Exception {
		
//		passing status id dynamically
		this.user_id = user_id;
		this.status_id = status_id;
		Initialize();
	}
	
	void Initialize() throws Exception {
//		initialisation function, make UI changes here
		setTitle("Update Page");
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
				
				try {
					Dashboard myDashboard = new Dashboard(user_id, status_id);
					myDashboard.setVisible(true);
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
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
		phonenumberField.setBounds(596, 245, 255, 41);
		contentPane.add(phonenumberField);
		
		bloodtype_comboBox = new JComboBox();
		bloodtype_comboBox.setBackground(new Color(255, 255, 255));
		bloodtype_comboBox.setBounds(124, 226, 108, 41);
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
		phonenumberLabel.setBounds(452, 243, 134, 39);
		contentPane.add(phonenumberLabel);
		
		lblBloodType = new JLabel("Blood type");
		lblBloodType.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBloodType.setBounds(12, 226, 100, 35);
		contentPane.add(lblBloodType);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(122, 159, 272, 41);
		contentPane.add(passwordField);
		
		signupButton = new JButton("Update");
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
						Database_Connection = myDataBase.Connect_to_DataBase();
						myPreparedStatement = Database_Connection.prepareStatement("UPDATE user\r\n" + 
								" Set Phone_No = ? ,\r\n" + 
								"     Password =  ?\r\n" + 
								" WHERE User_Id = ?");
						myPreparedStatement.setString(1, phonenumberField.getText());
						myPreparedStatement.setString(2, passwordField.getText());
						myPreparedStatement.setInt(3, user_id);
						myPreparedStatement.executeUpdate();
						
						if(status_id == 2) {
							myPreparedStatement = Database_Connection.prepareStatement("UPDATE donor\r\n" + 
									" Set First_Name = ? \r\n" + 
									"    ,Last_Name =  ? \r\n" + 
									" WHERE Donor_Id = ?;");
							myPreparedStatement.setString(1, nameField.getText());
							myPreparedStatement.setString(2, surnameField.getText());
							myPreparedStatement.setInt(3, user_id);
							myPreparedStatement.executeUpdate();
						}else {
							myPreparedStatement = Database_Connection.prepareStatement("UPDATE recipient\r\n" + 
									" Set First_Name = ? \r\n" + 
									"    ,Last_Name =  ? \r\n" + 
									" WHERE Recipient_Id = ?");
							myPreparedStatement.setString(1, nameField.getText());
							myPreparedStatement.setString(2, surnameField.getText());
							myPreparedStatement.setInt(3, user_id);
							myPreparedStatement.executeUpdate();
						}
						
						
						JOptionPane myOption = new JOptionPane();
						myOption.showMessageDialog(null, "Data Updated Successfully for " + user_id);
						
						
						Dashboard myDashboard = new Dashboard();
						myDashboard.setVisible(true);
						
						Database_Connection.close();
						myPreparedStatement.close();
						dispose();
						

						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
					
				
			}
		});
		signupButton.setIcon(new ImageIcon("resources\\\\photos\\\\Next.png"));
		signupButton.setBounds(308, 399, 322, 41);
		contentPane.add(signupButton);

	
		
		
		confirmpasswordLabel = new JLabel("Confirm Password");
		confirmpasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirmpasswordLabel.setBounds(422, 174, 164, 39);
		contentPane.add(confirmpasswordLabel);
		
		confirmpasswordField = new JPasswordField();
		confirmpasswordField.setBounds(595, 171, 255, 41);
		contentPane.add(confirmpasswordField);
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
