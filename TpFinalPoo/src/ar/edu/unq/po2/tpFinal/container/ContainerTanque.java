package ar.edu.unq.po2.tpFinal.container;

public class ContainerTanque extends Container {
	private String tipoDeContenido;
	
	public ContainerTanque(int id, double ancho, double largo, double altura, double pesoTotal,String tipoDeContenido) {
		super(id, ancho, largo, altura, pesoTotal);
		this.tipoDeContenido = tipoDeContenido;
	}
	
	public String getTipoDeContenido() {
		return tipoDeContenido;
	}
	
	public void setTipoDeContenido(String tipoDeContenido) {
		this.tipoDeContenido = tipoDeContenido;
	}
}
