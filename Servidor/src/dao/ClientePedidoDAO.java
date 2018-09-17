package dao;

public class ClientePedidoDAO {
	
	private static ClientePedidoDAO instancia = null;
	
	public static ClientePedidoDAO getInstancia() {
		if (instancia == null) {
			instancia = new ClientePedidoDAO();
		}
		return instancia;
	}

}
