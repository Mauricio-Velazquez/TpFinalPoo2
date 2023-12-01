package ar.edu.unq.po2.tpFinal.orden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.container.ContainerTanque;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.servicio.ServicioLavado;
import ar.edu.unq.po2.tpFinal.servicio.ServicioPesado;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenExportacionTestCase {
	private ClienteShipper cliente1;
	private ContainerTanque container1;
	private Viaje viaje1;
	private Camion camion1;
	private Chofer chofer1;
	private OrdenExportacion orden1;
	
    @BeforeEach
    public void setUp(){
    	cliente1 = mock(ClienteShipper.class);
    	container1 = mock(ContainerTanque.class);
    	viaje1 = mock(Viaje.class);
    	camion1 = mock(Camion.class);
    	chofer1 = mock(Chofer.class);

        orden1 = new OrdenExportacion(container1, viaje1, camion1, chofer1, LocalDate.of(2023, 11, 15), LocalDate.of(2023, 11, 20), 1, cliente1); 
    }
        
    @Test 
    public void testVerificarOrdenDeExportacionSinServicios(){
		assertEquals(orden1.getContainer(), container1);
		assertEquals(orden1.getViaje(), viaje1);
		assertEquals(orden1.getCamion(), camion1);
		assertEquals(orden1.getChofer(), chofer1);
		assertEquals(orden1.getFechaSalida(), LocalDate.of(2023, 11, 15));
		assertEquals(orden1.getFechaLlegada(), LocalDate.of(2023, 11, 20));
		assertEquals(orden1.getNroOrden(), 1);
		assertEquals(orden1.getCliente(), cliente1);
		assertEquals(orden1.getServicios().size(), 0);
	}  
    
    @Test 
    public void testVerificarOrdenDeExportacionConServicios(){
    	orden1.agregarServicio(new ServicioLavado(600d, 300d, container1));
    	orden1.agregarServicio(new ServicioPesado(200d, 1000d));
    	
		assertEquals(orden1.getServicios().size(), 2);
	} 
}
