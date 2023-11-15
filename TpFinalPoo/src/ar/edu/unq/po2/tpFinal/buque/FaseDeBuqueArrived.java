package ar.edu.unq.po2.tpFinal.buque;


public class FaseDeBuqueArrived implements FaseDeBuque {
	
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueWorking());
	}


	@Override
	public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ) {
	    double distancia = buque.calcularDistanciaATerminal();
		// una vez finalizados los trabajos, la terminal habilita su partida mediante la orden
		//“depart”, que lo lleva a la siguiente fase.
		return false;
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueArrived";
    }

	

}
