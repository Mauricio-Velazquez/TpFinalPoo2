package ar.edu.unq.po2.tpFinal.orden;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.cliente.ClienteConsignee;
import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.container.ContainerDry;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.Tramo;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Reloj;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenTestCase {
	private TerminalGestionada terminal1;
	private TerminalGestionada terminal2;
	private TerminalGestionada terminal3;
	private TerminalGestionada terminal4;
	private ClienteShipper cliente1;
	private ClienteConsignee cliente2;
	private ContainerDry container1;
	private Viaje viaje1;
	private Viaje viaje2;
	private Camion camion1;
	private Chofer chofer1;
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
	
    @BeforeEach
    public void setUp() throws Exception{
        terminal1 = new TerminalGestionada("TerminalTest");
		terminal2 = mock(TerminalGestionada.class);
		terminal3 = mock(TerminalGestionada.class);
		terminal4 = mock(TerminalGestionada.class);
        
        cliente1 = new ClienteShipper("Nestor", 14456546, "nestor@gmail.com");
        cliente2 = new ClienteConsignee("Alfredo", 13746249, "alfredo@gmail.com");
        
        container1 = mock(ContainerDry.class);
		chofer1 = mock(Chofer.class);
		camion1 = new Camion("AAA111", chofer1);
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		
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
        viaje1 = new Viaje(LocalDate.of(2023, 11, 15), buque1, circuito1, LocalDate.of(2023, 11, 19));
        viaje2 = new Viaje(LocalDate.of(2023, 11, 15), buque2, circuito2, LocalDate.of(2023, 11, 17));
        terminal1.agregarViaje(viaje1);
        terminal1.agregarViaje(viaje2);
        
        terminal1.registrarCliente(cliente1);
        terminal1.registrarCliente(cliente2);
        
        cliente1.enviarOrden(terminal1, container1, camion1, new ArrayList<Servicio>());
        
    }
    
    @Test 
    void verificarOrdenCargadaCorrectamente(){
		assertEquals(terminal1.cantidadDeOrdenes(), 1);
		assertEquals(terminal1.viajeMasCorto(), viaje2);
		assertEquals(cliente1.getTurno().getFechaYHora(), LocalDateTime.of(2023, 11, 15, 9, 0));
	}
    
    @Test 
    void verificarSiElShipperLlegoEnLaHoraAsignada(){
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(11);
		
    	assertTrue(terminal1.verificarSiLlegoEnHorario(cliente1, reloj));
	}
    
    @Test 
    void elShipperNoLlegoEnLaHoraAsignada(){
		reloj = mock(Reloj.class);
		when(reloj.getHora()).thenReturn(14);
		
    	assertFalse(terminal1.verificarSiLlegoEnHorario(cliente1, reloj));
	}
    
}
