package ar.edu.unq.po2.tpFinal.naviera;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
	private List<Tramo> tramos;

	public Circuito(){
		tramos = new ArrayList<Tramo>(); 
	}

	public List<Tramo> getTramos() {
		return tramos;
	}

	public void setTramos(List<Tramo> tramos) {
		this.tramos = tramos;
	}

	public void agregarTramo(Tramo tramo) {
		tramos.add(tramo);
	}
	
	// Calcula y devuelve el tiempo total estimado de todos los tramos.
	public int getTiempoTotalEstimadoDeLosTramos() {
		return tramos.stream().mapToInt(t -> t.getTiempoEstimadoEnHoras()).sum();
	}
	
}