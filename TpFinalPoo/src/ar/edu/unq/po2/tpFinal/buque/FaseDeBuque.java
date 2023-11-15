package ar.edu.unq.po2.tpFinal.buque;

public interface FaseDeBuque {
	void 	siguienteFase(Buque buque);
	boolean deberiaCambiar(Buque buque,Posicion ubicacionTerminal);
}
