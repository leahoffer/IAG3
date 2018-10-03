package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import model.Repartidor;

public class RepartidorDAO {
	
	
	private static RepartidorDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private RepartidorDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static RepartidorDAO getInstance() {
		
		if(instance==null)
			instance = new RepartidorDAO();
		return instance;
	}

	@Transactional
	public void saveOrUpdate (Repartidor r) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(r);
		session.getTransaction().commit();
		session.close();
	}
	
	
	
}
