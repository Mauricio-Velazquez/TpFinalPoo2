package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServicioAlmacenamientoExcedenteTest {

	double costoPorDia = 100.0;
	int diasAlmacenados = 5;
	ServicioAlmacenamientoExcedente servicio = new ServicioAlmacenamientoExcedente(costoPorDia, diasAlmacenados);
	
	@Test
	public void testCalcularCosto() {
		double costoCalculado = servicio.calcularCosto();
		assertEquals(servicio.getCosto(), costoCalculado);
	}

}
