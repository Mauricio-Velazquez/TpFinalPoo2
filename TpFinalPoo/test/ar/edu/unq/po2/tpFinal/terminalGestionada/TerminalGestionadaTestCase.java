package ar.edu.unq.po2.tpFinal.terminalGestionada;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.ClienteConsignee;
import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerDry;
import ar.edu.unq.po2.tpFinal.container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorCantidadDeTramos;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorCosto;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMenorTiempo;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.naviera.Tramo;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;

public class TerminalGestionadaTestCase {
	private TerminalGestionada terminal1;
	private TerminalGestionada terminal2;
	private TerminalGestionada terminal3;
	private TerminalGestionada terminal4;
	private Naviera naviera;
	private ClienteShipper cliente1;
	private ClienteConsignee cliente2;
	private ContainerDry container1;
	private ContainerTanque container2;
	private Viaje viaje1;
	private Viaje viaje2;
	private Viaje viaje3;
	private Camion camion1;
	private Chofer chofer1;
	private Camion camion2;
	private Chofer chofer2;
	private Buque buque1;
	private Buque buque2;
	private Buque buque3;
	private Circuito circuito1;
	private Circuito circuito2;
	private Circuito circuito3;
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
		
		container2 = mock(ContainerTanque.class);
		chofer2 = mock(Chofer.class);
		camion2 = new Camion("BBB333", chofer2);
		
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		buque3 = mock(Buque.class);
				
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
		
		circuito3 = mock(Circuito.class);
		
        viaje1 = new Viaje(LocalDate.of(2023, 11, 13), buque1, circuito1);
        viaje2 = new Viaje(LocalDate.of(2023, 11, 15), buque2, circuito2);
        
        viaje3 = mock(Viaje.class);
        when(viaje3.getBuque()).thenReturn(buque3);
        when(viaje3.getCircuito()).thenReturn(circuito3);
        when(viaje3.getFechaSalida()).thenReturn(LocalDate.of(2023, 12, 24));
        when(viaje3.getFechaLlegada()).thenReturn(LocalDate.of(2023, 12, 28));
        
        naviera.agregarBuque(buque1);
        naviera.agregarBuque(buque2);
        naviera.agregarCircuito(circuito1);
        naviera.agregarCircuito(circuito2);
        naviera.agregarViaje(viaje1);
        naviera.agregarViaje(viaje2);
        
        terminal1.registrarLineaNaviera(naviera);
                        
    }
    
    @Test
    public void testNotificarCliente() {
        // Crear mocks de las dependencias necesarias
        Buque buqueMock = mock(Buque.class);
        Orden ordenMock = mock(Orden.class);
        Cliente clienteMock = mock(Cliente.class);
        TerminalGestionada terminal = new TerminalGestionada("TerminalTest", new EstrategiaMenorCantidadDeTramos());

        // Configurar el comportamiento de las dependencias mock
        when(ordenMock.getCliente()).thenReturn(clienteMock);

        // Crear un mock separado para el viaje y configurarlo
        Viaje viajeMock = mock(Viaje.class);
        when(viajeMock.getBuque()).thenReturn(buqueMock);
        when(ordenMock.getViaje()).thenReturn(viajeMock);

        // Agregar la orden mock a la terminal
        terminal.registrarOrden(ordenMock);

        // Llamar al método a testear
        terminal.notificarCliente(buqueMock);

        // Verificar que se llame al método para enviar correo a consignee por cada orden asociada al buque
        verify(clienteMock, times(1)).recibirEmail(anyString()); // Ajustar el número según la cantidad esperada
    }
    
    @Test
    public void testGenerarFacturaViajeYServicios() {
        // Crear mocks de las dependencias necesarias
        Buque buqueMock = mock(Buque.class);
        Container containerMock1 = mock(Container.class);
        Container containerMock2 = mock(Container.class);
        Servicio servicioMock1 = mock(Servicio.class);
        Servicio servicioMock2 = mock(Servicio.class);
        
        List<Container> containersMock = Arrays.asList(containerMock1, containerMock2);

        // Configurar el comportamiento de los mocks
        when(buqueMock.calcularMontoTotalServicios()).thenReturn(100.0);
        when(buqueMock.getContainersAsociados()).thenReturn(containersMock);
        when(containerMock1.getServiciosContratados()).thenReturn(Arrays.asList(servicioMock1));
        when(containerMock2.getServiciosContratados()).thenReturn(Arrays.asList(servicioMock2));

        TerminalGestionada terminal = new TerminalGestionada("TerminalTest", new EstrategiaMenorCantidadDeTramos());

        // Llamar al método a testear
        String factura = terminal.generarFacturaViajeYServicios(buqueMock, "ResponsablePago");

        // Verificar el resultado esperado o alguna condición sobre la factura generada
        assertNotNull(factura);

        // Verificar interacciones o comportamientos específicos si es necesario
        verify(buqueMock, times(1)).calcularMontoTotalServicios();
        verify(buqueMock, times(1)).getContainersAsociados();
        verify(containerMock1, times(1)).getServiciosContratados();
        verify(containerMock2, times(1)).getServiciosContratados();
    }
    
    @Test
    public void testConsultarInicioDeTrabajo() {
      
        // Verificar que el inicio de trabajo devuelve true
        assertTrue(terminal1.consultarInicioDeTrabajo());
    }
    
    @Test
    public void testHabilitarPartida() {
        Buque buque = new Buque(1, terminal1);

        // Verificar que la partida se habilita correctamente
        assertTrue(terminal1.habilitarPartida(buque));
    }
        
    @Test 
    public void testVerificarOrdenDeExportacionCargadaCorrectamente(){
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
		assertEquals(terminal1.cantidadDeOrdenes(), 1);
		assertEquals(cliente1.getOrdenes().size(), 1);
		assertEquals(terminal1.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminal3), viaje1);
		assertTrue(cliente1.getTurnos().stream().anyMatch(turno -> turno.getFechaYHora().equals(LocalDateTime.of(2023, 11, 13, 9, 0))));
	}
    

    @Test
    public void testVerificarCondicionesDeIngresoDeUnShipperEnLaHoraAsignada() {
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertTrue(terminal1.verificarCondicionesDeIngresoDelShipper(cliente1, camion1, chofer1, reloj, 1));
    	assertTrue(terminal1.verificarSiLlegoEnHorarioElShipper(cliente1, 1, reloj));
    }
  
    @Test 
    public void testElShipperNoLlegoEnLaHoraAsignada(){
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(14);
		
    	assertFalse(terminal1.verificarCondicionesDeIngresoDelShipper(cliente1, camion1, chofer1, reloj, 1));
    	assertFalse(terminal1.verificarSiLlegoEnHorarioElShipper(cliente1, 1, reloj));
	}
    
    @Test 
    public void testElChoferDelShipperNoCoincideConElRegistrado(){
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertFalse(terminal1.verificarCondicionesDeIngresoDelShipper(cliente1, camion1, chofer2, reloj, 1));
	}
    
    @Test 
    public void testElCamionDelShipperNoCoincideConElRegistrado(){
        terminal1.exportarA(terminal3, camion1, chofer1, container1, cliente1);
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertFalse(terminal1.verificarCondicionesDeIngresoDelShipper(cliente1, camion2, chofer1, reloj, 1));
	}
    
    @Test 
    public void testVerificarOrdenDeImportacionCargadaCorrectamente(){
        terminal1.importar(camion2, chofer2, container2, cliente2, viaje3);
		assertEquals(terminal1.cantidadDeOrdenes(), 1);
		assertEquals(cliente2.getOrdenes().size(), 1);
	}
    
    @Test
    public void testVerificarCondicionesDeIngresoDeUnConsignee() {
    	terminal1.importar(camion2, chofer2, container2, cliente2, viaje3);
		reloj = mock(Reloj.class);
		when(reloj.getFechaYHora()).thenReturn(LocalDateTime.of(2023, 12, 28, 16, 00));
		
		assertEquals(reloj.getFechaYHora(), LocalDateTime.of(2023, 12, 28, 16, 00));
		assertTrue(terminal1.verificarCondicionesDeIngresoDelConsignee(cliente2, camion2, chofer2, reloj, 1));
		assertEquals(terminal1.getContainers().size(), 0);
		assertEquals(camion2.getContainerCargado(), container2);
    }
    
    @Test
    public void testVerificarCondicionesDeIngresoDeUnConsigneeQueLlegoTresDiasTarde() {
    	terminal1.importar(camion2, chofer2, container2, cliente2, viaje3);
		reloj = mock(Reloj.class);
		when(reloj.getFecha()).thenReturn(LocalDate.of(2023, 12, 31));
		when(reloj.getFechaYHora()).thenReturn(LocalDateTime.of(2023, 12, 31, 16, 00));
		
		assertTrue(terminal1.verificarCondicionesDeIngresoDelConsignee(cliente2, camion2, chofer2, reloj, 1));		
		Servicio servicio = terminal1.getOrdenes()
									 .stream()
									 .filter(o -> o.getNroOrden() == 1)
									 .findFirst()
									 .get()
									 .getServicios()
									 .getFirst();
		assertEquals(servicio.getCosto(), 600, 0.000);
    }
    
    @Test 
    public void testElChoferDelConsigneeNoCoincideConElRegistrado(){
    	terminal1.importar(camion2, chofer2, container2, cliente2, viaje3);
		reloj = mock(Reloj.class);
		when(reloj.getFechaYHora()).thenReturn(LocalDateTime.of(2023, 12, 28, 16, 00));
		
    	assertFalse(terminal1.verificarCondicionesDeIngresoDelConsignee(cliente2, camion2, chofer1, reloj, 1));	
	}
    
    @Test 
    public void testElCamionDelConsigneeNoCoincideConElRegistrado(){
    	terminal1.importar(camion2, chofer2, container2, cliente2, viaje3);
		reloj = mock(Reloj.class);
		when(reloj.getFechaYHora()).thenReturn(LocalDateTime.of(2023, 12, 28, 16, 00));
		
    	assertFalse(terminal1.verificarCondicionesDeIngresoDelConsignee(cliente2, camion1, chofer2, reloj, 1));	
	}
    
    @Test
    public void testRegistroMetodos() {
        Chofer choferMock = mock(Chofer.class);
        Orden ordenMock = mock(Orden.class);
        Cliente clienteMock = mock(Cliente.class);
        EmpresaTransportista empresaMock = mock(EmpresaTransportista.class);

        // Llamar a los métodos de registro de la terminal con los mocks
        terminal1.registrarChofer(choferMock);
        terminal1.registrarOrden(ordenMock);
        terminal1.registrarCliente(clienteMock);
        terminal1.registrarEmpresaTransportista(empresaMock);

        // Verificar si los métodos de adición de la terminal se llamaron con los mocks esperados
        assertTrue(terminal1.getChoferes().contains(choferMock));
        assertTrue(terminal1.getOrdenes().contains(ordenMock));
        assertTrue(terminal1.getClientes().contains(clienteMock));
        assertTrue(terminal1.getEmpresas().contains(empresaMock));
    }
    
    @Test
    public void testObtenerPosicionActualYNombre() {
        // Configuración del mock de GPS
        GPS gpsMock = mock(GPS.class);
        
        // Configuración del TerminalGestionada
        TerminalGestionada terminal = new TerminalGestionada("Terminal", estrategiaMock);
        terminal.setGPS(gpsMock); // Suponiendo que existe un método para configurar el GPS

        // Simulación de comportamiento del método obtenerPosicionActual()
        Posicion posicionMock = new Posicion(10.0, 10.0);
        when(gpsMock.obtenerPosicionActual()).thenReturn(posicionMock);

        // Llamada al método que se está testeando
        Posicion nuevaPosicion = new Posicion(10.0, 10.0); // Nueva posición para actualizar
        terminal.posicionarTerminal(nuevaPosicion);

        // Verificación de que el método utiliza el GPS correctamente y actualiza la posición
        Posicion posicionActual = terminal.obtenerPosicionActual();
        assertNotNull(posicionActual); // Verificar que se devuelve una posición

        // Verificar que la posición se actualizó correctamente
        assertEquals(nuevaPosicion.getLatitud(), posicionActual.getLatitud(), 0.0); // Comparación de la latitud
        assertEquals(nuevaPosicion.getLongitud(), posicionActual.getLongitud(), 0.0); // Comparación de la longitud

        assertEquals("Terminal", terminal.getNombre());
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
    public void testCuantoTardaEnLlegarElViajeDeLaNaviera() {
    	assertEquals(terminal1.cuantoTardaEnLlegar(naviera, terminal4), 50);
    }
    
    @Test
    public void testObtenerCircuitoDeMenorCosto() {
    	assertEquals(terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal4), circuito1);
    }
    
    @Test
    public void testObtenerCircuitoDeMenorTiempo() {
    	terminal1.setEstrategia(new EstrategiaMenorTiempo());
    	assertEquals(terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal4), circuito2);
    }
    
    @Test
    public void testObtenerCircuitoDeMenorCantidadDeTramos() {
    	terminal1.setEstrategia(new EstrategiaMenorCantidadDeTramos());
    	assertEquals(terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal4), circuito2);
    }
    
    @Test
    public void testInvalidoDeObtenerCircuitoDeMenorCosto() {
    	assertThrows(Exception.class, () -> terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal1));
    }
    
    @Test
    public void testInvalidoDeObtenerCircuitoDeMenorTiempo() {
    	terminal1.setEstrategia(new EstrategiaMenorTiempo());
    	assertThrows(Exception.class, () -> terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal1));
    }
    
    @Test
    public void testInvalidoDeObtenerCircuitoDeMenorCantidadDeTramos() {
    	terminal1.setEstrategia(new EstrategiaMenorCantidadDeTramos());
    	assertThrows(Exception.class, () -> terminal1.obtenerMejorCircuitoParaLaTerminalDestino(terminal1));
    }
    
    @Test
    public void testObtenerProximaFechaDeSalidaConTerminalDestino() {
    	assertEquals(terminal1.obtenerProximaFechaDeSalidaConTerminalDestino(terminal2), LocalDate.of(2023, 11, 13));
    }
    
    @Test
    public void testEnviarFacturaPorEmail() {
    	terminal1.enviarFacturaPorEmail(buque1, terminal1);
    }
  
}
