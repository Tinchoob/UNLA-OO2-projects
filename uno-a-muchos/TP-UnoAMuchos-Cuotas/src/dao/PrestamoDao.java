package dao;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Prestamo;
import java.util.List;

public class PrestamoDao {
	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public int agregar(Prestamo objeto){
		int id=0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	
	public void actualizar(Prestamo objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
			
		}catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
			
		} finally {
			session.close();
		}
	}
	
	public void eliminar(Prestamo objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}
		finally {
			session.close();
		}
	}
	
	
	
	public Prestamo traer(long idPrestamo) {
		Prestamo objeto = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo as p inner join fetch p.cliente as c where p.idPrestamo = "+idPrestamo;
			objeto = (Prestamo) session.createQuery(hql).uniqueResult();
		}finally {
			session.close();
		}
		return objeto;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Prestamo> traer(Cliente c){
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo as p inner join fetch p.cliente as c where c.idCliente="+c.getIdCliente();
			lista = session.createQuery(hql).list();
		}
		finally {
			session.close();
			}
		return lista;
	}
	
	public Prestamo traerPrestamoYCuotas(long idPrestamo)throws HibernateException{
		Prestamo obj = null;
		try {
			iniciaOperacion();
			String hql = "from Prestamo as p where p.idPrestamo = "+idPrestamo;
			obj = (Prestamo) session.createQuery(hql).uniqueResult();
			Hibernate.initialize(obj.getCuotas());
			
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
			
		}
		finally {session.close();
		}
		return obj;
	
	
	}
	
	
	
	

}
