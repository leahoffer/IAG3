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
			
		}
		if ("Estados".equals(request.getParameter("action"))){
			jsp ="verPedidoCliente.jsp";
		}
		
	
		if ("Seguimiento".equals(request.getParameter("action"))){
			jsp ="seguimiento.jsp";
		}
		
		if ("Entrega".equals(request.getParameter("action"))){
			jsp ="entregarpedidos.jsp";
		}
		
		
		
		if ("Envio".equals(request.getParameter("action"))){
			jsp ="nuevoenvio.jsp";
		}
		
		if ("Listar".equals(request.getParameter("action"))){
			jsp ="ListaHojas.jsp";
		}
		
		if ("Salir".equals(request.getParameter("action"))){
			jsp ="end.jsp";
		}
		
		if ("Volver".equals(request.getParameter("VolverAtras"))){
			jsp ="menu.jsp";
		}
		
		
		
		
		if ("Enviar".equals(request.getParameter("action"))){
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			String producto = request.getParameter("producto");
			SistemaLogistica.getInstancia().rutaPrivada(LoginUtils.getInstancia().getClienteBySession(request.getRequestedSessionId()), cantidad, producto);
			jsp ="menuCliente.jsp";
		}
		
		
		if("default".equals(request.getParameter("action")))
			jsp ="Index.jsp";
		
		String volver = request.getParameter("Volver");
		if(volver!=null) {
			if ("Volver".equals(request.getParameter("Volver")))
				jsp ="menu.jsp";
		}
		
		
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
