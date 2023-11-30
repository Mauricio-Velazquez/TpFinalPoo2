package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public abstract class Orden {
	private Container container;
	private Viaje viaje;
	private Camion camion;
	private Chofer chofer;
	private LocalDate fechaSalida;
	private LocalDate fechaLlegada;
	private int nroOrden;
	private Cliente cliente;
    private List<Servicio> servicios;

	public Orden(Container container, Viaje viaje, Camion camion, Chofer chofer, LocalDate fechaSalida, 
			LocalDate fechaLlegada, int nroOrden, Cliente cliente) {
		this.container = container;
		this.viaje = viaje;
		this.camion = camion;
		this.chofer = chofer;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.nroOrden = nroOrden;
		this.cliente = cliente;
		servicios = new ArrayList<Servicio>();
	}
		
    public Container getContainer() {
		return container;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public Camion getCamion() {
		return camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	public void agregarServicio(Servicio servicio) {
		servicios.add(servicio);
	}

}
