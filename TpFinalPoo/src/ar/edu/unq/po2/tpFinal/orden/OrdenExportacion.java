package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDateTime;
import java.util.List;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.filtro.FiltroAnd;
import ar.edu.unq.po2.tpFinal.filtro.FiltroPuertoDestino;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;

public class OrdenExportacion extends Orden {

	public OrdenExportacion(Container container, Buque buque, ar.edu.unq.po2.tpFinal.empresaTransportista.Camion camion,
			Chofer chofer, LocalDateTime fechaSalida, LocalDateTime fechaLlegada, int nroOrden, Cliente cliente,
			int horaLLegada, int horaSalida, Servicio sericio) {
		super(container, buque, camion, chofer, fechaSalida, fechaLlegada, nroOrden, cliente, horaLLegada, horaSalida, sericio);
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
