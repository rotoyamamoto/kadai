package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Course;

public class CourseDAO extends DAO {
	
	public List<Course> selectAll() throws Exception {
		List<Course> list = new ArrayList<Course>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from course");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Course c = new Course();
			c.setCourseId(rs.getInt("course_id"));
			c.setCourseName(rs.getString("course_name"));
			list.add(c);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public Course selectByCourseId(int courseId) throws Exception {
		Course c = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from course where course_id = ?");
		st.setInt(1, courseId);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			c = new Course();
			c.setCourseId(rs.getInt("course_id"));
			c.setCourseName(rs.getString("course_name"));
		}
		
		st.close();
		con.close();
		
		return c;
	}
	
	public Course insert(Course course) throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select max(course_id) + 1 as next_id from course");
		ResultSet rs = st.executeQuery();
		Integer nextId = null;
		if (rs.next()) {
			nextId = rs.getInt("next_id");
		}
		
		int userSetId = course.getCourseId();
		if (userSetId != 0) {
			nextId = userSetId;
		}

		if (nextId != null && nextId != 0) {
			course.setCourseId(nextId);
			
			st = con.prepareStatement(
					"insert into course(course_id, course_name) values(?, ?)");
			st.setInt(1, course.getCourseId());
			st.setString(2, course.getCourseName());
			st.executeUpdate();
		}
		
		st.close();
		con.close();
		
		return course;
	}

}
