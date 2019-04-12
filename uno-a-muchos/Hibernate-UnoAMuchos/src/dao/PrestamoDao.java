package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Cliente;
import datos.Prestamo;

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
	
	

	public Prestamo traer(long idPrestamo) throws HibernateException {
		Prestamo obj = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo as p inner join fetch p.cliente as c where p.idPrestamo=" + idPrestamo;
			obj = (Prestamo) session.createQuery(hQL).uniqueResult();
			}
			catch(HibernateException he) {			//el catch no esta en el archivo del pdf, si tira algun error sacarlo
				manejaExcepcion(he);
				throw he;
			}
		 finally {
			session.close();
		}
		return obj;
	}

	@SuppressWarnings("unchecked")
	public List<Prestamo> traer(Cliente c) throws HibernateException {
		List<Prestamo> lista = null;
		try {
			iniciaOperacion();
			String hQL = "from Prestamo as p inner join fetch p.cliente as c where c.idCliente=" + c.getIdCliente();
			lista = session.createQuery(hQL).list();
		}
		catch(HibernateException he) {		//el catch no esta en el archivo del pdf, si tira algun error sacarlo
			manejaExcepcion(he);
			throw he;
		}
		finally {
			session.close();
		}
		return lista;
	}
}