package test;

import negocio.ClienteABM;
import negocio.PrestamoABM;
import dao.ClienteDao;
import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;
import java.time.LocalDate;

public class TestActualizarPrestamo {
	public static void main(String[] args) {
		
		try {
		PrestamoABM preAbm = new PrestamoABM();
		long id=4;
		Prestamo p = preAbm.traerPrestamo(id);
		System.out.println("Prestamo sin update --> "+p.toString());
	//	p.setCantCuotas(3);
	//	p.setFecha(LocalDate.of(2018, 1, 1));
	//	p.setInteres(30);
	//	p.setMonto(4000);
	//	preAbm.actualizar(p);
	//	System.out.println("Prestamo con update --> "+p.toString());
		p.setCliente(preAbm.traerPrestamo(2).getCliente());
		preAbm.actualizar(p);
		System.out.println("Prestamo con update --> "+p.toString());
		
		
		
		} catch (Exception e) {
			System.out.println(""+e.getMessage());
		}
		
		

	}

}
