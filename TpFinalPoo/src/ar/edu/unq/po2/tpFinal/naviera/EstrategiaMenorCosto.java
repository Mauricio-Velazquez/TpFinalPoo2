package ar.edu.unq.po2.tpFinal.naviera;

import java.util.Comparator;
import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class EstrategiaMenorCosto implements EstrategiaMejorCircuito {
	
	@Override	
	public Circuito elegirMejorCircuito(List<Circuito> circuitos, TerminalGestionada terminalDestino) {
    	return circuitos.stream()
    			.filter(c -> c.incluyeTerminalDestino(terminalDestino))
    			.min(Comparator.comparingDouble(c -> c.costoHasta(terminalDestino)))
    			.orElseThrow(() -> new RuntimeException("No se encontró un circuito con la terminalDestino dada."));
    }
}
