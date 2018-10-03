package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Producto")
public class Producto {
	
	@Id
	@Column(name="id_producto")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	
	
	public Producto(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
