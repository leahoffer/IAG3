package controller;

import dao.ClienteDAO;
import model.ClientePedido;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hola mundo");
		
		@SuppressWarnings("unused")
		SistemaLogistica sl = new SistemaLogistica();
		
		ClientePedido cp = new ClientePedido("123", "fer", "asd", "41234");
		ClienteDAO.getInstance().saveOrUpdate(cp);
		
		

	}

}
