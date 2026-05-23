package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
