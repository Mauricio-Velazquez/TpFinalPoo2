package ar.edu.unq.po2.tpFinal.terminalGestionada;

import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RelojTestCase {

	private Reloj reloj;

    @BeforeEach
    void setUp() {
        reloj = new Reloj();
    }


    @Test
    void testGetHora() {
        
        int hora = reloj.getHora(); // Obtenemos la hora actual

        // Verificamos si el método getHora() devuelve una hora válida
        assertTrue(hora >= 0 && hora < 24);
    }

    @Test
    void testGetFecha() {
        LocalDate fecha = reloj.getFecha(); // Obtenemos la fecha actual

        // Verificamos si el método getFecha() devuelve una fecha válida
        assertNotNull(fecha);
    }
}
