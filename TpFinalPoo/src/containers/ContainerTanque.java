package containers;

public class ContainerTanque extends Container {
	private String tipoDeContenido;
	public ContainerTanque(String tipo, double ancho, double largo, double altura, double pesoTotal,String tipoDeContenido) {
		super(tipo, ancho, largo, altura, pesoTotal);
		this.tipoDeContenido = tipoDeContenido;
	}
	
	public String getTipoDeContenido() {
		return tipoDeContenido;
	}
	public void setTipoDeContenido(String tipoDeContenido) {
		this.tipoDeContenido = tipoDeContenido;
	}
}
