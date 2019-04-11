package test;

import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import dao.PrestamoDao;
import java.time.LocalDate;
import dao.ClienteDao;
import dao.CuotaDao;

public class TestAgregarPrestamo {
	public static void main(String[] args) {
		ClienteDao cliDao = new ClienteDao();
		PrestamoDao preDao = new PrestamoDao();
		CuotaDao cuDao = new CuotaDao();
		
		//agregar prestamo

		LocalDate fecha = LocalDate.now();
		double monto=3000;
		double interes = 1.2;
		int cantCuotas = 3;
		Cliente c = cliDao.traer(1234); //111111
		Prestamo p = new Prestamo(fecha, monto, interes, cantCuotas, c);
		preDao.agregar(p);
		
		
		//traer prestamo y sus cuotas
	//	Prestamo p2 = preDao.traerPrestamoYCuotas(1);
	//	System.out.println("Prestamo 1: "+p2.toString() + "\nCuotas: "+p2.getCuotas());
		
		//actualizar prestamo
	/*	Prestamo p2 = preDao.traer(3);
		p2.setCantCuotas(1);
		p2.setFecha(LocalDate.of(2018, 12, 15));
		p2.setMonto(3400);
		preDao.actualizar(p2);*/
		
		
		/////////////////////////// test para cuotas del prestamo//////////////////////////
		
		
		//agregar una cuota a un prestamo
	//	Prestamo p3 = preDao.traer(1);
		//Cuota c3 = new Cuota(2,LocalDate.of(2021, 4, 16),600,50,10,300,100,LocalDate.of(1900, 1, 1),4500,p3);
		//cuDao.agregar(c3);
		
		//el eliminar tambien funciona
		
		System.out.println("Traer cuota 1 del prestamo 1: "+cuDao.traerCuota(1, 2));
		
		
		
		
	
		
		
		
		
		
		
		
		
	}
	
	

}
