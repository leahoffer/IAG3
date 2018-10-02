package controller;

import org.hibernate.SessionFactory;

import dao.ClienteDAO;
import model.ClientePedido;

public class SistemaLogistica {
	
	private static SistemaLogistica instancia;
	private static SessionFactory sf = null;

	public SistemaLogistica() {
		
	}
	
	public static SistemaLogistica getInstancia() {
		
		if(instancia == null)
			instancia = new SistemaLogistica();
		return instancia;
		
	}
	
	
	public void agregarCliente(String dni, String nombre, String direccion, String telefono) {
		
		try {
		ClientePedido cp = new ClientePedido(dni, nombre, direccion, telefono);
		ClienteDAO.getInstance().saveOrUpdate(cp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
