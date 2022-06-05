//JDBC program to get the connection with the oracle db with selecting employee details using empno. 
package jdbcproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest05 {
	
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs =  null;
		Statement st = null;
		Scanner sc = null;
		String query = null;
		int empNo = 0;
		try {
			sc = new Scanner(System.in);
			//load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			
			//create the statement object.
            if(con != null) {
			    st = con.createStatement();
            }
            System.out.println("Enter the emp no");
            //get the input from user
            if(sc != null) {
            	empNo = sc.nextInt(); 
            }
            //prepare the query
            query = "SELECT ENAME,SAL,JOB FROM EMP WHERE EMPNO = "+empNo;
			//send and execute the query
            if(st != null) {
			    rs = st.executeQuery(query);
            }
			//process the result set
			if(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getFloat(2)+"\t\t"+rs.getString(3));
			}
			else {
				System.out.println("No records found");
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
