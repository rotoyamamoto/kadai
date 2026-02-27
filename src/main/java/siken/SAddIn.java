package siken;

import java.io.IOException;
import java.util.List;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/siken/add/in"})
public class SAddIn extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			CourseDAO dao = new CourseDAO();
			List<Course> courses = dao.selectAll();
			request.setAttribute("courses", courses);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("../add.jsp")
			.forward(request, response);
	}
}
