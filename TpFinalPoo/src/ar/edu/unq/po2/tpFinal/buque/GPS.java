package ar.edu.unq.po2.tpFinal.buque;
public class GPS {
	private Posicion posicionActual;

    public GPS() {
        // Inicializar con una posición inicial ficticia
        this.posicionActual = new Posicion(0.0, 0.0);
    }

    public Posicion obtenerPosicionActual() {
        return posicionActual;
    }

    public void actualizarPosicion(Posicion nuevaPosicion) {
        this.posicionActual = nuevaPosicion;
    }

 // Método que calcula la distancia entre dos ubicaciones
    public double calcularDistancia(Posicion ubicacion1, Posicion ubicacion2) {
        // Simulación: se utiliza la distancia euclidiana
        double deltaLatitud = ubicacion1.getLatitud() - ubicacion2.getLatitud();
        double deltaLongitud = ubicacion1.getLongitud() - ubicacion2.getLongitud();
        return Math.sqrt(Math.pow(deltaLatitud, 2) + Math.pow(deltaLongitud, 2));
    }
}
