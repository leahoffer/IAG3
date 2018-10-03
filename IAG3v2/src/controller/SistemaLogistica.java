package controller;

import org.hibernate.SessionFactory;

import dao.ClienteDAO;
import dao.ProductoDAO;
import model.ClientePedido;
import model.Producto;

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
		ClientePedido cp = new ClientePedido();
		cp.setDireccion(direccion);
		cp.setDni(dni);
		cp.setNombre(nombre);
		cp.setTelefono(telefono);
		ClienteDAO.getInstance().saveOrUpdate(cp);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
public void agregarProducto(String nombre) {
		
		try {
		Producto p = new Producto();
		p.setNombre(nombre);
		
		ProductoDAO.getInstance().saveOrUpdate(p);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
