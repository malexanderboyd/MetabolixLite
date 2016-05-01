import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class account extends JFrame {
	private JTextField textField;
	public account() {
		setTitle("MetabolixLite: Account Settings");
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(account.class.getResource("/images/logo.png")));
		label.setBounds(97, 0, 185, 180);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("New Password:");
		label_1.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		label_1.setBounds(67, 295, 92, 14);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(169, 293, 109, 20);
		getContentPane().add(textField);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(Color.RED);
		label_2.setBounds(172, 350, 124, 14);
		getContentPane().add(label_2);
		
		JButton button = new JButton("Change");
		button.setBounds(145, 323, 109, 23);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Change Password:");
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 262, 126, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTrainerInformation = new JLabel("Trainer Information:");
		lblTrainerInformation.setFont(new Font("Cambria Math", Font.PLAIN, 15));
		lblTrainerInformation.setBounds(10, 174, 138, 20);
		getContentPane().add(lblTrainerInformation);
		
		JLabel label_4 = new JLabel("Email:");
		label_4.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		label_4.setBounds(117, 202, 46, 14);
		getContentPane().add(label_4);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblUsername.setBounds(97, 233, 65, 14);
		getContentPane().add(lblUsername);
		
		JLabel emailVar = new JLabel("");
		emailVar.setBounds(172, 203, 82, 14);
		getContentPane().add(emailVar);
		
		JLabel usernameVar = new JLabel("");
		usernameVar.setBounds(172, 234, 82, 14);
		getContentPane().add(usernameVar);
	}
}
