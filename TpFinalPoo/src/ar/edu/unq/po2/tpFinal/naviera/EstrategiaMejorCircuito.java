package ar.edu.unq.po2.tpFinal.naviera;

import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public interface EstrategiaMejorCircuito {
	
	public Circuito elegirMejorCircuito(List<Circuito> circuitos, TerminalGestionada terminalDestino);
}
