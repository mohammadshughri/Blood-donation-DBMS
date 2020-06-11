import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private int user_id;
	private Connection Database_Connection;
	private ResultSet myResultset;
	private MySQLAccess myDataBase = new MySQLAccess();
	private Statement myStatement;
	private ArrayList<String> bankName = new ArrayList();
	private ArrayList<String> cityName = new ArrayList();
	private ArrayList<String> phone_No = new ArrayList();
	private ArrayList<String> addressDetails = new ArrayList();
	private int length_of_tuples;
	private int number_of_updates_done = 0;
	private int update_index = 1;
	private int status_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() throws Exception {
		Initialize();
	}
	
	public Dashboard(int user_id, int status_id) throws Exception {
		this.user_id = user_id;
		this.status_id = status_id;
		Initialize();
	}
	
	void Initialize() throws Exception {
		setFont(new Font("Times New Roman", Font.PLAIN, 17));
		setTitle("Dashboard\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1156, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start_Page myStartPage = new Start_Page();
				myStartPage.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/photos/exit.png")));
		btnNewButton.setBounds(1069, 11, 61, 67);
		contentPane.add(btnNewButton);
		
		
		
	
		
		
		
		JLabel nameRightLabel = new JLabel("center name here");
		nameRightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameRightLabel.setForeground(new Color(220, 20, 60));
		nameRightLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 22));
		nameRightLabel.setBounds(785, 426, 324, 48);
		contentPane.add(nameRightLabel);
		
		JLabel cityRightLabel = new JLabel("city name here");
		cityRightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityRightLabel.setForeground(new Color(220, 20, 60));
		cityRightLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		cityRightLabel.setBounds(829, 489, 235, 26);
		contentPane.add(cityRightLabel);
		
		JLabel phonenoRightLabel = new JLabel("phone number here");
		phonenoRightLabel.setForeground(new Color(220, 20, 60));
		phonenoRightLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23)); 
		phonenoRightLabel.setBounds(884, 536, 231, 48);
		contentPane.add(phonenoRightLabel);
		
		JLabel addressRightLabel = new JLabel("address here");
		addressRightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressRightLabel.setForeground(new Color(220, 20, 60));
		addressRightLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addressRightLabel.setBounds(788, 592, 319, 41);
		contentPane.add(addressRightLabel);
		
		JLabel nameLeftLabel = new JLabel("center name here");
		nameLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLeftLabel.setForeground(new Color(220, 20, 60));
		nameLeftLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		nameLeftLabel.setBounds(81, 412, 215, 48);
		contentPane.add(nameLeftLabel);
		
		JLabel cityLeftLabel = new JLabel("city name here");
		cityLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLeftLabel.setForeground(new Color(220, 20, 60));
		cityLeftLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		cityLeftLabel.setBounds(47, 475, 286, 31);
		contentPane.add(cityLeftLabel);
		
		JLabel phonenoLeftLabel = new JLabel("phone number here");
		phonenoLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonenoLeftLabel.setForeground(new Color(220, 20, 60));
		phonenoLeftLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		phonenoLeftLabel.setBounds(53, 528, 269, 48);
		contentPane.add(phonenoLeftLabel);
		
		JLabel addressLeftLabel = new JLabel("address here");
		addressLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLeftLabel.setForeground(new Color(220, 20, 60));
		addressLeftLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addressLeftLabel.setBounds(29, 592, 301, 41);
		contentPane.add(addressLeftLabel);
		
		JButton btnNewButton_1 = new JButton("Update Info");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					Update_Donor_Recipient_Frame myUpdatePage;
					myUpdatePage = new Update_Donor_Recipient_Frame(user_id, status_id);
					myUpdatePage.setVisible(true);
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(10, 11, 132, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel nameMidLabel = new JLabel("center name here");
		nameMidLabel.setForeground(new Color(220, 20, 60));
		nameMidLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		nameMidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameMidLabel.setBounds(393, 362, 361, 48);
		contentPane.add(nameMidLabel);
		
		JLabel cityMidLabel = new JLabel("city name here");
		cityMidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		cityMidLabel.setForeground(new Color(220, 20, 60));
		cityMidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityMidLabel.setBounds(446, 423, 251, 45);
		contentPane.add(cityMidLabel);
		
		JLabel phonenoMidLabel = new JLabel("phone number here");
		phonenoMidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phonenoMidLabel.setForeground(new Color(220, 20, 60));
		phonenoMidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 21));
		phonenoMidLabel.setBounds(432, 497, 291, 53);
		contentPane.add(phonenoMidLabel);
		
		JLabel addressMidLabel = new JLabel("address here");
		addressMidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressMidLabel.setForeground(new Color(220, 20, 60));
		addressMidLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		addressMidLabel.setBounds(381, 573, 381, 58);
		contentPane.add(addressMidLabel);
		
		JLabel MidPhotoLabel = new JLabel("");
		MidPhotoLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/photos/donation centers photo1.jpg")));
		MidPhotoLabel.setBounds(461, 179, 241, 180);
		contentPane.add(MidPhotoLabel);
		
		JLabel leftPhotoLabel = new JLabel("");
		leftPhotoLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/photos/donation centers photo3.jpg")));
		leftPhotoLabel.setBounds(74, 223, 210, 180);
		contentPane.add(leftPhotoLabel);
		
		JLabel RightPhotoLabel = new JLabel("");
		RightPhotoLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/photos/donation centers photo2.jpg")));
		RightPhotoLabel.setBounds(849, 226, 228, 180);
		contentPane.add(RightPhotoLabel);
		
		JLabel Main_Title_label = new JLabel("Donation centers");
		Main_Title_label.setForeground(new Color(220, 20, 60));
		Main_Title_label.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 37));
		Main_Title_label.setHorizontalAlignment(SwingConstants.CENTER);
		Main_Title_label.setBounds(295, 26, 563, 81);
		contentPane.add(Main_Title_label);
		
		JButton contactUs_btn_left = new JButton("Contact us!");
		contactUs_btn_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationCenterInfo myDonationCenterInfo = new DonationCenterInfo(nameLeftLabel.getText(), cityLeftLabel.getText(), phonenoLeftLabel.getText(), addressLeftLabel.getText(), user_id, status_id);
				myDonationCenterInfo.setVisible(true);
				dispose();
			}
		});
		contactUs_btn_left.setForeground(new Color(255, 250, 240));
		contactUs_btn_left.setBackground(new Color(220, 20, 60));
		contactUs_btn_left.setBounds(132, 648, 132, 36);
		contentPane.add(contactUs_btn_left);
		
		JButton contactUs_btn_mid = new JButton("Contact us!");
		contactUs_btn_mid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationCenterInfo myDonationCenterInfo = new DonationCenterInfo(nameMidLabel.getText(), cityMidLabel.getText(), phonenoMidLabel.getText(), addressMidLabel.getText(), user_id, status_id);
				myDonationCenterInfo.setVisible(true);
				dispose();
			}
		});
		contactUs_btn_mid.setForeground(new Color(255, 250, 240));
		contactUs_btn_mid.setBackground(new Color(220, 20, 60));
		contactUs_btn_mid.setBounds(515, 654, 132, 36);
		contentPane.add(contactUs_btn_mid);
		
		JButton contactUs_btn_right = new JButton("Contact us!");
		contactUs_btn_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonationCenterInfo myDonationCenterInfo = new DonationCenterInfo(nameRightLabel.getText(), cityRightLabel.getText(), phonenoRightLabel.getText(), addressRightLabel.getText(), user_id, status_id);
				myDonationCenterInfo.setVisible(true);
				dispose();
			}
		});
		contactUs_btn_right.setForeground(new Color(255, 250, 240));
		contactUs_btn_right.setBackground(new Color(220, 20, 60));
		contactUs_btn_right.setBounds(893, 660, 132, 36);
		contentPane.add(contactUs_btn_right);
		
		JButton donationCenterGroup_btn_1 = new JButton("Next");
		donationCenterGroup_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(number_of_updates_done == length_of_tuples) {
					JOptionPane myOption = new JOptionPane();
			    	myOption.showMessageDialog(null, "All available blood banks displayed");
				}else {
					if(update_index == 1) {
						nameLeftLabel.setText(bankName.get(number_of_updates_done));
						cityLeftLabel.setText(cityName.get(number_of_updates_done));
						phonenoLeftLabel.setText(phone_No.get(number_of_updates_done));
						addressLeftLabel.setText(addressDetails.get(number_of_updates_done));
						
						number_of_updates_done++;
						update_index++;
					}
					
					if(number_of_updates_done != length_of_tuples) {
						if(update_index == 2) {
							nameMidLabel.setText(bankName.get(number_of_updates_done));
							cityMidLabel.setText(cityName.get(number_of_updates_done));
							phonenoMidLabel.setText(phone_No.get(number_of_updates_done));
							addressMidLabel.setText(addressDetails.get(number_of_updates_done));
							
							number_of_updates_done++;
							update_index++;
						}
					}
					
					if(number_of_updates_done != length_of_tuples) {
						if(update_index == 3) {
							nameRightLabel.setText(bankName.get(number_of_updates_done));
							cityRightLabel.setText(cityName.get(number_of_updates_done));
							phonenoRightLabel.setText(phone_No.get(number_of_updates_done));
							addressRightLabel.setText(addressDetails.get(number_of_updates_done));
							
							number_of_updates_done++;
							update_index = 1;
						}
					}
					
					
				}
			}
		});
		
		donationCenterGroup_btn_1.setForeground(new Color(255, 255, 255));
		donationCenterGroup_btn_1.setBackground(new Color(220, 20, 60));
		donationCenterGroup_btn_1.setBounds(533, 125, 97, 25);
		contentPane.add(donationCenterGroup_btn_1);
		
		
		JLabel templateLabel = new JLabel("");
		templateLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/photos/Donation centers.png")));
		templateLabel.setBounds(0, 0, 1137, 724);
		contentPane.add(templateLabel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(573, 381, 46, 14);
		contentPane.add(lblNewLabel);
		
		Database_Connection = myDataBase.Connect_to_DataBase();
		myStatement = Database_Connection.createStatement();
		myResultset = myStatement.executeQuery("SELECT Name, City, District, Neighborhood, Phone_no from Blood_Bank, Address, User, Status where Blood_Bank.Bank_Id = User.User_Id and User.Status_Id = Status.Status_Id and User.Address_Id = Address.Address_Id");
		
		
		while(myResultset.next()) {
			bankName.add(myResultset.getString("Name"));
			cityName.add(myResultset.getString("City"));
			phone_No.add(myResultset.getString("Phone_no"));
			addressDetails.add(myResultset.getString("Neighborhood") + ", " + myResultset.getString("District"));
			length_of_tuples++;
		}
		
		if(number_of_updates_done != length_of_tuples) {
			if(update_index == 1) {
				nameLeftLabel.setText(bankName.get(number_of_updates_done));
				cityLeftLabel.setText(cityName.get(number_of_updates_done));
				phonenoLeftLabel.setText(phone_No.get(number_of_updates_done));
				addressLeftLabel.setText(addressDetails.get(number_of_updates_done));
				
				number_of_updates_done++;
				update_index++;
			}
		}
		
		if(number_of_updates_done != length_of_tuples) {
			if(update_index == 2) {
				nameMidLabel.setText(bankName.get(number_of_updates_done));
				cityMidLabel.setText(cityName.get(number_of_updates_done));
				phonenoMidLabel.setText(phone_No.get(number_of_updates_done));
				addressMidLabel.setText(addressDetails.get(number_of_updates_done));
				
				number_of_updates_done++;
				update_index++;
			}
		}
		
		if(number_of_updates_done != length_of_tuples) {
			if(update_index == 3) {
				nameRightLabel.setText(bankName.get(number_of_updates_done));
				cityRightLabel.setText(cityName.get(number_of_updates_done));
				phonenoRightLabel.setText(phone_No.get(number_of_updates_done));
				addressRightLabel.setText(addressDetails.get(number_of_updates_done));
				
				number_of_updates_done++;
				update_index = 1;
			}
		}
		
		
		
		
		
		
		
	}
}
