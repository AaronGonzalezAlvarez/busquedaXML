package busquedaXml;

public class Producto {
	
	private int id;
	private boolean aLaVenta;
	private String nombre;
	private Double precio;
	private int stock;
	
	public Producto(int id, boolean aLaVenta, String nombre, Double precio, int stock) {
		this.id = id;
		this.aLaVenta = aLaVenta;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isaLaVenta() {
		return aLaVenta;
	}
	public void setaLaVenta(boolean aLaVenta) {
		this.aLaVenta = aLaVenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
