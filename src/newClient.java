import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JRadioButton;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Label;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.Font;

public class newClient extends JFrame{
	private static JTextField date;
	private static JTextField name;
	private static JTextField age;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField subscap;
	private static JTextField tricepts;
	private static JTextField midAx;
	private static JTextField kidney;
	private static JTextField Abdom_f;
	private static JTextField supra;
	private static JTextField chest_f;
	private static JTextField thighs_f;
	private static JTextField neck;
	private static JTextField chest_g;
	private static JTextField arms;
	private static JTextField waist;
	private static JTextField abdom_g;
	private static JTextField hips;
	private static JTextField thighs_g;
	private static JTextField calfs;
	private static JTextField email;
	public newClient(final int trainerId) {
		setTitle("MetabolixLite: Client Register");
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("New Client Information");
		title.setFont(new Font("Tahoma", Font.BOLD, 11));
		title.setBounds(155, 24, 162, 22);
		getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(44, 60, 46, 14);
		getContentPane().add(lblNewLabel);
		
		date = new JTextField();
		date.setBounds(100, 57, 86, 20);
		getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblName = new JLabel("Name\r\n:");
		lblName.setBounds(44, 91, 46, 14);
		getContentPane().add(lblName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(100, 88, 86, 20);
		getContentPane().add(name);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setBounds(44, 122, 46, 14);
		getContentPane().add(lblSex);
		
		JRadioButton male = new JRadioButton("Male\r\n");
		male.setBackground(new Color(255, 235, 205));
		male.setBounds(85, 118, 52, 23);
		getContentPane().add(male);
		
		JRadioButton female = new JRadioButton("Female\r\n");
		female.setBackground(new Color(255, 235, 205));
		female.setBounds(139, 118, 66, 23);
		getContentPane().add(female);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(210, 60, 46, 14);
		getContentPane().add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(294, 57, 86, 20);
		getContentPane().add(age);
		
		JLabel lblHeight = new JLabel("Height (in):");
		lblHeight.setBounds(210, 88, 66, 14);
		getContentPane().add(lblHeight);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(294, 88, 86, 20);
		getContentPane().add(textField_4);
		
		JLabel lblWeightlbs = new JLabel("Weight (lbs):");
		lblWeightlbs.setBounds(211, 118, 73, 14);
		getContentPane().add(lblWeightlbs);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 116, 86, 20);
		getContentPane().add(textField_5);
		
		Label lowerTitle = new Label("New Clients Measurements");
		lowerTitle.setFont(new Font("Dialog", Font.BOLD, 12));
		lowerTitle.setBounds(147, 169, 170, 20);
		getContentPane().add(lowerTitle);
		
		Label foldHead = new Label("Girth");
		foldHead.setAlignment(Label.CENTER);
		foldHead.setBounds(100, 185, 62, 22);
		getContentPane().add(foldHead);
		
		Label label_6 = new Label("Skin Folds");
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(308, 185, 62, 22);
		getContentPane().add(label_6);
		
		JLabel lblTricepts = new JLabel("Tricep:");
		lblTricepts.setBounds(44, 216, 66, 14);
		getContentPane().add(lblTricepts);
		
		tricepts = new JTextField();
		tricepts.setColumns(10);
		tricepts.setBounds(100, 213, 76, 20);
		getContentPane().add(tricepts);
		
		JLabel lblSubscap = new JLabel("Subscap:");
		lblSubscap.setBounds(44, 247, 66, 14);
		getContentPane().add(lblSubscap);
		
		subscap = new JTextField();
		subscap.setColumns(10);
		subscap.setBounds(100, 244, 76, 20);
		getContentPane().add(subscap);
		
		JLabel lblKidney_1 = new JLabel("Kidney:");
		lblKidney_1.setBounds(44, 278, 66, 14);
		getContentPane().add(lblKidney_1);
		
		kidney = new JTextField();
		kidney.setColumns(10);
		kidney.setBounds(100, 275, 76, 20);
		getContentPane().add(kidney);
		
		JLabel lblKidney = new JLabel("Mid Ax:");
		lblKidney.setBounds(44, 309, 66, 14);
		getContentPane().add(lblKidney);
		
		midAx = new JTextField();
		midAx.setColumns(10);
		midAx.setBounds(100, 306, 76, 20);
		getContentPane().add(midAx);
		
		JLabel lblSupra = new JLabel("Supra:");
		lblSupra.setBounds(44, 341, 66, 14);
		getContentPane().add(lblSupra);
		
		supra = new JTextField();
		supra.setColumns(10);
		supra.setBounds(100, 338, 76, 20);
		getContentPane().add(supra);
		
		JLabel lblAbdom = new JLabel("Abdom:");
		lblAbdom.setBounds(44, 372, 66, 14);
		getContentPane().add(lblAbdom);
		
		Abdom_f = new JTextField();
		Abdom_f.setColumns(10);
		Abdom_f.setBounds(100, 369, 76, 20);
		getContentPane().add(Abdom_f);
		
		JLabel lblThight = new JLabel("Thigh:\r\n");
		lblThight.setBounds(44, 403, 66, 14);
		getContentPane().add(lblThight);
		
		thighs_f = new JTextField();
		thighs_f.setColumns(10);
		thighs_f.setBounds(100, 400, 76, 20);
		getContentPane().add(thighs_f);
		
		JLabel lblChest = new JLabel("Chest:");
		lblChest.setBounds(44, 434, 66, 14);
		getContentPane().add(lblChest);
		
		chest_f = new JTextField();
		chest_f.setColumns(10);
		chest_f.setBounds(100, 431, 76, 20);
		getContentPane().add(chest_f);
		
		JLabel lblNeck = new JLabel("Neck:");
		lblNeck.setBounds(246, 216, 48, 14);
		getContentPane().add(lblNeck);
		
		neck = new JTextField();
		neck.setColumns(10);
		neck.setBounds(294, 213, 76, 20);
		getContentPane().add(neck);
		
		JLabel lblChest_1 = new JLabel("Chest:");
		lblChest_1.setBounds(246, 247, 48, 14);
		getContentPane().add(lblChest_1);
		
		chest_g = new JTextField();
		chest_g.setColumns(10);
		chest_g.setBounds(294, 244, 76, 20);
		getContentPane().add(chest_g);
		
		JLabel lblArm = new JLabel("Arm:");
		lblArm.setBounds(246, 278, 48, 14);
		getContentPane().add(lblArm);
		
		arms = new JTextField();
		arms.setColumns(10);
		arms.setBounds(294, 275, 76, 20);
		getContentPane().add(arms);
		
		JLabel lblWaist = new JLabel("Waist:");
		lblWaist.setBounds(246, 309, 48, 14);
		getContentPane().add(lblWaist);
		
		waist = new JTextField();
		waist.setColumns(10);
		waist.setBounds(294, 306, 76, 20);
		getContentPane().add(waist);
		
		JLabel lblAbdom_1 = new JLabel("Abdom:");
		lblAbdom_1.setBounds(246, 341, 48, 14);
		getContentPane().add(lblAbdom_1);
		
		abdom_g = new JTextField();
		abdom_g.setColumns(10);
		abdom_g.setBounds(294, 338, 76, 20);
		getContentPane().add(abdom_g);
		
		JLabel lblHips = new JLabel("Hip:");
		lblHips.setBounds(246, 372, 48, 14);
		getContentPane().add(lblHips);
		
		hips = new JTextField();
		hips.setColumns(10);
		hips.setBounds(294, 369, 76, 20);
		getContentPane().add(hips);
		
		JLabel lblThights = new JLabel("Thigh:");
		lblThights.setBounds(246, 403, 48, 14);
		getContentPane().add(lblThights);
		
		thighs_g = new JTextField();
		thighs_g.setColumns(10);
		thighs_g.setBounds(294, 400, 76, 20);
		getContentPane().add(thighs_g);
		
		JLabel lblCalfs = new JLabel("Calf:");
		lblCalfs.setBounds(246, 434, 48, 14);
		getContentPane().add(lblCalfs);
		
		calfs = new JTextField();
		calfs.setColumns(10);
		calfs.setBounds(294, 431, 76, 20);
		getContentPane().add(calfs);
		
		Button register = new Button("Register");
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (date.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Date");
				}
				else if (name.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Name");
				}
				else if (age.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter an Age");
				}
				else if (textField_4.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Height");
				}
				else if (textField_5.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter a Weight");
				}
				else if (email.getText().length() <= 0) {
					JOptionPane.showMessageDialog(null, "Please Enter an Email");
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
				else if (thighs_f.getText().length() <= 0) {
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
					attemptNewClient(trainerId);
				}
				//setVisible(false);
			}
		});
		register.setBounds(177, 473, 84, 27);
		getContentPane().add(register);
		
		JLabel lblEmail = new JLabel("Email ");
		lblEmail.setBounds(44, 147, 46, 14);
		getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setBounds(100, 143, 280, 20);
		getContentPane().add(email);
		email.setColumns(10);
		
		JLabel lblYeardaymonth = new JLabel("Year-Day-Month");
		lblYeardaymonth.setBounds(100, 42, 106, 14);
		getContentPane().add(lblYeardaymonth);

		
	}; // Ends newClient 
		
		//Method to validate input and send to DB
		private static void attemptNewClient(int trainerId) {
		
			/*	private static JTextField date;
	private static JTextField name;
	private static JTextField age;
	private static JTextField textField_4; height
	private static JTextField textField_5; weight
	private static JTextField subscap;
	private static JTextField tricepts;
	private static JTextField midAx;
	private static JTextField kidney;
	private static JTextField Abdom_f;
	private static JTextField supra;
	private static JTextField chest_f;
	private static JTextField thighs_f;
	private static JTextField neck;
	private static JTextField chest_g;
	private static JTextField arms;
	private static JTextField waist;
	private static JTextField abdom_g;
	private static JTextField hips;
	private static JTextField thighs_g;
	private static JTextField calfs;
	private static JTextField email;*/
			

			
			
			//else {
		
			//code to send to DB
			sqlMethods sql = new sqlMethods();
			if(sql.attemptNewClient2(new String(name.getText()), new Integer(age.getText()), new String(date.getText()), new Integer(textField_4.getText()), new Integer(textField_5.getText()), new Float(midAx.getText()), new Float(subscap.getText()), new Float(tricepts.getText()), new Float(kidney.getText()), new Float(supra.getText()), new Float(chest_f.getText()), new Float(thighs_f.getText()), new Float(Abdom_f.getText()), trainerId, new Float(arms.getText()), new Float(waist.getText()), new Float(calfs.getText()), new Float(hips.getText()), new Float(thighs_g.getText()), new Float(neck.getText()), new Float(chest_g.getText()), new Float(abdom_g.getText()), new String (email.getText())))                                                                 
			{
				System.out.println("success - entered new client");
				JOptionPane.showMessageDialog(null, "Client successfully registered.");
				
				//clientMain cm = new clientMain();
				//cm.setVisible(true);
		
			}
			
			//} // ends else
		
		} // Ends attemptNewClient
} // Ends
