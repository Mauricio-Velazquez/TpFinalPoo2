package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.ClienteShipper;
import ar.edu.unq.po2.tpFinal.container.Container;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Camion;
import ar.edu.unq.po2.tpFinal.empresaTransportista.Chofer;
import ar.edu.unq.po2.tpFinal.empresaTransportista.EmpresaTransportista;
import ar.edu.unq.po2.tpFinal.filtro.Filtro;
import ar.edu.unq.po2.tpFinal.filtro.FiltroPuertoDestino;
import ar.edu.unq.po2.tpFinal.naviera.Circuito;
import ar.edu.unq.po2.tpFinal.naviera.EstrategiaMejorCircuito;
import ar.edu.unq.po2.tpFinal.naviera.Naviera;
import ar.edu.unq.po2.tpFinal.orden.Orden;
import ar.edu.unq.po2.tpFinal.orden.OrdenExportacion;
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
    private List<Orden> ordenes;
    private List<Cliente> clientes; // Para realizar validaciones de orden.
    private List<Camion> camiones;  // Para realizar validaciones de orden.
    private List<Chofer> choferes;  // Para realizar validaciones de orden.
    private List<EmpresaTransportista> empresas;
    private EstrategiaMejorCircuito estrategia;
    
    public TerminalGestionada(String nombre, EstrategiaMejorCircuito estrategia) {
        this.nombre = nombre;
        this.lineasNavieras = new ArrayList<Naviera>();
        this.gps = new GPS();
        this.ordenes = new ArrayList<Orden>();
        this.clientes = new ArrayList<Cliente>();
        this.camiones = new ArrayList<Camion>();
        this.choferes = new ArrayList<Chofer>();
        this.empresas = new ArrayList<EmpresaTransportista>();
        this.estrategia = estrategia;
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
    
    // Devuelve una lista de viajes con el filtro dado.
    public List<Viaje> obtenerViajesPorFiltro(Filtro filtro){
		List<Viaje> todosLosViajes = lineasNavieras.stream()
                .flatMap(ln -> ln.getViajes()
                .stream()).toList();
    	
    	 return todosLosViajes.stream()
                 .filter(filtro::cumpleFiltro)
                 .collect(Collectors.toList());
    }
    
    // Devuelve el viaje con la terminalDestino dada y fecha de salida mas temprana.
    public Viaje obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(TerminalGestionada terminalDestino){
    	List<Viaje> viajesConLaTerminalDestino = obtenerViajesPorFiltro(new FiltroPuertoDestino(terminalDestino));
    	Viaje viaje = viajeConFechaDeSalidaTemprana(viajesConLaTerminalDestino);
    	
   	    return viaje;
   }
   
    // Devuelve el viaje con la fecha de salida mas temprana.
    public Viaje viajeConFechaDeSalidaTemprana(List<Viaje> todosLosViajes) {
    	
    	return todosLosViajes.stream().min(Comparator.comparing(Viaje::getFechaSalida))
    			                      .orElseThrow(() -> new RuntimeException("No se encontró un viaje"));
    }
        
    // Proceso de exportación e importación.
    
    // Al cliente siempre se le da el viaje con la fecha de salida mas temprana.
	public void exportarA(TerminalGestionada terminalDestino, Camion camion, Chofer chofer, Container container, ClienteShipper cliente) {
		clientes.add(cliente);
		camiones.add(camion);
		choferes.add(chofer);

		OrdenExportacion orden = new OrdenExportacion(container, this.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino), camion, chofer, 
																 this.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino).getFechaSalida(), 
																 this.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino).getFechaLlegada(), 
																 this.darNroDeOrden(), cliente);
		orden.setServicios(container.getServiciosContratados());
		this.asignarTurno(cliente, this.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino).getFechaSalida(), this.darNroDeOrden());
		ordenes.add(orden);
		cliente.agregarOrden(orden);
	}

	public void importarDe() {
		
	}
    
    public int darNroDeOrden(){
    	return ordenes.size() + 1;
    }
    
    public int cantidadDeOrdenes(){
    	return ordenes.size();
    }
    
    // El turno siempre se asigna a las 9:00 AM del dia que el buque va a salir del puerto.
    public void asignarTurno(ClienteShipper cliente, LocalDate fecha, int nroOrden){
    	LocalDateTime fechaConHora = fecha.atTime(9, 00);
    	Turno turno = new Turno(fechaConHora, nroOrden);
    	cliente.agregarTurno(turno);
    }
    
    // El reloj es para controlar la hora actual, en los tests esta mockeado para que devuelva la hora que le pasamos.
    public boolean verificarCondicionesDeIngresoDe(ClienteShipper cliente, Camion camion, Chofer chofer, Reloj reloj, int nroOrden) {
    	if(this.verificarSiLlegoEnHorario(cliente, nroOrden, reloj) && this.verificarCamion(camion) && this.verificarChofer(chofer)) {
    		camion.descargarContainer();
			System.out.println("Carga depositada");
			return true;
    	}
		else {
			System.out.println("Se rechaza el ingreso porque no cumple alguna de las condiciones anteriores");
			return false;
		}
    }
    
    public boolean verificarSiLlegoEnHorario(ClienteShipper cliente, int nroOrden, Reloj reloj) {
    	Turno turno = cliente.getTurnos().stream()
    									 .filter(t -> t.getNroOrden() == (nroOrden))
    									 .findFirst()
    									 .orElseThrow(() -> new RuntimeException("No se encontró un turno con el nroOrden dado."));
    	boolean estaElClienteEnLaOrden = ordenes.stream().anyMatch(orden -> orden.getCliente().equals(cliente));
    	int diferenciaEnHoras = reloj.getHora() - turno.getHora();
    	return !(diferenciaEnHoras > 3) && estaElClienteEnLaOrden && clientes.contains(cliente);
    }
        
    public boolean verificarCamion(Camion camion) {
    	return ordenes.stream().anyMatch(orden -> orden.getCamion().equals(camion)) && camiones.contains(camion);
    }
    
    public boolean verificarChofer(Chofer chofer) {
    	return ordenes.stream().anyMatch(orden -> orden.getChofer().equals(chofer)) && choferes.contains(chofer);
    }
    
	public Circuito obtenerMejorCircuitoParaLaTerminalDestino(TerminalGestionada terminalDestino) {
		List<Circuito> todosLosCircuitos = lineasNavieras.stream()
				                           .flatMap(ln -> ln.getCircuitos()
				                           .stream()).toList();
			
		return estrategia.elegirMejorCircuito(todosLosCircuitos, terminalDestino);	
	}
	
	public void setEstrategia(EstrategiaMejorCircuito estrategia) {
		this.estrategia = estrategia;
	}

}
