package containers;

public class ContainerReefer extends Container {
	private double consumoDeEnergia;
	public ContainerReefer(String tipo, double ancho, double largo, double altura, double pesoTotal,double consumoDeEnergia) {
		super(tipo, ancho, largo, altura, pesoTotal);
		this.consumoDeEnergia = consumoDeEnergia;
		
	}
	public double getConsumoDeEnergia() {
		return consumoDeEnergia;
	}
	public void setConsumoDeEnergia(double consumoDeEnergia) {
		this.consumoDeEnergia = consumoDeEnergia;
	}

}
