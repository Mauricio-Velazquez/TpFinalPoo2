package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalGestionada {
	private String nombre;
	private GPS gps;
	private List<Naviera> lineasNavieras;
    private List<Viaje> viajes;
    private List<Orden> ordenes;
    private List<Cliente> clientes;
    private List<EmpresaTransportista> empresas;
    
    public TerminalGestionada(String nombre) {
        this.nombre = nombre;
        this.lineasNavieras = new ArrayList<Naviera>();
        this.gps = new GPS();
        this.viajes = new ArrayList<Viaje>();
        this.ordenes = new ArrayList<Orden>();
        this.clientes = new ArrayList<Cliente>();
        this.empresas = new ArrayList<EmpresaTransportista>();
    }
    
    public boolean consultarInicioDeTrabajo() {
    	return true;
    }
    
    public boolean habilitarPartida(Buque buque) {
    	buque.getEstadoActual().siguienteFase(buque);
    	return true;// Cambio de fase
    }
    
    public void notificarCliente(Buque buque) {
        List<Orden> ordenesEsperandoBuque = obtenerOrdenesEsperandoBuque(buque);

        // Enviar un correo a cada consignee asociado a las órdenes esperando el buque
        ordenesEsperandoBuque.stream()
        .map(Orden::getCliente)
        .forEach(cliente -> enviarCorreoConsignee(cliente, "El buque " + buque.getIdentificador() + "se encuentra en estado"+ buque.getEstadoActual()));
    }

    private List<Orden> obtenerOrdenesEsperandoBuque(Buque buque) {
        return ordenes.stream()
                .filter(orden -> orden.getViaje().getBuque().equals(buque))
                .collect(Collectors.toList());
    }

    private void enviarCorreoConsignee(Cliente cliente, String mensaje) {
        // Lógica para enviar el correo al consignee
        // ...
        System.out.println("Correo enviado a " + cliente.getNombre() + ": " + mensaje);
    }
    
    public String generarFacturaViajeYServicios(Buque buque, String responsablePago) {
        double montoTotalServicios = buque.calcularMontoTotalServicios();

        // sumar el costo de los tramos del viaje al monto total si es necesario

        List<Servicio> serviciosContratados = buque.getContainersAsociados().stream()
                .flatMap(container -> container.getServiciosContratados().stream())
                .collect(Collectors.toList());

        String facturaServicios = generarFactura(responsablePago, montoTotalServicios, serviciosContratados);

        // Devolver la factura para posibles usos adicionales
        return facturaServicios;
    }

    private String generarFactura(String responsablePago, double montoTotalServicios
    		, List<Servicio> servicios) {
    	return "Factura generada para " + responsablePago + ". Total a pagar por servicios: $" + montoTotalServicios;
    }

    public void enviarFacturaPorEmail(Buque buque,TerminalGestionada terminal) {
    	/*
    	 * siempre habrá una única orden asociada al buque y
    	 * esa orden contendrá al cliente responsable del pago
    	 * */
    	Optional<Orden> ordenBuscada = ordenes.stream()
                .filter(orden -> orden.getViaje().getBuque().equals(buque))
                .findFirst();
    	ordenBuscada.ifPresent(orden -> {
    		Cliente buscado = orden.getCliente();
    		buscado.recibirFactura(generarFacturaViajeYServicios(buque,(buscado.getNombre())));
    	});
    	
    }
    
    public Posicion obtenerPosicionActual(){
		 return gps.obtenerPosicionActual();
	}
   
    // Métodos para registrar líneas navieras, circuitos, etc.

    public void registrarLineaNaviera(Naviera lineaNaviera) {
    	lineasNavieras.add(lineaNaviera);
    }
    
    public void registrarOrden(Orden orden) {
    	ordenes.add(orden);
    }
    
    public void registrarCliente(Cliente cliente) {
    	clientes.add(cliente);
    }
    
    public void registrarEmpresaTransportista(EmpresaTransportista empresa) {
    	empresas.add(empresa);
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
        viajes.add(viaje);
    }

    public List<Viaje> obtenerViajesPorFiltro(Filtro filtro){
    	 return viajes.stream()
                 .filter(filtro::cumpleFiltro)
                 .collect(Collectors.toList());
    }
    
    public Viaje viajeMasCorto() {
    	return viajes.stream()
    			.min(Comparator.comparingInt(v -> v.getCircuito().getTiempoTotalEstimadoDeLosTramos()))
                .orElse(null);
    }
    
    public int darNroDeOrden(){
    	return ordenes.size() + 1;
    }
    
    public int cantidadDeOrdenes(){
    	return ordenes.size();
    }
    
    //El turno siempre se asigna a las 9:00 AM del dia que el buque va a salir del puerto.
    public void asignarTurno(ClienteShipper cliente, LocalDate fecha){
    	LocalDateTime fechaConHora = fecha.atTime(9, 00);
    	Turno turno = new Turno(fechaConHora);
    	cliente.setTurno(turno);
    }
    
    public void verificarCondicionesDeIngresoDe(ClienteShipper cliente, Camion camion, Reloj reloj) {
    	if(this.verificarSiLlegoEnHorario(cliente, reloj) && this.verificarCamion(camion) && this.verificarChofer(camion.getChofer())) {
    		camion.descargarContainer();
			System.out.println("Carga depositada");
    	}
		else {
			System.out.println("Se rechaza el ingreso porque no cumple alguna de las condiciones anteriores");
		}
    }
    
    public boolean verificarSiLlegoEnHorario(ClienteShipper cliente, Reloj reloj) {
    	int diferenciaEnHoras = reloj.getHora() - cliente.getTurno().getHora();
    	return !(diferenciaEnHoras > 3);
    }
        
    public boolean verificarCamion(Camion camion) {
    	return ordenes.stream().anyMatch(orden -> orden.getCamion().equals(camion));
    }
    
    public boolean verificarChofer(Chofer chofer) {
    	return ordenes.stream().anyMatch(orden -> orden.getCamion().getChofer().equals(chofer));
    }
    
}
