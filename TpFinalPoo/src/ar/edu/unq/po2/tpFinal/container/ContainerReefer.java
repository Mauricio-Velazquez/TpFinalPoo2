package ar.edu.unq.po2.tpFinal.container;

public class ContainerReefer extends Container {
	private double consumoDeEnergia;
	
	public ContainerReefer(int id, double ancho, double largo, double altura, double pesoTotal, double consumoDeEnergia) {
		super(id, ancho, largo, altura, pesoTotal);
		this.consumoDeEnergia = consumoDeEnergia;
	}
	
	public double getConsumoDeEnergia() {
		return consumoDeEnergia;
	}
	
}
