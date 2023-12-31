package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.container.Container;

public class Camion {
	private String patente;
	private Container containerCargado;	
	private Chofer chofer;
	
	public Camion (String patente, Chofer chofer) {
		this.patente = patente;
		this.chofer = chofer;
	}

	public String getPatente() {
		return patente;
	}

	public Chofer getChofer() {
		return chofer;
	}

	public Container getContainerCargado() {
		return containerCargado;
	}

	public void cargarContainer (Container container) {
		if (containerCargado == null) {
			containerCargado = container;
		}
		else {
			System.out.println("El camion ya tiene un container cargado");
		}
	}

	public void descargarContainer() {
		if (containerCargado != null) {
			containerCargado = null;
		}
		else {
			System.out.println("El camion no tiene ningun container cargado");
		}
	}
		
}
