//this program is for checking whether connection is established or not with oracle database. 
package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		if(con != null) {
			System.out.println("Connection is established");
		}
		else {
			System.out.println("Connection is not established");
		}
		

	}

}
