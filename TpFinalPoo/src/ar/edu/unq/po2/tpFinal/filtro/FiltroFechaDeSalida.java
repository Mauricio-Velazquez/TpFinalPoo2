package ar.edu.unq.po2.tpFinal.filtro;

import java.time.LocalDate;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class FiltroFechaDeSalida implements Filtro {
	private LocalDate fechaSalida;
    
    public FiltroFechaDeSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
    	 return viaje.getFechaSalida().isEqual(fechaSalida);
    }
}
