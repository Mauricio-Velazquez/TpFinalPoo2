package containers;

public abstract class Container {
	private String tipo; //posible state
	private double ancho;
	private double largo;
	private double altura;
	private double pesoTotal;

	// Constructor
	public Container(String tipo, double ancho, double largo, double altura, double pesoTotal) {
		this.tipo = tipo;
	    this.ancho = ancho;
	    this.largo = largo;
	    this.altura = altura;
	    this.pesoTotal = pesoTotal;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
}
