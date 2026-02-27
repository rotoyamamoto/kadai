package chap15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Student;
import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chap15/mondai13"})
public class Mondai13 extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.selectAll();
			

			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>学生番号</th>");
			out.println("<th>学生名</th>");
			out.println("<th>コース番号</th>");
			out.println("</tr>");
			
			for (Student s: list) {
				out.println("<tr>");
				out.println("<td>" + s.getStudentId() + "</td>");
				out.println("<td>" + s.getStudentName() + "</td>");
				out.println("<td>" + s.getCourseId() + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}
