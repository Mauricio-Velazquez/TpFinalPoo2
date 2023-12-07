package ar.edu.unq.po2.tpFinal.terminalGestionada;

import ar.edu.unq.po2.tpFinal.buque.Buque;
import ar.edu.unq.po2.tpFinal.buque.GPS;
import ar.edu.unq.po2.tpFinal.buque.Posicion;
import ar.edu.unq.po2.tpFinal.cliente.Cliente;
import ar.edu.unq.po2.tpFinal.cliente.ClienteConsignee;
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
import ar.edu.unq.po2.tpFinal.orden.OrdenImportacion;
import ar.edu.unq.po2.tpFinal.servicio.Servicio;
import ar.edu.unq.po2.tpFinal.servicio.ServicioAlmacenamientoExcedente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
    private List<Container> containers;  // Para la exportación e importación.
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
        this.containers = new ArrayList<Container>();
        this.estrategia = estrategia;
    }
    
    public boolean consultarInicioDeTrabajo() {
    	return true;
    }
    
    public boolean habilitarPartida(Buque buque) {
    	return true;// Cambio de fase
    }
    
    public void notificarCliente(Buque buque) {
        List<Orden> ordenesEsperandoBuque = obtenerOrdenesEsperandoBuque(buque);

        // Enviar un correo a cada consignee asociado a las órdenes esperando el buque
        ordenesEsperandoBuque.stream()
        .map(Orden::getCliente)
        .forEach(cliente -> enviarCorreoConsignee(cliente, "El buque " + buque.getIdentificador() + "se encuentra en estado"+ buque.getEstadoActual()));
    }

    public List<Orden> obtenerOrdenesEsperandoBuque(Buque buque) {
        return ordenes.stream()
                .filter(orden -> orden.getViaje().getBuque().equals(buque))
                .collect(Collectors.toList());
    }

    private void enviarCorreoConsignee(Cliente cliente, String mensaje) {
        cliente.recibirEmail(mensaje);
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
    	return "Factura generada para " + responsablePago + ". Total a pagar por servicios: $" + montoTotalServicios+" deglose de servicios "+servicios;
    }

    public void enviarFacturaPorEmail(Buque buque,TerminalGestionada terminal) {
    
    	List<Orden> ordenesBuscadas = ordenes.stream()
                .filter(orden -> orden.getViaje().getBuque().equals(buque)).toList();
    	
    	// Recorrer cada orden buscada y enviar la factura al cliente asociado
        ordenesBuscadas.forEach(orden -> {
            Cliente clienteResponsablePago = orden.getCliente();
            clienteResponsablePago.recibirFactura(generarFacturaViajeYServicios(buque, clienteResponsablePago.getNombre()));
        });
    }
    
    public Posicion obtenerPosicionActual(){
		 return gps.obtenerPosicionActual();
	}
   
    // Métodos para registrar líneas navieras, circuitos, etc.

    public void registrarLineaNaviera(Naviera lineaNaviera) {
    	lineasNavieras.add(lineaNaviera);
    }
    
    public void setGPS(GPS gps) {
    	this.gps = gps;
    }
    
    public void registrarCamion(Camion camion) {
        camiones.add(camion);
    }
    
    public void registrarChofer(Chofer chofer) {
        choferes.add(chofer);
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
    
    public List<Camion> getCamiones(){
    	return this.camiones;
    }
    
    public List<Container> getContainers(){
    	return this.containers;
    }
    
    public List<Orden> getOrdenes(){
    	return this.ordenes;
    }
    
    public void posicionarTerminal(Posicion pos) {
    	gps.actualizarPosicion(pos);
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
    
    // Devuelve la proxima fecha de salida para la terminalDestino dada.
    public LocalDate obtenerProximaFechaDeSalidaConTerminalDestino(TerminalGestionada terminalDestino){
    	LocalDate fechaDeSalida = obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino).getFechaSalida();
    	
   	    return fechaDeSalida;
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
		Viaje viajeMasTemprano = this.obtenerViajeConTerminalDestinoYFechaDeSalidaTemprana(terminalDestino);

		OrdenExportacion orden = new OrdenExportacion(container, viajeMasTemprano, camion, chofer, 
																 viajeMasTemprano.getFechaSalida(), 
																 viajeMasTemprano.getFechaLlegada(), 
																 this.darNroDeOrden(), cliente);
		orden.setServicios(container.getServiciosContratados());
		this.asignarTurno(cliente, viajeMasTemprano.getFechaSalida(), this.darNroDeOrden());
		ordenes.add(orden);
		cliente.agregarOrden(orden);
	}
	
	public void importar(Camion camion, Chofer chofer, Container container, ClienteConsignee cliente, Viaje viaje) {
        clientes.add(cliente);
        camiones.add(camion);
        choferes.add(chofer);

        OrdenImportacion orden = new OrdenImportacion(container, viaje, camion, chofer, 
                                                                 viaje.getFechaSalida(), 
                                                                 viaje.getFechaLlegada(), 
                                                                 this.darNroDeOrden(), cliente);
        orden.setServicios(container.getServiciosContratados());
        ordenes.add(orden);
        cliente.agregarOrden(orden);
        this.enviarCorreoConFechaLlegadaConMargen(viaje.getFechaLlegada(), cliente);
    }
	
	// Suponemos que todas las importanciones llegan a las 11:00 AM entonces el consignee tiene hasta las 11:00 AM del otro dia para buscar la carga.
	public void enviarCorreoConFechaLlegadaConMargen(LocalDate fechaLlegada, ClienteConsignee cliente) {
		LocalDateTime fechaLlegadaConHora = fechaLlegada.atTime(11, 00);
		LocalDateTime fechaLimiteRetiroConHora = fechaLlegadaConHora.plusDays(1);

        String mensaje = "Su carga llegará el " + fechaLlegadaConHora + ". Tiene hasta el " + fechaLimiteRetiroConHora + " para retirarla sin costo sino se le cobrara un extra.";

        enviarCorreoConsignee(cliente, mensaje);
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
    public boolean verificarCondicionesDeIngresoDelShipper(ClienteShipper cliente, Camion camion, Chofer chofer, Reloj reloj, int nroOrden) {
    	if(this.verificarSiLlegoEnHorarioElShipper(cliente, nroOrden, reloj) && this.verificarCamion(camion) && this.verificarChofer(chofer)) {
    		containers.add(camion.getContainerCargado());
    		camion.descargarContainer();
			System.out.println("Carga depositada");
			return true;
    	}
		else {
			System.out.println("Se rechaza el ingreso porque no cumple alguna de las condiciones anteriores");
			return false;
		}
    }
    
    public boolean verificarSiLlegoEnHorarioElShipper(ClienteShipper cliente, int nroOrden, Reloj reloj) {
    	boolean existeNroOrden = ordenes.stream().anyMatch(orden -> orden.getNroOrden() == nroOrden);
    	if(existeNroOrden && verificarCliente(cliente)) {
    		Turno turno = cliente.getTurnos().stream()
					                         .filter(t -> t.getNroOrden() == (nroOrden))
					                         .findFirst()
					                         .orElseThrow(() -> new RuntimeException("No se encontró un turno con el nroOrden dado."));
			int diferenciaEnHoras = reloj.getHora() - turno.getHora();
			return !(diferenciaEnHoras > 3);
    	}
    	else {
        	return false;
    	}
    }
        
    public boolean verificarCamion(Camion camion) {
    	return ordenes.stream().anyMatch(orden -> orden.getCamion().equals(camion)) && camiones.contains(camion);
    }
    
    public boolean verificarChofer(Chofer chofer) {
    	return ordenes.stream().anyMatch(orden -> orden.getChofer().equals(chofer)) && choferes.contains(chofer);
    }
    
    public boolean verificarCliente(Cliente cliente) {    	
    	return ordenes.stream().anyMatch(orden -> orden.getCliente().equals(cliente)) && clientes.contains(cliente);
    }
    
    // Si el Consignee se demora mas de 24 hs en buscar su carga se le cobra un monto fijo adicional por dia.
    public boolean verificarCondicionesDeIngresoDelConsignee(ClienteConsignee cliente, Camion camion, Chofer chofer, Reloj reloj, int nroOrden) {
    	Orden orden = ordenes.stream()
    						 .filter(o -> o.getNroOrden() == (nroOrden))
    						 .findFirst()
    						 .orElseThrow(() -> new RuntimeException("No se encontró una orden con el nroOrden dado."));
    	Container container = orden.getContainer();
    	containers.add(container); // Para representar que el container está en la terminal.
    	
    	if(this.verificarSiLlegoEnHorarioElConsignee(cliente, orden, reloj) && this.verificarCamion(camion) && this.verificarChofer(chofer)) {
    		camion.cargarContainer(container);
    		containers.remove(container);
    		return true;
    	}
		else if(verificarCliente(cliente) && this.verificarCamion(camion) && this.verificarChofer(chofer)) {
			LocalDate fechaInicial = orden.getFechaLlegada();
			int diasAlmacenados = Math.toIntExact(ChronoUnit.DAYS.between(fechaInicial, reloj.getFecha()));
			ServicioAlmacenamientoExcedente servicio = new ServicioAlmacenamientoExcedente(200d, diasAlmacenados);
			orden.agregarServicio(servicio);
    		camion.cargarContainer(container);
    		containers.remove(container);
    		return true;
		}
    	return false;
    }
    
    // Verifica si el Consignee llego dentro de las 24 hs.
    public boolean verificarSiLlegoEnHorarioElConsignee(ClienteConsignee cliente, Orden orden, Reloj reloj) {    	
		LocalDateTime fechaInicial = orden.getFechaLlegada().atTime(11, 00);
		LocalDateTime fechaLimite = fechaInicial.plusDays(1);
		LocalDateTime fechaActual = reloj.getFechaYHora();

    	return fechaActual.isBefore(fechaLimite) && verificarCliente(cliente);
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
	
	// Si el resultado es 0 es porque no existe la naviera dada en la terminalGestionada o la naviera no incluye la terminalDestino dada en sus viajes.
	public int cuantoTardaEnLlegar(Naviera naviera, TerminalGestionada terminalDestino) {
		int resultado = 0;
		if(lineasNavieras.contains(naviera) && naviera.incluyeTerminalDestinoEnLosViajes(terminalDestino)) {
			Viaje viaje = naviera.getViajes().stream()
							     .min(Comparator.comparingInt(Viaje::getTiempoTotal))
							     .orElseThrow(() -> new RuntimeException("No se encontró un viaje"));
			resultado = viaje.getTiempoTotal();	
		}
		return resultado;
	}
	
}
