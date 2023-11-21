package ar.edu.unq.po2.tpFinal.filtro;

import ar.edu.unq.po2.tpFinal.naviera.Circuito;

public class FiltroPuertoDestino implements Filtro {
	private String puertoDestino;

    public FiltroPuertoDestino(String puertoDestino) {
        this.puertoDestino = puertoDestino;
    }
    
    
	@Override
	public boolean cumpleFiltro(Object elemento) {
		if (!(elemento instanceof Circuito)) {
            return false;
        }
		//"castear" un objeto de tipo Object (que es la forma más genérica en Java) 
		//a un objeto del tipo Circuito
        Circuito circuito = (Circuito) elemento;

        return circuito.getTramos().stream()
               .anyMatch(tramo -> tramo.getTerminalDestino()
            		   .getNombre()
            		   .equals(this.puertoDestino));

	}

}
