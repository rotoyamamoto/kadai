package chap20;

import java.io.IOException;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chap20/mondai14/insert"})
public class Mondai14Insert extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			String courseName = request.getParameter("courseName");

			Course c = new Course();
			c.setCourseName(courseName);
			
			CourseDAO courseDAO = new CourseDAO();
			c = courseDAO.insert(c);
			
			if (c != null) {
				request.setAttribute("course", c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../mondai14insert.jsp")
			.forward(request, response);
	}
}
