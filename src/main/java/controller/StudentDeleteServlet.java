package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.StudentDAO;

import java.io.IOException;

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO dao = new StudentDAO();

	public StudentDeleteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int i = dao.deleteById(id);
		if (i != 0) {
			response.sendRedirect("read");
		} else {
			request.setAttribute("msg", "Something went wrong..");
			request.getRequestDispatcher("read").forward(request, response);
		}
	}

}
