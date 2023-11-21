package ar.edu.unq.po2.tpFinal.buque;


public class FaseDeBuqueArrived implements FaseDeBuque {
	@Override
	public void siguienteFase(Buque buque) {
		buque.setEstadoActual(new FaseDeBuqueWorking());
	}


	@Override
	public boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal ){
		
		return true;
	}
	
	@Override
    public String toString() {
        return "FaseDeBuqueArrived";
    }

}
