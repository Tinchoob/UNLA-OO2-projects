package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	public static void main(String[] args) {
		
		try {
		PrestamoABM prestamoABM = new PrestamoABM();
//		long idPrestamo = 4;
//
//		System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
//		Prestamo p = prestamoABM.traerPrestamo(idPrestamo);
//		System.out.println(p + "\nPertenece a " + p.getCliente());
		ClienteABM clienteABM = new ClienteABM();
		
		int dni = 12345;
		Cliente c = clienteABM.traer(dni);
		System.out.println("\n---> TraerPrestamos del Cliente=" + c + "\n\n");
		List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
		if (prestamos.isEmpty()) {
			System.out.println("El cliente "+c.getNombre()+" "+c.getApellido()+" no tiene prestamos asociados");
		}
		else {
		for (Prestamo o : prestamos)
			System.out.println(o + "\nPertenece a " + o.getCliente());
		}
		
		}
		
		catch (Exception e) {
			System.out.print(" "+e.getMessage());
		}
	}
	
	
	
}
