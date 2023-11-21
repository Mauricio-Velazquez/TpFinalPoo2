package ar.edu.unq.po2.tpFinal.buque;

public class FaseDeBuqueWorking implements FaseDeBuque{

	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueDeparting());
	}

	@Override
	public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ) {
		return true;
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueWorking";
    }
}
