package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDateTime;

public class Turno {
	private LocalDateTime fechaYHora;

	public Turno(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	
	public int getHora() {
		return fechaYHora.getHour();
	}
}
