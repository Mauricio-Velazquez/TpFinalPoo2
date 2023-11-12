package ar.edu.unq.po2.tpFinal.container;

public abstract class Container {
	private int id; 
	private double ancho;
	private double largo;
	private double altura;
	private double pesoTotal;

	public Container(int id, double ancho, double largo, double altura, double pesoTotal) {
		this.id = id;
	    this.ancho = ancho;
	    this.largo = largo;
	    this.altura = altura;
	    this.pesoTotal = pesoTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
