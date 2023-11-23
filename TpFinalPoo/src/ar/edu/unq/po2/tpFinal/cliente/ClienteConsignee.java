package ar.edu.unq.po2.tpFinal.cliente;

import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.orden.OrdenImportacion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class ClienteConsignee extends Cliente {
	private String mail;

	public ClienteConsignee(String mail, String nombre, int dni) {
		super(nombre, dni);
		this.mail = mail;
	}
	
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void enviarOrden(TerminalGestionada terminal, Container container, Camion camion, List<Servicio> servicios) {
		
		OrdenImportacion orden = new OrdenImportacion(container, terminal.viajeMasCorto(), camion, terminal.viajeMasCorto().getFechaInicio(), 
				terminal.viajeMasCorto().getFechaLlegada(), terminal.darNroDeOrden(), this);
		orden.setServicios(servicios);
		terminal.registrarOrden(orden);
	}
 
}
