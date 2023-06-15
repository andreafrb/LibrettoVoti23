package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Libretto {
	
	private ArrayList<Voto> voti;
	
	
	public Libretto() {
		this.voti = new ArrayList<Voto>();
	}
	
	/**
	 * Aggiungi nuovo voto al libretto
	 * Controllo se duplicato o conflitto
	 * @param v: Voto da aggiungere
	 * @return true se voto si può aggiungere, falso altrimenti
	 */

	public boolean add(Voto v) {
		if (this.esisteVotoConflitto(v) || this.esisteVotoDuplicato(v)) {
			//Non aggiungere voto
			
			//opzione 1: eccezione
			throw new IllegalArgumentException("Voto errato: " + v);
			//option 2: return false
		}		
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
		//throw new RuntimeException("Voto non trovato");
	}
	
	public boolean esisteVotoDuplicato(Voto nuovo) {
		for (Voto v: voti) {
			if (v.isDuplicato(nuovo))
				return true;
		}
		return false;	
	}
	
	public boolean esisteVotoConflitto(Voto nuovo) {
		for (Voto v: voti) {
			if (v.isDuplicato(nuovo))
				return true;
		}
		return false;	
	}
	
	/**
	 * Metodo factory per creare un nuovo libretto con i voti migliorati
	 * @return
	 */
	public Libretto librettoMigliorato() {
		Libretto miglioreLibretto = new Libretto();
		//miglioreLibretto.voti = new ArrayList<>(this.voti); //Così facendo i voti vengono condivisi dai due libretti
		miglioreLibretto.voti = new ArrayList<>(); 
		//Devo fare copia dei singoli elementi 
		for (Voto v: this.voti) {
			//miglioreLibretto.voti.add(v.clone());
			miglioreLibretto.voti.add(new Voto(v));
		}
		for (Voto v: miglioreLibretto.voti) {
			v.setPunti(v.getPunti()+2);
		}
		
		return miglioreLibretto;		
	}
	
	public void cancellaVotiInferiori(int punti) {
		//Opzione 1, sbagliata: stai iterando su una collection(lista) e al tempo stesso la stai modificando, da errore
		/*
		for (Voto v: this.voti) {
			if (v.getPunti() < punti)
				this.voti.remove(v);
		}
		
		//MAI AGGIUNGERE/TOGLIERE nella lista NELLO STESSO CICLO IN CUI STAI ITERANDO PER VISUALIZZARE
		
		//Opzione 2, sbagliata perchè stai cercando gli elementi e al tempo stesso modificando gli indici e la size man mano che elimini		
		for (int i=0; i<this.voti.size(); i++) {
			if (this.voti.get(i).getPunti() < punti)
				this.voti.remove(i);	
		}
		*/
		
		//Separare le operazioni: 
		//a) capire quali elementi rimuovere e aggiungerli in nuova lista  
		List<Voto> daCancellareList = new ArrayList<Voto>();
		for (Voto v: this.voti) {
			if (v.getPunti() < punti)
				daCancellareList.add(v);
		}
		//b) rimuoverli in un secondo momento:
		for (Voto v1: daCancellareList) {
			this.voti.remove(v1);
		}	
		//this.voti.removeAll(daCancellareList); cancellare la voti tutti gli elementi da daCancellareList
		
	}
	
	public Libretto librettoOrdinatoAlfabeticamente() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti); //cloniamo libretto 
		
		// ordinato.voti è una lista, e le liste hanno metodo sort che ri riordina gli elem senza modificarli
		ordinato.voti.sort(new ComparatorByName()); 
		//Collections.sort(ordinato.voti, new ComparatorByName() );

		return ordinato;
		
	}
	
	public Libretto librettoOrdinatoPerVoto() {
		Libretto ordinato = new Libretto();
		ordinato.voti = new ArrayList<>(this.voti); //cloniamo libretto 
		
		//Creo comparatore
		ordinato.voti.sort(new Comparator<Voto>(){
			@Override
			public int compare(Voto o1, Voto o2) {
				
				return o2.getPunti() - o1.getPunti();
			}		
		});

		return ordinato;
		
	}

}
