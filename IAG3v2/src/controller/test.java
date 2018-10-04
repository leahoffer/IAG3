package controller;

import java.util.List;

import dao.RepartidorDAO;
import enummeration.EstadoOE;
import model.Camioneta;
import model.ClientePedido;
import model.OrdenExpedicion;
import model.Repartidor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola mundo");
		
		
		SistemaLogistica sl = new SistemaLogistica();
		
		//ClientePedido p = new ClientePedido(dni, nombre, contrasenia, direccion, telefono)
		ClientePedido cp = new ClientePedido("123", "fer", "caca", "pedo", "231313");
		
//		/*
		sl.agregarCliente("1", "fer", "caca", "pedo", "42992134");
		sl.agregarCliente("2", "pedro", "caca", "pedo", "42992134");
		sl.agregarCliente("3", "picapiedra", "caca", "pedo", "42992134");
		sl.agregarCliente("4", "marmol", "caca", "pedo", "42992134");
		sl.agregarCliente("5", "asterix", "caca", "pedo", "42992134");
		
		
		sl.agregarProducto("prueba");
	
		sl.agregarRepartidor("carlitos");
		
		sl.agregarCamioneta(1, "ford", "20");
		
		
		sl.AgregarCamionetaARepartidor(1, 1);
		
		
		
		sl.agregarOE("1", 5);
		sl.agregarOE("2", 5);
		sl.agregarOE("3", 5);
		
	//	*/
		
		
		sl.ArmarRuta(1);
		
		List<OrdenExpedicion> oe = sl.getall();
		for(OrdenExpedicion o : oe) {
			System.out.println(o.getCliente().getDireccion());
		}
		
		
		String i = sl.validarLogin("1", "caca");
		System.out.println(i);

	}

}
