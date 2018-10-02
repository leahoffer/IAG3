package dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import hibernate.HibernateUtil;
import model.Producto;

public class ProductoDAO {

	
	private static ProductoDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private ProductoDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static ProductoDAO getInstance() {
		
		if(instance==null)
			instance = new ProductoDAO();
		return instance;
	}
	
	
	public void saveOrUpdate (Producto p) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		
	}
	
	
}
