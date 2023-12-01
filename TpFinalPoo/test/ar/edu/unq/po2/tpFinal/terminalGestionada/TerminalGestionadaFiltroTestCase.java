package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.filtro.FiltroAnd;
import ar.edu.unq.po2.tpFinal.filtro.FiltroFechaDeLlegada;
import ar.edu.unq.po2.tpFinal.filtro.FiltroFechaDeSalida;
import ar.edu.unq.po2.tpFinal.filtro.FiltroOr;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorCosto;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.naviera.Tramo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TerminalGestionadaFiltroTestCase {
	 private TerminalGestionada terminal1;
	 private TerminalGestionada terminal2;
	 private TerminalGestionada terminal3;
	 private TerminalGestionada terminal4;
	 private Naviera naviera;
	 private Viaje viaje1;
	 private Viaje viaje2;
	 private Buque buque1;
	 private Buque buque2;
	 private Tramo tramo1;
	 private Tramo tramo2;
	 private Tramo tramo3;
	 private Circuito circuito1;
	 
	 @BeforeEach
	 public void setUp() throws Exception {
		 terminal1 = new TerminalGestionada("TerminalTest", new EstrategiaMenorCosto());
		 terminal2 = mock(TerminalGestionada.class);
		 terminal3 = mock(TerminalGestionada.class);
		 terminal4 = mock(TerminalGestionada.class);
		 naviera = new Naviera("NavieraTest");
		 
		 buque1 = mock(Buque.class);
		 buque2 = mock(Buque.class);
		 
		 tramo1 = new Tramo(terminal1, terminal2, 500d, 100);
		 tramo2 = new Tramo(terminal2, terminal3, 300d, 200);
		 tramo3 = new Tramo(terminal3, terminal4, 400d, 84);
					
		 circuito1 = new Circuito();
		 circuito1.agregarTramo(tramo1);
		 circuito1.agregarTramo(tramo2);
		 circuito1.agregarTramo(tramo3);

	     viaje1 = new Viaje(LocalDate.of(2023, 11, 15), buque1, circuito1);
	     viaje2 = new Viaje(LocalDate.of(2023, 11, 20), buque2, circuito1);

	     naviera.agregarBuque(buque1);
	     naviera.agregarBuque(buque2);
	     naviera.agregarCircuito(circuito1);
	     naviera.agregarViaje(viaje1);
	     naviera.agregarViaje(viaje2);
	     
	     terminal1.registrarLineaNaviera(naviera);
	 }
	 
	 @Test
	 public void testFiltroAnd() {
        FiltroFechaDeLlegada filtro1 = new FiltroFechaDeLlegada(LocalDate.of(2023, 12, 1));
        FiltroFechaDeSalida filtro2 = new FiltroFechaDeSalida(LocalDate.of(2023, 11, 15));
        List<Filtro> filtros = new ArrayList<Filtro>();
        filtros.add(filtro1);
        filtros.add(filtro2);
        FiltroAnd filtro = new FiltroAnd(filtros);
        List<Viaje> viajesFiltrados = terminal1.obtenerViajesPorFiltro(filtro);

        assertEquals(1, viajesFiltrados.size());
        assertEquals(viaje1, viajesFiltrados.getFirst());
     }
	 
	 @Test
	 public void testFiltroOr() {
        FiltroFechaDeLlegada filtro1 = new FiltroFechaDeLlegada(LocalDate.of(2023, 12, 1));
        FiltroFechaDeSalida filtro2 = new FiltroFechaDeSalida(LocalDate.of(2023, 11, 15));
        List<Filtro> filtros = new ArrayList<Filtro>();
        filtros.add(filtro1);
        filtros.add(filtro2);
        FiltroOr filtro = new FiltroOr(filtros);
        List<Viaje> viajesFiltrados = terminal1.obtenerViajesPorFiltro(filtro);

        assertEquals(1, viajesFiltrados.size());
        assertEquals(viaje1, viajesFiltrados.getFirst());
     }

}
