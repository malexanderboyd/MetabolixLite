import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class lostPass extends JFrame {
	private JTextField emailField;
	public lostPass() {
	 	setTitle("MetabolixLite");

		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(177, 223, 157, 22);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		Button submit = new Button("Continue");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		submit.setBounds(201, 256, 84, 22);
		getContentPane().add(submit);
		
		Label email = new Label("Email:");
		email.setBounds(141, 223, 32, 22);
		getContentPane().add(email);
		
		Label message = new Label("Enter your email, so we can send you your password.");
		message.setFont(new Font("Dialog", Font.PLAIN, 15));
		message.setBounds(59, 188, 362, 22);
		getContentPane().add(message);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(lostPass.class.getResource("/images/logo.png")));
		label.setBounds(134, 10, 200, 174);
		getContentPane().add(label);
	}
}
