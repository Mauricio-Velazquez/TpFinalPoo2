package ar.edu.unq.po2.tpFinal.naviera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class Naviera {
	private String nombre;
	private List<Circuito> circuitos;
	private List<Buque> buques;
	private List<Viaje> viajes;
	
	public Naviera(String nombre) {
		this.nombre = nombre;
		circuitos = new ArrayList<Circuito>(); 
		buques = new ArrayList<Buque>(); 
		viajes = new ArrayList<Viaje>(); 
	}
	
    public void agregarCircuito(Circuito circuito) {
        circuitos.add(circuito);
    }

    public void agregarBuque(Buque buque) {
        buques.add(buque);
    }
    	
	public void agregarViaje(Viaje viaje) throws Exception {
		if (!circuitos.contains(viaje.getCircuito()) || !buques.contains(viaje.getBuque())) {
			throw new Exception("Solo pueden agregarse viajes con buques y circuitos que contenga la naviera");	
		}
		viajes.add(viaje);
	}
    
	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Circuito> getCircuitos() {
		return circuitos;
	}

	public void setCircuitos(List<Circuito> circuitos) {
		this.circuitos = circuitos;
	}

	public List<Buque> getBuques() {
		return buques;
	}

	public void setBuques(List<Buque> buques) {
		this.buques = buques;
	}
	
	// Indica si la terminal dada aparece como terminalDestino en alguno de los viajes.	
	public boolean incluyeTerminalDestinoEnLosViajes(TerminalGestionada terminal) {
		return viajes.stream().anyMatch(v -> v.getCircuito().incluyeTerminalDestino(terminal));
	}
	    
}
