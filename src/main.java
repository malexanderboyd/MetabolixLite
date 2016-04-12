import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Dimension;


public class main extends JFrame {
	private JTextField trainerUser;
	private JPasswordField trainerPass;
	 public main() {
	 	getContentPane().setFont(new Font("Cambria Math", Font.PLAIN, 13));
	 	getContentPane().setBackground(new Color(255, 235, 205));
	 	setTitle("MetabolixLite");
	 	setMinimumSize(new Dimension(350, 350));
	 	setMaximumSize(new Dimension(350, 350));
	 	setResizable(false);
	 	setFont(new Font("Corbel", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		//x,y,w,h
		trainerUser = new JTextField();
		trainerUser.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		trainerUser.setBounds(126, 180, 86, 20);
		getContentPane().add(trainerUser);
		trainerUser.setColumns(10);
		
		trainerPass = new JPasswordField();
		trainerPass.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		trainerPass.setBounds(126, 220, 86, 20);
		getContentPane().add(trainerPass);
		
		JLabel trainerPassLabel = new JLabel("Password");
		trainerPassLabel.setLabelFor(trainerPass);
		trainerPassLabel.setBounds(126, 204, 46, 14);
		getContentPane().add(trainerPassLabel);
		
		JLabel trainerUserLabel = new JLabel("Username");
		trainerUserLabel.setLabelFor(trainerUser);
		trainerUserLabel.setBounds(127, 165, 55, 14);
		getContentPane().add(trainerUserLabel);
		
		JLabel loginButton = new JLabel("");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		loginButton.setIcon(new ImageIcon(main.class.getResource("/images/login_ico.png")));
		loginButton.setBounds(149, 246, 48, 48);
		getContentPane().add(loginButton);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		lblLogin.setBounds(159, 291, 39, 20);
		getContentPane().add(lblLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(main.class.getResource("/images/logo.png")));
		lblLogo.setBounds(77, 0, 200, 173);
		getContentPane().add(lblLogo);
	}

	public static void main(String[] args) {
		
		
		
		

	}
}
