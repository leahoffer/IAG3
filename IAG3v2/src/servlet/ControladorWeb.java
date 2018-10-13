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
@WebServlet("/ControladorWeb")
public class ControladorWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jsp="default";
		if ("LoginCliente".equals(request.getParameter("action"))){
			jsp ="login.jsp";
		//	request.setAttribute("listaElaborados", Sistema.getInstancia().getElaboradoList());
			
		}
		if ("Login".equals(request.getParameter("action"))){
			jsp ="loginAdmin.jsp";
			//request.setAttribute("listaSemiElaborados", Sistema.getInstancia().getSemiElaboradoList());
		}
		
		
		if("default".equals(request.getParameter("action")))
			jsp ="Index.jsp";
		
		if("Registro".equals(request.getParameter("action"))) 
			jsp ="registro.jsp";
		

		String registrar = request.getParameter("Registrar");
		
		if(registrar !=null) {
			if(request.getParameter("Registrar").equals("Registrarse")) {
				
				int dni = Integer.parseInt(request.getParameter("dni"));
				String nombre = request.getParameter("nombre");
				String direccion = request.getParameter("direccion");
				String telefono = request.getParameter("telefono");
				String password = request.getParameter("password");
				
				SistemaLogistica.getInstancia().agregarCliente(dni, nombre, password, direccion, telefono);
				LoginUtils.getInstancia().saveSession(request.getSession().getId(), dni);

				jsp = "menuCliente.jsp";
				
				
				
			}
			
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
