package ar.edu.unq.po2.tpFinal.buque;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Buque {
	private int identificador;
	private GPS gps;
	private FaseDeBuque estadoActual;
	private List <Container> containersAsociados;
	private TerminalGestionada terminal;
	
	public Buque(int identificador,TerminalGestionada terminal) {
		this.identificador = identificador;
		this.estadoActual = new FaseDeBuqueOutbound();
		this.containersAsociados = new ArrayList<Container>();
		this.gps = new GPS();
		this.terminal = terminal;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}
	 
	 public FaseDeBuque getEstadoActual() {
		 return estadoActual;
	 }
	 
	 public double calcularMontoTotalServicios(){
		 return containersAsociados.stream()
	                .flatMap(container -> container.getServiciosContratados().stream())
	                .mapToDouble(Servicio::getCosto)
	                .sum();
	 }
	 
	 public List<Container> getContainersAsociados(){
		 return containersAsociados;
	 }
	 
	 public void setEstadoActual(FaseDeBuque estadoActual){
		 this.estadoActual = estadoActual;
	 }
	 
	 
	 public void agregarContainer(Container container){
		 containersAsociados.add(container);
	 }
	 
	 public TerminalGestionada getTerminal() {
		 return terminal;
	 }
	 
	 public Posicion obtenerPosicionActual() {
		 return gps.obtenerPosicionActual();
	 }
	 
	 public void moverBuque(Posicion nuevaPosicion) {
		 gps.actualizarPosicion(nuevaPosicion);
		    if (estadoActual.deberiaCambiar(this, terminal)) {
		    	estadoActual.notificarTerminal(this,terminal);
		        estadoActual.siguienteFase(this);
		        System.out.println("Nueva fase: " + estadoActual);
		    }
	 }
	 
	 public void simularActualizacionPeriodica() {
		    Timer timer = new Timer();
		    timer.schedule(new TimerTask() {
		        @Override
		        public void run() {
		            // Simular una nueva posición
		            double nuevaLatitud = Math.random() * 180 - 90;  // Latitud aleatoria entre -90 y 90
		            double nuevaLongitud = Math.random() * 360 - 180;  // Longitud aleatoria entre -180 y 180
		            Posicion nuevaPosicion = new Posicion(nuevaLatitud, nuevaLongitud);

		            // Actualizar la posición del GPS
		            moverBuque(nuevaPosicion);

		            // Mostrar la nueva posición
		            System.out.println("Nueva posición: Latitud " + nuevaLatitud + ", Longitud " + nuevaLongitud);

		            // Mostrar el estado actual del buque
		            System.out.println("Fase actual del buque: " + getEstadoActual());
		        }
		    }, 0, 60000);  // Actualizar cada minuto (60000 milisegundos)
		}

	 
	 public double calcularDistanciaATerminal() {
		 Posicion ubicacionActual = obtenerPosicionActual();
	     return gps.calcularDistancia(ubicacionActual, terminal.obtenerPosicionActual());
	 }

}
