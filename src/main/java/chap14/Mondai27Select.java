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

@WebServlet(urlPatterns = {"/chap14/mondai27/input"})
public class Mondai27Select extends HttpServlet {
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
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			PreparedStatement st = con.prepareStatement(
					"select * from STUDENT where STUDENT_ID = ?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			String name = rs.getString("STUDENT_NAME");
			int course_id = rs.getInt("COURSE_ID");
			
			st = con.prepareStatement(
					"select * from COURSE");
			rs = st.executeQuery();
			
			out.println("<form action=\"update\" method=\"get\">");
			out.println("お名前　　：");
			out.println("<input type=\"text\" name=\"name\" value=\"" + name + "\">");
			out.println("<br>");
			out.println("コース番号：");
			out.println("<select name=\"course_id\">");
			
			while(rs.next()) {
				int cid = rs.getInt("COURSE_ID");
				if (course_id == cid) {
					out.println("<option value=\"" + cid + "\" selected>");
				} else {
					out.println("<option value=\"" + cid + "\">");
				}
				out.println(cid);
				out.println("</option>");
			}
			
			out.println("</select>");
			out.println("<br>");
			
			out.println("<input type=\"hidden\" name=\"id\" value=\"" + id + "\">");
			
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
