package chap20;

import java.io.IOException;

import bean.Course;
import bean.Student;
import dao.CourseDAO;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chap20/mondai13/disp"})
public class Mondai13Disp extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			Integer studentId = Integer.valueOf(request.getParameter("id"));

			StudentDAO studentDAO = new StudentDAO();
			Student s = studentDAO.selectByStudentId(studentId);
			
			Course c = null;
			if (s != null) {
				CourseDAO courseDAO = new CourseDAO();
				c = courseDAO.selectByCourseId(s.getCourseId());
			}
			
			request.setAttribute("student", s);
			request.setAttribute("course", c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../mondai13disp.jsp")
			.forward(request, response);
	}
}
