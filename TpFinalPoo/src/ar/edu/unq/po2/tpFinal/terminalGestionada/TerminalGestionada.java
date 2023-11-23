package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;

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
    
    public String generarFacturaViajeYServicios(Buque buque, String responsablePago) {
        double montoTotalServicios = buque.calcularMontoTotalServicios();

        // sumar el costo de los tramos del viaje al monto total si es necesario

        List<Servicio> serviciosContratados = buque.getContainersAsociados().stream()
                .flatMap(container -> container.getServiciosContratados().stream())
                .collect(Collectors.toList());

        String facturaServicios = generarFactura(responsablePago, montoTotalServicios, serviciosContratados);
        enviarFacturaPorEmail(responsablePago, facturaServicios);

        // Devolver la factura para posibles usos adicionales
        return facturaServicios;
    }

    private String generarFactura(String responsablePago, double montoTotalServicios
    		, List<Servicio> servicios) {
    	return "Factura generada para " + responsablePago + ". Total a pagar por servicios: $" + montoTotalServicios;
    }

    private void enviarFacturaPorEmail(String responsablePago, String factura) {
        // Lógica para enviar la factura por email
        // ...
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
