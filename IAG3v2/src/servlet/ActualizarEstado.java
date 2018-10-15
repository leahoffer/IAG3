package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import controller.*;

/**
 * Servlet implementation class ListarSemiElaborados
 */
@WebServlet("/ActualizarEstado")
public class ActualizarEstado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActualizarEstado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("pedidocli"));
		
		int oe = Integer.parseInt(request.getParameter("pedidoscli"));
		
		request.setAttribute("pedidoscli",SistemaLogistica.getInstancia().EntregarPedidos(oe));
		
		LoginUtils.getInstancia().saveSession(request.getSession().getId(), oe);
		
		String jsp ="head.jsp";
		
		
		
	
		dispatcher (jsp,request,response);
		
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

