package ar.edu.unq.po2.tpFinal.cliente;

import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public abstract class Cliente {
	private String nombre;
	private int dni;
	private String mail;
	
	public Cliente(String nombre, int dni, String mail) {
		this.nombre = nombre;
		this.dni = dni;
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
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public void recibirFactura(String factura) {
		System.out.println("Se recibio la factura" + factura);
	}

	public abstract void enviarOrden(TerminalGestionada terminal, Container container, Camion camion, List<Servicio> servicios);
}
