package ar.edu.unq.po2.tpFinal.filtro;

import java.util.List;

public class FiltroAnd implements Filtro {
	 private List<Filtro> filtros;
	 
	 public FiltroAnd(List<Filtro> filtros) {
		 this.filtros = filtros;
	 }

	 @Override
	 public boolean cumpleFiltro(Object elemento) {
		 return filtros.stream().allMatch(filtro -> filtro.cumpleFiltro(elemento));
	 }

}
