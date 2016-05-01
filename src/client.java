import java.awt.Color;
import java.awt.Dimension;
import java.sql.Date;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JList;

public class client extends JFrame{
	private JTable girthTable;
	private JTable table_2;
	private JTable skinTable;
	private JTable weekTable;
	private int clientID;
	public client(int client) {
	
	clientID = client;
		setupTables();
	
	// might need a re-work to better lay it out 
	setTitle("MetabolixLite: Client Manager");
	getContentPane().setBackground(new Color(255, 235, 205));
	getContentPane().setLayout(null);
	
	JScrollPane mealPlan = new JScrollPane();
	mealPlan.setBounds(120, 377, 414, 71);
	getContentPane().add(mealPlan);
	
	table_2 = new JTable();
	mealPlan.setViewportView(table_2);
	
	JLabel weekDataLabel = new JLabel("Progress Data:");
	weekDataLabel.setBounds(12, 114, 116, 14);
	getContentPane().add(weekDataLabel);
	
	JLabel lblAssessmentTst = new JLabel("Assessment Tests:");
	lblAssessmentTst.setBounds(12, 223, 160, 14);
	getContentPane().add(lblAssessmentTst);
	
	JLabel lblMealPlan = new JLabel("Meal Plan:");
	lblMealPlan.setBounds(22, 351, 111, 14);
	getContentPane().add(lblMealPlan);
	
	JButton btnNewButton = new JButton("New Week");
	btnNewButton.setBounds(106, 11, 89, 23);
	getContentPane().add(btnNewButton);

	JTabbedPane assessmentTestTabPane = new JTabbedPane(JTabbedPane.TOP);
	assessmentTestTabPane.setBounds(22, 249, 419, 90);
	getContentPane().add(assessmentTestTabPane);
	
	JScrollPane fold = new JScrollPane();
	assessmentTestTabPane.addTab("Skin Fold", null, fold, null);
	
	skinTable = new JTable();
	skinTable.setModel(skinTableModel);
	fold.setViewportView(skinTable);
	
	JScrollPane girth = new JScrollPane();
	assessmentTestTabPane.addTab("Girth", null, girth, null);
	
	girthTable = new JTable();
	girthTable.setModel(girthTableModel);
	girth.setViewportView(girthTable);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(12, 140, 419, 71);
	getContentPane().add(scrollPane);
	
	weekTable = new JTable();
	weekTable.setModel(weekTableModel);
	scrollPane.setViewportView(weekTable);
	
	
	setPreferredSize(new Dimension(650,650));
	pack();
	updateTables();
	repaint();
	
	
	

	}
	private void updateTables()
	{
		weekTableModel.setRowCount(0);
		skinTableModel.setRowCount(0);
		girthTableModel.setRowCount(0);

		Thread runner = new Thread() 
		{
			public void run()
			{
				try {
					sqlMethods sql = new sqlMethods();
					ResultSet queryResult1;
					
					queryResult1 = sql.getClientWeekData(ClientID);
					
					while(queryResult1.next())
					{

							String name = queryResult1.getString(2) + queryResult1.getString(3);
							int age = queryResult1.getInt(4);
							Date date = queryResult1.getDate(5);		
							int ht = queryResult1.getInt(6);
							int wt = queryResult1.getInt(7);
							
							weekTableModel.addRow(new Object[] { date, name, age, ht, wt });
					}
					//Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered (date), Height (int), Weight(int), Trainer_Uname)

					queryResult1.close();
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}






		};

		
		Thread runner2 = new Thread() 
		{
			public void run()
			{
				try {
					sqlMethods sql = new sqlMethods();
					ResultSet queryResult2;
					
					queryResult2 = sql.getClientSkinData(ClientID);
					
					while(queryResult2.next())
					{
						//Skinfold(S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs)
							Date date = queryResult2.getDate(1);		
							float arm = queryResult2.getFloat(2);
							float waist = queryResult2.getFloat(3);
							float calf = queryResult2.getFloat(4);
							float hips = queryResult2.getFloat(5);
							float thigh = queryResult2.getFloat(6);
							float neck = queryResult2.getFloat(7);
							float chest = queryResult2.getFloat(8);
							float abdom = queryResult2.getFloat(9);
							skinTableModel.addRow(new Object[] { date, arm, waist, calf, hips, thigh, neck, chest, abdom });
					}
					
					queryResult2.close();
				//Skinfold(S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs)
				//"Date", "Arm", "Waist", "Calf", "Hips", "Thigh", "Neck", "Chest", "Abdom"
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}






		};
		
		
		Thread runner3 = new Thread() 
		{
			public void run()
			{
				try {
					sqlMethods sql = new sqlMethods();
					ResultSet queryResult3;
					
					queryResult3 = sql.getClientGirthData(ClientID);
					
					while(queryResult3.next())
					{

						Date date = queryResult3.getDate(1);		
						float midax = queryResult3.getFloat(2);
						float subscap = queryResult3.getFloat(3);
						float tricep = queryResult3.getFloat(4);
						float kidney = queryResult3.getFloat(5);
						float supra = queryResult3.getFloat(6);
						float chest = queryResult3.getFloat(7);
						float thigh = queryResult3.getFloat(8);
						float abdom = queryResult3.getFloat(9);
						girthTableModel.addRow(new Object[] { date, midax, subscap, tricep, kidney, supra, chest, thigh, abdom });
					}
					//Girth(G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg)
					//"Date", "Mid Ax", "Subscap", "Triceps", "Kidney", "Supra", "Chest", "Thigh", "Abdom"
					queryResult3.close();
				} catch(Exception e)
				{
					e.printStackTrace();
				}
			}






		};
		
		runner.run();
		runner2.run();
		runner3.run();
		





	}
	private void setupTables()
	{
		//Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered, Height, Weight, Trainer_Uname)
		
		/*
		 * 
		 *  weekly data table
		 */
		weekTableModel = new DefaultTableModel() {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		weekTableModel.setColumnCount(5);
		weekTableModel.setColumnIdentifiers(new String[] {
				"Date", "Name", "Age", "Height", "Weight"
		});
		
		/*
		 * 
		 *  girth assessment data table
		 *  Girth(G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg)
	 *	

		 */	
		
		girthTableModel = new DefaultTableModel() {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		girthTableModel.setColumnCount(9);
		girthTableModel.setColumnIdentifiers(new String[] {
				"Date", "Mid Ax", "Subscap", "Triceps", "Kidney", "Supra", "Chest", "Thigh", "Abdom"
		});
		
		/*
		 * 
		 *  skin fold assessment data table
		 *  
	 *	Skinfold(S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs)

		 */	
	
		skinTableModel = new DefaultTableModel() {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class,
					Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		skinTableModel.setColumnCount(5);
		skinTableModel.setColumnIdentifiers(new String[] {
				"Date", "Arm", "Waist", "Calf", "Hips", "Thigh", "Neck", "Chest", "Abdom"
		});
	
		
	}
	private DefaultTableModel weekTableModel;
	private DefaultTableModel skinTableModel;
	private DefaultTableModel girthTableModel;
	private int ClientID;
}

