package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class FaseDeBuqueOutbound implements FaseDeBuque {
	
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueInbound());
	}
	
    @Override
    public boolean deberiaCambiar(Buque buque,TerminalGestionada terminal) {
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia < 50.0; // Cambiar de fase si la distancia es menor a 50 km;
    }
    
    @Override
    public String toString() {
        return "FaseDeBuqueOutbound";
    }

	@Override
	public void notificarTerminal(Buque buque,TerminalGestionada terminal) {
		// TODO Auto-generated method stub
		
	}
	

}
