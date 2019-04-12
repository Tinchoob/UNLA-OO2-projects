package test;

import negocio.ClienteABM;
import datos.Cliente;
import datos.Prestamo;



public class TestTraerClienteYPrestamos {
	public static void main(String[] args) {
		long idCliente = 3;
		ClienteABM cliAbm = new ClienteABM();
		Cliente c = cliAbm.traerClienteYPrestamos(idCliente);
		System.out.println("\n---> Traer Cliente y Prestamos idCliente=" + idCliente);
		System.out.println("\n" + c);
		if (c.getPrestamos().isEmpty()) {
			System.out.println("El cliente "+c.getNombre() +" "+c.getApellido()+" no posee prestamos a su nombre.");
		}
		else {
		for (Prestamo p : c.getPrestamos())
			System.out.println("\n" + p);
		
		}
	}
	
	
	
	
}
