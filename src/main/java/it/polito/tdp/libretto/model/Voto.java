package it.polito.tdp.libretto.model;
import java.time.LocalDate;

public class Voto {
	private String corso;
	private int punti; //da 18 a 31
	private LocalDate data;
	
	public Voto(String corso, int punti, LocalDate data) {
		super();
		this.corso = corso;
		this.punti = punti;
		this.data = data;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Voto [corso=" + corso + ", punti=" + punti + ", data=" + data + "]";
	}
	
	
	
	
	

}
