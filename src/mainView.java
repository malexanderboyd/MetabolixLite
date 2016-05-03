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
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Dimension;


public class mainView extends JFrame {
	final static JFrame mainFrame = new JFrame();

	public mainView() {
	}


	private static JTextField trainerUser;
	private static JPasswordField trainerPass;
	private static JLabel errorText = new JLabel("");
	private static JLabel forgottenPW = new JLabel("");
	
	public static void main(String[] args) {
		
		initFrame();
	}

	private static void initFrame() {
			
		mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		mainFrame.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		mainFrame.getContentPane().setBackground(new Color(255, 235, 205));
		mainFrame.setTitle("MetabolixLite");
		mainFrame.setMinimumSize(new Dimension(400, 400));
		mainFrame.setMaximumSize(new Dimension(400, 400));
		mainFrame.setResizable(false);
		mainFrame.setFont(new Font("Corbel", Font.PLAIN, 14));
		mainFrame.getContentPane().setLayout(null);
		//x,y,w,h
		trainerUser = new JTextField();
		trainerUser.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		trainerUser.setBounds(150, 180, 100, 20);
		mainFrame.getContentPane().add(trainerUser);
		trainerUser.setColumns(10);
		
		trainerPass = new JPasswordField();
		trainerPass.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		trainerPass.setBounds(150, 220, 100, 20);
		mainFrame.getContentPane().add(trainerPass);
		
		JLabel trainerPassLabel = new JLabel("Password");
		trainerPassLabel.setLabelFor(trainerPass);
		trainerPassLabel.setBounds(150, 204, 75, 14);
		mainFrame.getContentPane().add(trainerPassLabel);
		
		JLabel trainerUserLabel = new JLabel("Username");
		trainerUserLabel.setLabelFor(trainerUser);
		trainerUserLabel.setBounds(150, 165, 75, 14);
		mainFrame.getContentPane().add(trainerUserLabel);
		
		JLabel loginButton = new JLabel("");
		loginButton.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e)
			{
				attemptLogin();
			}
		});
		loginButton.setIcon(new ImageIcon(mainView.class.getResource("/images/login.png")));
		loginButton.setBounds(218, 296, 48, 48);
		mainFrame.getContentPane().add(loginButton);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		lblLogin.setBounds(227, 346, 39, 15);
		mainFrame.getContentPane().add(lblLogin);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(mainView.class.getResource("/images/logo.png")));
		lblLogo.setBounds(100, 5, 200, 173);
		mainFrame.getContentPane().add(lblLogo);
		
		
		
		errorText.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		errorText.setBackground(new java.awt.Color(0, 0, 0));
		errorText.setForeground(new Color(255, 75, 0));
		

		mainFrame.getContentPane().add(errorText);
		
		
		JLabel signUpButton = new JLabel("");
		signUpButton.setIcon(new ImageIcon(mainView.class.getResource("/images/signup2.png")));
		signUpButton.setBounds(135, 296, 55, 48);
		signUpButton.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e)
			{
				acctRegister ar = new acctRegister();
		
			}
		});
		mainFrame.getContentPane().add(signUpButton);
		
		JLabel SignupButtonLabel = new JLabel("Signup");
		SignupButtonLabel.setBounds(131, 346, 70, 15);
		SignupButtonLabel.setFont(new Font("Cambria Math", Font.PLAIN, 12));
		mainFrame.getContentPane().add(SignupButtonLabel);
		
		forgottenPW.setFont(new Font("Cambria Math", Font.PLAIN, 13));
		forgottenPW.setBackground(new java.awt.Color(0, 0, 0));
		forgottenPW.setForeground(new Color(255, 75, 0));
		forgottenPW.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e)
			{
				lostPass lp = new lostPass();
				lp.setVisible(true);
			}
		});
		mainFrame.getContentPane().add(forgottenPW);
		

		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	};

	
	
	private static void attemptLogin(){ // text box must be centered - tzvi
		errorText.setVisible(false); // get rid of previous error message
		if(forgottenPW.isVisible())
		{
			forgottenPW.setVisible(false);
		}
		
		
		if(trainerUser.getText().length() <= 0)
		{
			errorText.setText("Please enter a username.");
			errorText.setBounds(150, 250, 200, 15);
			errorText.setVisible(true);
		}
		else if(trainerPass.getPassword().length <= 0)
		{
			errorText.setText("Please enter your password.");
			errorText.setBounds(150, 250, 200, 15);
			forgottenPW.setText("Forgotten password? Click here!");
			forgottenPW.setBounds(150, 265, 210, 15);
			errorText.setVisible(true);
			forgottenPW.setVisible(true);
		}
		else
		{
			//code to login
			// test sql method //
			sqlMethods sql = new sqlMethods();
			int clientID = sql.attemptLogin(trainerUser.getText(), new String(trainerPass.getPassword())); // user successfully logged in
			if(clientID != -1)
			{
				System.out.println("success");
				clientMain cm = new clientMain(clientID);
				cm.setVisible(true);
				mainFrame.dispose();
			}	
			else{
				errorText.setText("Invalid username or password.");
				errorText.setBounds(150, 250, 200, 15);
				errorText.setVisible(true);
			}
		}
	}
}
