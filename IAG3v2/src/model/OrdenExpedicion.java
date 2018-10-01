package model;

import java.util.Date;
import java.util.List;

import enummeration.EstadoOE;

public class OrdenExpedicion {

	private int nro;
	private Date fecha;
	private ClientePedido cliente;
	private int pedido;
	private EstadoOE estado;
	private List<DetalleOE> detalle;
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
	public List<DetalleOE> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<DetalleOE> detalle) {
		this.detalle = detalle;
	}
	
	
	
}
