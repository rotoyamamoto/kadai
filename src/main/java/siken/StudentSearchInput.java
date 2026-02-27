package siken;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/siken/search/input"})
public class StudentSearchInput extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		request.getRequestDispatcher("../search.jsp")
			.forward(request, response);
	}
}
