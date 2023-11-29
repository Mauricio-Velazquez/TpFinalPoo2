package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class FaseDeBuqueInbound implements FaseDeBuque {
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueArrived());
	}
	
	@Override
	public boolean deberiaCambiar(Buque buque,TerminalGestionada terminal){
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia == 0.0; // Cambiar de fase si la distancia es menor a 50 km;
    }
	
	@Override
    public String toString() {
        return "FaseDeBuqueInbound";
    }

	@Override
	public void notificarTerminal(Buque buque,TerminalGestionada terminal) {
		terminal.notificarCliente(buque);
	}
}
