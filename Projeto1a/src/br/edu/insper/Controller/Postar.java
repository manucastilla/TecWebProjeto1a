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

/**
 * Servlet implementation class Postar
 */
@WebServlet("/postar")
public class Postar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Postar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String titulo = request.getParameter("titulo_nota");
		String nota = request.getParameter("notas");
		String user = request.getParameter("nome");
				
		DAO dao = new DAO();

		Notas notinhas = new Notas();
		notinhas.setUser(user);
		notinhas.setTitulo(titulo);
		notinhas.setNotas(nota);
		
		dao.postNotas(notinhas);
		dao.close();
		
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}

}
