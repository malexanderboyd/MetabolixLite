import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;


public class clientMain extends JFrame{
	private JTable clientSQL;
	public clientMain() {
		setMinimumSize(new Dimension(400, 400));
		setMaximumSize(new Dimension(400, 400));
		setResizable(false);
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JScrollPane clientTable = new JScrollPane();
		clientTable.setBounds(10, 44, 374, 254);
		getContentPane().add(clientTable);
		
		clientSQL = new JTable();
		clientTable.setViewportView(clientSQL);
		
		Label client = new Label("Your Clients");
		client.setAlignment(Label.CENTER);
		client.setBounds(165, 10, 82, 22);
		getContentPane().add(client);

		
		// not sure about trainer layout, needs to be adjusted just not sure how
		JLabel TrainerOption = new JLabel("Trainer Options"); 
		TrainerOption.setBounds(259, 68, 82, 22);
		getContentPane().add(TrainerOption);
		
		JButton changepass = new JButton("Change Password");
		changepass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("ChangePassword has been clicked");
				//display passRest.java view!!
				passRest ps = new passRest();
				ps.setBounds(400, 400, 400, 400);
				ps.setVisible(true);
			}
		});
		changepass.setBounds(241, 118, 119, 23);
		getContentPane().add(changepass);
		
		JButton form = new JButton("Send Forms");
		form.setBounds(241, 163, 119, 23);
		getContentPane().add(form);
		
		JTextPane txt = new JTextPane();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txt.setBackground(new Color(255, 235, 205));
		txt.setText("For conditioning programs and meal plans, please visit our website at metabolix.net.");
		txt.setBounds(10, 339, 384, 22);
		getContentPane().add(txt);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(clientMain.class.getResource("/images/small_logo.png")));
		lblNewLabel.setBounds(0, 0, 38, 33);
		getContentPane().add(lblNewLabel);
		
		JLabel trainerVar = new JLabel("");
		trainerVar.setBounds(338, 0, 46, 14);
		getContentPane().add(trainerVar);
		
		JButton btnNewButton = new JButton("Add New Client");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newClient nc = new newClient();
				nc.setBounds(400,0,450,600);
				nc.setVisible(true);
			}
		});
		btnNewButton.setBounds(150, 309, 105, 23);
		getContentPane().add(btnNewButton);
		setTitle("MetabolixLite: Trainer Panel");
	}
}
