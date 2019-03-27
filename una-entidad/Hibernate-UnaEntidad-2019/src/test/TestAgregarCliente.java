package test;

import java.util.GregorianCalendar;
import dao.ClienteDao;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		
		try {
			String apellido = "Guido";
			String nombre = "Contento";
			int documento = 41064750;
			GregorianCalendar fechaDeNacimiento = new GregorianCalendar(1998, 02, 05);//
			ClienteABM abm = new ClienteABM();
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
	
			ClienteDao d1 = new ClienteDao();

		
		
		}
		catch(Exception e) {
			System.out.println(""+e.getMessage());
		}
		
	}
}