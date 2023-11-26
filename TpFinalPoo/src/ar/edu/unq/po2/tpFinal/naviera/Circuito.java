package ar.edu.unq.po2.tpFinal.naviera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class Circuito {
	private List<Tramo> tramos;

	public Circuito() {
		tramos = new ArrayList<Tramo>(); 
	}

	public List<Tramo> getTramos() {
		return tramos;
	}

	public int cantidadDeTramos() {
		return tramos.size();
	}
		
	// Agrega el tramo solo si la terminalOrigen del tramo a agregar coincide con la terminalDestino del último tramo de la lista.
	public void agregarTramo(Tramo tramo) throws Exception {
	    if (!tramos.isEmpty()) {
	        Tramo ultimoTramo = getUltimoTramo(); 
	        if (!(tramo.getTerminalOrigen().equals(ultimoTramo.getTerminalDestino()))) {
	            throw new Exception("La terminalOrigen del tramo a agregar no coincide con la terminalDestino del ultimo tramo");
	        }
	    }
	    tramos.add(tramo);
	}
	
	// Obtiene el último tramo de la lista, la lista no debe estar vacía.
	public Tramo getUltimoTramo() {
		return tramos.get(cantidadDeTramos() - 1); 
	}
	
	// Calcula y devuelve el tiempo total en horas de todos los tramos.
	public int getTiempoTotal() {
		return tramos.stream().mapToInt(t -> t.getTiempoEstimadoEnHoras()).sum();
	}
	
	// Calcula y devuelve el costo total de todos los tramos.
	public double getCostoTotal() {
		return tramos.stream().mapToDouble(t -> t.getCosto()).sum();
	}
	
	// Indica si la terminal dada aparece como terminalOrigen o terminalDestino en alguno de los tramos del circuito.	
	public boolean incluyeTerminal(TerminalGestionada terminal) {
		return tramos.stream().anyMatch(tramo -> tramo.incluyeTerminal(terminal));
	}
	
	// Obtiene la primera terminalOrigen, la lista de tramos no debe estar vacía.
	public TerminalGestionada getTerminalOrigen() {
		return tramos.get(0).getTerminalOrigen(); 
	}
	
	// Obtiene la última terminalDestino, la lista de tramos no debe estar vacía.
	public TerminalGestionada getTerminalDestino() {
		return getUltimoTramo().getTerminalDestino(); 
	}
}