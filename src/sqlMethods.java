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
	 * 	Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered, Height, Weight, Trainer_id)
	 *	Client_Assessment_Form (C_ID, Liability_Waiver, Environmental_Inventory, Health_History_Questionnaire)
	 *	Girth(G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg)
	 *	Skinfold(S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs)
	 *	Trainer(trainerID, T_Uname, password, email)
	 * 
	 * 
	 * 
	 */

	private static String connect_URL = "jdbc:mysql://" + hostName + ":" + port + "/" + database;

	public int attemptLogin(String username, String password)
	{
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT * FROM Trainer WHERE username = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setString(1, username);
		
		ResultSet rs = preparedStmt.executeQuery();
		String retrievedpw = "n/a";
		int clientId = -1;
		while(rs.next())
		{
			retrievedpw = rs.getString("password");
			clientId = rs.getInt("trainerID");
		}
		String saltedpw = SALT + password;
		String hashedpw = generateHash(saltedpw);
		

		if(retrievedpw.equals(hashedpw))
		{
			preparedStmt.close();
			conn.close();
			return clientId;
		}
		else
		{
			preparedStmt.close();
			conn.close();
			return -1;
		}
		

			

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return -1;
		}

	}
	
	//send client info to DB
	public Boolean attemptNewClient2(String name, Integer age, String date, Integer height, Integer weight, Float midax, Float subscap, Float triceps, Float kidney, Float supra, Float gchest, Float gthigh, Float gabdom, Integer trainerId, Float arm, Float waist, Float calf, Float hips, Float s_thigh, Float neck, Float s_chest, Float s_abdom) {
		
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		Statement st = conn.createStatement();
		st.executeUpdate("insert into Client (Client_name, Client_Age, Date_Entered, Height, Weight, Trainer_id) VALUES('" + name + "', '"+ age +"', '"+ date + "', '"+ height +"', '"+ weight +"', '"+ trainerId +"')");
		
		//add sql statement to grab the client id to pass into the girth and skinfold table
		String idQ = ("SELECT Client_ID FROM Client WHERE Client_name = ? AND Client_Age = ?");
		PreparedStatement preparedStmt = conn.prepareStatement(idQ);
		preparedStmt.setString(1, name);
		preparedStmt.setInt(2,  age);
		
		ResultSet r = preparedStmt.executeQuery();
		int cid = 0;
		while (r.next()) {
		cid = r.getInt("Client_ID");
		}
		
		//System.out.printf("Client ID is equal to %d", cid);
		
		//girth
		st.executeUpdate("insert into Girth (G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg) VALUES('"+ date + "', '"+ midax +"', '"+ subscap+"', '"+ triceps +"', '"+ kidney +"', '"+ supra +"', '"+ gchest +"', '"+ gthigh +"', '"+ gabdom +"', '"+ cid +"')");                                                   
		//skinfold
		st.executeUpdate("insert into Skinfold (S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs) VALUES('"+ date +"', '"+ arm +"', '"+ waist +"', '"+ calf +"', '"+ hips +"', '"+ s_thigh + "', '"+ neck +"', '"+ s_chest +"', '"+ s_abdom +"', '"+ cid + "')");
		
		//ResultSet rs = preparedStmt.executeUpdate();
		//String retrievedpw = "n/a";
		
		conn.close();
		return true;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return false;
		}
		
	}
	
	public boolean attemptAddWeek(int clientID, String date, Integer weight, Float midax, Float subscap, Float triceps, Float kidney, Float supra, Float gchest, Float gthigh, Float gabdom, Float arm, Float waist, Float calf, Float hips, Float s_thigh, Float neck, Float s_chest, Float s_abdom) {
		
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);

		Statement st = conn.createStatement();
		String update = ("UPDATE Client SET Date_Entered = ?, Weight = ? WHERE Client_ID = ? ");
		PreparedStatement p = conn.prepareStatement(update);
		p.setString(1, date);
		p.setInt(2, weight);
		p.setInt(3, clientID);
		p.executeUpdate();
		
		//System.out.printf("Client ID is equal to %d", cid);
		
		//girth
		st.executeUpdate("insert into Girth (G_date, MidAx, Subscap, Triceps, Kidney, Supra, G_Chest, G_Thigh, G_Abdom, C_IDg) VALUES('"+ date + "', '"+ midax +"', '"+ subscap+"', '"+ triceps +"', '"+ kidney +"', '"+ supra +"', '"+ gchest +"', '"+ gthigh +"', '"+ gabdom +"', '"+ clientID +"')");                                                   
		//skinfold
		st.executeUpdate("insert into Skinfold (S_Date, Arm, Waist, Calf, Hips, S_Thigh, Neck, S_Chest, S_Abdom, C_IDs) VALUES('"+ date +"', '"+ arm +"', '"+ waist +"', '"+ calf +"', '"+ hips +"', '"+ s_thigh + "', '"+ neck +"', '"+ s_chest +"', '"+ s_abdom +"', '"+ clientID + "')");
		
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

				String signupQuery = "insert into Trainer (username, password, email) values (?, ?, ?)";

				PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
				preparedStmt.setString(1, username);
				preparedStmt.setString(3, email);

				// hashing pw to store in db // 
				String saltedpw = SALT + password;
				String hashedpw = generateHash(saltedpw);
				preparedStmt.setString(2, hashedpw); // store hashed pw in db
				
				preparedStmt.executeUpdate();
				preparedStmt.close();
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
	
	String signupQuery = "SELECT * FROM Trainer WHERE username = ?";
	
	PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
	preparedStmt.setString(1, username);
	
	ResultSet rs = preparedStmt.executeQuery();
	String retrievedpw = "n/a";
	System.out.println(rs.toString());
	if(!rs.next())
	{
		preparedStmt.close();
		conn.close();
		return false;
	}
	else
	{
		preparedStmt.close();
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


			return rs;


		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}

	//Client(Client_ID, Client_Fname, Client_Lname, Client_Age, Date_Entered, Height, Weight, Trainer_Uname)
	public ResultSet getTrainerClients(int trainer)
	{
			java.sql.Connection conn = null;
			try {
			conn = DriverManager.getConnection(connect_URL, userName, this.password);
			
			String signupQuery = "SELECT * FROM Client WHERE Trainer_id = ?";
			
			PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
			preparedStmt.setInt(1, trainer);
			
			ResultSet rs = preparedStmt.executeQuery();
			
			
			return rs;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	//gets client email
	public ResultSet getClientEmail(int clientID) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String signupQuery = "SELECT Client_email FROM Client WHERE Client_ID = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
		preparedStmt.setInt(1, clientID);
		
		ResultSet rs = preparedStmt.executeQuery();

			
			return rs;

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
			return null;
		}
	}
	
	//sets form boolean in table
	public void formSet(int clientID, boolean health, boolean envi, boolean lia) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String form = "UPDATE Client_Assessment_Form SET Health_History_Questionnaire= ? AND Environmental_Inventory = ? AND Liability_Waiver = ? WHERE C_ID = ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(form);
		preparedStmt.setBoolean(1, health);
		preparedStmt.setBoolean(2, envi);
		preparedStmt.setBoolean(3, lia);
		preparedStmt.setInt(4, clientID);
	
		preparedStmt.executeUpdate();
		conn.close();

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}//end of form set
	
	
	//reset password
	public void resetPass(String email, String pass) {
		java.sql.Connection conn = null;
		try {
		conn = DriverManager.getConnection(connect_URL, userName, this.password);
		
		String resetPass = "UPDATE Trainer SET password = ? WHERE email= ?";
		
		PreparedStatement preparedStmt = conn.prepareStatement(resetPass);
		String saltedpw = SALT + pass;
		String hashedpw = generateHash(saltedpw);
		preparedStmt.setString(1, hashedpw);
		preparedStmt.setString(2, email);
	
		preparedStmt.executeUpdate();

			conn.close();

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}
	}//end of reset
	
	
	
	
    public ResultSet getTrainerEmail(String user) {
        java.sql.Connection conn = null;
        try {
        conn = DriverManager.getConnection(connect_URL, userName, this.password);
       
        String signupQuery = "SELECT email FROM Trainer WHERE username = ?";
       
        PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
        preparedStmt.setString(1, user);
       
        ResultSet rs = preparedStmt.executeQuery();
 
    
            return rs;
 
        } catch(SQLException sqlE) {
            sqlE.printStackTrace();
            return null;
        }
    }
	
	public String getTrainerUsername(int trainerId)
	{
		 java.sql.Connection conn = null;
	        try {
	        conn = DriverManager.getConnection(connect_URL, userName, this.password);
	       
	        String signupQuery = "SELECT username FROM Trainer WHERE trainerID = ?";
	       
	        PreparedStatement preparedStmt = conn.prepareStatement(signupQuery);
	        preparedStmt.setInt(1, trainerId);
	       
	        ResultSet rs = preparedStmt.executeQuery();
	        rs.next();
	    
	        return rs.getString(1);
	 
	        } catch(SQLException sqlE) {
	            sqlE.printStackTrace();
	            return null;
	        }
	}
	
	
	

} // end of class
