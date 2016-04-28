import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class client extends JFrame{
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	public client() {
	
	// might need a re-work to better lay it out 
	setTitle("MetabolixLite: Client Manager");
	getContentPane().setBackground(new Color(255, 235, 205));
	getContentPane().setLayout(null);
	
	JScrollPane fold = new JScrollPane();
	fold.setBounds(10, 71, 414, 71);
	getContentPane().add(fold);
	
	table = new JTable();
	fold.setViewportView(table);
	
	JScrollPane girth = new JScrollPane();
	girth.setBounds(10, 177, 414, 71);
	getContentPane().add(girth);
	
	table_1 = new JTable();
	girth.setViewportView(table_1);
	
	JScrollPane mealPlan = new JScrollPane();
	mealPlan.setBounds(10, 281, 414, 71);
	getContentPane().add(mealPlan);
	
	table_2 = new JTable();
	mealPlan.setViewportView(table_2);
	
	JLabel lblNewLabel = new JLabel("Skin Fold Assessments:");
	lblNewLabel.setBounds(10, 46, 111, 14);
	getContentPane().add(lblNewLabel);
	
	JLabel lblGirthMeasurements = new JLabel("Girth Measurement:");
	lblGirthMeasurements.setBounds(10, 152, 111, 14);
	getContentPane().add(lblGirthMeasurements);
	
	JLabel lblMealPlan = new JLabel("Meal Plan:");
	lblMealPlan.setBounds(10, 256, 111, 14);
	getContentPane().add(lblMealPlan);
	
	JButton btnNewButton = new JButton("New Week");
	btnNewButton.setBounds(106, 11, 89, 23);
	getContentPane().add(btnNewButton);
	
	JButton btnSendForms = new JButton("Send Forms");
	btnSendForms.setBounds(232, 11, 89, 23);
	getContentPane().add(btnSendForms);
	}
}
