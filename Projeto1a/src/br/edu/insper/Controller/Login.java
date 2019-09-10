package br.edu.insper.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.Model.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("userLogin");
		String password = request.getParameter("userPassword");
		
		DAO dao = new DAO();
		User user =  dao.getUser(login);
		dao.close();
		
		if (user.getLogin() == null) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Você ainda não tem login :(</h1>");
			out.println("<form action='PaginaInicial.html'>");
			out.println("<input type='submit' value='VOLTAR'>");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		
		else if (!password.contentEquals(user.getPassword())) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>SENHA NAO BATE</h1>");
			out.println("<form action='PaginaInicial.html'>");
			out.println("<input type='submit' value='VOLTAR'>");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} else {
			request.setAttribute("user", login);
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
			rd.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
