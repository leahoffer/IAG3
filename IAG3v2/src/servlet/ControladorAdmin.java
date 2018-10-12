package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.*;

/**
 * Servlet implementation class ControladorWeb
 */
@WebServlet("/ControladorAdmin")
public class ControladorAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jsp="default";
		if ("ArmarRuta".equals(request.getParameter("action"))){
			jsp ="ListarOE.jsp";
		//	request.setAttribute("listaElaborados", Sistema.getInstancia().getElaboradoList());
			
		}
		if ("Estados".equals(request.getParameter("action"))){
			jsp ="verPedidoCliente.jsp";
			//request.setAttribute("listaSemiElaborados", Sistema.getInstancia().getSemiElaboradoList());
		}
		
		
		if("default".equals(request.getParameter("action")))
			jsp ="Index.jsp";
		
		dispatcher (jsp, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void dispatcher(String jsp, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}
}
