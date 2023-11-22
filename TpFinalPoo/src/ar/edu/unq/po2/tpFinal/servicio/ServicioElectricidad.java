package ar.edu.unq.po2.tpFinal.servicio;

import java.time.Duration;
import java.time.LocalDateTime;

import ar.edu.unq.po2.tpFinal.container.ContainerReefer;

public class ServicioElectricidad implements Servicio {
	
    private double costoPorKw;
    private LocalDateTime inicioConexion;
    private LocalDateTime finConexion;
    private ContainerReefer container;

    public ServicioElectricidad(double costoPorKw, double consumoKwHora,ContainerReefer container,
    		LocalDateTime inicioConexion,LocalDateTime finConexion) {
       
        this.costoPorKw = costoPorKw;
        this.inicioConexion = inicioConexion;
        this.finConexion = finConexion;
        this.container = container;
        
    }

    @Override
    public double getCosto() {
        // Calcular el costo total al llamar a calcularCosto()
        return calcularCosto();
    }

    @Override
    public double calcularCosto() {
        // Verificar que tanto el inicio como el fin de la conexión estén establecidos
        if (inicioConexion != null && finConexion != null) {
            // Calcular la duración de la conexión en horas
            long duracionEnHoras = Duration.between(inicioConexion, finConexion).toHours();
            // Calcular el consumo total de kilowatts durante la conexión
            double consumoTotal = duracionEnHoras * (container.getConsumoDeEnergia());
            // Calcular el costo final multiplicando el consumo por el precio por kW
            return consumoTotal * costoPorKw;
        } else {
            // En caso de que no se haya establecido el inicio o fin de la conexión
            return 0.0; // Otra opción podría ser lanzar una excepción indicando un error
        }
    }

}
