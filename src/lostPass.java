import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class lostPass extends JFrame {
	private JTextField emailField;
	public lostPass() {
	 	setTitle("MetabolixLite: Lost Password");

		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(lostPass.class.getResource("/images/logo.png")));
		icon.setBounds(128, 9, 200, 173);
		getContentPane().add(icon);
		
		emailField = new JTextField();
		emailField.setBounds(164, 216, 157, 22);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		
		Button submit = new Button("Continue");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = emailField.getText();
				sqlMethods sql = new sqlMethods();

				if (sendEmail(s)) {
					sql.resetPass(s, "Apple123!");
					JOptionPane.showMessageDialog(null, "Email successfully sent.");
					setVisible(false);
				} else
					JOptionPane.showMessageDialog(null, "Email unsuccessfully sent.");
					setVisible(false);
			}
		});
		submit.setBounds(185, 261, 92, 22);
		getContentPane().add(submit);
		
		Label email = new Label("Email:");
		email.setBounds(128, 216, 32, 22);
		getContentPane().add(email);
		
		Label message = new Label("Enter your email, so we can send you your password.");
		message.setFont(new Font("Dialog", Font.PLAIN, 15));
		message.setBounds(47, 188, 362, 20);
		getContentPane().add(message);
		setPreferredSize(new Dimension(450,350));
		pack();
		setLocationRelativeTo(null);
	}
	public Boolean sendEmail(String s) {
		String[] to = new String[] {s};
		return EmailSender.sendMail("metabolixlite@gmail.com", "password6969", "Your new password", "Your new password is 'Apple123!'", to);
	}
}
