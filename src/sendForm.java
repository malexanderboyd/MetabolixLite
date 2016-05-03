import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sendForm extends JFrame{
	
	private int clientID;
		
	public sendForm(int client) {
		clientID = client;
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		setMinimumSize(new Dimension(365, 315));
		setMaximumSize(new Dimension(365, 315));
		
		JButton submit = new JButton("Send");
		
		submit.setBounds(123, 249, 89, 23);
		getContentPane().add(submit);
		
		JLabel lblPleaseSelectDesired = new JLabel("Please select desired forms to send:");
		lblPleaseSelectDesired.setBounds(9, 176, 330, 20);
		getContentPane().add(lblPleaseSelectDesired);
		
		final JCheckBox checkBox_health = new JCheckBox("Health Questionnaire");
		checkBox_health.setBackground(new Color(255, 235, 205));
		checkBox_health.setBounds(19, 219, 156, 23);
		getContentPane().add(checkBox_health);
		
		final JCheckBox checkBox_envi = new JCheckBox("Environmental Inventory");
		checkBox_envi.setBackground(new Color(255, 235, 205));
		checkBox_envi.setBounds(177, 193, 156, 23);
		getContentPane().add(checkBox_envi);
		
		final JCheckBox checkBox_Lia = new JCheckBox("Liability Waiver");
		checkBox_Lia.setBackground(new Color(255, 235, 205));
		checkBox_Lia.setBounds(19, 193, 156, 23);
		getContentPane().add(checkBox_Lia);
		
		final JCheckBox checkbox_Reimbursement = new JCheckBox("Client Reimbursement");
		checkbox_Reimbursement.setBackground(new Color(255, 235, 205));
		checkbox_Reimbursement.setBounds(177, 219, 156, 23);
		getContentPane().add(checkbox_Reimbursement);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon(sendForm.class.getResource("/images/logo.png")));
		icon.setBounds(73, 0, 198, 169);
		getContentPane().add(icon);
		setTitle("MetabolixLite: Form Sender");
		
		//send button and actions
		submit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				attemptFormSend(clientID,checkBox_health.isSelected(),checkBox_envi.isSelected(),checkBox_Lia.isSelected(), checkbox_Reimbursement.isSelected());
				setVisible(false);
			}
		});
		setLocationRelativeTo(null);
		pack();//pack for size 
		
	}//ends send form
		
	//Method to validate input and send to DB
	private static void attemptFormSend(int client, boolean health, boolean envi, boolean lia, boolean reimbursement) {
		String clientEmail = null;
		try {
			
		//code to send to DB
		sqlMethods sql = new sqlMethods();
		sqlMethods sql1 = new sqlMethods();
		ResultSet email;
		email = sql.getClientEmail(client);
		
		while(email.next()){
			clientEmail=email.getString(1);
			}
		
		//call email function here
		sendEmail(clientEmail,clientEmail, health, envi, lia, reimbursement);
		
		//set sql client form vars
		sql.formSet(client, health, envi, lia);		
		
		} catch(Exception e){
			e.printStackTrace();
		}
	
	} // Ends attemptFormSend
	
	public static Boolean sendEmail(String s,String email,boolean health, boolean envi, boolean lia, boolean reimbursement) {
		String[] to = new String[] {s};
		
		return EmailSender.sendAttach("metabolixlite@gmail.com", "password6969", "Trainer Forms Request","Attached are forms that your trainer has requested you fill out.'",to,
				email,health, envi, lia, reimbursement);
	}// end email

}//end
