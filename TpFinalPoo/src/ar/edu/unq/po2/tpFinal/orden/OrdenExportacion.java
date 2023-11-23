package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenExportacion extends Orden {

	public OrdenExportacion(Container container, Viaje viaje, Camion camion, 
			LocalDate fechaSalida, LocalDate fechaLlegada, int nroOrden, Cliente cliente) {
		super(container, viaje, camion, fechaSalida, fechaLlegada, nroOrden, cliente);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realizarOperacion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean verificarCondiciones() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
