package controller;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.CamionetaDAO;
import dao.ClienteDAO;
import dao.HojaRutaDAO;
import dao.ProductoDAO;
import dao.RepartidorDAO;
import enummeration.EstadoOE;
import model.Camioneta;
import model.ClientePedido;
import model.HojaRuta;
import model.OrdenExpedicion;
import model.Producto;
import model.Repartidor;

import dao.OrdenExpedicionDAO;

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
	
	public void agregarOE(String idcliente, int pedido) {
		OrdenExpedicion oe = new OrdenExpedicion();
		oe.setPedido(pedido);
		ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(idcliente);
		Date d = new Date();
		oe.setCliente(cliente);
		oe.setEstado(EstadoOE.Pendiente);
		oe.setFecha(d);
		OrdenExpedicionDAO.getInstance().saveOrUpdate(oe);
		
	}
	
	public List<OrdenExpedicion> getall() {
		return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findAll();
		}

		public void ArmarRuta (int repartidor) {
			HojaRuta hoja = new HojaRuta();
			Date d = new Date();
			hoja.setFecha(d);
			Repartidor r = RepartidorDAO.getInstance().findRepartidorById(repartidor);
			hoja.setRepartidor(r);
			List<OrdenExpedicion> oe = OrdenExpedicionDAO.getInstance().findAll();
			
			hoja.setPedidos(oe);
			HojaRutaDAO.getInstance().saveOrUpdate(hoja);
			
			
			
			
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
