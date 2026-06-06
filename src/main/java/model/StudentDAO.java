package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import entity.Student;

public class StudentDAO {

	// insert
	public int insert(Student st) {
		int i = 0;
		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("insert into student(name, age, course) values(?,?,?)");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setString(3, st.getCourse());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// read all students..
	public List<Student> getAllStudents() {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("course")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// delete :
	public int deleteById(int id) {
		int i = 0;
		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("delete from student where id = ?");
			pst.setInt(1, id);
			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// get one student with there id :
	public Student getOneStudent(int id) {
		Student st = null;

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from student where id = ?");
			pst.setInt(1, id);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				st = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("course"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return st;
	}

	// update :
	public int updateStudent(Student st) {
		int i = 0;
		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("update student set name=?, age=?, course=? where id=?");
			pst.setString(1, st.getName());
			pst.setInt(2, st.getAge());
			pst.setString(3, st.getCourse());
			pst.setInt(4, st.getId());

			i = pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return i;
	}

	// search ...
	public List<Student> search(String name) {
		List<Student> list = new LinkedList<>();

		try {
			Connection con = DBUtil.makeConnection();
			PreparedStatement pst = con.prepareStatement("select * from student where name like ?");
			pst.setString(1, "%" + name + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("course")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
