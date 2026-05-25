package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAO();

	public ReadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Student> list = dao.getAllStudents();
		for (Student s : list) {
			out.println("<h1> " + s.getId() + " " + s.getName() + " " + s.getAge() + " " + s.getCourse() + "</h1>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<Student> list = dao.getAllStudents();
		for (Student s : list) {
			out.println("<h1> " + s.getId() + " " + s.getName() + " " + s.getAge() + " " + s.getCourse() + "</h1>");
		}

	}

}
