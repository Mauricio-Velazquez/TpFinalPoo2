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
	
	public abstract void realizarOperacion();

    public abstract boolean verificarCondiciones();
	
    public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Camion getCamion() {
		return camion;
	}

	public void setCamion(Camion camion) {
		this.camion = camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDate getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDate fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

}
