package ar.edu.unq.po2.tpFinal.servicio;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioLavado implements Servicio {
	
    private double costo;
    private double montoSuperior;
    private double montoInferior;
    private Container container;

    public ServicioLavado(double costo,
    	double montoSuperior, double montoInferior,Container container) {
        
        this.costo = costo;
        this.montoSuperior = montoSuperior;
        this.montoInferior = montoInferior;
        this.container = container;
    }

    @Override
    public double getCosto() {
        return costo;
    }

    @Override
    public double calcularCosto() {
    	 if (container.getPesoTotal() > 70) {
    	        return montoSuperior; // Si el contenedor supera los 70 metros cúbicos
    	    } else {
    	        return montoInferior; // Si el contenedor está por debajo de los 70 metros cúbicos
    	    }
    }

    public double getMontoSuperior() {
        return montoSuperior;
    }

    public void setMontoSuperior(double montoSuperior) {
        this.montoSuperior = montoSuperior;
    }

    public double getMontoInferior() {
        return montoInferior;
    }

    public void setMontoInferior(double montoInferior) {
        this.montoInferior = montoInferior;
    }
}
