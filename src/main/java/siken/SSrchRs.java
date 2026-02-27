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

@WebServlet(urlPatterns = {"/siken/srch/rs"})
public class SSrchRs extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		try {
			String keyword = request.getParameter("name");
			if (keyword == null) {
				keyword = "";
			}

			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectByStudentName(keyword);
			request.setAttribute("list", list);
			request.setAttribute("keyword", keyword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("../sres.jsp")
			.forward(request, response);
	}
}
