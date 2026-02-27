package chap16;

import java.io.IOException;
import java.util.List;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chap16/mondai10"})
public class Mondai10 extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {

		try {
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();
			
			request.setAttribute("list", list);

			request.getRequestDispatcher("mondai10.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
