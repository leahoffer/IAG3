package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.HibernateUtil;
import model.HojaRuta;

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
	

}
