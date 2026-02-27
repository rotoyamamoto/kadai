package chap16;

import java.io.IOException;
import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/chap16/mondai9"})
public class Mondai9 extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {

		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();
			
			request.setAttribute("list", list);

			request.getRequestDispatcher("mondai9.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
