package ar.edu.unq.po2.tpFinal.buque;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

class BuqueTestCase {
	private TerminalGestionada terminalMock;
    private Buque buque;

    @BeforeEach
    public void setUp() {
        terminalMock =  mock(TerminalGestionada.class);
        buque = new Buque(1, terminalMock);
    }

    @Test
    public void testBuqueCambioDeFase() {
        // Comportamiento esperado: Comenzamos en la fase Outbound
        assertEquals("FaseDeBuqueOutbound", buque.getEstadoActual().toString());

        // Simulamos la llegada del buque a menos de 50 km de la terminal
        Mockito.when(terminalMock.obtenerPosicionActual()).thenReturn(new Posicion(10.0, 10.0));
        buque.moverBuque(new Posicion(10.0, 10.0));

        // Verificamos si el buque cambió a la fase Inbound
        assertEquals("FaseDeBuqueInbound", buque.getEstadoActual().toString());

        // Simulamos el arribo del buque a la terminal
        Mockito.when(terminalMock.obtenerPosicionActual()).thenReturn(new Posicion(1.0, 1.0));
        buque.moverBuque(new Posicion(1.0, 1.0));

        // Verificamos si el buque cambió a la fase Arrived
        assertEquals("FaseDeBuqueArrived", buque.getEstadoActual().toString());

        // Simulamos el inicio de trabajo en la terminal
        Mockito.when(terminalMock.consultarInicioDeTrabajo()).thenReturn(true);
        buque.getEstadoActual().deberiaCambiar(buque, terminalMock);
        buque.moverBuque(new Posicion(1.0, 1.0));

        // Verificamos si el buque cambió a la fase Working
        assertEquals("FaseDeBuqueWorking", buque.getEstadoActual().toString());

        // Simulamos el fin de trabajo y la partida del buque
        Mockito.when(terminalMock.habilitarPartida(buque)).thenReturn(true);
        buque.getEstadoActual().siguienteFase(buque);

        // Verificamos si el buque cambió a la fase Departing
        assertEquals("FaseDeBuqueDeparting", buque.getEstadoActual().toString());

        // Verificamos si la terminal notifica a los clientes al entrar en la fase Inbound
        Mockito.when(terminalMock.obtenerPosicionActual()).thenReturn(new Posicion(10.0, 10.0));
        buque.moverBuque(new Posicion(10.0, 10.0));
        Mockito.verify(terminalMock, Mockito.times(1)).notificarCliente(buque);
    }
}
