import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class donations_centers_info extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donations_centers_info frame = new donations_centers_info();
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
	public donations_centers_info() {
		setTitle("Kocasinan center");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 679);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel BankName_label = new JLabel("");
		BankName_label.setHorizontalAlignment(SwingConstants.CENTER);
		BankName_label.setForeground(new Color(220, 20, 60));
		BankName_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		BankName_label.setBounds(296, 160, 297, 48);
		contentPane.add(BankName_label);
		
		JLabel Capacity_label = new JLabel("");
		Capacity_label.setHorizontalAlignment(SwingConstants.CENTER);
		Capacity_label.setForeground(new Color(220, 20, 60));
		Capacity_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Capacity_label.setBounds(313, 259, 280, 48);
		contentPane.add(Capacity_label);
		
		JLabel bloodBankFixed = new JLabel("Blood bank:");
		bloodBankFixed.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		bloodBankFixed.setHorizontalAlignment(SwingConstants.CENTER);
		bloodBankFixed.setForeground(new Color(220, 20, 60));
		bloodBankFixed.setBounds(194, 167, 90, 41);
		contentPane.add(bloodBankFixed);
		
		JLabel CapacityFixed = new JLabel("Blood capacity:");
		CapacityFixed.setHorizontalAlignment(SwingConstants.CENTER);
		CapacityFixed.setForeground(new Color(220, 20, 60));
		CapacityFixed.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		CapacityFixed.setBounds(194, 266, 111, 41);
		contentPane.add(CapacityFixed);
		
		JLabel AmountFixed = new JLabel("To be determined");
		AmountFixed.setHorizontalAlignment(SwingConstants.CENTER);
		AmountFixed.setForeground(new Color(220, 20, 60));
		AmountFixed.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		AmountFixed.setBounds(172, 357, 185, 41);
		contentPane.add(AmountFixed);
		
		JLabel A_type_label = new JLabel("");
		A_type_label.setHorizontalAlignment(SwingConstants.CENTER);
		A_type_label.setForeground(new Color(220, 20, 60));
		A_type_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		A_type_label.setBounds(232, 454, 50, 48);
		contentPane.add(A_type_label);
		
		JLabel B_type_label = new JLabel("");
		B_type_label.setHorizontalAlignment(SwingConstants.CENTER);
		B_type_label.setForeground(new Color(220, 20, 60));
		B_type_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		B_type_label.setBounds(329, 454, 50, 48);
		contentPane.add(B_type_label);
		
		JLabel AB_type_label = new JLabel("");
		AB_type_label.setHorizontalAlignment(SwingConstants.CENTER);
		AB_type_label.setForeground(new Color(220, 20, 60));
		AB_type_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		AB_type_label.setBounds(443, 454, 50, 48);
		contentPane.add(AB_type_label);
		
		JLabel O_type_label = new JLabel("");
		O_type_label.setHorizontalAlignment(SwingConstants.CENTER);
		O_type_label.setForeground(new Color(220, 20, 60));
		O_type_label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		O_type_label.setBounds(530, 454, 50, 48);
		contentPane.add(O_type_label);
		
		JLabel Date_label_1_1 = new JLabel("A:");
		Date_label_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		Date_label_1_1.setForeground(new Color(220, 20, 60));
		Date_label_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		Date_label_1_1.setBounds(194, 454, 40, 48);
		contentPane.add(Date_label_1_1);
		
		JLabel Date_label_1_2 = new JLabel("B:");
		Date_label_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		Date_label_1_2.setForeground(new Color(220, 20, 60));
		Date_label_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		Date_label_1_2.setBounds(290, 454, 40, 48);
		contentPane.add(Date_label_1_2);
		
		JLabel Date_label_1_3 = new JLabel("AB:");
		Date_label_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		Date_label_1_3.setForeground(new Color(220, 20, 60));
		Date_label_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		Date_label_1_3.setBounds(391, 454, 40, 48);
		contentPane.add(Date_label_1_3);
		
		JLabel Date_label_1 = new JLabel("O:");
		Date_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		Date_label_1.setForeground(new Color(220, 20, 60));
		Date_label_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		Date_label_1.setBounds(491, 454, 40, 48);
		contentPane.add(Date_label_1);
		
		JLabel template_background2 = new JLabel("");
		template_background2.setIcon(new ImageIcon(donations_centers_info.class.getResource("/photos/Categories1.png")));
		template_background2.setBounds(81, 111, 512, 457);
		contentPane.add(template_background2);
		
		JLabel template_background = new JLabel("");
		template_background.setIcon(new ImageIcon(donations_centers_info.class.getResource("/photos/BloodDonationCentersInfo_template.png")));
		template_background.setBounds(0, 0, 717, 632);
		contentPane.add(template_background);
	}
}
