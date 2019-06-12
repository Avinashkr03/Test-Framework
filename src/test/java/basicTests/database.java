package basicTests;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class database {
	
	public static void main(String[] args) throws SQLException {
		String host  = "localhost";
		String port = "3306";
		//getconnection takes three parameter 
		//DriverManager.getConnection(url, user, password)
		//here url is connection string with format
		//["jdbc:mysql//"+host+":"+port+"/databasename"] 
		Connection con = DriverManager.getConnection("jdbc:mysql://"+ host +":" + port + "/qatesting", "root", "nous;123");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("SELECT * from Employeeinfo where name = 'dam';");
		rs.next();
		System.out.println(rs.getString("name"));
		System.out.println(rs.getInt("age"));
	}
}
