package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private ArrayList<Voto> voti;
	
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi nuovo voto al libretto
	 * (Per ora nessun controllo)
	 * @param v: Voto da aggiungere
	 * @return true
	 */

	public boolean add(Voto v) {
		return this.voti.add(v);
	}
	
	public void stampa() {
		for (Voto v: this.voti) {
			System.out.println(v.toString());
		}
	}
	
	public void stampaPuntiUguali(int valore ) {
		for (Voto v: this.voti) {
			if (v.getPunti() == valore)
				System.out.println(v.toString());
		}
	}
	
	public void stampaPuntiMaggiori(int valore ) {
		for (Voto v: this.voti) {
			if (v.getPunti() > valore)
				System.out.println(v.toString());
		}
	}
	
	public void stampaPuntiMinori(int valore ) {
		for (Voto v: this.voti) {
			if (v.getPunti() < valore)
				System.out.println(v.toString());
		}
	}
	
	public Voto cercaVotoPerNome(String corso) {
		for (Voto v: this.voti) {
			if (v.getCorso().equals(corso)) 
				return v;	
		}
		return null;
	}

}
