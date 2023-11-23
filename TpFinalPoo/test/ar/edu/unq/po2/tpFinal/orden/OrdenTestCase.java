package ar.edu.unq.po2.tpFinal.orden;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
	private Reloj reloj;
	
    @BeforeEach
    public void setUp() {
    	reloj = new Reloj();
        terminal1 = new TerminalGestionada("TerminalTest");
        terminal2 = new TerminalGestionada("OtraTerminalTest");
        cliente1 = new ClienteShipper("Nestor", 14456546);
        cliente2 = new ClienteConsignee("alfredo@gmail.com", "Alfredo", 13746249);
        container1 = new ContainerDry (9233, 4, 10, 3, 2000);
		chofer1 = new Chofer(34654745);
		camion1 = new Camion("AAA111", chofer1);
		camion1.cargarContainer(container1);
		buque1 = new Buque(1, terminal1);
		buque2 = new Buque(2, terminal1);
		tramo1 = new Tramo(terminal1, terminal2, 500d, 70, 300);
		tramo2 = new Tramo(terminal1, terminal2, 300d, 30, 100);
		tramo3 = new Tramo(terminal1, terminal2, 1000d, 40, 300);
		tramo4 = new Tramo(terminal1, terminal2, 600d, 10, 100);
		circuito1 = new Circuito();
		circuito1.agregarTramo(tramo1);
		circuito1.agregarTramo(tramo2);
		circuito2 = new Circuito();
		circuito2.agregarTramo(tramo3);
		circuito2.agregarTramo(tramo4);
        viaje1 = new Viaje(LocalDate.of(2023, 11, 15), buque1, circuito1, LocalDate.of(2023, 11, 19));
        viaje2 = new Viaje(LocalDate.of(2023, 11, 15), buque2, circuito2, LocalDate.of(2023, 11, 17));
        terminal1.agregarViaje(viaje1);
        terminal1.agregarViaje(viaje2);
        
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
    	//Hacer mock con el reloj y ponerle de hora las 11 AM.
    	terminal1.verificarCondicionesDeIngresoDe(cliente1, camion1, reloj);
	}
    
}
