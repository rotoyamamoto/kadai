package chap9;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chap9/mondai12"})
public class Mondai12 extends HttpServlet {
	
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Page.header(out);
		out.println("<h1>こちらのタイトルはServletで記述しています！</h1>");
		request.getRequestDispatcher("mondai12.jsp").include(request, response);
		out.println("こちらの文はServletで記述しています！");
		Page.footer(out);
	}

}
