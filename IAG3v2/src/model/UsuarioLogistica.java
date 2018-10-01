package model;

public class UsuarioLogistica {

	private String usuario;
	private String password;
	private String nombre;
	public UsuarioLogistica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioLogistica(String usuario, String password, String nombre) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
