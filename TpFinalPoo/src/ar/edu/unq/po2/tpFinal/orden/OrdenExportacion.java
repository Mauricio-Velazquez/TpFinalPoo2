package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenExportacion extends Orden {

	public OrdenExportacion(Container container, Viaje viaje, Camion camion, Chofer chofer, 
			LocalDate fechaSalida, LocalDate fechaLlegada, int nroOrden, Cliente cliente) {
		super(container, viaje, camion, chofer, fechaSalida, fechaLlegada, nroOrden, cliente);
	}

}
