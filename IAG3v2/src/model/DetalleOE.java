package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleOE")
public class DetalleOE {
	
	@Id
	@Column(name="id_detalleOE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id; 
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	@Column(name="cantidad")
	private int cantidad;
	
	public DetalleOE(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public DetalleOE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
