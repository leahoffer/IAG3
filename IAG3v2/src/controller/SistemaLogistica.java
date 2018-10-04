package controller;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import dao.CamionetaDAO;
import dao.ClienteDAO;
import dao.DetalleOeDAO;
import dao.HojaRutaDAO;
import dao.ProductoDAO;
import dao.RepartidorDAO;
import enummeration.EstadoOE;
import model.Camioneta;
import model.ClientePedido;
import model.DetalleOE;
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
	
	public void agregarOE(String idcliente, int pedido, int iddetalle) {
		OrdenExpedicion oe = new OrdenExpedicion();
		oe.setPedido(pedido);
		ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(idcliente);
		Date d = new Date();
		oe.setCliente(cliente);
		oe.setEstado(EstadoOE.Pendiente);
		oe.setFecha(d);
		DetalleOE doe = DetalleOeDAO.getInstance().findById(iddetalle);
		oe.setDetalle(doe);
		OrdenExpedicionDAO.getInstance().saveOrUpdate(oe);
		
	}
	
	public void agregarDetalleOE (int cantidad, int idproducto) {
		DetalleOE doe = new DetalleOE();
		doe.setCantidad(cantidad);
		Producto p = ProductoDAO.getInstance().findById(idproducto);
		doe.setProducto(p);
		DetalleOeDAO.getInstance().saveOrUpdate(doe);
		
	}
	
	public List<String> EnviarEstadoPedido(String dnicliente) {
		
		List<String> notificacion = new ArrayList<>(); 
		List<OrdenExpedicion> oes = OrdenExpedicionDAO.getInstance().findAll();
		String dni = null;
		for(OrdenExpedicion o : oes) {
			dni = o.getCliente().getClienteId();
			
			ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(dni);
			
			if (cliente.getDni().equals(dnicliente)) {
				notificacion.add(o.getEstado().name());
				notificacion.add(cliente.getNombre());
				notificacion.add(cliente.getDireccion());
				notificacion.add(convertirFechaString(o.getFecha()));
				
			}
			
		}
		return notificacion;
		
	}
	
	public String convertirFechaString(Date date){
			
		   return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
		}
	
	public void EnviarCambioEstadoAPendiente() {
		
	}
	
	public void EnviarCambioEstadoADespachado() {
		
	}
	
	public void EnviarCambioEstadoAEntregado() {
		
	}
	
	
	
	public List<OrdenExpedicion> getall() {
		return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findAll();
	}
	
	public List<HojaRuta> getallHojas() {
		return (List<HojaRuta>) HojaRutaDAO.getInstance().findAll();
	}

		public void ArmarRuta (int repartidor, int ordenExpedicion) {
			HojaRuta hoja = new HojaRuta();
			Date d = new Date();
			hoja.setFecha(d);
			Repartidor r = RepartidorDAO.getInstance().findRepartidorById(repartidor);
			hoja.setRepartidor(r);
			OrdenExpedicion oe = OrdenExpedicionDAO.getInstance().findOrdenById(ordenExpedicion);
			oe.setEstado(EstadoOE.Despachado);
			hoja.setPedidos(oe);
			
	     	HojaRutaDAO.getInstance().saveOrUpdate(hoja);
				
		}	
		
		public List<OrdenExpedicion> getDespachados() {
			return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findDespachados();
		} 
		
		public void EntregarPedidos() {
		//	List<HojaRuta> hojas = new ArrayList<>();
		//	hojas = HojaRutaDAO.getInstance().findAll();
			List<OrdenExpedicion> oes = OrdenExpedicionDAO.getInstance().findDespachados();
			
			for(OrdenExpedicion oe : oes) {
				oe.setEstado(EstadoOE.Entregado);
				OrdenExpedicionDAO.getInstance().saveOrUpdate(oe);
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
