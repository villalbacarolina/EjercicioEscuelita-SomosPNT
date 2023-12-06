/*
linkedin.in/villalbacarolina  -   github.com/villalbacarolina
*/

package ejercicio;

public class Alimento extends Producto{
	
	private String unidad;

	public Alimento(String nombre, int precio, String unidad) {
		super(nombre, precio);
		if(    !unidad.equals("kilo") 
			&& !unidad.equals("gramos")
			&& !unidad.equals("ramillete") 
			&& !unidad.equals("unidad")     )
			throw new IllegalArgumentException("ERROR: unidad invalida.");
		this.unidad = unidad;
	}
	
	@Override
	public String toString() {
		StringBuilder info = new StringBuilder();
		info.append("Nombre: ").append(super.nombre).append(" /// Precio: $").append(super.precio)
			.append(" /// Unidad de venta: ").append(unidad);
		return info.toString();
	}

}
