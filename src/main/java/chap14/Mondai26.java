package chap14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chap14/mondai26"})
public class Mondai26 extends HttpServlet {
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
			String name = request.getParameter("name");
			int course_id = Integer.parseInt(request.getParameter("course_id"));
			
			PreparedStatement st = con.prepareStatement(
					"insert into STUDENT(STUDENT_ID, STUDENT_NAME, COURSE_ID) "
					+ "values(?, ?, ?)");
			st.setInt(1, id);
			st.setString(2, name);
			st.setInt(3, course_id);
			int line = st.executeUpdate();
			
			if (line > 0) {
				out.println("追加に成功しました。");
			}
			
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace(out);
		}
		
		Page.footer(out);
		
	}

}
