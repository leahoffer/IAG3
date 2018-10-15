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
	
	
	public void agregarCliente(int dni, String nombre, String contrasenia, String direccion, String telefono) {
		
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
	
	//pedido refiere al peso (que va a ocupar en el camion)
	
	public int agregarOE(int idcliente, int pedido, int iddetalle) {
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
		
		return oe.getNro();
		
	}
	
	public int agregarDetalleOE (int cantidad, int idproducto) {
		DetalleOE doe = new DetalleOE();
		doe.setCantidad(cantidad);
		Producto p = ProductoDAO.getInstance().findById(idproducto);
		doe.setProducto(p);
		DetalleOeDAO.getInstance().saveOrUpdate(doe);
		return doe.getId();
		
	}
	
	public DetalleOE DOEfindbyid (int id) {
		DetalleOE doe = DetalleOeDAO.getInstance().findById(id);
		return doe;
	}
	
	
	public HojaRuta HRfindbyid (int id) {
		HojaRuta HojaRuta = HojaRutaDAO.getInstance().findbyId(id);
		return HojaRuta;
	}
	
	
	public Producto PfindByNombre (String nombre) {
		Producto p = ProductoDAO.getInstance().findbyNombre(nombre);
		
		if(p!=null) {
			return p;
		}else {
		return null;
		}
	}
	
	
	public List<String> EnviarEstadoPedido(int dnicliente) {
		
		List<String> notificacion = new ArrayList<>(); 
		List<OrdenExpedicion> oes = OrdenExpedicionDAO.getInstance().findAll();
		int dni = 0;
		for(OrdenExpedicion o : oes) {
			dni = o.getCliente().getClienteId();
			
			ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(dni);
			
			if (cliente.getDni()==(dnicliente)) {
				notificacion.add(o.getEstado().name());
				notificacion.add(cliente.getNombre());
				notificacion.add(cliente.getDireccion());
				notificacion.add(convertirFechaString(o.getFecha()));
				notificacion.add(o.getDetalle().getProducto().getNombre());
				notificacion.add("-------------------------------");
				
				
			}
			
		}
		return notificacion;
		
	}
	
	public String convertirFechaString(Date date){
			
		   return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			
		}
	
	
	public List<OrdenExpedicion> getall() {
		return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findAll();
	}
	public List<Repartidor> getallRep() {
		return (List<Repartidor>) RepartidorDAO.getInstance().findAll();
	}
	
	public List<HojaRuta> getallHojas() {
		return (List<HojaRuta>) HojaRutaDAO.getInstance().findAll();
	}

		public int ArmarRuta (int repartidor, int ordenExpedicion) {
			HojaRuta hoja = new HojaRuta();
			Date d = new Date();
			hoja.setFecha(d);
			Repartidor r = RepartidorDAO.getInstance().findRepartidorById(repartidor);
			hoja.setRepartidor(r);
			OrdenExpedicion oe = OrdenExpedicionDAO.getInstance().findOrdenById(ordenExpedicion);
			oe.setEstado(EstadoOE.Despachado);
			hoja.setPedidos(oe);
			
	     	HojaRutaDAO.getInstance().saveOrUpdate(hoja);
	     	
	     	return hoja.getId();
				
		}	
		
		
		
		public List<OrdenExpedicion> getDespachados() {
			return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findDespachados();
		} 
		
		public List<OrdenExpedicion> getPendientes() {
			return (List<OrdenExpedicion>) OrdenExpedicionDAO.getInstance().findPendientes();
		} 
		
		public String EntregarPedidos(int dni) {
		//	List<HojaRuta> hojas = new ArrayList<>();
		//	hojas = HojaRutaDAO.getInstance().findAll();
			
			ClientePedido cli ;
			cli = ClienteDAO.getInstance().findClienteByDNI(dni);
			
			List<OrdenExpedicion> oes = OrdenExpedicionDAO.getInstance().findDespachados();
			
			for(OrdenExpedicion oe : oes) {
				if(oe.getCliente().getClienteId() == cli.getClienteId()){
				oe.setEstado(EstadoOE.Entregado);
				OrdenExpedicionDAO.getInstance().saveOrUpdate(oe);
				}
			}
			
			String a = "Actualizado";
			return a;
		}
		
		
	public int agregarProducto(String nombre) {
		
		try {
		Producto p = new Producto();
		p.setNombre(nombre);
		
		ProductoDAO.getInstance().saveOrUpdate(p);
		return p.getId();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
		
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
		
		
		
	public int validarLogin(int dni, String contrasenia) {
		ClientePedido cliente = ClienteDAO.getInstance().findClienteByDNI(dni);
		if(cliente != null && cliente.validarLogin(contrasenia) && cliente.isActivo()==true)
			return cliente.getClienteId();
		else
			return 0;
}
	
	public int rutaPrivada(int dni, int cantidad, String producto) {
		
		Producto p = SistemaLogistica.getInstancia().PfindByNombre(producto);
		if (p==null) {
			int idp = SistemaLogistica.getInstancia().agregarProducto(producto);
			int id = SistemaLogistica.getInstancia().agregarDetalleOE(cantidad, idp);
			DetalleOE doe = SistemaLogistica.getInstancia().DOEfindbyid(id);
			int nro = SistemaLogistica.getInstancia().agregarOE(dni, doe.getCantidad(), id);
			return nro;
			
		}else {
		int id = SistemaLogistica.getInstancia().agregarDetalleOE(cantidad, p.getId());
		DetalleOE doe = SistemaLogistica.getInstancia().DOEfindbyid(id);
		int nro = SistemaLogistica.getInstancia().agregarOE(dni, doe.getCantidad(), id);
		
		
		
		return nro;
		}
		
		
	}
	
	
}
