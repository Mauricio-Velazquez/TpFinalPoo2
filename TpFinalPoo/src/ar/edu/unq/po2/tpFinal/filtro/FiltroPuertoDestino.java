package ar.edu.unq.po2.tpFinal.filtro;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;


public class FiltroPuertoDestino implements Filtro {
	private String puertoDestino;
    
    public FiltroPuertoDestino(String puertoDestino) {
        this.puertoDestino = puertoDestino;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
        return viaje.getCircuito().getTramos().stream()
            .anyMatch(tramo -> tramo.getTerminalDestino().getNombre().equals(this.puertoDestino));
    }
}
