package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
/**
 * Servlet implementation class login
 */
@WebServlet("/login2")
public class login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		PrintWriter pw = response.getWriter();
		response.setContentType("text/plain");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/ispmanagementsystem", "root", "myroot");response.setContentType("text/html");
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			  String query =  "select * from customer where username='"+username+"' and password='"+password+"'";
			
			  Statement statement = connect.createStatement();
			  ResultSet  resultSet = statement.executeQuery(query);

			  int cnt = 0;
			  while(resultSet.next())
			   {
				  cnt++;
				  pw.println("<table style=\"width: 100%; \">");
				  pw.println("<tr><th>Customer ID</th><th>Name</th><th>Username</th><th>Phone Number</th><th>Email</th><th>Plan ID</th></tr>");
				  pw.println("<tr><td>" + resultSet.getInt("customerId") + "</td><td>" + resultSet.getString("name") + "</td><td>" + resultSet.getString("username") + "</td><td>" + resultSet.getString("phone") + "</td><td>" + resultSet.getString("email") + "</td><td>" + resultSet.getString("planId") + "</td></tr>");
				  pw.println("</table>"); 
//				  pw.println(resultSet.getInt("customerId"));
//				   pw.println(resultSet.getString("name"));
//				   pw.println(resultSet.getString("username"));
//				   pw.println(resultSet.getString("phone"));
//				   pw.println(resultSet.getString("email"));
//				   pw.println(resultSet.getInt("planId"));
			   }
			  if(cnt==0)
			  {
				  pw.print("Wrong credentials");
			  }
//			  pw.println(query);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		
		
	}

}
