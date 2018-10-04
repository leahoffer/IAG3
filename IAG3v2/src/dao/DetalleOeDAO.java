package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import model.ClientePedido;
import model.DetalleOE;

public class DetalleOeDAO {
	

	private static DetalleOeDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private DetalleOeDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static DetalleOeDAO getInstance() {
		
		if(instance==null)
			instance = new DetalleOeDAO();
		return instance;
	}

	@Transactional
	public void saveOrUpdate (DetalleOE cp) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cp);
		session.getTransaction().commit();
		session.close();
	}
	
	
public DetalleOE findById(int id) {
		
		Session session = sf.openSession();
		
		Query<DetalleOE> query = session.createQuery("from DetalleOE doe where doe.id = :id", DetalleOE.class);
		query.setParameter("id", id);
		DetalleOE detalleoe = query.uniqueResult();
		session.close();
		
		if(detalleoe !=null) {
			return detalleoe;
		}
		else {
			session.close();
			return null;
		}
		
	}
	
}
