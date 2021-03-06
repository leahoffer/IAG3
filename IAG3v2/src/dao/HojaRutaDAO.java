package dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import model.HojaRuta;
import model.OrdenExpedicion;
import model.Producto;

public class HojaRutaDAO {
	

	private static HojaRutaDAO instance = null;
	private static SessionFactory sf = null;
	
	
	private HojaRutaDAO() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	public static HojaRutaDAO getInstance() {
		
		if(instance==null)
			instance = new HojaRutaDAO();
		return instance;
	}
	
	@Transactional
	public void saveOrUpdate(HojaRuta hoja) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(hoja);
		session.getTransaction().commit();
		session.close();
	}
	
	

	public List<HojaRuta> findAll() {
		List<HojaRuta> hojas = new ArrayList<>();
		
		
		try {
			Session session = sf.openSession();
			Query query = session.createQuery("from HojaRuta");
			hojas = query.list();
			session.close();
			
			return hojas;
			
		} catch (Exception e) {
			e.printStackTrace();
		
		return hojas;
		
		}	
	}
	
	
public HojaRuta findbyId(int id) {
		
		Session session = sf.openSession();
		
		Query<HojaRuta> query = session.createQuery("from HojaRuta hr where hr.id = :id", HojaRuta.class);
		query.setParameter("id", id);
		HojaRuta HojaRuta = query.uniqueResult();
		session.close();
		
		if(HojaRuta !=null) {
			return HojaRuta;
		}
		else {
			return null;
		}
		
		
	}

}
