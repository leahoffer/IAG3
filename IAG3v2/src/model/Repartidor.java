package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Repartidor")
public class Repartidor {

	@Id
	@Column (name="id_repartidor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	
	@OneToOne(fetch = FetchType.LAZY, optional=true)
	@JoinColumn(name="id_camioneta")
	private Camioneta camioneta;
	
	
	public Repartidor(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Repartidor() {
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
	public Camioneta getCamioneta() {
		return camioneta;
	}
	public void setCamioneta(Camioneta camioneta) {
		this.camioneta = camioneta;
	}
	
	
	
	
}
