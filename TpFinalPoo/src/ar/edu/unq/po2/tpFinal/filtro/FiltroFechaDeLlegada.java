package ar.edu.unq.po2.tpFinal.filtro;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class FiltroFechaDeLlegada implements Filtro {
	private LocalDate fechaLlegada;
    
    public FiltroFechaDeLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
    	 return viaje.getFechaLlegada()== fechaLlegada;
    }
}
