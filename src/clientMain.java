<<<<<<< HEAD
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
=======
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;


public class clientMain extends JFrame{
	private JTable clientSQL;
	private final String trainer;	
	public clientMain(String trainerUsername) {
		
		trainer = trainerUsername;
		clientIds = new ArrayList<Integer>();
		
		setupTable();
		getClients(trainer);
		setMinimumSize(new Dimension(400, 415));
		setMaximumSize(new Dimension(400, 415));
		setResizable(false);
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JScrollPane clientTable = new JScrollPane();
		clientTable.setBounds(10, 44, 374, 254);
		getContentPane().add(clientTable);
		
		clientSQL = new JTable();
		clientSQL.setModel(clientTableModel);
		clientSQL.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				int rowindex = clientSQL.getSelectedRow();
				Integer clientId = clientIds.get(rowindex);
				
				client c = new client(clientId);
				c.setVisible(true);
			}
			
			
			
		});
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
		
		JTextPane txt = new JTextPane();
		txt.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txt.setBackground(new Color(255, 235, 205));
		txt.setText("For conditioning programs and meal plans, please visit our website at metabolix.net.");
		txt.setBounds(10, 339, 384, 30);
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
		btnNewButton.setBounds(150, 309, 145, 24);
		getContentPane().add(btnNewButton);
		setTitle("MetabolixLite: Trainer Panel");
	}
	
	
	
	private void getClients(final String trainer) {
		
		try {
				sqlMethods sql = new sqlMethods();
				ResultSet res;
				
				res = sql.getTrainerClients(trainer);
				while(res.next())
				{
				
					clientIds.add(res.getInt(1));
					String name = res.getString(2);
					
					clientTableModel.addRow(new Object[] { name } );
				}
			} catch(SQLException e)
		{
				e.printStackTrace();
		}
	}



	private void setupTable()
	{
		//Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered, Height, Weight, Trainer_Uname)
		
		/*
		 * 
		 *  weekly data table
		 */
		clientTableModel = new DefaultTableModel() {
			Class[] columnTypes = new Class[] {
					Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};
		clientTableModel.setColumnCount(1);
		clientTableModel.setColumnIdentifiers(new String[] {
				"Name"
		});
		

	}
	
	
	
private DefaultTableModel clientTableModel;	
private ArrayList<Integer> clientIds;
}
>>>>>>> refs/remotes/origin/boyd
