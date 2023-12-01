package ar.edu.unq.po2.tpFinal.orden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.cliente.ClienteConsignee;
import ar.edu.unq.po2.tpFinal.container.ContainerReefer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.servicio.ServicioAlmacenamientoExcedente;
import ar.edu.unq.po2.tpFinal.servicio.ServicioElectricidad;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Viaje;

public class OrdenImportacionTestCase {
	private ClienteConsignee cliente1;
	private ContainerReefer container1;
	private Viaje viaje1;
	private Camion camion1;
	private Chofer chofer1;
	private OrdenImportacion orden1;
	
    @BeforeEach
    public void setUp(){
    	cliente1 = mock(ClienteConsignee.class);
    	container1 = mock(ContainerReefer.class);
    	viaje1 = mock(Viaje.class);
    	camion1 = mock(Camion.class);
    	chofer1 = mock(Chofer.class);

        orden1 = new OrdenImportacion(container1, viaje1, camion1, chofer1, LocalDate.of(2023, 12, 7), LocalDate.of(2023, 12, 10), 1, cliente1);  
    }
        
    @Test 
    public void testVerificarOrdenDeImportacionSinServicios(){
		assertEquals(orden1.getContainer(), container1);
		assertEquals(orden1.getViaje(), viaje1);
		assertEquals(orden1.getCamion(), camion1);
		assertEquals(orden1.getChofer(), chofer1);
		assertEquals(orden1.getFechaSalida(), LocalDate.of(2023, 12, 7));
		assertEquals(orden1.getFechaLlegada(), LocalDate.of(2023, 12, 10));
		assertEquals(orden1.getNroOrden(), 1);
		assertEquals(orden1.getCliente(), cliente1);
		assertEquals(orden1.getServicios().size(), 0);
	}     
    
    @Test 
    public void testVerificarOrdenDeImportacionConServicios(){
    	orden1.agregarServicio(mock(ServicioAlmacenamientoExcedente.class));
    	orden1.agregarServicio(mock(ServicioElectricidad.class));
    	
		assertEquals(orden1.getServicios().size(), 2);
	} 
}
