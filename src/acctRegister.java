import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class acctRegister extends JFrame {
	private JTextField userNameInput;
	private JTextField passwordInput;
	private JTextField emailInput;
	public acctRegister() {
		initFrame();
	}
	private void initFrame() {
		final JFrame mainFrame = new JFrame();
		mainFrame.setTitle("MetabolixLite: Account Creation");
		mainFrame.getContentPane().setBackground(new Color(255, 235, 205));
		mainFrame.getContentPane().setLayout(null);
		mainFrame.setPreferredSize(new Dimension(350, 370));
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(acctRegister.class.getResource("/images/logo.png")));
		logoLabel.setBounds(76, 0, 185, 180);
		mainFrame.getContentPane().add(logoLabel);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblUsername.setBounds(86, 172, 66, 21);
		mainFrame.getContentPane().add(lblUsername);
		
		userNameInput = new JTextField();
		lblUsername.setLabelFor(userNameInput);
		userNameInput.setBounds(152, 173, 109, 20);
		mainFrame.getContentPane().add(userNameInput);
		userNameInput.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setLabelFor(lblPassword);
		lblPassword.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblPassword.setBounds(86, 210, 66, 14);
		mainFrame.getContentPane().add(lblPassword);
		
		passwordInput = new JTextField();
		passwordInput.setBounds(152, 204, 109, 20);
		mainFrame.getContentPane().add(passwordInput);
		passwordInput.setColumns(10);
		
		final JLabel errorText = new JLabel("");
		errorText.setForeground(new Color(255, 0, 0));
		errorText.setBounds(122, 270, 124, 14);
		mainFrame.getContentPane().add(errorText);
		
		
		emailInput = new JTextField();
		emailInput.setBounds(152, 239, 109, 20);
		mainFrame.getContentPane().add(emailInput);
		emailInput.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		lblNewLabel.setBounds(96, 241, 46, 14);
		mainFrame.getContentPane().add(lblNewLabel);
		
		JButton signUpButton = new JButton("Signup");
		signUpButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				if(userNameInput.getText().length() <= 0)
				{
					errorText.setText("Enter a username.");
				}
				else if(passwordInput.getText().length() <= 0)
				{
					errorText.setText("Enter a password.");
				}
				else if(emailInput.getText().length() <= 0)
				{
					errorText.setText("Enter an email.");
				}
				else
				{

				sqlMethods sql = new sqlMethods();
				if(sql.attemptSignUp(userNameInput.getText(), passwordInput.getText(), emailInput.getText()))
				{
					JOptionPane.showMessageDialog(getContentPane(),
						    "Account Created Successfully!");
					mainFrame.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(),
						    "Account Already Exists!");
				}
				}
			}
		});
		signUpButton.setBounds(122, 298, 109, 23);
		mainFrame.getContentPane().add(signUpButton);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}
}
