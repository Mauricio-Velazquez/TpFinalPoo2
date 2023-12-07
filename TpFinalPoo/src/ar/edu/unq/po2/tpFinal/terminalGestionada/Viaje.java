package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;

public class Viaje {
	private LocalDate fechaSalida;
    private Buque buque;
    private Circuito circuito;
    private LocalDate fechaLlegada;

    public Viaje(LocalDate fechaSalida, Buque buque, Circuito circuito) {
        this.fechaSalida = fechaSalida;
        this.buque = buque;
        this.circuito = circuito;
        this.fechaLlegada = fechaSalida.plusDays(circuito.getTiempoTotal() / 24);
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public Buque getBuque() {
        return buque;
    }

    public Circuito getCircuito() {
        return circuito;
    }
    
	// Calcula y devuelve el tiempo total en horas del circuito.
	public int getTiempoTotal() {
		return circuito.getTiempoTotal();
	}
	
	public boolean incluyeTerminalDestino(TerminalGestionada terminalDestino) {
		return circuito.incluyeTerminalDestino(terminalDestino);
	}
}
