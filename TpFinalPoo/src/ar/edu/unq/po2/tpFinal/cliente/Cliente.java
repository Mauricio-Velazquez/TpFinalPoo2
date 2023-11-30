package ar.edu.unq.po2.tpFinal.cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.orden.Orden;

public abstract class Cliente {
	private String nombre;
	private int dni;
	private String mail;
	private List<Orden> ordenes;
	
	public Cliente(String nombre, int dni, String mail) {
		this.nombre = nombre;
		this.dni = dni;
		this.mail = mail;
		ordenes = new ArrayList<Orden>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDni() {
		return dni;
	}
	
	public String getMail() {
		return mail;
	}
	
	public List<Orden> getOrdenes() {
		return ordenes;
	}
	
	public void recibirFactura(String factura) {
		System.out.println("Se recibio la factura" + factura);
	}
	
	public void recibirEmail(String mensaje) {
		System.out.println("Se recibio un Email: "+mensaje);
	}
	
	public void agregarOrden(Orden orden){
		ordenes.add(orden);
	}

}
