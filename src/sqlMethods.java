import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.swing.JOptionPane;
public class sqlMethods {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
/*	private static String hostName = "triton.towson.edu";
	private static int port = 3360;
	private static String database = "mboyd8db";
	private static String userName = "mboyd8";
	private static String password = "Cosc*4h4p";
	private static final String SALT = "tacos4lyfe"; */
	
	private static String hostName = "triton.towson.edu";
	private static int port = 3360;
	private static String database = "msanto7db";
	private static String userName = "msanto7";
	private static String password = "Cosc*8adm";
	private static final String SALT = "tacos4lyfe";
	
	/*
	 *  Database Tables 
	 * 	Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered, Height, Weight, Trainer_Uname)
	 *	Client_Assessment_Form (C_ID, Liability_Waiver, Environmental_Inventory, Health_History_Questionnaire)
	 *	Girth(G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg)
	 *	Skinfold(S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs)
	 *	Trainer(T_Uname, password, email)
	 * 
	 * 
	 * 
	 */

	private static String connect_URL = "jdbc:mysql://" + hostName + ":" + port + "/" + database;

	public Boolean attemptLogin(String username, String password)
	{
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT password FROM Trainer WHERE T_Uname = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setString(1, username);
		
		ResultSet rs = preparedStmt.executeQuery();
		String retrievedpw = "n/a";
		while(rs.next())
		{
			retrievedpw = rs.getString("password");
		}
		
		String saltedpw = SALT + password;
		String hashedpw = generateHash(saltedpw);
		

		if(retrievedpw.equals(hashedpw))
		{
			////** add code to open manage client window *\\\\\
		}
		
		
			conn.close();
			return true;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return false;
		}

	}
	
	//send client info to DB
	public Boolean attemptNewClient2(String name, Integer age, String date, Integer height, Integer weight, Float midax, Float subscap, Float triceps, Float kidney, Float supra, Float gchest, Float gthigh, Float gabdom) {
		
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		//String newClient = "INSERT name IN Client VALUES('" + name + "')";	
		//PreparedStatement preparedStmt = conn.prepareStatement(newClient);
		//preparedStmt.setString(1, name);
		
		Statement st = conn.createStatement();
		st.executeUpdate("insert into Client (Client_name, Client_Age, Date_Entered, Height, Weight) VALUES('" + name + "', '"+ age +"', '"+ date + "', '"+ height +"', '"+ weight +"')");
		
		st.executeUpdate("insert into Girth (G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg) VALUES('"+ date + "', '"+ midax +"', '"+ subscap+"', '"+ triceps +"', '"+ kidney +"', '"+ supra +"', '"+ gchest +"', '"+ gthigh +"', '"+ gabdom +"', '"+ 5 +"')");                                                   
		
		//ResultSet rs = preparedStmt.executeUpdate();
		//String retrievedpw = "n/a";
		
		conn.close();
		return true;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean attemptSignUp(String username, String password, String email)
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		if(!checkUserExists(username))
		{
			try {
				conn = DriverManager.getConnection(connect_URL, userName, this.password);

				String signupQuery = "insert into Trainer (T_Uname, password, email) values (?, ?, ?)";

				PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
				preparedStmt.setString(1, username);
				preparedStmt.setString(3, email);

				// hashing pw to store in db // 
				String saltedpw = SALT + password;
				String hashedpw = generateHash(saltedpw);
				preparedStmt.setString(2, hashedpw); // store hashed pw in db
				
				preparedStmt.executeUpdate();
				conn.close();
				return true;
			} catch(SQLException sqlE) {
				sqlE.printStackTrace();
			}
		}
		return false;
	}

	
private boolean checkUserExists(String username) {
		
	java.sql.Connection conn = null;
	try {
	conn = DriverManager.getConnection(connect_URL, userName, this.password);
	
	String signupQuery = "SELECT * FROM Trainer WHERE T_Uname = ?";
	
	PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
	preparedStmt.setString(1, username);
	
	ResultSet rs = preparedStmt.executeQuery();
	String retrievedpw = "n/a";
	System.out.println(rs.toString());
	if(!rs.next())
	{
		conn.close();
		return false;
	}
	else
	{
		conn.close();
		return true;
	}

	} catch(SQLException sqlE) {
		sqlE.printStackTrace();
	}
	
	return false;
}


	// used to hash pw in db
	public static String generateHash(String input) {
		StringBuilder hash = new StringBuilder();

		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			byte[] hashedBytes = sha.digest(input.getBytes());
			char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
					'a', 'b', 'c', 'd', 'e', 'f' };
			for (int idx = 0; idx < hashedBytes.length; ++idx) {
				byte b = hashedBytes[idx];
				hash.append(digits[(b & 0xf0) >> 4]);
				hash.append(digits[b & 0x0f]);
			}
		} catch (NoSuchAlgorithmException e) {
			// handle error here.
		}

		return hash.toString();
	}


	public ResultSet getClientWeekData(int clientID) {

		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT * FROM Client WHERE Client_ID = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setInt(1, clientID);
		
		ResultSet rs = preparedStmt.executeQuery();

			conn.close();
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}


	public ResultSet getClientSkinData(int clientID) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT * FROM Skinfold WHERE C_IDs = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setInt(1, clientID);
		
		ResultSet rs = preparedStmt.executeQuery();

			conn.close();
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}


	public ResultSet getClientGirthData(int clientID) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT * FROM Girth WHERE C_IDg = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setInt(1, clientID);
		
		ResultSet rs = preparedStmt.executeQuery();

			conn.close();
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}
	
	public ResultSet getClientEmail(int clientID) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT Client_email FROM Client WHERE Client_ID = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setInt(1, clientID);
		
		ResultSet rs = preparedStmt.executeQuery();

			conn.close();
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}
	
	public ResultSet resetPass(String email, String pass) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String resetPass = "UPDATE Trainer SET password = ? WHERE email= ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(resetPass);
		preparedStmt.setString(1, pass);
		preparedStmt.setString(2, email);
	
		ResultSet rs = preparedStmt.executeQuery();

			conn.close();
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}

} // end of class
