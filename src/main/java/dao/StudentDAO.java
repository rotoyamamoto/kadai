package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

public class StudentDAO extends DAO {
	
	public List<Student> selectAll() throws Exception {
		List<Student> list = new ArrayList<Student>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from student");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student s = new Student();
			s.setStudentId(rs.getInt("student_id"));
			s.setStudentName(rs.getString("student_name"));
			s.setCourseId(rs.getInt("course_id"));
			list.add(s);
		}
		
		st.close();
		con.close();
		
		return list;
	}
	
	public Student selectByStudentId(int studentId) throws Exception {
		Student s = null;
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"select * from student where student_id = ?");
		st.setInt(1, studentId);
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			s = new Student();
			s.setStudentId(rs.getInt("student_id"));
			s.setStudentName(rs.getString("student_name"));
			s.setCourseId(rs.getInt("course_id"));
		}
		
		st.close();
		con.close();
		
		return s;
	}

}
