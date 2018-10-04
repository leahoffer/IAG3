package controller;

import java.util.List;

import dao.RepartidorDAO;
import enummeration.EstadoOE;
import model.Camioneta;
import model.ClientePedido;
import model.HojaRuta;
import model.OrdenExpedicion;
import model.Repartidor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola mundo");
		
		
		SistemaLogistica sl = new SistemaLogistica();
		
		//ClientePedido p = new ClientePedido(dni, nombre, contrasenia, direccion, telefono)
		ClientePedido cp = new ClientePedido("123", "fer", "caca", "pedo", "231313");
		
//	/*
		sl.agregarCliente("1", "Fernando Alonso", "fernet", "Av. Segui 2215", "42992134");
		sl.agregarCliente("2", "Juan Martin", "piter", "Pedro Dreyer 1234", "42992134");
		sl.agregarCliente("3", "Eber", "jaimito", "Mitre 1234", "42992134");
		sl.agregarCliente("4", "Martin", "anibal", "Av. Espora 1456", "42992134");
		sl.agregarCliente("5", "Pablo", "partido", "Miramar 0878", "42992134");
		
		
		sl.agregarProducto("Coca-Cola Light");
		sl.agregarProducto("Coca-Cola comun");
		sl.agregarProducto("papas fritas");
	
		sl.agregarRepartidor("Carlitos");
		sl.agregarRepartidor("Pedrito");
		
		sl.agregarCamioneta(1, "ford", "20");
		sl.agregarCamioneta(2, "Peugeot", "10");
		
		
		sl.AgregarCamionetaARepartidor(1, 1);
		sl.AgregarCamionetaARepartidor(2, 2);
		
		sl.agregarDetalleOE(10, 1);
		sl.agregarDetalleOE(5, 2);
		sl.agregarDetalleOE(6, 3);
		sl.agregarDetalleOE(6, 1);
		
		sl.agregarOE("1", 5, 1);
		sl.agregarOE("2", 5, 2);
		sl.agregarOE("3", 5, 3);
		
//	*/
		
		
		sl.ArmarRuta(1,1);
		sl.ArmarRuta(1,2);
		sl.ArmarRuta(2,3);
		
		List<HojaRuta> hr = sl.getallHojas();
		for(HojaRuta o : hr) {
			System.out.println(o.getPedidos().getEstado());
			System.out.println(o.getPedidos().getCliente().getDireccion());
			System.out.println(o.getPedidos().getDetalle().getProducto().getNombre());
		}
		
		List<OrdenExpedicion> oe = sl.getDespachados();
		for(OrdenExpedicion o : oe) {
			System.out.println("oiajsdioas:    " +o.getCliente().getDni());	
		}
		
		
		sl.EntregarPedidos();
		
		List<OrdenExpedicion> oe1 = sl.getDespachados();
		for(OrdenExpedicion o : oe1) {
			System.out.println("oiajsdioas:    " +o.getCliente().getDni());	
		}
		
		
		List<HojaRuta> hr1 = sl.getallHojas();
		for(HojaRuta o : hr1) {
			System.out.println(o.getPedidos().getEstado());
		}
		
		
		
//		List<OrdenExpedicion> oe = sl.getall();
//		for(OrdenExpedicion o : oe) {
//			System.out.println(o.getCliente().getDireccion());
//			System.out.println(o.getDetalle().getProducto().getNombre());
//		}
		
		
//		String i = sl.validarLogin("1", "fernet");
//		System.out.println(i);

	}

}
