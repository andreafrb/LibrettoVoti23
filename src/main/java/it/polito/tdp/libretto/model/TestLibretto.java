package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	public static void main(String[] args) {
		
		Libretto lib = new Libretto();
		
		lib.add(new Voto("Analisi 1", 29, LocalDate.of(2023, 02, 15)));
		lib.add(new Voto("Analisi 2", 25, LocalDate.of(2023, 06, 15)));
		lib.add(new Voto("Fisica 1", 29, LocalDate.of(2023, 02, 1)));
		lib.add(new Voto("Fisica 2", 27, LocalDate.of(2023, 01, 15)));
		lib.add(new Voto("Geometria 5", 23, LocalDate.of(2023, 03, 15)));
		
		lib.stampa();
		System.out.println("VOTO=25");
		lib.stampaPuntiUguali(25);
		System.out.println("VOTO>25");
		lib.stampaPuntiMaggiori(25);
		System.out.println("VOTO<25");
		lib.stampaPuntiMinori(25);
		
		Voto v = lib.cercaVotoPerNome("Analisi 1");
		System.out.println(v);

	}

}
