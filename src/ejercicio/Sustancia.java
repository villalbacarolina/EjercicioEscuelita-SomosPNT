/*
linkedin.in/villalbacarolina  -   github.com/villalbacarolina
*/

package ejercicio;

public class Sustancia extends Producto {

	private String cantidad;
	
	public Sustancia(String nombre, int precio, String cantidad) {
		super(nombre, precio);
		if(cantidad.equals(""))
			throw new IllegalArgumentException("ERROR: cantidad invalida.");
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nombre: ").append(super.nombre).append(" /// Contenido: ")
			.append(cantidad).append(" /// Precio: $").append(super.precio);
		return info.toString();
	}
}
