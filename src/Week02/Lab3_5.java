package Week02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Lab3_5 {
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
		
		//3.2: Create prepared statement
		//3.2.1: Create a prepared statement object
		String queryStr = "SELECT * FROM comp303db.laptop WHERE owner = ?";
		PreparedStatement ps = con.prepareStatement(queryStr);
		//3.2.2: Set the parameters before executing
		String owner = JOptionPane.showInputDialog("Input the name of the owner you would like to retrieve the information");
		ps.setString(1, owner);
		//3.2.3: Actual execution of the statement
		ResultSet res = ps.executeQuery();

		//3.3:Processing the ResultSet(Retrieving the values of the columns)
		System.out.println("Owner\tModel    Manufacturer\tScreen\tYear");
		while(res.next()){
			System.out.print(res.getString("Owner")+"\t");
			System.out.print(res.getString("Model")+"     ");
			System.out.print(res.getString("Manufacture")+"\t");
			System.out.print(res.getString("Screen")+"\t");
			System.out.print(res.getString("Year")+"\n");
		}
		//4:Close Everything
		stm.close();
		res.close();
		con.close();
	}
}
