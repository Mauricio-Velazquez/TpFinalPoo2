package ar.edu.unq.po2.tpFinal.filtro;

import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class FiltroOr implements Filtro {

	private List<Filtro> filtros;

    public FiltroOr(List<Filtro> filtros) {
        this.filtros = filtros;
    }

    @Override
    public boolean cumpleFiltro(Viaje viaje) {
        return filtros.stream().anyMatch(filtro -> filtro.cumpleFiltro(viaje));
    }

}
