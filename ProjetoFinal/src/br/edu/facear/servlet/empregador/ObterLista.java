package br.edu.facear.servlet.empregador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.model.Empregador;
import br.edu.facear.service.ClienteService;
import br.edu.facear.service.EmpregadorService;

/**
 * Servlet implementation class ObterLista
 */
@WebServlet("/ObterLista")
public class ObterLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ObterLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		////////////////////////
		
		ClienteService service = new ClienteService();
		try {
			ArrayList<Cliente> lista = (ArrayList<Cliente>) 
												service.listaClientes();
			
			request.setAttribute("listaClientes", lista);
			
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = getServletContext().
				getRequestDispatcher("/listarClientes.jsp");
		rd.forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
