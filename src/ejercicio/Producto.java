package ejercicio;

public abstract class Producto implements Comparable<Producto>{
	
	protected String nombre;
	protected double precio;
	
	public Producto(String nombre, double precio) {
		if(nombre.equals(""))
			throw new IllegalArgumentException("ERROR: nombre invalido.");
		if(precio<=0)
			throw new IllegalArgumentException("ERROR: precio invalido.");
		
		this.nombre = nombre;
		this.precio = precio;
	}
	
	double precio() {
		return precio;
	}
	String nombre() {
		return nombre;
	}
	
	public abstract String toString();
	
	@Override
	public int compareTo(Producto otroProducto) {
		if( precio < otroProducto.precio() )
			return -1;
		if( precio > otroProducto.precio() )
			return 1;
		return 0;
	}
}
