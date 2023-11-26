package ar.edu.unq.po2.tpFinal.cliente;

import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.orden.OrdenImportacion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class ClienteConsignee extends Cliente {

	public ClienteConsignee(String nombre, int dni, String mail) {
		super(nombre, dni, mail);
	}
	
	public void enviarOrden(TerminalGestionada terminal, Container container, Camion camion, List<Servicio> servicios) {
		
		OrdenImportacion orden = new OrdenImportacion(container, terminal.viajeMasCorto(), camion, terminal.viajeMasCorto().getFechaSalida(), 
				terminal.viajeMasCorto().getFechaLlegada(), terminal.darNroDeOrden(), this);
		orden.setServicios(servicios);
		terminal.registrarOrden(orden);
	}
 
}
