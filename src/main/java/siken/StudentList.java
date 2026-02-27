package siken;

import java.io.IOException;
import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/siken/list"})
public class StudentList extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("list.jsp")
			.forward(request, response);
	}
}
