package ar.edu.unq.po2.tpFinal.naviera;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class CircuitoTestCase {
	private TerminalGestionada terminal1; 
	private TerminalGestionada terminal2; 
	private TerminalGestionada terminal3;
	private TerminalGestionada terminal4; 
	private TerminalGestionada terminal5; 
	private TerminalGestionada terminal6;
	private Circuito circuito1;
	private Tramo tramo1; 
	private Tramo tramo2;
	private Tramo tramo3; 
	private Tramo tramo4;
	
	@BeforeEach
	public void setUp() {
		terminal1 = mock(TerminalGestionada.class);
		terminal2 = mock(TerminalGestionada.class);
		terminal3 = mock(TerminalGestionada.class);
		terminal4 = mock(TerminalGestionada.class);
		terminal5 = mock(TerminalGestionada.class);
		terminal6 = mock(TerminalGestionada.class);
		tramo1 = new Tramo(terminal1, terminal2, 150d, 20);
		tramo2 = new Tramo(terminal2, terminal3, 230d, 30);
		tramo3 = new Tramo(terminal3, terminal4, 75d, 10);
		tramo4 = new Tramo(terminal4, terminal5, 120d, 15);
		circuito1 = new Circuito();
	}

	@Test
	public void agregarTramoACircuitoVacio() throws Exception {
		circuito1.agregarTramo(tramo1);
		assertEquals(circuito1.cantidadDeTramos(), 1);
	}
	
	@Test
	public void agregarTramoInvalidoACircuito() throws Exception {
		circuito1.agregarTramo(tramo1);
		assertThrows(Exception.class, () -> circuito1.agregarTramo(tramo4));
	}

	@Test
	public void testObtenerUltimoTramo() throws Exception {
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.getUltimoTramo(), tramo4);
	}
	
	@Test
	public void testObtenerPrimeraTerminalOrigenYUltimaTerminalDestino() throws Exception {
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.getTerminalOrigen(), tramo2.getTerminalOrigen());
		assertEquals(circuito1.getTerminalDestino(), tramo4.getTerminalDestino());
	}
	
	@Test
	public void testCircuitoIncluyeTerminal() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		assertTrue(circuito1.incluyeTerminal(terminal3));
	}
	
	@Test
	public void testCircuitoNoIncluyeTerminal() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		assertFalse(circuito1.incluyeTerminal(terminal6));
	}
	
	@Test
	public void testTiempoTotalDelCircuito() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.getTiempoTotal(), 75);
	}
	
	@Test
	public void testCostoTotalDelCircuito() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.getCostoTotal(), 575);
	}
	
	@Test
	public void testCantidadDeTramosHastaUnaDeterminadaTerminalDestino() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.cantidadDeTramosHasta(terminal4), 3);
	}
	
	@Test
	public void testCantidadDeTramosHastaUnaTerminalDestinoQueNoExiste() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.cantidadDeTramosHasta(terminal6), 0);
	}
	
	@Test
	public void testCostoHastaUnaDeterminadaTerminalDestino() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.costoHasta(terminal4), 455);
	}
	
	@Test
	public void testCostoHastaUnaTerminalDestinoQueNoExiste() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.costoHasta(terminal6), 0);
	}
	
	@Test
	public void testTiempoHastaUnaDeterminadaTerminalDestino() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.tiempoHasta(terminal4), 60);
	}
	
	@Test
	public void testTiempoHastaUnaTerminalDestinoQueNoExiste() throws Exception {
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		circuito1.agregarTramo(tramo4);
		assertEquals(circuito1.tiempoHasta(terminal6), 0);
	}
}
