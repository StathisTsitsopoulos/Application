package ergasia;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class registerop extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name;
		Connection con = null;
		Statement stmt = null ;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerdb", "root", "yagami12");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			stmt = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ResultSet rs = stmt.executeQuery("SELECT name FROM register");
			String s = rs.getString("name");
			PrintWriter out = res.getWriter();
			
			
			
			out.println("welcome register" + s);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		name = req.getParameter("name");
		PrintWriter out = res.getWriter();
		
		
		
		out.println("welcome " + name);

	}
	

}