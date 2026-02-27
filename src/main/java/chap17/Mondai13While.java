package chap17;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/chap17/mondai13/while"})
public class Mondai13While extends HttpServlet {

	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		session.setAttribute("price", price);
		session.setAttribute("quantity", quantity);

		request.getRequestDispatcher("../mondai13while.jsp")
			.forward(request, response);
	}

}
