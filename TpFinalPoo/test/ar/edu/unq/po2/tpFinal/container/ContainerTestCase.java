package ar.edu.unq.po2.tpFinal.container;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.servicio.Servicio;

class ContainerTestCase {

	 private Container container;

	    @BeforeEach
	    public void setUp() {
	        container = new Container(1, 10.0, 12.0, 8.0, 500.0) {
	            @Override
	            public String toString() {
	                return "Container";
	            }
	        };
	    }

	    @Test
	    public void testVerificarDatosDeContainer() {
	        assertEquals(container.getId(), 1);
	        assertEquals(container.getAncho(), 10);
	        assertEquals(container.getLargo(), 12);
	        assertEquals(container.getAltura(), 8);
	        assertEquals(container.getPesoTotal(), 500);
	    }
	    
	    @Test
	    public void testContratarServicio() {
	        Servicio servicioMock = mock(Servicio.class);
	        container.contratarServicio(servicioMock);

	        List<Servicio> serviciosContratados = container.getServiciosContratados();

	        assertEquals(1, serviciosContratados.size());
	        assertTrue(serviciosContratados.contains(servicioMock));
	    }

	    @Test
	    public void testContratarMultipleServicio() {
	        Servicio servicioMock1 = mock(Servicio.class);
	        Servicio servicioMock2 = mock(Servicio.class);

	        container.contratarServicio(servicioMock1);
	        container.contratarServicio(servicioMock2);

	        List<Servicio> serviciosContratados = container.getServiciosContratados();

	        assertEquals(2, serviciosContratados.size());
	        assertTrue(serviciosContratados.contains(servicioMock1));
	        assertTrue(serviciosContratados.contains(servicioMock2));
	    }
	    
	    @Test
	    public void testContainerDry() {
	        Container containerDry = new ContainerDry(1, 10.0, 12.0, 8.0, 500.0);

	        Servicio servicioMock = mock(Servicio.class);
	        containerDry.contratarServicio(servicioMock);

	        List<Servicio> serviciosContratados = containerDry.getServiciosContratados();

	        assertEquals(1, serviciosContratados.size());
	        assertTrue(serviciosContratados.contains(servicioMock));
	    }

	    @Test
	    public void testContainerReefer() {
	        Container containerReefer = new ContainerReefer(2, 8.0, 10.0, 6.0, 400.0, 20.0);

	        assertEquals(20.0, ((ContainerReefer) containerReefer).getConsumoDeEnergia());
	    }

	    @Test
	    public void testContainerTanque() {
	        Container containerTanque = new ContainerTanque(3, 15.0, 20.0, 10.0, 600.0, "Líquido");

	        assertEquals("Líquido", ((ContainerTanque) containerTanque).getTipoDeContenido());
	    }

}
