package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import enummeration.EstadoOE;


@Entity
@Table(name="OrdenExpedicion")
public class OrdenExpedicion {

	@Id
	@Column(name="id_OE")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int nro;
	
	@Column(name="fecha")
	private Date fecha;
	
	@OneToOne(cascade=CascadeType.ALL)
	 private ClientePedido cliente;
	
	@Column(name="pedido")
	private int pedido;
	
	@Enumerated(EnumType.STRING)
	private EstadoOE estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_detalleOE")
	private DetalleOE detalle;
	

	
	
	public OrdenExpedicion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public ClientePedido getCliente() {
		return cliente;
	}
	public void setCliente(ClientePedido cliente) {
		this.cliente = cliente;
	}
	public int getPedido() {
		return pedido;
	}
	public void setPedido(int pedido) {
		this.pedido = pedido;
	}
	
	
	public EstadoOE getEstado() {
		return estado;
	}
	public void setEstado(EstadoOE estado) {
		this.estado = estado;
	}
	public DetalleOE getDetalle() {
		return detalle;
	}
	public void setDetalle(DetalleOE detalle) {
		this.detalle = detalle;
	}
	private Date getfecha() {
		Date fechaActual = new Date();
		return fechaActual;
	}
	public OrdenExpedicion(int pedido, EstadoOE estado, DetalleOE detalle) {
		super();
		this.fecha = getFecha();
		this.pedido = pedido;
		this.estado = estado;
		this.detalle = detalle;
	}

	
	
	
}
