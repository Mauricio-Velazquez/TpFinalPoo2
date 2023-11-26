package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class FaseDeBuqueWorking implements FaseDeBuque{

	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueDeparting());
	}

	@Override
	public boolean deberiaCambiar(Buque buque,TerminalGestionada terminal ) {
		return terminal.habilitarPartida(buque);
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueWorking";
    }

	@Override
	public void notificarTerminal(Buque buque,TerminalGestionada terminal) {
		// TODO Auto-generated method stub
		
	}
}
