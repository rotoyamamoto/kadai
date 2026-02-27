package siken;

import java.io.IOException;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/siken/add/done"})
public class StudentAddDone extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			Integer studentId = Integer.valueOf(request.getParameter("studentId"));
			String studentName = request.getParameter("studentName");
			Integer courseId = Integer.valueOf(request.getParameter("courseId"));

			Student s = new Student();
			s.setStudentId(studentId);
			s.setStudentName(studentName);
			s.setCourseId(courseId);

			StudentDAO dao = new StudentDAO();
			s = dao.insert(s);
			request.setAttribute("student", s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("../addDone.jsp")
			.forward(request, response);
	}
}
