
import java.awt.Button;
import java.awt.Color;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addWeek extends JFrame{
	private JTextField date;
	private JTextField age;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField subscap;
	private JTextField tricepts;
	private JTextField midAx;
	private JTextField kidney;
	private JTextField Abdom_f;
	private JTextField supra;
	private JTextField chest_f;
	private JTextField thights_f;
	private JTextField neck;
	private JTextField chest_g;
	private JTextField arms;
	private JTextField waist;
	private JTextField abdom_g;
	private JTextField hips;
	private JTextField thighs_g;
	private JTextField calfs;
	public addWeek() {
		setTitle("MetabolixLite: New Week");
		getContentPane().setBackground(new Color(255, 235, 205));
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("New Client Week");
		title.setBounds(188, 21, 101, 25);
		getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("Date:");
		lblNewLabel.setBounds(44, 60, 46, 14);
		getContentPane().add(lblNewLabel);
		
		date = new JTextField();
		date.setBounds(100, 57, 86, 20);
		getContentPane().add(date);
		date.setColumns(10);
				
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(44, 88, 46, 14);
		getContentPane().add(lblAge);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(100, 85, 86, 20);
		getContentPane().add(age);
		
		JLabel lblHeight = new JLabel("Height (in):");
		lblHeight.setBounds(228, 88, 66, 14);
		getContentPane().add(lblHeight);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(294, 85, 76, 20);
		getContentPane().add(textField_4);
		
		JLabel lblWeightlbs = new JLabel("Weight (lbs):");
		lblWeightlbs.setBounds(228, 57, 66, 14);
		getContentPane().add(lblWeightlbs);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(294, 54, 76, 20);
		getContentPane().add(textField_5);
		
		Label lowerTitle = new Label("New Week's Measurement");
		lowerTitle.setBounds(165, 121, 151, 22);
		getContentPane().add(lowerTitle);
		
		Label foldHead = new Label("Skin Folds");
		foldHead.setAlignment(Label.CENTER);
		foldHead.setBounds(75, 149, 62, 22);
		getContentPane().add(foldHead);
		
		Label label_6 = new Label("Girth");
		label_6.setAlignment(Label.CENTER);
		label_6.setBounds(265, 149, 62, 22);
		getContentPane().add(label_6);
		
		JLabel lblTricepts = new JLabel("Tricepts:");
		lblTricepts.setBounds(44, 180, 66, 14);
		getContentPane().add(lblTricepts);
		
		tricepts = new JTextField();
		tricepts.setColumns(10);
		tricepts.setBounds(100, 177, 76, 20);
		getContentPane().add(tricepts);
		
		JLabel lblSubscap = new JLabel("Subscap:");
		lblSubscap.setBounds(44, 211, 66, 14);
		getContentPane().add(lblSubscap);
		
		subscap = new JTextField();
		subscap.setColumns(10);
		subscap.setBounds(100, 208, 76, 20);
		getContentPane().add(subscap);
		
		JLabel lblKidney_1 = new JLabel("Kidney:");
		lblKidney_1.setBounds(44, 242, 66, 14);
		getContentPane().add(lblKidney_1);
		
		kidney = new JTextField();
		kidney.setColumns(10);
		kidney.setBounds(100, 239, 76, 20);
		getContentPane().add(kidney);
		
		JLabel lblKidney = new JLabel("Mid Ax:");
		lblKidney.setBounds(44, 273, 66, 14);
		getContentPane().add(lblKidney);
		
		midAx = new JTextField();
		midAx.setColumns(10);
		midAx.setBounds(100, 270, 76, 20);
		getContentPane().add(midAx);
		
		JLabel lblSupra = new JLabel("Supra:");
		lblSupra.setBounds(44, 305, 66, 14);
		getContentPane().add(lblSupra);
		
		supra = new JTextField();
		supra.setColumns(10);
		supra.setBounds(100, 302, 76, 20);
		getContentPane().add(supra);
		
		JLabel lblAbdom = new JLabel("Abdom:");
		lblAbdom.setBounds(44, 336, 66, 14);
		getContentPane().add(lblAbdom);
		
		Abdom_f = new JTextField();
		Abdom_f.setColumns(10);
		Abdom_f.setBounds(100, 333, 76, 20);
		getContentPane().add(Abdom_f);
		
		JLabel lblThight = new JLabel("Thights:\r\n");
		lblThight.setBounds(44, 367, 66, 14);
		getContentPane().add(lblThight);
		
		thights_f = new JTextField();
		thights_f.setColumns(10);
		thights_f.setBounds(100, 364, 76, 20);
		getContentPane().add(thights_f);
		
		JLabel lblChest = new JLabel("Chest:");
		lblChest.setBounds(44, 398, 66, 14);
		getContentPane().add(lblChest);
		
		chest_f = new JTextField();
		chest_f.setColumns(10);
		chest_f.setBounds(100, 395, 76, 20);
		getContentPane().add(chest_f);
		
		JLabel lblNeck = new JLabel("Neck:");
		lblNeck.setBounds(246, 180, 48, 14);
		getContentPane().add(lblNeck);
		
		neck = new JTextField();
		neck.setColumns(10);
		neck.setBounds(294, 177, 76, 20);
		getContentPane().add(neck);
		
		JLabel lblChest_1 = new JLabel("Chest:");
		lblChest_1.setBounds(246, 211, 48, 14);
		getContentPane().add(lblChest_1);
		
		chest_g = new JTextField();
		chest_g.setColumns(10);
		chest_g.setBounds(294, 208, 76, 20);
		getContentPane().add(chest_g);
		
		JLabel lblArm = new JLabel("Arms:");
		lblArm.setBounds(246, 242, 48, 14);
		getContentPane().add(lblArm);
		
		arms = new JTextField();
		arms.setColumns(10);
		arms.setBounds(294, 239, 76, 20);
		getContentPane().add(arms);
		
		JLabel lblWaist = new JLabel("Waist:");
		lblWaist.setBounds(246, 273, 48, 14);
		getContentPane().add(lblWaist);
		
		waist = new JTextField();
		waist.setColumns(10);
		waist.setBounds(294, 270, 76, 20);
		getContentPane().add(waist);
		
		JLabel lblAbdom_1 = new JLabel("Abdom:");
		lblAbdom_1.setBounds(246, 305, 48, 14);
		getContentPane().add(lblAbdom_1);
		
		abdom_g = new JTextField();
		abdom_g.setColumns(10);
		abdom_g.setBounds(294, 302, 76, 20);
		getContentPane().add(abdom_g);
		
		JLabel lblHips = new JLabel("Hips:");
		lblHips.setBounds(246, 336, 48, 14);
		getContentPane().add(lblHips);
		
		hips = new JTextField();
		hips.setColumns(10);
		hips.setBounds(294, 333, 76, 20);
		getContentPane().add(hips);
		
		JLabel lblThights = new JLabel("Thights:");
		lblThights.setBounds(246, 367, 48, 14);
		getContentPane().add(lblThights);
		
		thighs_g = new JTextField();
		thighs_g.setColumns(10);
		thighs_g.setBounds(294, 364, 76, 20);
		getContentPane().add(thighs_g);
		
		JLabel lblCalfs = new JLabel("Calfs:");
		lblCalfs.setBounds(246, 398, 48, 14);
		getContentPane().add(lblCalfs);
		
		calfs = new JTextField();
		calfs.setColumns(10);
		calfs.setBounds(294, 395, 76, 20);
		getContentPane().add(calfs);
		
		Button submit = new Button("Submit");
		submit.setBounds(178, 429, 84, 27);
		getContentPane().add(submit);

	}
}
