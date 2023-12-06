/*
linkedin.in/villalbacarolina  -   github.com/villalbacarolina
*/

package ejercicio;

public class Bebida extends Producto{
	
	private double litros;
	
	public Bebida(String nombre, int precio, double litros) {
		super(nombre, precio);
		if(litros<=0)
			throw new IllegalArgumentException("ERROR: valor de litros invalido.");
		this.litros=litros;
	}
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nombre: ").append(super.nombre).append(" /// Litros: ").append(litros)
			.append(" /// Precio: $").append(precio);
		return info.toString();
	}

	
}
