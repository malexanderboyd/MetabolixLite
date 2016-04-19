import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class sqlMethods {
	private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String hostName = "triton.towson.edu";
	private static int port = 3360;
	private static String database = "mboyd8db";
	private static String userName = "mboyd8";
	private static String password = "Cosc*4h4p";


	private static String connect_URL = "jdbc:mysql://" + hostName + ":" + port + "/" + database;

	public void ConnectToDB()
	{
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(connect_URL, userName, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Branch;");
			 while (rs.next()) {
	                System.out.println("Branch #:" + rs.getString(1));

	            }
			
			conn.close();
			stmt.close();
			rs.close();

		} catch(SQLException sqlE) {
			sqlE.printStackTrace();
		}


	}



} // end of class
