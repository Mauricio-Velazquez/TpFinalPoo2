package ar.edu.unq.po2.tpFinal.buque;


public class FaseDeBuqueInbound implements FaseDeBuque {
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueArrived());
	}
	
	@Override
	public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ) {
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia == 0.0; // Cambiar de fase si la distancia es menor a 50 km;
    }
	
	@Override
    public String toString() {
        return "FaseDeBuqueInbound";
    }
}
