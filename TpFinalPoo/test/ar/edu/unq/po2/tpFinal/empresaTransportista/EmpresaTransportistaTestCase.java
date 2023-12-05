package ar.edu.unq.po2.tpFinal.empresaTransportista;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTransportistaTestCase {

	private EmpresaTransportista empresa;
    private Camion camionMock;
    private Chofer choferMock;

    @BeforeEach
    public void setUp() {
        empresa = new EmpresaTransportista("Transportista 1");
        camionMock = mock(Camion.class);
        choferMock = mock(Chofer.class);
    }
    
    @Test 
    public void nombreEmpresa() {
    	assertEquals("Transportista 1",empresa.getNombre());
    }
    
    @Test
    public void testRegistrarCamion() {
        empresa.registrarCamion(camionMock);
        List<Camion> camiones = empresa.getCamiones();

        assertEquals(1, camiones.size());
        assertEquals(camionMock, camiones.get(0));
    }

    @Test
    public void testRegistrarChofer() {
        empresa.registrarChofer(choferMock);
        List<Chofer> choferes = empresa.getChoferes();

        assertEquals(1, choferes.size());
        assertEquals(choferMock, choferes.get(0));
    }

}
