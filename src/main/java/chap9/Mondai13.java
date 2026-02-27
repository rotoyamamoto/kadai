package chap9;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chap9/mondai13"})
public class Mondai13 extends HttpServlet {
	
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = request.getParameter("url");
		response.sendRedirect(url);
	}

}
