package ar.edu.unq.po2.tpFinal.buque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

class BuqueTestCase {
	TerminalGestionada terminal = new TerminalGestionada("Terminal A");
    Buque buque = new Buque(1, terminal);
    Posicion pos = new Posicion(-34.6037, -58.3816);  // Posición de la terminal
    Posicion nuevaPosicion = new Posicion(-34.6037, -58.3810);  // Posición cercana a la terminal

    @BeforeEach
    void setUp() {
        terminal.posicionarTerminal(pos);
        buque.moverBuque(nuevaPosicion);  // Ubica el buque a menos de 50km de la terminal
        buque.simularActualizacionPeriodica();
    }

    @Test
    void test() {
        // Esperar 1 minuto
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Se verifica si la fase cambió después de esperar
        System.out.println("Fase actual del buque: " + buque.getEstadoActual());
        System.out.println(terminal.obtenerPosicionActual());
        System.out.println(buque.calcularDistanciaATerminal());
    }

}
