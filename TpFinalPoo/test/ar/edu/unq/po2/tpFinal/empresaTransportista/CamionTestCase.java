package ar.edu.unq.po2.tpFinal.empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.container.ContainerDry;

class CamionTestCase {

	Camion camion = new Camion ("AAA111");
	Container container1 = new ContainerDry (9233, 4, 10, 3, 2000);
	Container container2 = new ContainerDry (9234, 4, 10, 3, 1000);
			
	@Test
	void testCargarContainerExitoso() {
		camion.cargarContainer(container1);
		assertEquals(container1, camion.getContainerCargado());
	}
	
	@Test
	void testIntentarCargarSegundoContainer() {
		camion.cargarContainer(container1);
		camion.cargarContainer(container2);
		assertEquals(container1, camion.getContainerCargado());
	}
	
	@Test
	void testIntentarCargarContenedorNulo() {
		camion.cargarContainer(null);
		assertNull(camion.getContainerCargado());
	}
}
