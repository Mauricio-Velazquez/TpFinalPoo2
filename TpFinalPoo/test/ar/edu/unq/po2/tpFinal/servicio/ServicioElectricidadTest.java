package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

public class ServicioElectricidadTest {

	private ServicioElectricidad servicioElectricidad;
	private ContainerReefer mockContainer;
	
	@BeforeEach
	public void setUp() {
		//Se crea el mock
		mockContainer = Mockito.mock(ContainerReefer.class);
		Mockito.when(mockContainer.getConsumoDeEnergia()).thenReturn(10.0);
		
		double costoPorKw = 10.0;
		
		//Hay que establecer el tiempo de conexion para poder saber el costo del servicio
		LocalDateTime inicioConexion = LocalDateTime.of(2023, 1, 1, 12, 0);
        LocalDateTime finConexion = LocalDateTime.of(2023, 1, 1, 16, 0);
        
        servicioElectricidad = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion, finConexion);
	} 
		
	@Test
	public void testCalcularCosto() {
		double costo = servicioElectricidad.calcularCosto();
		assertEquals (400,costo);
	}

}
