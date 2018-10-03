package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import model.Camioneta;
import model.Repartidor;

public class CamionetaDAO {
	
	
	private static CamionetaDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private CamionetaDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static CamionetaDAO getInstance() {
		
		if(instance==null)
			instance = new CamionetaDAO();
		return instance;
	}

	@Transactional
	public void saveOrUpdate (Camioneta c) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(c);
		session.getTransaction().commit();
		session.close();
	}
	
	
	public Camioneta findCamionetaById(int id) {
		
		Session session = sf.openSession();
		
		Query<Camioneta> query = session.createQuery("from Camioneta c where c.id = :id", Camioneta.class);
		query.setParameter("id", id);
		Camioneta repa = query.uniqueResult();
		
		if(repa !=null) {
			return repa;
		}
		else {
			session.close();
			return null;
		}
		
	}
	

}
