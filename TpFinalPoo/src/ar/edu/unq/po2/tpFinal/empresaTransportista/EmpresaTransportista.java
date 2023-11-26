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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Camion> getCamiones() {
		return camiones;
	}

	public void setCamiones(List<Camion> camiones) {
		this.camiones = camiones;
	}

	public List<Chofer> getChoferes() {
		return choferes;
	}

	public void setChoferes(List<Chofer> choferes) {
		this.choferes = choferes;
	}
	
	//En la terminal se chequea si los choferes y camiones estan autorizados
	
}
