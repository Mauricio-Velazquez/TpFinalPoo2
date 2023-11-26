package ar.edu.unq.po2.tpFinal.naviera;

import ar.edu.unq.po2.tpFinal.terminalGestionada.TerminalGestionada;

public class Tramo {
	private TerminalGestionada terminalOrigen;
	private TerminalGestionada terminalDestino;
	private double costo;
	private int tiempoEstimadoEnHoras;
	
	public Tramo(TerminalGestionada terminalOrigen, TerminalGestionada terminalDestino, double costo, int tiempoEstimadoEnHoras) {
		this.terminalOrigen = terminalOrigen;
		this.terminalDestino = terminalDestino;
		this.costo = costo;
		this.tiempoEstimadoEnHoras = tiempoEstimadoEnHoras;
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
	
	public boolean incluyeTerminal(TerminalGestionada terminal) {
	    return this.terminalOrigen.equals(terminal) || this.terminalDestino.equals(terminal);
	}
	
	public boolean incluyeTerminalDestino(TerminalGestionada terminal) {
	    return this.terminalDestino.equals(terminal);
	}

}
