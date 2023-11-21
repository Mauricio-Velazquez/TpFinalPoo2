package ar.edu.unq.po2.tpFinal.empresaTransportista;

import ar.edu.unq.po2.tpFinal.container.Container;

public class Camion {
	private String patente;
	private Container containerCargado;	
	
	public Camion (String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Container getContainerCargado() {
		return containerCargado;
	}

	public void setContainerCargado(Container containerCargado) {
		this.containerCargado = containerCargado;
	}
	
	public void cargarContainer (Container container) {
		if (containerCargado == null) {
			containerCargado = container;
		}
		else {
			System.out.println("El camion ya tiene un contenedor cargado");
		}
	}

	
	//Desde la terminal se debe implementar si se verifican las condiciones para que el camion deje la carga
	//La misma implementacion de verificar condiciones para agarrar la carga
	
}
