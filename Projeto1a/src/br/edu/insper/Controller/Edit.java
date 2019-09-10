package br.edu.insper.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.Model.DAO;
import br.edu.insper.Model.Notas;
import br.edu.insper.Model.User;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("nome");
		String nota = request.getParameter("nota");
		String titulo = request.getParameter("titulo");
		String id = request.getParameter("id");
		
		request.setAttribute("user", login);
		request.setAttribute("nota", nota);
		request.setAttribute("titulo", titulo);
		request.setAttribute("id", Integer.valueOf(id));
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		DAO dao = new DAO();
		
		String titulo = request.getParameter("titulo_nota");
		String nota = request.getParameter("notas");
		String user = request.getParameter("nome");
		int id = Integer.valueOf(request.getParameter("id"));
		
		Notas notinhas = new Notas();
		notinhas.setUser(user);
		notinhas.setTitulo(titulo);
		notinhas.setNotas(nota);
		notinhas.setId(id);
		
		dao.editarNotas(notinhas);
		dao.close();
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
		
	}

}
