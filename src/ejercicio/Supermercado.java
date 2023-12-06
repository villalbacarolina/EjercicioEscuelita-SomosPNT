/*
linkedin.in/villalbacarolina  -   github.com/villalbacarolina
*/

package ejercicio;

import java.util.HashMap;

/*
______________________________________________________________________________________________________
Imaginemos un supermercado de barrio.
Crear un programa cuyo punto de entrada sea un main en donde, al ejecutarse, se visualiza 
lo siguiente por consola y se termina la ejecución:


Nombre: Coca-Cola Zero /// Litros: 1.5 /// Precio: $20
Nombre: Coca-Cola /// Litros: 1.5 /// Precio: $18
Nombre: Shampoo Sedal /// Contenido: 500ml /// Precio: $19
Nombre: Frutillas /// Precio: $64 /// Unidad de venta: kilo
=============================
Producto más caro: Frutillas
Producto más barato: Coca-Cola


La solución debe cumplir con los siguientes requisitos:
- Diseñar una solución orientada a objetos. YES
- La salida es por consola y exactamente como se requiere. YES
- Usar solamente las clases provistas por Java 8.. YES
- Cargar la lista de productos en un único método. YES No hay ingreso por pantalla de ningún tipo. YES
- El algoritmo usado para la impresión no tiene que depender de la cantidad o tipo de productos.
- Para mostrar el mayor / menor, utilizar la interfaz Comparable. YES
- Para imprimir por pantalla, sobrescribir el método toString() YES
______________________________________________________________________________________________________
*/

public class Supermercado{
	
	private static HashMap<Integer,Ticket> tickets;
	
	Supermercado(){
		tickets = new HashMap<Integer,Ticket>();
	}
	
	private static boolean existeTicket(int codigo) {
		return tickets.containsKey(codigo);
	}
	
	public void agregarTicket(int codigo) {
		if(existeTicket(codigo))
			throw new RuntimeException("ERROR: el ticket ya existe");
		
		Ticket t = new Ticket(codigo);
		tickets.put(codigo, t);
	}
	
	public static void agregarProducto(int codigo, Producto prod) {
		if(!existeTicket(codigo))
			throw new RuntimeException("ERROR: el ticket no existe");
		
		Ticket ticket = tickets.get(codigo);
		ticket.agregarProducto(prod);
	}
	
	@Override
	public String toString() { 
		StringBuilder ticketsInfo = new StringBuilder();
		
		for(Ticket ticket: tickets.values())
			ticketsInfo.append(ticket.toString());
				
		return ticketsInfo.toString();
	}

	public static void main(String[] args) {
		
		Supermercado sm = new Supermercado();
		
		sm.agregarTicket(1);
		sm.agregarProducto( 1, (Producto) new Bebida("Coca-Cola Zero", 20, 1.5) );
		sm.agregarProducto( 1, (Producto) new Bebida("Coca-Cola", 18, 1.5) );
		sm.agregarProducto( 1, (Producto) new Sustancia("Shampoo Sedal", 19, "500ml") );
		sm.agregarProducto( 1, (Producto) new Alimento("Frutillas", 64, "kilo") );
		
		System.out.println( sm.toString() );		
	}

	
}
