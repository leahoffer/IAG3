package controller;

import model.ClientePedido;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola mundo");
		
		
		SistemaLogistica sl = new SistemaLogistica();
		
		ClientePedido cp = new ClientePedido("123", "fer", "asd", "41234");
		
		sl.agregarCliente("1", "fer", "asd", "41234");
		
		sl.agregarProducto("prueba");
	
		
		

	}

}
