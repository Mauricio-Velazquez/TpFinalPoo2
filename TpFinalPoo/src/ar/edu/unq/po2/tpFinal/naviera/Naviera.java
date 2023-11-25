package ar.edu.unq.po2.tpFinal.naviera;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.buque.Buque;

public class Naviera {
	private String nombre;
	private List<Circuito> circuitos;
	private List<Buque> buques;
	
	public Naviera(String nombre) {
		this.nombre = nombre;
		circuitos = new ArrayList<Circuito>(); 
		buques = new ArrayList<Buque>(); 
	}
	
    public void agregarCircuito(Circuito circuito) {
        circuitos.add(circuito);
    }

    public void agregarBuque(Buque buque) {
        buques.add(buque);
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
	
	// Calcula y devuelve el tiempo total en horas de todos los circuitos.
    public int getTiempoTotalEstimadoDeLosCircuitos() {
        return circuitos.stream().mapToInt(c -> c.getTiempoTotal()).sum();
    }
	
}
