package chap15;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.Course;
import dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns = {"/chap15/mondai14"})
public class Mondai14 extends HttpServlet {
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			CourseDAO dao = new CourseDAO();
			List<Course> list = dao.selectAll();
			

			out.println("<table border=1>");
			out.println("<tr>");
			out.println("<th>コース番号</th>");
			out.println("<th>コース名</th>");
			out.println("</tr>");
			
			for (Course c: list) {
				out.println("<tr>");
				out.println("<td>" + c.getCourseId() + "</td>");
				out.println("<td>" + c.getCourseName() + "</td>");
				out.println("</tr>");
			}
			
			out.println("</table>");
			
		} catch (Exception e) {
			e.printStackTrace(out);
		}

		Page.footer(out);
	}

}
