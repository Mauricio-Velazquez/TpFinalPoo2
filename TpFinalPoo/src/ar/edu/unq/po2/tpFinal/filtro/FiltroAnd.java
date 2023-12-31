package ar.edu.unq.po2.tpFinal.filtro;

import java.util.List;

import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class FiltroAnd implements Filtro {
	 private List<Filtro> filtros;
	 
	 public FiltroAnd(List<Filtro> filtros) {
		 this.filtros = filtros;
	 }

	 @Override
	 public boolean cumpleFiltro(Viaje viaje) {
		 return filtros.stream().allMatch(filtro -> filtro.cumpleFiltro(viaje));
	 }

}
