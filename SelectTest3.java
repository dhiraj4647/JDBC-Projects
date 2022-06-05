//select employee name from emp table based on the salary.
package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// load the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the lower range");
		float lowRange = sc.nextFloat();
		System.out.println("Enter the hiigher range");
		float highRange= sc.nextFloat();
		
		String query = "SELECT ENAME FROM EMP WHERE SAL BETWEEN +"+lowRange+" AND "+highRange;
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		
		//create the statement object.
		Statement st = con.createStatement();
		
		//send and execute the query
		ResultSet rs = st.executeQuery(query);
		//process the result set
		while(rs.next() == true) {
			System.out.println(rs.getString(1));
		}
		//close the object 
		rs.close();
		st.close();
		con.close();

	}

}
