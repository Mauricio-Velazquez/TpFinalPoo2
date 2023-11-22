package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDateTime;

public class Turno {
	private LocalDateTime fechaHora;

	public Turno(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}
