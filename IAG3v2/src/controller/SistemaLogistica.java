package controller;

import org.hibernate.SessionFactory;

import dao.CamionetaDAO;
import dao.ClienteDAO;
import dao.ProductoDAO;
import dao.RepartidorDAO;
import model.Camioneta;
import model.ClientePedido;
import model.Producto;
import model.Repartidor;

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
	
	
	public void agregarCliente(String dni, String nombre, String contrasenia, String direccion, String telefono) {
		
		try {
		ClientePedido cp = new ClientePedido();
		
		cp.setDni(dni);
		cp.setNombre(nombre);
		cp.setContrasenia(contrasenia);
		cp.setDireccion(direccion);
		cp.setTelefono(telefono);
		cp.setActivo(true);
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
	
	public void agregarRepartidor(String nombre) {
		
		try {
			Repartidor repa = new Repartidor();
			repa.setNombre(nombre);
			
			RepartidorDAO.getInstance().saveOrUpdate(repa);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public void AgregarCamionetaARepartidor (int idrepartidor, int idcamioneta) {
		
			Repartidor repa = RepartidorDAO.getInstance().findRepartidorById(idrepartidor);
			Camioneta camioneta = CamionetaDAO.getInstance().findCamionetaById(idcamioneta);
			repa.setCamioneta(camioneta);
			RepartidorDAO.getInstance().saveOrUpdate(repa);
			
		}
	
		
		public void agregarCamioneta(int id_repartidor, String modelo, String capacidad) {
			
			try {
				
				Repartidor r = RepartidorDAO.getInstance().findRepartidorById(id_repartidor);
				
				Camioneta camioneta = new Camioneta();
				
				camioneta.setCapacidad(capacidad);
				camioneta.setModelo(modelo);
				camioneta.setR(r);
				CamionetaDAO.getInstance().saveOrUpdate(camioneta);
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			
		}
		
		
		
	public String validarLogin(String dni, String contrasenia) {
		ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(dni);
		if(cliente != null && cliente.validarLogin(contrasenia) && cliente.isActivo()==true)
			return cliente.getClienteId();
		else
			return null;
}
	
	
}
