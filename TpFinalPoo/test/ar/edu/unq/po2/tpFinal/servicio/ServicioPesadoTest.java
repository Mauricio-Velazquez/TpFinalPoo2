package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;

//import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

class ServicioPesadoTest {

	private ServicioPesado servicioPesado;
//	private ContainerReefer mockContainer;
	
/*
	@BeforeEach
	public void setUp () {
		//Se crea el mock
		mockContainer = Mockito.mock(ContainerReefer.class);
		Mockito.when(mockContainer)
	}
*/	
	
	@Test
	public void testCalcularCosto() {
		servicioPesado = new ServicioPesado (20.0, 30.0);
		assertEquals (20.0, servicioPesado.calcularCosto());
	}

}
