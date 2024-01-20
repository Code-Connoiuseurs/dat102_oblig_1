package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		Film sherlock = new Film(123, "Sherlock", "Mark Gatiss", "BBC", 2010,  Sjanger.DRAMA);
		Film deadpool = new Film(321, "Deadpool", "Tim Miller", "Marvel", 2016,  Sjanger.ACTION);
		Film joker = new Film(890, "Joker", "Todd Phillips", "Warner Bros", 2019,  Sjanger.DRAMA);
		Film parasite  = new Film(567, "Parasite", "Bong Joon Ho", "CJ Entertainment", 2019,  Sjanger.DRAMA);
		
		filmarkiv.leggTilFilm(sherlock);
		filmarkiv.leggTilFilm(deadpool);
		filmarkiv.leggTilFilm(joker);
		filmarkiv.leggTilFilm(parasite);
		
		System.out.println("0: Lukk programmet");
		System.out.println("1: Les inn ny film");
		System.out.println("2: Vis film info");
		System.out.println("3: Søk etter tittel");
		System.out.println("4: Søk etter produsent");
		System.out.println("5: Vis arkiv statistikk");
		
		
		Scanner scanner = new Scanner(System.in);
		
		boolean ferdig = false;
		
		while (true && !ferdig) {
			System.out.print("Hvilket tall velger du?");
			int input = scanner.nextInt();
			switch (input) {
			case 0:
				ferdig = true;
				break;
			case 1:
				filmarkiv.leggTilFilm(Tekstgrensesnitt.lesFilm());
				break;
			case 2:
				System.out.print("Skriv film nummer: " );
				Tekstgrensesnitt.skrivUtFilm(filmarkiv.finnFilm(scanner.nextInt()));
				break;
			case 3:
				System.out.print("Skriv inn film tittel: " );
				Tekstgrensesnitt.skrivUtFilmDelstrengITittel(filmarkiv, scanner.next());
				break;
			case 4:
				System.out.print("Skriv film produsent: " );
				Tekstgrensesnitt.skrivUtFilmProdusent(filmarkiv, scanner.next());
				break;
			case 5:
				Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
				break;
			}				
		}
		scanner.close();
	}
}
