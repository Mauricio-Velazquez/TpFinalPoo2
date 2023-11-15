package ar.edu.unq.po2.tpFinal.buque;

public class FaseDeBuqueDeparting implements FaseDeBuque {
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueOutbound());
	}


	@Override
	public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ) {
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia >1.1; // Cambiar de fase si la distancia es menor a 50 km;
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueDeparting";
    }
}
