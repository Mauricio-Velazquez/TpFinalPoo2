package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public interface FaseDeBuque {
	void 	siguienteFase(Buque buque);
	boolean deberiaCambiar(Buque buque,TerminalGestionada terminal);
	void    notificarTerminal(Buque buque,TerminalGestionada terminal);
}
