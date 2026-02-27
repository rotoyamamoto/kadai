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

@WebServlet(urlPatterns = {"/chap14/mondai28/delete"})
public class Mondai28Delete extends HttpServlet {
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
					"delete from STUDENT "
					+ "where STUDENT_ID = ?");
			st.setInt(1, id);
			int line = st.executeUpdate();
			
			if (line > 0) {
				out.println("削除に成功しました。");
			}
			
			st.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace(out);
		}
		
		Page.footer(out);
		
	}

}
