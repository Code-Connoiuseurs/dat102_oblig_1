package no.hvl.data102.filmarkiv.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import no.hvl.data102.film.impl.Film;
import no.hvl.data102.film.impl.Sjanger;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Meny {
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		Film sherlock = new Film(123, "Sherlock", "Mark Gatiss", "BBC", 2010, Sjanger.DRAMA);
		Film deadpool = new Film(321, "Deadpool", "Tim Miller", "Marvel", 2016, Sjanger.ACTION);
		Film joker = new Film(890, "Joker", "Todd Phillips", "Warner Bros", 2019, Sjanger.DRAMA);
		Film parasite = new Film(567, "Parasite", "Bong Joon Ho", "CJ Entertainment", 2019, Sjanger.DRAMA);

		filmarkiv.leggTilFilm(sherlock);
		filmarkiv.leggTilFilm(deadpool);
		filmarkiv.leggTilFilm(joker);
		filmarkiv.leggTilFilm(parasite);

		System.out.println("0: Lukk programmet");
		System.out.println("1: Les inn ny film");
		System.out.println("2: Vis filminfo");
		System.out.println("3: Søk etter tittel");
		System.out.println("4: Søk etter produsent");
		System.out.println("5: Vis arkivstatistikk");

		Scanner scanner = new Scanner(System.in);

		boolean ferdig = false;

		while (true && !ferdig) {
			System.out.print("Tast inn menyvalg (1-5) eller avslutt programmet med 0:");
			int input = Integer.parseInt(scanner.nextLine());
			switch (input) {
			case 0:
				ferdig = true;
				System.out.println("Program avsluttet.");
				break;
			case 1:
				filmarkiv.leggTilFilm(Tekstgrensesnitt.lesFilm(filmarkiv));
				break;
			case 2:
				int fnr = 0;
				try {
					System.out.print("Skriv filmnummer: ");
					fnr = Integer.parseInt(scanner.nextLine());
				} catch (InputMismatchException | NumberFormatException e) {
					System.out.println("Filmnummer består av kun tall.");
					break;
				}
				if (filmarkiv.finnFilm(fnr) == null) {
					System.out.println("Film med ID: " + fnr + " finnes ikke i arkivet.");
					break;
				}
				Tekstgrensesnitt.skrivUtFilm(filmarkiv.finnFilm(fnr));
				break;
			case 3:
				System.out.print("Skriv filmtittel: ");
				Tekstgrensesnitt.skrivUtFilmDelstrengITittel(filmarkiv, scanner.nextLine());
				break;
			case 4:
				System.out.print("Skriv filmprodusent: ");
				Tekstgrensesnitt.skrivUtFilmProdusent(filmarkiv, scanner.nextLine());
				break;
			case 5:
				Tekstgrensesnitt.skrivUtStatistikk(filmarkiv);
				break;
			}
		}
		scanner.close();
	}
}
