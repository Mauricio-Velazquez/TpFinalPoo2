package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.filtro.FiltroAnd;
import ar.edu.unq.po2.tpFinal.filtro.FiltroPuertoDestino;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.Tramo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TerminalGestionadaFiltroTestCase {
	 private TerminalGestionada terminalGestionada;

	    @BeforeEach
	    public void setUp() {
	        terminalGestionada = new TerminalGestionada("Mi Terminal");

	        TerminalGestionada terminalOrigen = new TerminalGestionada("terminalOrigen");
	        TerminalGestionada terminalDestino = new TerminalGestionada("terminalDestino");
	        Circuito circuito1 = new Circuito();
	        circuito1.agregarTramo(new Tramo(terminalOrigen, terminalDestino, 200, 10, 1.1));
	        circuito1.agregarTramo(new Tramo(terminalOrigen, terminalDestino, 200, 10, 1.1));

	        Circuito circuito2 = new Circuito();
	        circuito2.agregarTramo(new Tramo(terminalOrigen, terminalDestino, 200, 10, 1.1));
	        circuito2.agregarTramo(new Tramo(terminalOrigen, terminalOrigen, 200, 10, 1.1)); // Tramo con destino distinto

	        terminalGestionada.registrarCircuitoMaritimo(circuito1);
	        terminalGestionada.registrarCircuitoMaritimo(circuito2);
	    }
	    @Test
	    public void testBuscarRutasPorPuertoDestino() {
	    	// Creamos un filtro con el nombre del puerto destino a buscar
	        FiltroPuertoDestino filtroPuertoDestino = new FiltroPuertoDestino("terminalDestino");
	        FiltroPuertoDestino filtroPuertoDestino1 = new FiltroPuertoDestino("terminalOrigen");
	        // Creamos un filtro AND con el filtro de puerto destino
	        FiltroAnd filtroAnd = new FiltroAnd(List.of(filtroPuertoDestino,filtroPuertoDestino1));

	        // Ejecutamos la búsqueda
	        List<Circuito> rutasFiltradas = terminalGestionada.buscarRutas(filtroAnd);

	        // Verificamos que se encuentren solo los circuitos que tengan el puerto destino esperado
	        assertEquals(1, rutasFiltradas.size());
	    }

}
