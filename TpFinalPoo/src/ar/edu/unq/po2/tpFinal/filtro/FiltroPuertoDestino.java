package ar.edu.unq.po2.tpFinal.filtro;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;


public class FiltroPuertoDestino implements Filtro {
	private TerminalGestionada terminalDestino;
    
    public FiltroPuertoDestino(TerminalGestionada terminalDestino) {
        this.terminalDestino = terminalDestino;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
        return viaje.getCircuito().getTramos().stream()
            .anyMatch(tramo -> tramo.incluyeTerminalDestino(this.terminalDestino));
    }
}
