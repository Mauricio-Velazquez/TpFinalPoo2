package ar.edu.unq.po2.tpFinal.servicio;

public class ServicioPesado implements Servicio {
	private double costo;
	private double pesoRegistrado;
	
	public ServicioPesado(double costo, double pesoRegistrado) {
		this.costo = costo;
	    this.pesoRegistrado = pesoRegistrado; 
	}
	
	public double getPesoRegistrado() {
		return pesoRegistrado;
	}
		
	@Override
	public double getCosto() {
		return costo;
	}
	
	@Override
	public double calcularCosto() {
		return costo; // El costo es fijo
	}

}
