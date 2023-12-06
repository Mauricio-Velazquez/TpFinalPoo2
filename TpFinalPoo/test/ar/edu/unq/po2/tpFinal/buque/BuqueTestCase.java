package ar.edu.unq.po2.tpFinal.buque;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;


class BuqueTestCase {
	private TerminalGestionada terminalMock;
    private Buque buque;
    private Buque buque1;
    private List<Container> containers;

    @BeforeEach
    public void setUp() {
        terminalMock =  mock(TerminalGestionada.class);
        buque = new Buque(1, terminalMock);
        containers = new ArrayList<>();
    }
    
    @Test
    public void testGetIdentificador() {
        int expectedId = 1;
        int actualId = buque.getIdentificador();
        assertEquals(expectedId, actualId);
    }
    
    @Test
    public void testCalcularMontoTotalServicios() {
    	Container containerMock1 = mock(Container.class);
        Container containerMock2 = mock(Container.class);

        Servicio servicioMock1 = mock(Servicio.class);
        Servicio servicioMock2 = mock(Servicio.class);

        when(containerMock1.getServiciosContratados()).thenReturn(List.of(servicioMock1));
        when(containerMock2.getServiciosContratados()).thenReturn(List.of(servicioMock2));

        containers.add(containerMock1);
        containers.add(containerMock2);

        buque.agregarContainer(containerMock1);
        buque.agregarContainer(containerMock2);

        double costoTotalEsperado = servicioMock1.getCosto() + servicioMock2.getCosto();
        double delta = 0.0001; // la cantidad permitida de diferencia entre dos valores decimales para considerarlos iguales en una comparación
        assertEquals(costoTotalEsperado, buque.calcularMontoTotalServicios(), delta);
    }

    @Test
    public void testGetContainersAsociados() {
        Container containerMock1 = mock(Container.class);
        Container containerMock2 = mock(Container.class);

        containers.add(containerMock1);
        containers.add(containerMock2);

        buque.agregarContainer(containerMock1);
        buque.agregarContainer(containerMock2);

        assertEquals(containers, buque.getContainersAsociados());
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
    
    @Test
    public void testNotificarClienteAlIngresarFaseInbound() {
        // Comprobación inicial: el buque comienza en la fase Outbound
        assertEquals("FaseDeBuqueOutbound", buque.getEstadoActual().toString());

        // Simulamos que el buque está a menos de 50 km de la terminal
        when(terminalMock.obtenerPosicionActual()).thenReturn(new Posicion(10.0, 10.0));
        buque.moverBuque(new Posicion(10.0, 10.0));

        // Verificamos si el buque cambió a la fase Inbound
        assertEquals("FaseDeBuqueInbound", buque.getEstadoActual().toString());

        // Simulamos la notificación al entrar en la fase Inbound
        buque.getEstadoActual().notificarTerminal(buque, terminalMock);

        // Verificamos que se haya notificado al cliente
        verify(terminalMock, times(1)).notificarCliente(buque);
    }
    
    @Test
    public void testNotificarClienteYEnviarFacturaAlIngresarFaseDeparting() {
    	buque1 = new Buque(1, terminalMock);
        // Establecemos directamente el buque en la fase Departing
        buque1.setEstadoActual(new FaseDeBuqueDeparting());
    	
        // Verificamos si el buque está en la fase Departing
        assertEquals("FaseDeBuqueDeparting", buque1.getEstadoActual().toString());

        // Simulamos la notificación al entrar en la fase Departing
        buque1.getEstadoActual().notificarTerminal(buque1, terminalMock);

        // Verificamos que se haya notificado al cliente
        verify(terminalMock, times(1)).notificarCliente(buque1);

        // Verificamos que se haya enviado la factura a cada cliente asociado a una orden del buque
        verify(terminalMock, times(1)).enviarFacturaPorEmail(buque1, terminalMock);
    }




}
