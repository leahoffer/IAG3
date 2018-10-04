package model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

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
@Table (name="HojaRuta")
public class HojaRuta {

	@Id
	@Column(name="id_hojaRuta")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="fecha")
	private Date fecha;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_repartidor")
	private Repartidor repartidor;
	
	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_oe")
	private OrdenExpedicion pedidos;
	
	
	
	public HojaRuta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}
	
	public OrdenExpedicion getPedidos() {
		return pedidos;
	}
	public void setPedidos(OrdenExpedicion pedidos) {
		this.pedidos = pedidos;
	}
	private Date getfecha() {
		Date fechaActual = new Date();
		return fechaActual;
	}
	
   
	
	public HojaRuta(Repartidor repartidor, OrdenExpedicion pedidos) {
		super();
		this.fecha = getFecha();
		this.repartidor = repartidor;
		this.pedidos = pedidos;
	}
	
	
	
	
}
