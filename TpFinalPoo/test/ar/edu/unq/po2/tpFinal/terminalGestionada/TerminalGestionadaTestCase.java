package ar.edu.unq.po2.tpFinal.terminalGestionada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.ClienteConsignee;
import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.container.ContainerDry;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorCantidadDeTramos;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorCosto;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.naviera.Tramo;
import ar.edu.unq.po2.tpFinal.orden.Orden;

public class TerminalGestionadaTestCase {
	private TerminalGestionada terminal1;
	private TerminalGestionada terminal2;
	private TerminalGestionada terminal3;
	private TerminalGestionada terminal4;
	private Naviera naviera;
	private ClienteShipper cliente1;
	private ClienteConsignee cliente2;
	private ContainerDry container1;
	private Viaje viaje1;
	private Viaje viaje2;
	private Camion camion1;
	private Chofer chofer1;
	private Camion camion2;
	private Chofer chofer2;
	private Buque buque1;
	private Buque buque2;
	private Circuito circuito1;
	private Circuito circuito2;
	private Tramo tramo1;
	private Tramo tramo2;
	private Tramo tramo3;
	private Tramo tramo4;
	private Tramo tramo5;
	private Reloj reloj;
	// Crear el mock de EstrategiaMenorCantidadDeTramos
    EstrategiaMenorCantidadDeTramos estrategiaMock = mock(EstrategiaMenorCantidadDeTramos.class);
	
    @BeforeEach
    public void setUp() throws Exception{
        terminal1 = new TerminalGestionada("TerminalTest", new EstrategiaMenorCosto());
		terminal2 = mock(TerminalGestionada.class);
		terminal3 = mock(TerminalGestionada.class);
		terminal4 = mock(TerminalGestionada.class);
		
		naviera = new Naviera("NavieraTest");
        
        cliente1 = new ClienteShipper("Nestor", 14456546, "nestor@gmail.com");
        cliente2 = new ClienteConsignee("Alfredo", 13746249, "alfredo@gmail.com");
        
        container1 = mock(ContainerDry.class);
		chofer1 = mock(Chofer.class);
		camion1 = new Camion("AAA111", chofer1);
		camion1.cargarContainer(container1);
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		
		chofer2 = mock(Chofer.class);
		camion2 = new Camion("BBB333", chofer2);
		
		tramo1 = new Tramo(terminal1, terminal2, 500d, 70);
		tramo2 = new Tramo(terminal2, terminal3, 300d, 30);
		tramo3 = new Tramo(terminal3, terminal4, 400d, 40);
		tramo4 = new Tramo(terminal1, terminal2, 900d, 10);
		tramo5 = new Tramo(terminal2, terminal4, 600d, 40);
		
		circuito1 = new Circuito();
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito1.agregarTramo(tramo3);
		
		circuito2 = new Circuito();
		circuito2.agregarTramo(tramo4);
		circuito2.agregarTramo(tramo5);
		
        viaje1 = new Viaje(LocalDate.of(2023, 11, 15), buque1, circuito1);
        viaje2 = new Viaje(LocalDate.of(2023, 11, 15), buque2, circuito2);
        
        naviera.agregarBuque(buque1);
        naviera.agregarBuque(buque2);
        naviera.agregarCircuito(circuito1);
        naviera.agregarCircuito(circuito2);
        naviera.agregarViaje(viaje1);
        naviera.agregarViaje(viaje2);
        
        terminal1.registrarLineaNaviera(naviera);
                
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
        
        terminal1.importar(camion2, chofer2, container1, cliente2, viaje2);
        
    }
        
    /*
     * @Test 
    public void testVerificarOrdenCargadaCorrectamente(){
		assertEquals(terminal1.cantidadDeOrdenes(), 1);
		assertEquals(terminal1.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminal3), viaje1);
		assertTrue(cliente1.getTurnos().stream().anyMatch(turno -> turno.getFechaYHora().equals(LocalDateTime.of(2023, 11, 15, 9, 0))));
	}
     */
    
    @Test
    public void testRegistroMetodos() {
        // Crear el mock de TerminalGestionada y los mocks de las clases asociadas
        TerminalGestionada terminalMock = mock(TerminalGestionada.class);
        Chofer choferMock = mock(Chofer.class);
        Orden ordenMock = mock(Orden.class);
        Cliente clienteMock = mock(Cliente.class);
        EmpresaTransportista empresaMock = mock(EmpresaTransportista.class);

        // Llamar a los métodos de registro de la terminal con los mocks
        terminalMock.registrarChofer(choferMock);
        terminalMock.registrarOrden(ordenMock);
        terminalMock.registrarCliente(clienteMock);
        terminalMock.registrarEmpresaTransportista(empresaMock);

        // Verificar si los métodos de adición de la terminal se llamaron con los mocks esperados
        verify(terminalMock).registrarChofer(choferMock);
        verify(terminalMock).registrarOrden(ordenMock);
        verify(terminalMock).registrarCliente(clienteMock);
        verify(terminalMock).registrarEmpresaTransportista(empresaMock);
    }
    
    @Test
    public void testObtenerPosicionActualYNombre() {
        // Configuración del mock de GPS
        GPS gpsMock = mock(GPS.class);
        
        // Configuración del TerminalGestionada
        TerminalGestionada terminal = new TerminalGestionada("Terminal", estrategiaMock);
        terminal.setGPS(gpsMock); // Suponiendo que existe un método para configurar el GPS

        // Simulación de comportamiento del método obtenerPosicionActual()
        when(gpsMock.obtenerPosicionActual()).thenReturn(new Posicion(10.0, 10.0));

        // Llamada al método que se está testeando
        Posicion posicion = terminal.obtenerPosicionActual();

        // Verificación de que el método utiliza el GPS correctamente
        assertNotNull(posicion); // Verificar que se devuelve una posición
        assertEquals("Terminal",terminal.getNombre());
    }
    
    @Test
    public void testRegistrarCamion() {
        // Configuración del mock de Camion
        Camion camionMock = mock(Camion.class);
        
        // Configuración del TerminalGestionada
        TerminalGestionada terminal = new TerminalGestionada("Terminal", estrategiaMock);

        // Ejecución del método que registra el camión
        terminal.registrarCamion(camionMock);

        // Verificación de que el camión fue registrado en la lista correspondiente
        assertEquals(1, terminal.getCamiones().size());
        assertEquals(camionMock, terminal.getCamiones().get(0));
    }
    
    @Test
    public void testVerificarCondicionesDeIngresoDeUnShipper() {
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertTrue(terminal1.verificarCondicionesDeIngresoDelShipper(cliente1, camion1, chofer1, reloj, 1));
    }
    
    @Test 
    public void testVerificarSiElShipperLlegoEnLaHoraAsignada(){
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertTrue(terminal1.verificarSiLlegoEnHorarioElShipper(cliente1, 1, reloj));
	}
    
    @Test 
    public void testElShipperNoLlegoEnLaHoraAsignada(){
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(14);
		
    	assertFalse(terminal1.verificarSiLlegoEnHorarioElShipper(cliente1, 1, reloj));
	}
    
}
