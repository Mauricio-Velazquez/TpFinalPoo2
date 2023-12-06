package ar.edu.unq.po2.tpFinal.naviera;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class NavieraTestCase {
	private TerminalGestionada terminal1;
	private TerminalGestionada terminal2;
	private Naviera naviera;
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	private Buque buque1;
	private Buque buque2;
	private Buque buque3;
	private Circuito circuito1;
	private Circuito circuito2;
	private Circuito circuito3;
	
    @BeforeEach
    public void setUp() throws Exception{
        terminal1 = new TerminalGestionada("TerminalTest", new EstrategiaMenorCosto());
        terminal2 = mock(TerminalGestionada.class);
		
		naviera = new Naviera("NavieraTest");
        
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		buque3 = mock(Buque.class);
		
		circuito1 = mock(Circuito.class);	
		circuito2 = mock(Circuito.class);
		circuito3 = mock(Circuito.class);
		
        viaje1 = new Viaje(LocalDate.of(2023, 11, 15), buque1, circuito1);
        viaje2 = new Viaje(LocalDate.of(2023, 12, 23), buque2, circuito2);
        viaje3 = new Viaje(LocalDate.of(2023, 10, 7), buque3, circuito3);
        
        naviera.agregarBuque(buque1);
        naviera.agregarBuque(buque2);
        naviera.agregarCircuito(circuito1);
        naviera.agregarCircuito(circuito2);
    }
        
	@Test
	public void agregarViajeANaviera() throws Exception {
		String nombreEsperado = "NavieraTest";
        naviera.agregarViaje(viaje1);
        naviera.agregarViaje(viaje2);
		assertEquals(naviera.getViajes().size(), 2);
		assertEquals(naviera.getCircuitos().size(), 2);
		assertEquals(naviera.getBuques().size(), 2);
		assertTrue(naviera.getNombre().equals(nombreEsperado));
	}
	
	@Test
	public void agregarViajeInvalidoANaviera() throws Exception {
		assertThrows(Exception.class, () -> naviera.agregarViaje(viaje3));
	}
	
	@Test
	public void testCircuitosConLaTerminalDada() throws Exception {
        naviera.agregarViaje(viaje1);
        naviera.agregarViaje(viaje2);
		when(circuito1.incluyeTerminal(terminal1)).thenReturn(true);
		when(circuito2.incluyeTerminalDestino(terminal2)).thenReturn(true);
		assertEquals(naviera.circuitosConLaTerminal(terminal1).size(), 1);
		assertTrue(naviera.incluyeTerminalDestinoEnLosViajes(terminal2));
	}
}
