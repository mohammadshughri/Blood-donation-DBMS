import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DonationCenterInfo extends JFrame {

	private JPanel contentPane;
	private String bankName;
	private String cityName;
	private String phoneNo;
	private String address;
	private int user_id;
	private int status_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DonationCenterInfo frame = new DonationCenterInfo();
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
	public DonationCenterInfo() {
		Initialize();
	}
	
	public DonationCenterInfo(String bankName, String cityName, String phoneNo, String address, int user_id, int status_id) {
		this.bankName = bankName;
		this.cityName = cityName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.status_id = status_id;
		this.user_id = user_id;
		Initialize();
	}
	
	
	
	void Initialize() {
		setTitle("Center Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 907);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 547, 950);
		contentPane.add(contentPane_1);
		
		JLabel CityLabel = new JLabel(" Talas/Kayseri");
		CityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CityLabel.setForeground(new Color(220, 20, 60));
		CityLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		CityLabel.setBounds(39, 413, 469, 55);
		contentPane_1.add(CityLabel);
		
		JLabel addressLabel = new JLabel("Address: Harman, Yonca Sk. No:8, 38280");
		addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addressLabel.setForeground(new Color(220, 20, 60));
		addressLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		addressLabel.setBounds(66, 530, 454, 41);
		contentPane_1.add(addressLabel);
		
		JLabel phoneNumberLabel = new JLabel("Phone number: 202-555-0517");
		phoneNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneNumberLabel.setForeground(new Color(220, 20, 60));
		phoneNumberLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 23));
		phoneNumberLabel.setBounds(48, 300, 446, 41);
		contentPane_1.add(phoneNumberLabel);
		
		JLabel bankNameLabel = new JLabel("Talas center");
		bankNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bankNameLabel.setForeground(new Color(220, 20, 60));
		bankNameLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 25));
		bankNameLabel.setBounds(61, 201, 433, 48);
		contentPane_1.add(bankNameLabel);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBackground(new Color(255, 255, 255));
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard myDashboard;
				try {
					myDashboard = new Dashboard(user_id, status_id);
					myDashboard.setVisible(true);
					dispose();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnReturn.setBounds(10, 11, 89, 23);
		contentPane_1.add(btnReturn);
		
		bankNameLabel.setText(bankName);
		phoneNumberLabel.setText("Phone Number :" + phoneNo);
		addressLabel.setText("Address :" + address);
		CityLabel.setText(cityName);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(DonationCenterInfo.class.getResource("/photos/Catogorizes.png")));
		backgroundLabel.setBounds(0, -80, 547, 1030);
		contentPane_1.add(backgroundLabel);
		
	
		
		
		
	}
}
