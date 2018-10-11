package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.HibernateUtil;
import model.DetalleOE;
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
	
	@Transactional
	public void saveOrUpdate (Producto p) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(p);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	public Producto findById(int id) {
		
		Session session = sf.openSession();
		
		Query<Producto> query = session.createQuery("from Producto p where p.id = :id", Producto.class);
		query.setParameter("id", id);
		Producto producto = query.uniqueResult();
		session.close();
		
		if(producto !=null) {
			return producto;
		}
		else {
			session.close();
			return null;
		}
		
	}

	public Producto findbyNombre(String nombre) {
		
		Session session = sf.openSession();
		
		Query<Producto> query = session.createQuery("from Producto p where p.nombre = :nombre", Producto.class);
		query.setParameter("nombre", nombre);
		Producto producto = query.uniqueResult();
		session.close();
		
		if(producto !=null) {
			return producto;
		}
		else {
			return null;
		}
		
		
	}
	
	
}
