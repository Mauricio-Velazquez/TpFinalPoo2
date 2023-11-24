package ar.edu.unq.po2.tpFinal.cliente;

import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.orden.OrdenExportacion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Turno;

public class ClienteShipper extends Cliente {
	private Turno turno;

	public ClienteShipper(String nombre, int dni, String mail) {
		super(nombre, dni, mail);
	}
	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void enviarOrden(TerminalGestionada terminal, Container container, Camion camion, List<Servicio> servicios) {
		
		OrdenExportacion orden = new OrdenExportacion(container, terminal.viajeMasCorto(), camion, terminal.viajeMasCorto().getFechaInicio(), 
				terminal.viajeMasCorto().getFechaLlegada(), terminal.darNroDeOrden(), this);
		orden.setServicios(servicios);
		terminal.registrarOrden(orden);
		terminal.asignarTurno(this, terminal.viajeMasCorto().getFechaInicio());
	}
}
