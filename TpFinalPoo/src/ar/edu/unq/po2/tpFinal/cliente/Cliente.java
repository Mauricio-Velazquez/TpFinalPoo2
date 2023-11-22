package ar.edu.unq.po2.tpFinal.cliente;

public abstract class Cliente {
	private String mail;
	private String nombre;
	private int dni;
	
	public Cliente(String mail, String nombre, int dni) {
		this.mail = mail;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
}
