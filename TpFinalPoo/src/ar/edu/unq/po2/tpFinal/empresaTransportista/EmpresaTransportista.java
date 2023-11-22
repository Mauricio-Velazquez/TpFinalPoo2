package ar.edu.unq.po2.tpFinal.empresaTransportista;

import java.util.ArrayList;
import java.util.List;

public class EmpresaTransportista {
	private int cuit;
	private List<Camion> camiones;
	private List<Chofer> choferes;
	
	public EmpresaTransportista(int cuit) {
		this.cuit = cuit;
		this.camiones = new ArrayList<Camion>();
		this.choferes = new ArrayList<Chofer>();
	}
	
	public void registrarCamion (Camion camion) {
		camiones.add(camion);
	}
	
	public void registrarChofer (Chofer chofer) {
		choferes.add(chofer);
	}

	public int getCuit() {
		return cuit;
	}

	public void setCuit(int cuit) {
		this.cuit = cuit;
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
	
	//En la temrinal se corrobora si los choferes y camiones estan autorizados
	
}
