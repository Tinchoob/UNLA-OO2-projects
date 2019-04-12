package test;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import negocio.CuotaABM;
import dao.PrestamoDao;
import java.time.LocalDate;
import dao.ClienteDao;
import dao.CuotaDao;

public class TestTraerCuotas {
	
	public static void main(String[] args) {
	CuotaABM abmCuota = new CuotaABM();
	long idPrestamo = 1;
	
	System.out.println("Cuotas del prestamo: "+idPrestamo+" -->\n "+abmCuota.traerCuotas(idPrestamo));
	
	
	
	
	}
	

}
