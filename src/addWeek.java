
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class addWeek extends JFrame{
	private static JTextField date;
	private static JTextField textField_5;
	private static JTextField subscap;
	private static JTextField tricepts;
	private static JTextField midAx;
	private static JTextField kidney;
	private static JTextField Abdom_f;
	private static JTextField supra;
	private static JTextField chest_f;
	private static JTextField thights_f;
	private static JTextField neck;
	private static JTextField chest_g;
	private static JTextField arms;
	private static JTextField waist;
	private static JTextField abdom_g;
	private static JTextField hips;
	private static JTextField thighs_g;
	private static JTextField calfs;
	public addWeek(final int client) {
		
		setTitle("MetabolixLite: New Week");
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Client's New Week");
		title.setFont(new Font("Tahoma", Font.BOLD, 11));
		title.setBounds(163, 11, 111, 25);
		getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(44, 60, 46, 14);
		getContentPane().add(lblNewLabel);
		
		date = new JTextField();
		date.setBounds(100, 57, 86, 20);
		getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblWeightlbs = new JLabel("Weight (lbs):");
		lblWeightlbs.setBounds(215, 60, 79, 14);
		getContentPane().add(lblWeightlbs);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 57, 76, 20);
		getContentPane().add(textField_5);
		
		Label lowerTitle = new Label("New Week's Measurement");
		lowerTitle.setFont(new Font("Dialog", Font.BOLD, 12));
		lowerTitle.setBounds(147, 93, 167, 22);
		getContentPane().add(lowerTitle);
		
		Label foldHead = new Label("Girth");
		foldHead.setAlignment(Label.CENTER);
		foldHead.setBounds(98, 121, 62, 22);
		getContentPane().add(foldHead);
		
		Label label_6 = new Label("Skinfolds");
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(294, 121, 62, 22);
		getContentPane().add(label_6);
		
		JLabel lblTricepts = new JLabel("Tricep:");
		lblTricepts.setBounds(44, 152, 66, 14);
		getContentPane().add(lblTricepts);
		
		tricepts = new JTextField();
		tricepts.setColumns(10);
		tricepts.setBounds(100, 149, 76, 20);
		getContentPane().add(tricepts);
		
		JLabel lblSubscap = new JLabel("Subscap:");
		lblSubscap.setBounds(44, 183, 66, 14);
		getContentPane().add(lblSubscap);
		
		subscap = new JTextField();
		subscap.setColumns(10);
		subscap.setBounds(100, 180, 76, 20);
		getContentPane().add(subscap);
		
		JLabel lblKidney_1 = new JLabel("Kidney:");
		lblKidney_1.setBounds(44, 214, 66, 14);
		getContentPane().add(lblKidney_1);
		
		kidney = new JTextField();
		kidney.setColumns(10);
		kidney.setBounds(100, 211, 76, 20);
		getContentPane().add(kidney);
		
		JLabel lblKidney = new JLabel("Mid Ax:");
		lblKidney.setBounds(44, 245, 66, 14);
		getContentPane().add(lblKidney);
		
		midAx = new JTextField();
		midAx.setColumns(10);
		midAx.setBounds(100, 242, 76, 20);
		getContentPane().add(midAx);
		
		JLabel lblSupra = new JLabel("Supra:");
		lblSupra.setBounds(44, 277, 66, 14);
		getContentPane().add(lblSupra);
		
		supra = new JTextField();
		supra.setColumns(10);
		supra.setBounds(100, 274, 76, 20);
		getContentPane().add(supra);
		
		JLabel lblAbdom = new JLabel("Abdom:");
		lblAbdom.setBounds(44, 308, 66, 14);
		getContentPane().add(lblAbdom);
		
		Abdom_f = new JTextField();
		Abdom_f.setColumns(10);
		Abdom_f.setBounds(100, 305, 76, 20);
		getContentPane().add(Abdom_f);
		
		JLabel lblThight = new JLabel("Thigh:");
		lblThight.setBounds(44, 339, 66, 14);
		getContentPane().add(lblThight);
		
		thights_f = new JTextField();
		thights_f.setColumns(10);
		thights_f.setBounds(100, 336, 76, 20);
		getContentPane().add(thights_f);
		
		JLabel lblChest = new JLabel("Chest:");
		lblChest.setBounds(44, 370, 66, 14);
		getContentPane().add(lblChest);
		
		chest_f = new JTextField();
		chest_f.setColumns(10);
		chest_f.setBounds(100, 367, 76, 20);
		getContentPane().add(chest_f);
		
		JLabel lblNeck = new JLabel("Neck:");
		lblNeck.setBounds(246, 152, 48, 14);
		getContentPane().add(lblNeck);
		
		neck = new JTextField();
		neck.setColumns(10);
		neck.setBounds(294, 149, 76, 20);
		getContentPane().add(neck);
		
		JLabel lblChest_1 = new JLabel("Chest:");
		lblChest_1.setBounds(246, 183, 48, 14);
		getContentPane().add(lblChest_1);
		
		chest_g = new JTextField();
		chest_g.setColumns(10);
		chest_g.setBounds(294, 180, 76, 20);
		getContentPane().add(chest_g);
		
		JLabel lblArm = new JLabel("Arm:");
		lblArm.setBounds(246, 214, 48, 14);
		getContentPane().add(lblArm);
		
		arms = new JTextField();
		arms.setColumns(10);
		arms.setBounds(294, 211, 76, 20);
		getContentPane().add(arms);
		
		JLabel lblWaist = new JLabel("Waist:");
		lblWaist.setBounds(246, 245, 48, 14);
		getContentPane().add(lblWaist);
		
		waist = new JTextField();
		waist.setColumns(10);
		waist.setBounds(294, 242, 76, 20);
		getContentPane().add(waist);
		
		JLabel lblAbdom_1 = new JLabel("Abdom:");
		lblAbdom_1.setBounds(246, 277, 48, 14);
		getContentPane().add(lblAbdom_1);
		
		abdom_g = new JTextField();
		abdom_g.setColumns(10);
		abdom_g.setBounds(294, 274, 76, 20);
		getContentPane().add(abdom_g);
		
		JLabel lblHips = new JLabel("Hip:");
		lblHips.setBounds(246, 308, 48, 14);
		getContentPane().add(lblHips);
		
		hips = new JTextField();
		hips.setColumns(10);
		hips.setBounds(294, 305, 76, 20);
		getContentPane().add(hips);
		
		JLabel lblThights = new JLabel("Thigh:");
		lblThights.setBounds(246, 339, 48, 14);
		getContentPane().add(lblThights);
		
		thighs_g = new JTextField();
		thighs_g.setColumns(10);
		thighs_g.setBounds(294, 336, 76, 20);
		getContentPane().add(thighs_g);
		
		JLabel lblCalfs = new JLabel("Calf:");
		lblCalfs.setBounds(246, 370, 48, 14);
		getContentPane().add(lblCalfs);
		
		calfs = new JTextField();
		calfs.setColumns(10);
		calfs.setBounds(294, 367, 76, 20);
		getContentPane().add(calfs);
		
		Button submit = new Button("Submit");
		submit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (date.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Date");
				}
				else if (textField_5.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Weight");
				}
				else if (subscap.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Subscap Measurement");
				}
				else if (tricepts.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Tricep Measurement");
				}
				else if (midAx.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a MidAx Measurement");
				}
				else if (kidney.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Kidney Measurement");
				}
				else if (Abdom_f.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter an Abdomen Girth Measurement");
				}
				else if (supra.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Supra Measurement");
				}
				else if (chest_f.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Chest Girth Measurement");
				}
				else if (thights_f.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Thigh Girth Measurement");
				}
				else if (neck.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Neck Measurement");
				}
				else if (chest_g.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Chest Skin Fold Measurement");
				}
				else if (arms.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter an Arm Measurement");
				}
				else if (waist.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Waist Measurement");
				}
				else if (abdom_g.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter an Abdomen Skin Fold Measurement");
				}
				else if (hips.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Hip Measurement");
				}
				else if (thighs_g.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Thigh Skin Fold Measurement");
				}			
				else if (calfs.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Calf Measurement");
				}
				else {
				
				attemptAddWeek(client);
				setVisible(false);
				
				}
			}
		});
		submit.setBounds(177, 407, 84, 27);
		getContentPane().add(submit);
		
		JLabel lblFds = new JLabel("Year-Day-Month");
		lblFds.setBounds(100, 77, 106, 14);
		getContentPane().add(lblFds);

	} // Ends add week
	
	//Method to validate input and send to DB
	private static void attemptAddWeek(int client) {
		
		
		//need to add methods to force insert into all fields....will add this last 
	
		//code to send to DB
		sqlMethods sql = new sqlMethods();
		if(sql.attemptAddWeek(client, new String(date.getText()), new Integer(textField_5.getText()), new Float(midAx.getText()), new Float(subscap.getText()), new Float(tricepts.getText()), new Float(kidney.getText()), new Float(supra.getText()), new Float(chest_f.getText()), new Float(thights_f.getText()), new Float(Abdom_f.getText()), new Float(arms.getText()), new Float(waist.getText()), new Float(calfs.getText()), new Float(hips.getText()), new Float(thighs_g.getText()), new Float(neck.getText()), new Float(chest_g.getText()), new Float(abdom_g.getText())))                                                                 
		{
			System.out.println("success - entered new client");
			JOptionPane.showMessageDialog(null, "New week successfully added.");
			//clientMain cm = new clientMain();
			//cm.setVisible(true);
	
		}
	
	} // Ends attemptNewClient
}
