package ar.edu.unq.po2.tpFinal.terminalGestionada;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;

public class Viaje {
	private LocalDate fechaInicio;
    private Buque buque;
    private Circuito circuito;
    private LocalDate fechaLlegada;

    public Viaje(LocalDate fechaInicio, Buque buque, Circuito circuito,LocalDate fechaLlegada) {
        this.fechaInicio = fechaInicio;
        this.buque = buque;
        this.circuito = circuito;
        this.fechaLlegada = fechaLlegada;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Buque getBuque() {
        return buque;
    }

    public void setBuque(Buque buque) {
        this.buque = buque;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }
}
