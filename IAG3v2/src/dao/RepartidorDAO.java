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
	
	public Repartidor findRepartidorById(int id) {
		Session session = sf.openSession();
		
		
		Query<Repartidor> query = session.createQuery("from Repartidor r where r.id = :id", Repartidor.class);
		query.setParameter("id", id);
		Repartidor repa = query.uniqueResult();
		session.close();
		
		if(repa !=null) {
			return repa;
		}
		else {
			session.close();
			return null;
		}
		
	}
	
	public List<Repartidor> findAll(){
		List<Repartidor> repartidores = new ArrayList<>();
		
		
		try {
			Session session = sf.openSession();
			Query query = session.createQuery("from Repartidor");
			repartidores = query.list();
			session.close();
			
			return repartidores;
			
		} catch (Exception e) {
			e.printStackTrace();
		
		return repartidores;
		
		}			
	}
	
}
