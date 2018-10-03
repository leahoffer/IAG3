package controller;

import dao.RepartidorDAO;
import model.Camioneta;
import model.ClientePedido;
import model.Repartidor;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola mundo");
		
		
		SistemaLogistica sl = new SistemaLogistica();
		
		//ClientePedido p = new ClientePedido(dni, nombre, contrasenia, direccion, telefono)
		ClientePedido cp = new ClientePedido("123", "fer", "caca", "pedo", "231313");
		
		sl.agregarCliente("1", "fer", "caca", "pedo", "42992134");
		
		sl.agregarProducto("prueba");
	
		sl.agregarRepartidor("carlitos");


		
		
		Camioneta camioneta = new Camioneta("ford", "20");
		
		sl.agregarCamioneta(1, "ford", "20");
		
		sl.AgregarCamionetaARepartidor(1, 1);
		
		String i = sl.validarLogin("1", "caca");
		System.out.println(i);

	}

}
