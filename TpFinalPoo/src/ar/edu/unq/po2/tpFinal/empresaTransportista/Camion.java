package ar.edu.unq.po2.tpFinal.empresaTransportista;

public class Camion {
	private String patente;
	
	public Camion (String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	//Desde la terminal se debe implementar si se verifican las condiciones para que el camion deje la carga
	//La misma implementacion de verificar condiciones para agarrar la carga
	
}
