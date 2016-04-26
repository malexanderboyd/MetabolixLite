import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import java.awt.Font;


public class clientMain extends JFrame{
	private JTable clientSQL;
	public clientMain() {
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JScrollPane clientTable = new JScrollPane();
		clientTable.setBounds(23, 44, 167, 254);
		getContentPane().add(clientTable);
		
		clientSQL = new JTable();
		clientTable.setViewportView(clientSQL);
		
		Label client = new Label("Your Clients");
		client.setAlignment(Label.CENTER);
		client.setBounds(63, 16, 82, 22);
		getContentPane().add(client);
		
		// not sure about trainer layout, needs to be adjusted just not sure how
		JLabel TrainerOption = new JLabel("Trainer Options"); 
		TrainerOption.setBounds(259, 68, 82, 22);
		getContentPane().add(TrainerOption);
		
		JButton changepass = new JButton("Change Password");
		changepass.setBounds(241, 118, 119, 23);
		getContentPane().add(changepass);
		
		JButton form = new JButton("Send Forms");
		form.setBounds(241, 163, 119, 23);
		getContentPane().add(form);
		
		JTextPane txt = new JTextPane();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txt.setBackground(new Color(255, 235, 205));
		txt.setText("For conditioning programs and meal plans, please visit our website at metabolix.net.");
		txt.setBounds(219, 214, 180, 63);
		getContentPane().add(txt);
		setTitle("MetabolixLite: Trainer Panel");
	}
}
