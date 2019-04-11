package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import funciones.Funciones;

public class Prestamo {
	private long idPrestamo;
	private LocalDate fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private Cliente cliente;
	private Set<Cuota> cuotas;		//es bidireccional, hay que incluir el Set para las cuotas

	public Prestamo() {}		//constructor vacio

	public Prestamo(LocalDate fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.generarCuotas(); // lo usamos para agregar automaticamente las cuotas cuando hacemos el insert de prestamo
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	protected void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public String toString() {
		String prestamo = "Prestamo: $ " + monto + "\nFecha: " + Funciones.traerFechaCorta(fecha) + "\nInteres: "
				+ interes + "\nCant.de Cuotas: " + cantCuotas;
		return prestamo;
	}
	
	
		 
		 public void generarCuotas() {
			 int nroCuota;
			 LocalDate fechaVencimiento = this.fecha;
			 double saldoPendiente = monto;
			 double amortizacion;
			 double interesCuota;
			 double cuota;
			 double deuda;
			 cuotas = new HashSet<Cuota>();
			 
			 
			 for (int i = 1 ; i <= this.cantCuotas ; i++) {
			
				 nroCuota = i;
				 
				 fechaVencimiento = fecha;
				 fechaVencimiento = fecha.plusMonths(i);
				 while(!Funciones.esDiaHabil(fechaVencimiento)) {
					 fechaVencimiento = fechaVencimiento.plusDays(1); // f.plusDays devuelve una copia por lo que si o si hay que igualar, sino no funciona
				 }
				 
				 
				 amortizacion = (saldoPendiente*interes) / (Math.pow(1+interes,this.cantCuotas - i +1)-1);	// esta elevado a un coeficiente binomial: n, n-1, n-2 etc // la formula es: 
				 interesCuota = saldoPendiente * interes;													// (n - k + 1) k = numero de elementos que escojemos
				 cuota = amortizacion + interesCuota;
				 deuda = saldoPendiente - amortizacion;
				 saldoPendiente = saldoPendiente - amortizacion;
				 
				 //fecha de vencimiento es 1 mes despues de solicitado el prestamo, y no puede ser sabado, domingo o feriado
				
				 Cuota c = new Cuota( nroCuota, fechaVencimiento, saldoPendiente,  amortizacion,interesCuota, cuota,  deuda,this);
				 cuotas.add(c);
				 
				 
				 
				 
				 
			 }
			 
		 }
		 
		 
		 
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
