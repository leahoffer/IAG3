package dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import model.ClientePedido;
import model.OrdenExpedicion;

public class OrdenExpedicionDAO {
	
	private static OrdenExpedicionDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private OrdenExpedicionDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static OrdenExpedicionDAO getInstance() {
		
		if(instance==null)
			instance = new OrdenExpedicionDAO();
		return instance;
	}
	
	public List<OrdenExpedicion> findAll() {
		List<OrdenExpedicion> ordenes = new ArrayList<>();
		Session session = sf.openSession();
		
		try {
			Query query = session.createQuery("from OrdenExpedicion");
			ordenes = query.list();
			
			return ordenes;
	
		} catch (Exception e) {
			e.printStackTrace();
		
		return ordenes;
		}	
	}
	@Transactional
	public void saveOrUpdate (OrdenExpedicion op) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(op);
		session.getTransaction().commit();
		session.close();
	}

	
	
	
}
