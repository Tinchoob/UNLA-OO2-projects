package test;
import datos.Cliente;
import datos.Contacto;
import dao.ClienteDao;
import dao.ContactoDao;
import java.util.GregorianCalendar;


public class TestAgregarClienteYContacto {
	
	public static void main(String[] args) {
	ClienteDao dao = new ClienteDao();
	String apellido = "Pereira";
	String nombre = "Hector";
	int dni = 221133;
	GregorianCalendar fechaNacim = new GregorianCalendar(1992,01,24);
	long id = dao.agregar(new Cliente(apellido,nombre,dni,fechaNacim));
	
	/*agregamos al cliente y le ponemos contacto con un update!*/
	
	
	/*em este caso llamo al 3 porque es el siguiente que voy a agregar*/
	Cliente c = dao.traerCliente(221133);
	Contacto con = new Contacto("hpereira@yahoo.com","11-3211-2111","4888-8881",c);
	ContactoDao dao1 = new ContactoDao();
	dao1.agregar(con);	// primero tenemos que agregar el contacto a la tabla, sino va a fallar
	c.setContacto(con); // modificamos el atributo mediante set
	dao.actualizar(c);	// actualizamos
	Cliente cModif = dao.traerCliente(221133);
	System.out.println("Cliente con contacto --> "+cModif.toString());
	
	
	}
	
	

}
