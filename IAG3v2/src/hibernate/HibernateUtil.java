package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.*;

import model.Camioneta;
import model.ClientePedido;
import model.Producto;
import model.Repartidor;
import model.UsuarioLogistica;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			
			config.addAnnotatedClass(ClientePedido.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Repartidor.class);
			config.addAnnotatedClass(UsuarioLogistica.class);
			config.addAnnotatedClass(Camioneta.class);

			
			
			//new Console().runTool(); Esto solo sirve para mostrar o abrir el browser de entidades
			//org.h2.tools.Server web = org.h2.tools.Server.createTcpServer();
		//	org.h2.tools.Server web = org.h2.tools.Server.createWebServer();
		//	web.start();
			sessionFactory = config.buildSessionFactory();
			
			
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
