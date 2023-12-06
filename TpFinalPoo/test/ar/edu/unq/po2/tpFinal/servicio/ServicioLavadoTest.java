package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

class ServicioLavadoTest {

	private ServicioLavado servicioLavado;
	private ServicioLavado servicioLavado2;
	private ContainerReefer mockContainer;
	private ContainerReefer mockContainer2;
	
	@BeforeEach
	public void setUp() {
		//Se crea el mock
		mockContainer = Mockito.mock(ContainerReefer.class);
		Mockito.when(mockContainer.getPesoTotal()).thenReturn(80.0);
		
		mockContainer2 = Mockito.mock(ContainerReefer.class);
		Mockito.when(mockContainer2.getPesoTotal()).thenReturn(30.0);
		
		double costoPorMontoSuperior = 20.0;
		double costoPorMontoInferior = 10.0;
		
		servicioLavado = new ServicioLavado (costoPorMontoSuperior, costoPorMontoInferior, mockContainer);
		servicioLavado2 = new ServicioLavado (costoPorMontoSuperior, costoPorMontoInferior, mockContainer2);
	}
	
	@Test
	public void testCalcularCostoDeMontoSuperior() {
		double costoLavado = servicioLavado.calcularCosto();
		assertEquals(servicioLavado.getCosto(), costoLavado);
		assertEquals(servicioLavado.getMontoSuperior(), 20);
	}
	
	@Test
	public void testCalcularCostoDeMontoInferior() {
		double costoLavado = servicioLavado2.calcularCosto();
		assertEquals(servicioLavado2.getCosto(), costoLavado);
		assertEquals(servicioLavado.getMontoInferior(), 10);
	}

}
