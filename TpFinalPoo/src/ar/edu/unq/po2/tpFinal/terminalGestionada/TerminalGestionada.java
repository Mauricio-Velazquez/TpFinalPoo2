package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.Orden;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalGestionada {
	private String nombre;
	private GPS gps;
	private List<Naviera> lineasNavieras;
    private List<Circuito> circuitosMaritimos;
    private List<Viaje> historialViajes;
    private List<Orden> ordenes;

    public TerminalGestionada(String nombre) {
        this.nombre = nombre;
        this.lineasNavieras = new ArrayList<Naviera>();
        this.circuitosMaritimos = new ArrayList<Circuito>();
        this.gps = new GPS();
        this.historialViajes = new ArrayList<Viaje>();
        this.ordenes = new ArrayList<Orden>();
    }
    
    public Posicion obtenerPosicionActual(){
		 return gps.obtenerPosicionActual();
	}
   
    // Métodos para registrar líneas navieras, circuitos, etc.

    public void registrarLineaNaviera(Naviera lineaNaviera) {
    	lineasNavieras.add(lineaNaviera);
    }

    public void registrarCircuitoMaritimo(Circuito circuitoMaritimo) {
    	circuitosMaritimos.add(circuitoMaritimo);
    }
    
    public void registrarOrden(Orden orden) {
    	ordenes.add(orden);
    }

    public String getNombre() {
        return nombre;
    }
    
    public void posicionarTerminal(Posicion pos) {
    	gps.actualizarPosicion(pos);
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void agregarViaje(Viaje viaje) {
        historialViajes.add(viaje);
    }

    public List<Viaje> obtenerViajesPorFiltro(Filtro filtro){
    	 return historialViajes.stream()
                 .filter(filtro::cumpleFiltro)
                 .collect(Collectors.toList());
    }
    
}
