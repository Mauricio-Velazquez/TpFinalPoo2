package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.filtro.FiltroAnd;
import ar.edu.unq.po2.tpFinal.filtro.FiltroFechaDeLlegada;
import ar.edu.unq.po2.tpFinal.filtro.FiltroFechaDeSalida;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalGestionadaFiltroTestCase {
	 private TerminalGestionada terminal;
	    private Viaje viaje1;
	    private Viaje viaje2;

	    @BeforeEach
	    public void setUp() {
	        terminal = new TerminalGestionada("TerminalTest");

	        viaje1 = new Viaje(LocalDate.of(2023, 11, 15), null, null, LocalDate.of(2023, 12, 1));
	        viaje2 = new Viaje(LocalDate.of(2023, 11, 20), null, null, LocalDate.of(2023, 12, 5));

	        terminal.agregarViaje(viaje1);
	        terminal.agregarViaje(viaje2);
	    }

	    @Test
	    public void testFiltroFechaDeLlegada() {
	        FiltroFechaDeLlegada filtro1 = new FiltroFechaDeLlegada(LocalDate.of(2023, 12, 1));
	        FiltroFechaDeSalida filtro2 = new FiltroFechaDeSalida(LocalDate.of(2023, 11, 15));
	        List<Filtro> filtros= new ArrayList<Filtro>();
	        filtros.add(filtro1);
	        filtros.add(filtro2);
	        FiltroAnd filtro = new FiltroAnd(filtros);
	        List<Viaje> viajesFiltrados = terminal.obtenerViajesPorFiltro(filtro);

	        assertEquals(1, viajesFiltrados.size());
	     
	    }

}
