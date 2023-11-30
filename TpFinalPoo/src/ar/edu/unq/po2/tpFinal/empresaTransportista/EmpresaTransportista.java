package ar.edu.unq.po2.tpFinal.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
	private String nombre;
	private List<Camion> camiones;
	private List<Chofer> choferes;
	
	public EmpresaTransportista(String nombre) {
		this.nombre = nombre;
		this.camiones = new ArrayList<Camion>();
		this.choferes = new ArrayList<Chofer>();
	}
	
	public void registrarCamion (Camion camion) {
		camiones.add(camion);
	}
	
	public void registrarChofer (Chofer chofer) {
		choferes.add(chofer);
	}

	public String getNombre() {
		return nombre;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}
		
}
