package controller;

import java.util.ArrayList;
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
		ClientePedido cp = new ClientePedido(123, "fer", "caca", "pedo", "231313");
		
//	/*
		sl.agregarCliente(1, "Fernando Alonso", "fernet", "Av. Segui 2215", "42992134");
		sl.agregarCliente(2, "Juan Martin", "piter", "Pedro Dreyer 1234", "42992134");
		sl.agregarCliente(3, "Eber", "jaimito", "Mitre 1234", "42992134");
		sl.agregarCliente(4, "Martin", "anibal", "Av. Espora 1456", "42992134");
		
		
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
		
		sl.agregarOE(1, 5, 1);
		sl.agregarOE(2, 5, 2);
		sl.agregarOE(3, 5, 3);
		
//	*/
		
		
		//se arma la hoja de ruta con el id de repartidor y el id hoja de oe
		sl.ArmarRuta(1,1);
		sl.ArmarRuta(1,2);
		sl.ArmarRuta(2,3);
		
		
		
		
		// me trae todas las hojas de ruta
		List<HojaRuta> hr = sl.getallHojas();
		for(HojaRuta o : hr) {
			System.out.println(o.getPedidos().getEstado());
			System.out.println(o.getPedidos().getCliente().getDireccion());
			System.out.println(o.getPedidos().getDetalle().getProducto().getNombre());
		}
		
		//verica que el pedido esta despachado y imprime estado, nombre, direccion.
		List<String> prueba1 = sl.EnviarEstadoPedido(1);
		
		for(String la : prueba1) {
			if(la!=null)
			System.out.println(la);
		}
		
		List<OrdenExpedicion> oe = sl.getDespachados();
		for(OrdenExpedicion o : oe) {
			System.out.println("oiajsdioas:    " +o.getCliente().getDni());	
		}
		
		
		//todos los pedidos que estan en la hoja de ruta los marca como entregados y quedan guardados.
		sl.EntregarPedidos();
		
		List<OrdenExpedicion> oe1 = sl.getDespachados();
		for(OrdenExpedicion o : oe1) {
			System.out.println("oiajsdioas:    " +o.getCliente().getDni());	
		}
		
		
		List<HojaRuta> hr1 = sl.getallHojas();
		for(HojaRuta o : hr1) {
			if(o!=null)
			System.out.println(o.getPedidos().getEstado());
		}
		
		//verica que el pedido esta entregado y imprime estado, nombre, direccion.
		List<String> prueba = new ArrayList<>();
	
		prueba = sl.EnviarEstadoPedido(1);
		
		for(String la : prueba) {
			if(la!=null)
			System.out.println(la);
		}
		
		// valida el login con el dni del cliente y la contrasenia y imprime el dni para ver si lo valida
		int i = sl.validarLogin(1, "fernet");
		System.out.println(i);
		
		
		System.out.println("hasta aca llegue");

		

		//envio de cliente privado: primero se agrega al cliente
		
		sl.agregarCliente(5, "Pablo", "partido", "Miramar 0878", "42992134");

		//pide el "dni" del cliente, la cantidad y el producto que envia 


		int rutaprivada = sl.rutaPrivada(5, 15, "notebook"); //si el producto no existe en la base, lo crea, si existe lo asocia.
		
		int hojap = sl.ArmarRuta(1, rutaprivada); 
		
		//tomo el id de la hoja que arme recien y imprimo los datos.
		
		HojaRuta o = sl.HRfindbyid(hojap);
			System.out.println(o.getPedidos().getEstado());
			System.out.println(o.getPedidos().getCliente().getDireccion());
			System.out.println(o.getPedidos().getDetalle().getCantidad());
			System.out.println(o.getPedidos().getDetalle().getProducto().getNombre());
		
		
		
		
		//si el cliente existe y vuelve a usar el servicio con el dni haces el proceso
	
		int dosenvio = sl.rutaPrivada(5, 2, "caracoles");
		int hojados = sl.ArmarRuta(2, dosenvio);
		
		//tomo el id de la hoja que arme recien y imprimo los datos.
		
				HojaRuta o1 = sl.HRfindbyid(hojados);
					System.out.println(o1.getPedidos().getEstado());
					System.out.println(o1.getPedidos().getCliente().getDireccion());
					System.out.println(o1.getPedidos().getDetalle().getCantidad());
					System.out.println(o1.getPedidos().getDetalle().getProducto().getNombre());
		
	}


}