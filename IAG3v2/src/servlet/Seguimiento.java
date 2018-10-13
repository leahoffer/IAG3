package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.SistemaLogistica;

/**
 * Servlet implementation class Seguimiento
 */
@WebServlet("/Seguimiento")
public class Seguimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Seguimiento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.getParameter("username");
		
		String jsp="default";
		if ("Salir".equals(request.getParameter("action"))){
			jsp ="end.jsp";
			
			dispatcher (jsp, request, response);
		
		}
		String Volver = request.getParameter("Volver");
		if(Volver!=null) {
			if("Volver a menu".equals(request.getParameter("Volver"))){
	//		if(request.getParameter("Volver").equals("Volver a menu")) {
				jsp = "menuCliente.jsp";
			
				dispatcher (jsp, request, response);
			
			}
		}
		
		String Login = request.getParameter("Login");

		if(Login!=null) {
		if(request.getParameter("Login").equals("Login")) {
			jsp = "login.jsp";
			
			dispatcher (jsp, request, response);
			
		}
		}
		
		
		 
	
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
