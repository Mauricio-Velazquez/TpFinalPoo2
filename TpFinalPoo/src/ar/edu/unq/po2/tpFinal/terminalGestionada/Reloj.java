package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDateTime;

public class Reloj {
	private LocalDateTime fechaYHora;
	
	public Reloj(){
		fechaYHora = LocalDateTime.now();
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	
	public int getHora() {
		return fechaYHora.getHour();
	}
}
