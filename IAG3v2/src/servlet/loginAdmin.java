package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import controller.SistemaLogistica;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginAdmin")
public class loginAdmin extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SistemaLogistica sl = SistemaLogistica.getInstancia();
		
		
		int email = Integer.parseInt(request.getParameter("username"));
		String password = request.getParameter("password");
		
		try {
			int clienteId = sl.validarLogin(email, password);
			if(clienteId> 0) {
				
				System.out.println("si");
				
				LoginUtils.getInstancia().saveSession(request.getSession().getId(), clienteId);

				response.sendRedirect("menu.jsp");
				return;			
				}
			
			else {
				response.sendRedirect("end.jsp");
				return;			
				}
		} catch (Exception e) {
			response.sendRedirect("./jsp/cliente/login.jsp?badCredentials");
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
