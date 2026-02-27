package chap14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chap14/mondai24"})
public class Mondai24 extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup(
					"java:/comp/env/jdbc/kadai");
			Connection con = ds.getConnection();
			
			String name = request.getParameter("name");
			
			PreparedStatement st = con.prepareStatement(
					"select * from STUDENT where STUDENT_NAME like ?");
			st.setString(1, "%" + name + "%");
			ResultSet rs = st.executeQuery();

			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>学生番号</th>");
			out.println("<th>学生名</th>");
			out.println("<th>コース番号</th>");
			out.println("</tr>");
			
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>" + rs.getInt("STUDENT_ID") + "</td>");
				out.println("<td>" + rs.getString("STUDENT_NAME") + "</td>");
				out.println("<td>" + rs.getInt("COURSE_ID") + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace(out);
		}
		
		Page.footer(out);
		
	}

}
