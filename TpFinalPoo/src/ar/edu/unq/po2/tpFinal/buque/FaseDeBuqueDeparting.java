package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class FaseDeBuqueDeparting implements FaseDeBuque {
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueOutbound());
	}


	@Override
	public boolean deberiaCambiar(Buque buque,TerminalGestionada terminal ) {
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia >1.1; // Cambiar de fase si la distancia es menor a 50 km;
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueDeparting";
    }


	@Override
	public void notificarTerminal(Buque buque,TerminalGestionada terminal) {
		terminal.notificarCliente(buque);
		terminal.enviarFacturaPorEmail(buque,terminal);
	}
}
