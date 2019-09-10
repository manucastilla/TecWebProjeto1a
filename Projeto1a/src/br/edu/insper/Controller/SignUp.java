package br.edu.insper.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.Model.DAO;
import br.edu.insper.Model.User;


/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String login = request.getParameter("userLogin");
		String password = request.getParameter("userPassword");
		String checkPassword = request.getParameter("checkPassword");
		
		DAO dao = new DAO();
		User user =  dao.getUser(login);

		if (user.getLogin() == null) {
			if (password.contentEquals(checkPassword)){

				User parca = new User();
				parca.setLogin(login);
				parca.setPassword(password);
				
				dao.postUser(parca);
				dao.close();

				java.io.PrintWriter out = response.getWriter();
				out.println("<html>");
				out.println("<body>");
				out.println("<h1>Você está cadastrado!</h1>");
				out.println("<form action='PaginaInicial.html'>");
				out.println("<input type='submit' value='VOLTAR'>");	
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");	
				
			}
		
		
		else if (password.contentEquals("") || checkPassword.contentEquals("")) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Você deixou vazio :(</h1>");
			out.println("<form action='PaginaInicial.html'>");
			out.println("<input type='submit' value='VOLTAR'>");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			return;	}
		
		else if (!password.contentEquals(checkPassword)) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Você botou senhas diferentes :(</h1>");
			out.println("<form action='PaginaInicial.html'>");
			out.println("<input type='submit' value='VOLTAR'>");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h1>Algo de errado não está certo :(</h1>");
			out.println("<form action='PaginaInicial.html'>");
			out.println("<input type='submit' value='VOLTAR'>");	
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		

	}

    }

}
