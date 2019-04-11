package dao;


import datos.Cliente;
import datos.Cuota;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.Prestamo;
import java.util.List;

public class CuotaDao {
	private static Session session;
	private Transaction tx;
	
	
	private void iniciaOperacion() throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	
	public int agregar(Cuota objeto) {
		int id=0;
		try {
			iniciaOperacion();
			id=	Integer.parseInt(session.save(objeto).toString());
			tx.commit();
			
		}catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally {
			session.close();
		}
		return id;
	}
	
	
	public void actualizar(Cuota objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}
		catch(HibernateException he) {
			manejaExcepcion(he);
			throw he;
			
		}
		finally {session.close();}
	}
	
	public Cuota traerCuota(long idPrestamo, int nroCuota) throws HibernateException{
		Cuota obj = null;
		try {
			iniciaOperacion();
			String hql = "from Cuota as c inner join fetch c.prestamo as p where p.idPrestamo="+idPrestamo+"and c.nroCuota="+nroCuota;
			obj = (Cuota) session.createQuery(hql).uniqueResult();
		}
		finally {
			session.close();
		}
		return obj;
		
	}
		
		public Cuota traerCuota(long idCuota) throws HibernateException {
			Cuota objeto = null;
			try {
				iniciaOperacion();
				objeto = (Cuota) session.get(Cuota.class, idCuota);
			} finally {
				session.close();
			}
			return objeto;
		}
		
		
		public void eliminar(Cuota objeto)  throws HibernateException{
			try {
				iniciaOperacion();
				session.delete(objeto);
				tx.commit();
			}catch(HibernateException he) {
				manejaExcepcion(he);
				throw he;
			}finally {
				session.close();
			}
		}
		
		
		
		@SuppressWarnings("unchecked")
		public List<Cuota> traerCuotas(long idPrestamo){
			List<Cuota> cuotas = null;
			try {
				iniciaOperacion();
				String hql = "from Cuota as c inner join fetch c.prestamo as p where p.idPrestamo ="+idPrestamo;
				cuotas = session.createQuery(hql).list();
				
			} finally {
				session.close();
				}
			
			return cuotas;
			
		}
		
		
		
	
	
	
	
	
	
	
	
	
	
	

}
