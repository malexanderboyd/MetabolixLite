import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class sendForm extends JFrame{
	private JTextField email;
	public sendForm() {
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JButton submit = new JButton("Submit");
		submit.setBounds(130, 280, 89, 23);
		getContentPane().add(submit);
		
		email = new JTextField();
		email.setBounds(120, 249, 120, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		JLabel label = new JLabel("Please select desired forms and enter email address of recipient.");
		label.setBounds(29, 168, 330, 20);
		getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setBounds(83, 252, 35, 14);
		getContentPane().add(lblNewLabel_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Health Questionnaire");
		chckbxNewCheckBox.setBackground(new Color(255, 235, 205));
		chckbxNewCheckBox.setBounds(29, 215, 156, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		JCheckBox chckbxEnvironmentalInventory = new JCheckBox("Environmental Inventory");
		chckbxEnvironmentalInventory.setBackground(new Color(255, 235, 205));
		chckbxEnvironmentalInventory.setBounds(187, 189, 156, 23);
		getContentPane().add(chckbxEnvironmentalInventory);
		
		JCheckBox checkBox_2 = new JCheckBox("Liability Waiver");
		checkBox_2.setBackground(new Color(255, 235, 205));
		checkBox_2.setBounds(29, 189, 156, 23);
		getContentPane().add(checkBox_2);
		
		JCheckBox chckbxClientReimbursement = new JCheckBox("Client Reimbursement");
		chckbxClientReimbursement.setBackground(new Color(255, 235, 205));
		chckbxClientReimbursement.setBounds(187, 215, 156, 23);
		getContentPane().add(chckbxClientReimbursement);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(sendForm.class.getResource("/images/logo.png")));
		icon.setBounds(73, 0, 198, 169);
		getContentPane().add(icon);
		setTitle("MetabolixLite: Form Sender");

	}

}
