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

public class donation_centers_info3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donation_centers_info3 frame = new donation_centers_info3();
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
	public donation_centers_info3() {
		setTitle("M\u0130THATPA\u015EA center");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 717, 632);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("resources\\\\photos\\\\20337580_kan-basdsgis-salonu-giris.jpg"));
		lblNewLabel_1.setBounds(258, 118, 236, 161);
		contentPane_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("38050 Mithatpa\u015Fa/Kayseri");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(220, 20, 60));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(132, 508, 441, 34);
		contentPane_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Address: Mithatpa\u015Fa, Erkilet Blv., ");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_5_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_5_1.setBounds(132, 469, 454, 41);
		contentPane_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5 = new JLabel("Phone number: 202-555-0311");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(220, 20, 60));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(157, 412, 413, 41);
		contentPane_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4_1 = new JLabel("Our main branch is in Kocasinan.");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(253, 358, 241, 41);
		contentPane_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4 = new JLabel("We help deliver blood to people in need.");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(222, 322, 289, 48);
		contentPane_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("M\u0130THATPA\u015EA center");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(222, 274, 282, 48);
		contentPane_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("resources\\\\photos\\\\test.png"));
		lblNewLabel.setBounds(0, 0, 717, 632);
		contentPane_1.add(lblNewLabel);
	}

}
