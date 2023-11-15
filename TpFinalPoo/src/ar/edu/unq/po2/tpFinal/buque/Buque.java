package ar.edu.unq.po2.tpFinal.buque;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

import java.util.ArrayList;
import java.util.List;

public class Buque {
	int identificador;
	private GPS gps;
	FaseDeBuque estadoActual;
	List <Container> containersAsociados;
	private TerminalGestionada terminal;
	
	public Buque(int identificador,TerminalGestionada terminal) {
		this.identificador = identificador;
		this.estadoActual = new FaseDeBuqueOutbound();
		this.containersAsociados = new ArrayList<Container>();
		this.gps = new GPS();
		this.terminal = terminal;
	}
	
	 public void avanzarFase(){
		 if(estadoActual.deberiaCambiar(this,terminal.obtenerPosicionActual())) {
			 estadoActual.siguienteFase(this);
		 }
		 
	 }
	 
	 public FaseDeBuque getEstadoActual() {
		 return estadoActual;
	 }
	 
	 
	 public void setEstadoActual(FaseDeBuque estadoActual){
		 this.estadoActual = estadoActual;
	 }
	 
	 
	 public void agregarContainer(Container container){
		 containersAsociados.add(container);
	 }
	 
	 public Posicion obtenerPosicionActual() {
		 return gps.obtenerPosicionActual();
	 }
	 
	 public void moverBuque(Posicion nuevaPosicion) {
		    gps.actualizarPosicion(nuevaPosicion);
		    avanzarFase();
	 }

	 
	 public double calcularDistanciaATerminal() {
		 Posicion ubicacionActual = obtenerPosicionActual();
	     return gps.calcularDistancia(ubicacionActual, terminal.obtenerPosicionActual());
	    }

}
