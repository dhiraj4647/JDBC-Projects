//this program is used to select the records from the emp table
package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		//create the statement object.
		Statement st = con.createStatement();
		
		//send and execute the query
		ResultSet rs = st.executeQuery("SELECT * FROM EMP");
		//process the result set
		while(rs.next() == true) {
			System.out.println(rs.getString(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"
		+rs.getString(5)+"\t\t"+rs.getString(6)+"\t\t"+rs.getString(7)+"\t\t"+rs.getString(8));
			
		}
		//close the object 
		rs.close();
		st.close();
		con.close();

	}

}
