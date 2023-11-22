package ar.edu.unq.po2.tpFinal.orden;

import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;

public abstract class Orden {
	private Container container;
	private Buque buque;
	private Camion Camion;
	private Chofer chofer;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private int nroOrden;
	private Cliente cliente;
	private int horaLLegada;
	private int horaSalida;
	private Servicio sericio;

	public Orden(Container container, Buque buque, ar.edu.unq.po2.tpFinal.empresaTransportista.Camion camion,
			Chofer chofer, LocalDateTime fechaSalida, LocalDateTime fechaLlegada, int nroOrden, Cliente cliente,
			int horaLLegada, int horaSalida, Servicio sericio) {
		super();
		this.container = container;
		this.buque = buque;
		Camion = camion;
		this.chofer = chofer;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.nroOrden = nroOrden;
		this.cliente = cliente;
		this.horaLLegada = horaLLegada;
		this.horaSalida = horaSalida;
		this.sericio = sericio;
	}
	
	public abstract void realizarOperacion();

    public abstract boolean verificarCondiciones();
	
    public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Buque getBuque() {
		return buque;
	}

	public void setBuque(Buque buque) {
		this.buque = buque;
	}

	public Camion getCamion() {
		return Camion;
	}

	public void setCamion(Camion camion) {
		Camion = camion;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public void setChofer(Chofer chofer) {
		this.chofer = chofer;
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDateTime fechaLlegada) {
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

	public int getHoraLLegada() {
		return horaLLegada;
	}

	public void setHoraLLegada(int horaLLegada) {
		this.horaLLegada = horaLLegada;
	}

	public int getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Servicio getSericio() {
		return sericio;
	}

	public void setSericio(Servicio sericio) {
		this.sericio = sericio;
	}
	
	
}
