package ar.edu.unq.po2.tpFinal.servicio;

public class ServicioPesado implements Servicio {
	private double costo;
	private double pesoRegistrado;
	
	public ServicioPesado(double costo) {
		this.costo = costo;
	    this.pesoRegistrado = 0.0; // Inicialmente el peso registrado es 0
	}
	
	public double getPesoRegistrado() {
		return pesoRegistrado;
	}
	
	public void setPesoRegistrado(double pesoRegistrado) {
        this.pesoRegistrado = pesoRegistrado;
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
