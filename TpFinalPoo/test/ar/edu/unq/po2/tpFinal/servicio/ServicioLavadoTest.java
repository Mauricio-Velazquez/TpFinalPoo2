package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

class ServicioLavadoTest {

	private ServicioLavado servicioLavado;
	private ContainerReefer mockContainer;
	
	@BeforeEach
	public void setUp() {
		//Se crea el mock
		mockContainer = Mockito.mock(ContainerReefer.class);
		Mockito.when(mockContainer.getPesoTotal()).thenReturn(80.0);
		
		double montoSuperior = 20.0;
		double montoInferior = 10.0;
		
		servicioLavado = new ServicioLavado (250.0, montoSuperior, montoInferior, mockContainer );
	}
	
	@Test
	public void testCalcularCosto() {
		double costoLavado = servicioLavado.calcularCosto();
		assertEquals (20.0, costoLavado);
	}

}
