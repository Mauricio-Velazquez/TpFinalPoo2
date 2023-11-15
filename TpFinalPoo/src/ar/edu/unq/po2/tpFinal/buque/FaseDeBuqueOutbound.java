package ar.edu.unq.po2.tpFinal.buque;


public class FaseDeBuqueOutbound implements FaseDeBuque {
	
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueInbound());
	}
	
    @Override
    public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ) {
	    double distancia = buque.calcularDistanciaATerminal();
	    return distancia < 50.0; // Cambiar de fase si la distancia es menor a 50 km;
    }
    
    @Override
    public String toString() {
        return "FaseDeBuqueOutbound";
    }
	

}
