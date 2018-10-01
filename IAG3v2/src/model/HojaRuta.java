package model;

import java.util.Date;
import java.util.List;

public class HojaRuta {

	private int id;
	private Date fecha;
	private List<Repartidor> repartidores;
	private List<OrdenExpedicion> pediods;
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
	public List<Repartidor> getRepartidores() {
		return repartidores;
	}
	public void setRepartidores(List<Repartidor> repartidores) {
		this.repartidores = repartidores;
	}
	public List<OrdenExpedicion> getPediods() {
		return pediods;
	}
	public void setPediods(List<OrdenExpedicion> pediods) {
		this.pediods = pediods;
	}
	
	
}
