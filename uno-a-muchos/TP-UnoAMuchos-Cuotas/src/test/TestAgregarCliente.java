package test;
import datos.Cliente;
import datos.Cuota;
import datos.Prestamo;
import dao.PrestamoDao;

import java.time.LocalDate;

import dao.ClienteDao;
import dao.CuotaDao;

public class TestAgregarCliente {

	public static void main(String[] args) {
		ClienteDao cliDao = new ClienteDao();
		
		//agregar un cliente
		String apellido ="Tetano";
		String nombre = "Farmin";
		int dni = 223344;
		LocalDate fechaNacimiento = LocalDate.of(2018, 3, 15);
		
		
		Cliente c1 = new Cliente(apellido,nombre,dni,fechaNacimiento);
		cliDao.agregar(c1);
		
		
	
		//actualizar un cliente
	/*	Cliente c2 = cliDao.traer(1234);
		c2.setApellido("Rivas");
		c2.setNombre("Erica");
		cliDao.actualizar(c2);*/
		
		//traer cliente y prestamos
		Cliente c3 = cliDao.traerClienteYPrestamos(5);
		System.out.println("Cliente "+ c3.toString()+"\nPrestamos: "+c3.getPrestamos());
		
		
		
		
	
	}

}
