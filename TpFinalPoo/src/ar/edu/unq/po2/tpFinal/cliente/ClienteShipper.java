package ar.edu.unq.po2.tpFinal.cliente;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Turno;

public class ClienteShipper extends Cliente {
	private List<Turno> turnos;

	public ClienteShipper(String nombre, int dni, String mail) {
		super(nombre, dni, mail);
		turnos = new ArrayList<Turno>();
	}
	
	public void agregarTurno(Turno turno){
		turnos.add(turno);
	}
	
	public List<Turno> getTurnos() {
		return turnos;
	}

}
