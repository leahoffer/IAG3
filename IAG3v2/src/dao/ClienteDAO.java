package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import model.ClientePedido;

public class ClienteDAO {
	
	private static ClienteDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private ClienteDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static ClienteDAO getInstance() {
		
		if(instance==null)
			instance = new ClienteDAO();
		return instance;
	}
	
	public void saveOrUpdate (ClientePedido cp) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cp);
		
	}
	

	

}
