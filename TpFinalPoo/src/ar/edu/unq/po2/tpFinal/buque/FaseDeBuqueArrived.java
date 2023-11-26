package ar.edu.unq.po2.tpFinal.buque;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class FaseDeBuqueArrived implements FaseDeBuque {
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueWorking());
	}


	@Override
	public boolean deberiaCambiar(Buque buque,TerminalGestionada terminal ){
		//terminal simbre lista para descarga
		return terminal.consultarInicioDeTrabajo();
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueArrived";
    }


	@Override
	public void notificarTerminal(Buque buque,TerminalGestionada terminal) {
		// TODO Auto-generated method stub
		
	}

}
