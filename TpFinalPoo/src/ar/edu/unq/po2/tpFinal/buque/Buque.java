package ar.edu.unq.po2.tpFinal.buque;
import ar.edu.unq.po2.tpFinal.container.Container;
import java.util.ArrayList;
import java.util.List;

public class Buque {
	int identificador;
	//idea tipo Par posicionGPSRespecto;
	FaseDeBuque estadoActual;
	List <Container> containersAsociados;
	
	public Buque(int identificador) {
		this.identificador = identificador;
		this.estadoActual = new FaseDeBuqueOutbound();
		this.containersAsociados = new ArrayList<Container>();
	}
}
