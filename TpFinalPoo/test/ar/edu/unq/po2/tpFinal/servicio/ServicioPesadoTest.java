package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServicioPesadoTest {

	private ServicioPesado servicioPesado;
	
	@Test
	public void testCalcularCosto() {
		servicioPesado = new ServicioPesado (20.0, 30.0);
		assertEquals (servicioPesado.getCosto(), servicioPesado.calcularCosto());
		assertEquals (servicioPesado.getPesoRegistrado(), 30);
	}

}
