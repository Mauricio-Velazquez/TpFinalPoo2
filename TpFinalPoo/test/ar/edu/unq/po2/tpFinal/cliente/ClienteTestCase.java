package ar.edu.unq.po2.tpFinal.cliente;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.terminalGestionada.Turno;

class ClienteTestCase {

	 private ClienteConsignee consignee;
	 private ClienteShipper shipper;;

	    @BeforeEach
	    void setUp() {
	        consignee = new ClienteConsignee("Mauri", 123456789, "Mauri@example.com");
	        shipper = new ClienteShipper("Ivan", 987654321, "Ivan@example.com");
	        
	    }
	    
	    @Test
	    void testRecibirFactura() {
	        assertEquals(0, consignee.getOrdenes().size());
	        
	        consignee.recibirFactura("Factura de ejemplo");
	        consignee.recibirFactura("Otra factura de ejemplo");
	        
	        assertEquals(0, consignee.getOrdenes().size());
	    }
	    
	    @Test
	    void testGetOrdenes() {
	        assertEquals(0, shipper.getOrdenes().size());
	        
	        // Crear una lista simulada de órdenes
	        List<Orden> ordenesSimuladas = new ArrayList<>();
	        
	        // Crear y agregar órdenes simuladas a la lista
	        for (int i = 0; i < 3; i++) {
	            Orden ordenMock = mock(Orden.class);
	            ordenesSimuladas.add(ordenMock);
	        }
	        
	        // Agregar las órdenes simuladas al cliente Shipper
	        shipper.agregarOrden(ordenesSimuladas.get(0));
	        shipper.agregarOrden(ordenesSimuladas.get(1));
	        shipper.agregarOrden(ordenesSimuladas.get(2));
	        
	        // Verificar que la cantidad de órdenes sea la esperada
	        assertEquals(3, shipper.getOrdenes().size());
	    }
	 
	    @Test 
	    void testGetMailYGetDni(){
	    	assertEquals("Mauri@example.com",consignee.getMail());
	    	assertEquals("Ivan@example.com",shipper.getMail());
	    	assertEquals(123456789,consignee.getDni());
	    	assertEquals(987654321,shipper.getDni());
	    }

	    @Test
	    void testGetNombre() {
	        String expectedNombre1 = "Mauri";
	        String actualNombre1 = consignee.getNombre();
	        assertEquals(expectedNombre1, actualNombre1);
	        
	        String expectedNombre = "Ivan";
	        String actualNombre = shipper.getNombre();
	        assertEquals(expectedNombre, actualNombre);
	    }
	    
	    @Test
	    void testAgregarTurno() {
	        Turno turnoMock = mock(Turno.class);
	        shipper.agregarTurno(turnoMock);
	        assertEquals(1, shipper.getTurnos().size());
	    }

}
