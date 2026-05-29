package controller;

import java.io.IOException;

import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

@WebServlet("/update")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAO();

	public UpdateStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student st = dao.getOneStudent(id);
		request.setAttribute("Student", st);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String course = request.getParameter("course");

		Student st = new Student(id, name, age, course);
		int i = dao.updateStudent(st);
		if (i != 0) {
			response.sendRedirect("read");
		}
	}

}
