package test;

import java.time.LocalDate;

import funciones.Funciones;


public class testDiaHabil {

	public static void main(String[] args) throws InterruptedException {
		
		LocalDate fechaHoy = LocalDate.of(2019,04,13);
		
		System.out.println("Hoy es dia habil? --> "+Funciones.esDiaHabil(fechaHoy));
		
		
		
		while(!Funciones.esDiaHabil(fechaHoy)) {
			 fechaHoy = fechaHoy.plusDays(1);
			 System.out.println("Sumamos 1 dia, por lo que es: "+fechaHoy.toString());
			 Thread.sleep(300);
		 }
		
		System.out.println("Hoy es: "+fechaHoy.toString());
		
		
		
		
		
		

	}

}
