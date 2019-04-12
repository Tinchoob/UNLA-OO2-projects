package negocio;

import dao.PrestamoDao;
import dao.CuotaDao;
import java.util.List;
import java.time.LocalDate;
import datos.Cuota;
import datos.Prestamo;

public class CuotaABM {
	CuotaDao dao = new CuotaDao();
	PrestamoDao prestamoDao = new PrestamoDao();
	
	
	
	public Cuota traer(long idCuota) throws Exception{
		Cuota cuo = dao.traerCuota(idCuota);
		if (cuo == null) {
			throw new Exception("ERROR: La cuota de id: "+idCuota+" no existe en la base de datos.");
		}
		return cuo;
	}
	
	public Cuota traer(long idPrestamo,int nroCuota) throws Exception{
		Prestamo p = prestamoDao.traer(idPrestamo);
		
		if (p == null) {
			throw new Exception("ERROR: El prestamo de ID: "+idPrestamo+" no se encuentra disponible.");
		}
		Cuota c = dao.traerCuota(idPrestamo, nroCuota);
		
		if (c == null) {
			throw new Exception ("ERROR: La cuota nro "+nroCuota+" del prestamo de ID: "+idPrestamo+" no fue encontrada.");
		}
		
	
		return c;
		
		
	}
	
	public void actualizar(Cuota objeto) throws Exception{
		try {
			dao.actualizar(objeto);
		}catch(Exception e) {
			throw new Exception("ERROR: Al intentar modificar la cuota "+objeto.getIdCuota());
		}
	}
	
	
	public List<Cuota> traerCuotas(long idPrestamo){
		return dao.traerCuotas(idPrestamo);
	}
	
	
	
	
	

}
