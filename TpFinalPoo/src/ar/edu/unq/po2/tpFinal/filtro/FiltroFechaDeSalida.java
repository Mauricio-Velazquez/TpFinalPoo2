package ar.edu.unq.po2.tpFinal.filtro;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class FiltroFechaDeSalida implements Filtro {
	private LocalDate fechaInicio;
    
    public FiltroFechaDeSalida(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
    	 return viaje.getFechaInicio()== fechaInicio;
    }
}
