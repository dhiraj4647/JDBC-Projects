//SELECT THE ENAME,DESIGNATION, SAL FROM EMP TABLE BASED ON GIVEN DESIGNATION.
package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTestWithCodingStd {
	//define the query
	public static final String QUERY= "SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB IN('CLERK','SALESMAN','PRESIDENT')";	

	public static void main(String[] args) {
		//declare the required objects
		ResultSet rs = null;
		Connection con = null;
		Statement st = null;
		try {
			// load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//create the statement object.
			st = con.createStatement();
			
			//send and execute the query
			rs = st.executeQuery(QUERY);
			//process the result set
			while(rs.next() == true) {
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3));
			}
			
			
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(st != null) {
					st.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			try {
				if(rs != null) {
					rs.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
			try {
				if(con != null) {
					con.close();
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			catch(Exception e) {
				e.printStackTrace();
			}	
		}

	}

}
