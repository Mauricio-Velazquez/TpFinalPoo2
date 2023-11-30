package ar.edu.unq.po2.tpFinal.servicio;

import ar.edu.unq.po2.tpFinal.container.Container;

public class ServicioLavado implements Servicio {
	
    private double costoPorMontoSuperior;
    private double costoPorMontoInferior;
    private Container container;

    public ServicioLavado(double costoPorMontoSuperior, double costoPorMontoInferior, Container container) {
        this.costoPorMontoSuperior = costoPorMontoSuperior;
        this.costoPorMontoInferior = costoPorMontoInferior;
        this.container = container;
    }

    @Override
    public double getCosto() {
        return calcularCosto();
    }

    @Override
    public double calcularCosto() {
    	 if (container.getPesoTotal() > 70) {
    	        return costoPorMontoSuperior; // Si el contenedor supera los 70 metros cúbicos
    	    } else {
    	        return costoPorMontoInferior; // Si el contenedor está por debajo de los 70 metros cúbicos
    	    }
    }

    public double getMontoSuperior() {
        return costoPorMontoSuperior;
    }

    public double getMontoInferior() {
        return costoPorMontoInferior;
    }

}
