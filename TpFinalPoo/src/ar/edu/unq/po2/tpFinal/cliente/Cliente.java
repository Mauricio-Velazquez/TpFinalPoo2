package ar.edu.unq.po2.tpFinal.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

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
	
	public abstract void enviarOrden(TerminalGestionada terminal, Viaje viaje, Container container, Camion camion, LocalDate fechaSalida, 
			LocalDate fechaLlegada, int nroOrden, LocalDateTime horaLlegada, LocalDateTime horaSalida, List<Servicio> servicios);
}
