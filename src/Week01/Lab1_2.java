package Week01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab1_2 {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//1:Register with the driverManager
		String driverName = "com.mysql.jdbc.Driver";
		Class.forName(driverName).newInstance();
		
		//2:Establishing the connection to the DB Lab1_1 from the DriverManager
		String conURL="jdbc:mysql://localhost:3306/COMP303DB";//URL specifying JDBC Connection
		String user ="root";
		String password = "3415";
		Connection con = DriverManager.getConnection(conURL, user, password);
		
		//3: Communicate with the FirstDatabase DB
		//3.1 Creation of a Statement Object 
		Statement stm = (Statement) con.createStatement();
		
		//3.2: Executing of SQL Statement (SQL query)
		ResultSet res = stm.executeQuery(
				"SELECT * FROM laptop WHERE Manufacture = 'DELL';");

		//3.3:Processing the ResultSet(Retrieving the values of the columns)
		System.out.println("Manufacturer");
		while(res.next()){
			System.out.println(res.getString("Manufacture"));
		}
		//4:Close Everything
		stm.close();
		res.close();
		con.close();
	}
}
