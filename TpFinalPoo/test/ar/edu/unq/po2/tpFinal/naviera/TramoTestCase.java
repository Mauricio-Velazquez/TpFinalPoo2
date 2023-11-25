package ar.edu.unq.po2.tpFinal.naviera;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class TramoTestCase {
	private TerminalGestionada terminal1; 
	private TerminalGestionada terminal2; 
	private TerminalGestionada terminal3;
	private Tramo tramo1; 
	private Tramo tramo2; 

	@BeforeEach
	void setUp() {
		terminal1 = mock(TerminalGestionada.class);
		terminal2 = mock(TerminalGestionada.class);
		terminal3 = mock(TerminalGestionada.class);
		tramo1 = new Tramo(terminal1, terminal2, 150d, 20);
		tramo2 = new Tramo(terminal2, terminal3, 230d, 30);
	}

	@Test
	void testTramoIncluyeTerminal() {
		assertTrue(tramo1.incluyeTerminal(terminal1));
	}

	@Test
	void testTramoNoIncluyeTerminal() {
		assertFalse(tramo2.incluyeTerminal(terminal1));
	}

}
