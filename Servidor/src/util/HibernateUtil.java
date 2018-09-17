package util;

import org.h2.tools.Console;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.ClientesEntity;



public class HibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		try {
			Configuration config = new Configuration();
			config.addAnnotatedClass(ClientesEntity.class);
			
			//new Console().runTool(); Esto solo sirve para mostrar o abrir el browser de entidades
			//org.h2.tools.Server web = org.h2.tools.Server.createTcpServer();
			org.h2.tools.Server web = org.h2.tools.Server.createWebServer();
			web.start();
			sessionFactory = config.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("Initial SessionFactory creation failed." + e);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
