package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import dao.ClienteDAO;

@Entity
@Table (name="ClientePedido")
public class ClientePedido {

	
	@Id
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contrasenia")
	private String contrasenia;
	
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="estado")
	private boolean activo;
	
	
	
	public ClientePedido() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public String getContrasenia() {
		return contrasenia;
	}




	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}




	public void setActivo(boolean activo) {
		this.activo = activo;
	}




	public ClientePedido(String dni, String nombre, String contrasenia, String direccion, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.contrasenia = contrasenia;
		this.direccion = direccion;
		this.telefono = telefono;
		this.activo = true;
	}

	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public boolean validarLogin(String contrasenia) {
		return this.contrasenia.equals(contrasenia);
	} 
	
	public void darDeBaja() {
		this.activo = false;
		save();
	}
	
	 public void save() {
			 ClienteDAO.getInstance().saveOrUpdate(this);
	    }

	public boolean isActivo() {
		return activo;
	}

	public String getClienteId() {
		return dni;
	}
	
}
