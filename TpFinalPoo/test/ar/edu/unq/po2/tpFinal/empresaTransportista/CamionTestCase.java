package ar.edu.unq.po2.tpFinal.empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.container.ContainerDry;

class CamionTestCase {
	private Camion camion1;
	private Chofer chofer1;
	private ContainerDry container1;
	private ContainerDry container2;
	
	@BeforeEach
	public void setUp(){
		chofer1 = new Chofer(34654745);
		camion1 = new Camion("AAA111", chofer1);
		container1 = new ContainerDry (9233, 4, 10, 3, 2000);
		container2 = new ContainerDry (9234, 4, 10, 3, 1000);
	}
			
	@Test
	public void testCargarContainerExitoso() {
		camion1.cargarContainer(container1);
		assertEquals(container1, camion1.getContainerCargado());
	}
	
	@Test
	public void testChoferDeCamion() {
		assertEquals(chofer1, camion1.getChofer());
	}
	
	@Test
	public void testDniDeChoferDeCamionYPatente() {
		assertEquals("AAA111", camion1.getPatente());
		assertEquals(34654745, camion1.getChofer().getDni());
	}
	
	
	@Test
	public void testIntentarCargarSegundoContainer() {
		camion1.cargarContainer(container1);
		camion1.cargarContainer(container2);
		assertEquals(container1, camion1.getContainerCargado());
	}
	
	@Test
	public void testDescargarContainer() {
		camion1.cargarContainer(container1);
		camion1.descargarContainer();
		assertEquals(camion1.getContainerCargado(), null);
	}
	
	@Test
	public void testIntentarDescargarContainerNulo() {
		camion1.descargarContainer();
		assertEquals(camion1.getContainerCargado(), null);
	}
	
	@Test
	public void testIntentarCargarContenedorNulo() {
		camion1.cargarContainer(null);
		assertNull(camion1.getContainerCargado());
	}
}
