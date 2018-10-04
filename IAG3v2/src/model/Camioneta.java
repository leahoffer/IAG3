package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="Camionetas")
public class Camioneta {
	
	@Id
	@Column(name="id_camioneta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="capacidad")
	private String capacidad;
	
	
	@OneToOne (cascade = CascadeType.ALL, 
            fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name= "id_repartidor")
	private Repartidor r;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public Repartidor getR() {
		return r;
	}

	public void setR(Repartidor r) {
		this.r = r;
	}

	public Camioneta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Camioneta(String modelo, String capacidad) {
		super();
		this.modelo = modelo;
		this.capacidad = capacidad;
		
	}
	
	
	

}
