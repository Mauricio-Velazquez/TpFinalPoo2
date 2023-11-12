package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class Tramo {
	private TerminalGestionada terminalOrigen;
	private TerminalGestionada terminalDestino;
	private double costo;
	private int tiempoEstimadoEnHoras;
	private double distanciaEnKilometros;
	
	public Tramo(TerminalGestionada terminalOrigen, TerminalGestionada terminalDestino, double costo,
			int tiempoEstimadoEnHoras, double distanciaEnKilometros) {
		this.terminalOrigen = terminalOrigen;
		this.terminalDestino = terminalDestino;
		this.costo = costo;
		this.tiempoEstimadoEnHoras = tiempoEstimadoEnHoras;
		this.distanciaEnKilometros = distanciaEnKilometros;
	}

	public TerminalGestionada getTerminalOrigen() {
		return terminalOrigen;
	}

	public void setTerminalOrigen(TerminalGestionada terminalOrigen) {
		this.terminalOrigen = terminalOrigen;
	}

	public TerminalGestionada getTerminalDestino() {
		return terminalDestino;
	}

	public void setTerminalDestino(TerminalGestionada terminalDestino) {
		this.terminalDestino = terminalDestino;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getTiempoEstimadoEnHoras() {
		return tiempoEstimadoEnHoras;
	}

	public void setTiempoEstimadoEnHoras(int tiempoEstimadoEnHoras) {
		this.tiempoEstimadoEnHoras = tiempoEstimadoEnHoras;
	}

	public double getDistanciaEnKilometros() {
		return distanciaEnKilometros;
	}

	public void setDistanciaEnKilometros(double distanciaEnKilometros) {
		this.distanciaEnKilometros = distanciaEnKilometros;
	}
	
	
}
