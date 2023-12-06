package ejercicio;

import java.util.LinkedList;

public class Ticket {

	private int codigo;
	private static LinkedList<Producto> productos;
	
	Ticket(int codigo){
		if(codigo<=0)
			throw new IllegalArgumentException("ERROR: codigo invalido");
		this.codigo=codigo;
		productos = new LinkedList<Producto>();
	}
	
	public int codigo() {
		return codigo;
	}
	
	public void agregarProducto(Producto p){
		productos.add(p);
	}
	
	public static Producto productoExtremo(String extremoBuscado) {
	    if(productos.isEmpty())
	    	throw new RuntimeException("ERROR: no hay productos.");
	    if(productos.size() == 1)
	        return productos.getFirst();

	    Producto extremo = productos.getFirst();

	    for (Producto prod : productos)
	        if (   (extremoBuscado.equals("barato") && prod.compareTo(extremo)<0) 
	        	|| (extremoBuscado.equals("caro") && prod.compareTo(extremo)>0))
	            extremo = prod;

	    return extremo;
	}

	public static Producto productoMasBarato(LinkedList<Producto> productos) {
	    return productoExtremo("barato");
	}

	public static Producto productoMasCaro(LinkedList<Producto> productos) {
	    return productoExtremo("caro");
	}
	
	@Override
	public String toString() { //devuelve info de todos los productos
		StringBuilder infoProductos = new StringBuilder();
		
		for( Producto prod: productos )
			infoProductos.append( prod.toString() ).append("\n");
		
		return infoProductos.toString();
	}

}
