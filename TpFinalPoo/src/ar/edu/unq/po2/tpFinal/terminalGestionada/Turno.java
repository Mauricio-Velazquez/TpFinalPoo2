package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDateTime;

public class Turno {
	private LocalDateTime fechaYHora;
	private int nroOrden;

	public Turno(LocalDateTime fechaYHora, int nroOrden) {
		this.fechaYHora = fechaYHora;
		this.nroOrden = nroOrden;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	
	public int getHora() {
		return fechaYHora.getHour();
	}

	public int getNroOrden() {
		return nroOrden;
	}
	
}
