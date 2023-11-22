package ar.edu.unq.po2.tpFinal.cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.orden.OrdenExportacion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class ClienteShipper extends Cliente {

	public ClienteShipper(String mail, String nombre, int dni) {
		super(mail, nombre, dni);
	}
	
	public void enviarOrden(TerminalGestionada terminal, Viaje viaje, Container container, Camion camion, LocalDate fechaSalida, 
			LocalDate fechaLlegada, int nroOrden, LocalDateTime horaLlegada, LocalDateTime horaSalida, List<Servicio> servicios) {
		
		OrdenExportacion orden = new OrdenExportacion(container, viaje, camion, fechaSalida, fechaLlegada, nroOrden, this,
				horaLlegada, horaSalida);
		orden.setServicios(servicios);
		terminal.registrarOrden(orden);
	}

}
