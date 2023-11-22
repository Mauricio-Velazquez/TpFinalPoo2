package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenImportacion extends Orden {

	public OrdenImportacion(Container container, Viaje viaje, Camion camion, 
			LocalDate fechaSalida, LocalDate fechaLlegada, int nroOrden, Cliente cliente,
			LocalDateTime horaLLegada, LocalDateTime horaSalida) {
		super(container, viaje, camion, fechaSalida, fechaLlegada, nroOrden, cliente, horaLLegada, horaSalida);
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
