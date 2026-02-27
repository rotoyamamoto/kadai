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
				"select * from student order by student_id");
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			Student s = new Student();
			s.setStudentId(rs.getInt("student_id"));
			s.setStudentName(rs.getString("student_name"));
			s.setCourseId(rs.getInt("course_id"));
			list.add(s);
		}
		
		rs.close();
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
		
		rs.close();
		st.close();
		con.close();
		
		return s;
	}

	public List<Student> selectByStudentName(String keyword) throws Exception {
		List<Student> list = new ArrayList<Student>();

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"select * from student where student_name like ? order by student_id");
		st.setString(1, "%" + keyword + "%");
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Student s = new Student();
			s.setStudentId(rs.getInt("student_id"));
			s.setStudentName(rs.getString("student_name"));
			s.setCourseId(rs.getInt("course_id"));
			list.add(s);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}

	public Student insert(Student student) throws Exception {
		Connection con = getConnection();
		Integer studentId = student.getStudentId();

		if (studentId == null || studentId == 0) {
			PreparedStatement st = con.prepareStatement(
					"select max(student_id) + 1 as next_id from student");
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				studentId = rs.getInt("next_id");
			}
			rs.close();
			st.close();
			if (studentId == null || studentId == 0) {
				studentId = 1;
			}
		}

		PreparedStatement check = con.prepareStatement(
				"select count(*) as cnt from student where student_id = ?");
		check.setInt(1, studentId);
		ResultSet checkRs = check.executeQuery();
		boolean exists = false;
		if (checkRs.next()) {
			exists = checkRs.getInt("cnt") > 0;
		}
		checkRs.close();
		check.close();

		if (exists) {
			PreparedStatement st = con.prepareStatement(
					"select max(student_id) + 1 as next_id from student");
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				studentId = rs.getInt("next_id");
			}
			rs.close();
			st.close();
			if (studentId == null || studentId == 0) {
				studentId = 1;
			}
		}

		student.setStudentId(studentId);

		PreparedStatement st = con.prepareStatement(
				"insert into student(student_id, student_name, course_id) values(?, ?, ?)");
		st.setInt(1, student.getStudentId());
		st.setString(2, student.getStudentName());
		st.setInt(3, student.getCourseId());
		st.executeUpdate();

		st.close();
		con.close();

		return student;
	}

}
