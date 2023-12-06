/*
linkedin.in/villalbacarolina  -   github.com/villalbacarolina
*/

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
	
	public static String productoExtremo(String extremoBuscado) {
	    if(productos.isEmpty())
	    	throw new RuntimeException("ERROR: no hay productos.");
	    if(productos.size() == 1)
	        return productos.getFirst().toString();

	    Producto extremo = productos.getFirst();

	    for (Producto prod : productos)
	        if (   (extremoBuscado.equals("barato") && prod.compareTo(extremo)<0) 
	        	|| (extremoBuscado.equals("caro") && prod.compareTo(extremo)>0))
	            extremo = prod;

	    return extremo.nombre();
	}

	public static String productoMasBarato(LinkedList<Producto> productos) {
	    return productoExtremo("barato");
	}

	public static String productoMasCaro(LinkedList<Producto> productos) {
	    return productoExtremo("caro");
	}
	
	@Override
	public String toString() {
		StringBuilder infoProductos = new StringBuilder();
		
		for( Producto prod: productos )
			infoProductos.append( prod.toString() ).append("\n");
		infoProductos.append("=============================").append("\n")
		   		     .append("Producto más caro: "  ).append( productoExtremo("caro") ).append("\n")
		   		     .append("Producto más barato: ").append( productoExtremo("barato") );
		
		return infoProductos.toString();
	}

}
