package ejercicio;

public class Sustancia extends Producto {

	private String cantidad;
	
	public Sustancia(String nombre, double precio, String cantidad) {
		super(nombre, precio);
		if(cantidad.equals(""))
			throw new IllegalArgumentException("ERROR: cantidad invalida.");
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nombre: ").append(super.nombre).append(" /// Precio: $").append(super.precio)
			.append(" /// Contenido: ").append(cantidad);
		return info.toString();
	}
}
