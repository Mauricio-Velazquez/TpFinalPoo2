package ar.edu.unq.po2.tpFinal.servicio;

public class ServicioAlmacenamientoExcedente implements Servicio {
	private double costoPorDia;
    private int diasAlmacenados;

    public ServicioAlmacenamientoExcedente(double costoPorDia) {
        this.costoPorDia = costoPorDia;
        this.diasAlmacenados = 0; // Inicialmente, no hay días almacenados
    }

    // Método para establecer la cantidad de días almacenados
    public void setDiasAlmacenados(int diasAlmacenados) {
        this.diasAlmacenados = diasAlmacenados;
    }

    @Override
    public double getCosto() {
        return calcularCosto(); // Retorna el costo calculado
    }

    @Override
    public double calcularCosto() {
        return costoPorDia * diasAlmacenados; // Costo por día multiplicado por la cantidad de días almacenados
    }

}
