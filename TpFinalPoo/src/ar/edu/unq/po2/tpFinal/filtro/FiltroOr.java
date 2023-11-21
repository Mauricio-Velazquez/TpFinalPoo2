package ar.edu.unq.po2.tpFinal.filtro;

import java.util.List;

public class FiltroOr implements Filtro {

	private List<Filtro> filtros;

    public FiltroOr(List<Filtro> filtros) {
        this.filtros = filtros;
    }

    @Override
    public boolean cumpleFiltro(Object elemento) {
        return filtros.stream().anyMatch(filtro -> filtro.cumpleFiltro(elemento));
    }

}
