package test;

import dao.ClienteDao;
import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;
import java.util.GregorianCalendar;

public class TestAgregarCliente {
	
	public static void main(String[] args) {
	
	ClienteDao dao = new ClienteDao();
	String apellido = "Perez";
	String nombre = "Maruela";
	int dni = 12345;
	GregorianCalendar fechaNacimiento = new GregorianCalendar(2001,02,12);
	
	Cliente c = new Cliente(apellido,nombre,dni,fechaNacimiento);
	long id = dao.agregar(c);
	
	}

	
	

	
	

}
