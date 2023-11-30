package ar.edu.unq.po2.tpFinal.servicio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

public class ServicioElectricidadTest {

	private ServicioElectricidad servicioElectricidad;
	private ServicioElectricidad servicioElectricidadSinInicioDeConexion;
	private ServicioElectricidad servicioElectricidadSinFinDeConexion;
	private ServicioElectricidad servicioElectricidadSinInicioNiFinDeConexion;
	private ServicioElectricidad servicioElectricidadConFinDeConexionMayorAlInicio;
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
        LocalDateTime finConexion2 = LocalDateTime.of(2023, 1, 1, 4, 0);
        LocalDateTime inicioConexion0 = null;
        LocalDateTime finConexion0 = null;
        
        servicioElectricidad = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion, finConexion);
        servicioElectricidadSinInicioDeConexion = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion0, finConexion);
        servicioElectricidadSinFinDeConexion = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion, finConexion0);
        servicioElectricidadSinInicioNiFinDeConexion = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion0, finConexion0);
        servicioElectricidadConFinDeConexionMayorAlInicio = new ServicioElectricidad (costoPorKw, mockContainer, inicioConexion, finConexion2);
	} 
		
	@Test
	public void testCalcularCosto() {
		double costo = servicioElectricidad.calcularCosto();
		assertEquals (400,costo);
	}
	
	@Test
	public void testCalcularCostoCuandoNoSeEstableceElInicioDeConexion() {
		double costo = servicioElectricidadSinInicioDeConexion.calcularCosto();
		assertEquals (0,costo);
	} 
	
	@Test
	public void testCalcularCostoCuandoNoSeEstableceElFinDeConexion() {
		double costo = servicioElectricidadSinFinDeConexion.calcularCosto();
		assertEquals (0,costo);
	} 
	
	@Test
	public void testCalcularCostoCuandoNoSeEstableceElInicioNiFinDeConexion() {
		double costo = servicioElectricidadSinInicioNiFinDeConexion.calcularCosto();
		assertEquals (0,costo);
	} 
	
	@Test
	public void testCalcularCostoCuandoElFinDeConexionEsMayorAlInicio(){
		double costo = servicioElectricidadConFinDeConexionMayorAlInicio.calcularCosto();
		assertEquals (0,costo);
	}
	}
