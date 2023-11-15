package ar.edu.unq.po2.tpFinal.buque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

class BuqueTestCase {
	TerminalGestionada terminal = new TerminalGestionada("Terminal A");
    Buque buque = new Buque(1, terminal);
    Posicion pos = new Posicion(-34.6037, -58.3816);
    Posicion nuevaPosicion = new Posicion(-24.6037, -38.3816);
    @BeforeEach
    void setUp() {
    	terminal.posicionarTerminal(pos);
    	buque.moverBuque(nuevaPosicion);
    }
    
	@Test
	void test() {
		// Se verifica si la fase cambió
        System.out.println("Fase actual del buque: "+ buque.getEstadoActual());
        System.out.println(terminal.obtenerPosicionActual());
        System.out.println(buque.calcularDistanciaATerminal());
	}

}
