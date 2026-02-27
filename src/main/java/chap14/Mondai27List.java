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

@WebServlet(urlPatterns = {"/chap14/mondai27"})
public class Mondai27List extends HttpServlet {
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
			
			PreparedStatement st = con.prepareStatement(
					"select * from STUDENT");
			ResultSet rs = st.executeQuery();
			
			out.println("<p>データを更新する学生を選んでください</p>");
			out.println("<form action=\"mondai27/input\" method=\"get\">");
			out.println("<select name=\"id\">");
			
			while(rs.next()) {
				out.println("<option value=\"" + rs.getInt("STUDENT_ID") + "\">");
				out.println(rs.getString("STUDENT_NAME"));
				out.println("</option>");
			}
			
			out.println("</select>");
			out.println("<input type=\"submit\" value=\"送信\">");
			
			out.println("</form>");
			
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace(out);
		}
		
		Page.footer(out);
		
	}

}
