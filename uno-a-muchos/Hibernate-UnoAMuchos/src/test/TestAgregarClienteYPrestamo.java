package test;

import negocio.ClienteABM;
import negocio.PrestamoABM;
import datos.Cliente;
import datos.Prestamo;

import java.time.LocalDate;

public class TestAgregarClienteYPrestamo {
	
	public static void main(String[] args) {
		
		ClienteABM cliAbm = new ClienteABM();
		PrestamoABM preAbm = new PrestamoABM();
		String apellido= "Juarez";
		String nombre = "Mario";
		int dni = 223311;
		LocalDate fechaDeNacimiento = LocalDate.of(1990, 12, 31);
		long id = cliAbm.agregar(apellido, nombre, dni, fechaDeNacimiento);
		Cliente c = cliAbm.traer(12345);
	//	long idPrestamo = preAbm.agregar(LocalDate.now(),2300, 30, 4,c);
	//	preAbm.agregar(LocalDate.now(),5400, 20, 2,c);
		
		
		
		
		
	}

}
