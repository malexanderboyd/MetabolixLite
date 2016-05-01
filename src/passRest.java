import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;


//no longer used
public class passRest extends JFrame {
	private JTextField textField_1;
	private JTextField textField_2;
	public passRest() {
		
		setTitle("MetabolixLite: Password Rest");
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(passRest.class.getResource("/images/logo.png")));
		label.setBounds(71, 0, 185, 180);
		getContentPane().add(label);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewPassword.setBounds(62, 213, 92, 14);
		getContentPane().add(lblNewPassword);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 211, 109, 20);
		getContentPane().add(textField_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setForeground(Color.RED);
		label_3.setBounds(165, 270, 124, 14);
		getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(164, 180, 109, 20);
		getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		label_4.setBounds(108, 182, 46, 14);
		getContentPane().add(label_4);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(118, 244, 109, 23);
		getContentPane().add(btnChange);
	}
}
