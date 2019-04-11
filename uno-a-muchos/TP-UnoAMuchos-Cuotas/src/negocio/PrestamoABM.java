package negocio;

import dao.PrestamoDao;
import dao.ClienteDao;
import java.time.LocalDate;
import java.util.List;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	private PrestamoDao dao = new PrestamoDao();
	private ClienteDao daoCli = new ClienteDao();

	public Prestamo traerPrestamo(long idPrestamo) throws Exception{
		Prestamo p = dao.traer(idPrestamo);
		if (p == null) {
			throw new Exception ("ERROR: El prestamo de ID: "+idPrestamo+" no se encuentra en la base de datos.");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traer(c);
	}
	
	public int agregar(LocalDate fecha,double monto, double interes, int cantCuotas,Cliente cliente) throws Exception{	//agregar exception
		if (daoCli.traer(cliente.getIdCliente()) == null) {
			throw new Exception ("ERROR: El cliente de dni: "+cliente.getDni()+"al que le quiere agregar el prestamo no existe");
		}
		
		Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,cliente);
		return dao.agregar(p);
	}
	
	public void actualizar(Prestamo objeto) {
		dao.actualizar(objeto);
	}
	
	public void eliminar(long idPrestamo) throws Exception{
		Prestamo p = dao.traer(idPrestamo);
		if (p == null) {
			throw new Exception ("ERROR: El prestamo de iD: "+idPrestamo+" que desea eliminar no existe.");
		}
		dao.eliminar(p);
	}
	
	
	public Prestamo traerPrestamoYCuotas(long idPrestamo) {
		Prestamo p = dao.traerPrestamoYCuotas(idPrestamo);
		return p;
	}

	
	
	
}
