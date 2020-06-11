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

public class Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1251, 771);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameAndSurname_label = new JLabel("Name and Surname here");
		NameAndSurname_label.setHorizontalAlignment(SwingConstants.CENTER);
		NameAndSurname_label.setForeground(new Color(220, 20, 60));
		NameAndSurname_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
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
		PhoneNum_label.setBounds(736, 324, 369, 68);
		contentPane.add(PhoneNum_label);
		
		JLabel MedReport_label = new JLabel("Medical report here");
		MedReport_label.setHorizontalAlignment(SwingConstants.CENTER);
		MedReport_label.setForeground(new Color(220, 20, 60));
		MedReport_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		MedReport_label.setBounds(728, 421, 459, 68);
		contentPane.add(MedReport_label);
		
		JLabel Location_label = new JLabel("Location here");
		Location_label.setHorizontalAlignment(SwingConstants.CENTER);
		Location_label.setForeground(new Color(220, 20, 60));
		Location_label.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		Location_label.setBounds(728, 521, 369, 68);
		contentPane.add(Location_label);
		
		JLabel NameAndSurname_fixed = new JLabel("Name & Surname:");
		NameAndSurname_fixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		NameAndSurname_fixed.setForeground(new Color(255, 255, 255));
		NameAndSurname_fixed.setHorizontalAlignment(SwingConstants.CENTER);
		NameAndSurname_fixed.setBounds(146, 151, 369, 68);
		contentPane.add(NameAndSurname_fixed);
		
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
		
		JLabel MedReportFixed = new JLabel("Medical report:");
		MedReportFixed.setHorizontalAlignment(SwingConstants.CENTER);
		MedReportFixed.setForeground(Color.WHITE);
		MedReportFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		MedReportFixed.setBounds(138, 433, 369, 68);
		contentPane.add(MedReportFixed);
		
		JLabel LocationFixed = new JLabel("Location:");
		LocationFixed.setHorizontalAlignment(SwingConstants.CENTER);
		LocationFixed.setForeground(Color.WHITE);
		LocationFixed.setFont(new Font("Comic Sans MS", Font.PLAIN, 34));
		LocationFixed.setBounds(138, 533, 369, 68);
		contentPane.add(LocationFixed);
		
		JLabel lblNewLabel_1_4 = new JLabel("Profile");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_1_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel_1_4.setBounds(752, 58, 369, 68);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel template_lebal = new JLabel("");
		template_lebal.setIcon(new ImageIcon(Profile.class.getResource("/photos/Profile template.png")));
		template_lebal.setBounds(0, 0, 1233, 724);
		contentPane.add(template_lebal);
	}
}
