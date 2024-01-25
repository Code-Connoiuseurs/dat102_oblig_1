package no.hvl.data102.filmarkiv.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import no.hvl.data102.film.impl.Film;
import no.hvl.data102.film.impl.Sjanger;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;

// Vi velger å implementere Tekstgrensesnitt med statiske metoder sånn at vi ikke trenger å initialisere den
public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnerer et Film-objekt
	public static Film lesFilm(FilmarkivADT arkiv) {

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int filmNr = 0;
		do {
			try {
				System.out.println("Skriv inn filmnummer: ");
				filmNr = Integer.parseInt(scanner.nextLine());
			} catch (InputMismatchException | NumberFormatException e) {
				System.out.println("Filmnummer må bestå av kun tall. Prøv igjen.");
			}
			if (!erUniktFilmNr(arkiv, filmNr)) {
				System.out.println("Filmnummer " + filmNr + " finnes allerede i arkivet. Prøv igjen.");
			}
		} while (filmNr <= 0 || !erUniktFilmNr(arkiv, filmNr));

		System.out.println("Skriv inn tittel: ");
		String tittel = scanner.nextLine();

		System.out.println("Skriv inn produsent: ");
		String produsent = scanner.nextLine();

		System.out.println("Skriv inn filmselskap: ");
		String filmselskap = scanner.nextLine();

		int lanseringsAr = 0;
		do {
			try {
				System.out.println("Skriv inn lanseringsår: ");
				lanseringsAr = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Lanseringsår må bestå av kun tall. Prøv igjen.");
			}
		} while (1888 >= lanseringsAr || lanseringsAr > 2050);

		Sjanger sjanger;
		do {
			System.out.println("Skriv inn sjanger: (Action, drama, history, scifi)");
			sjanger = Sjanger.finnSjanger(scanner.nextLine());
		} while (sjanger == null);

		return new Film(filmNr, tittel, produsent, filmselskap, lanseringsAr, sjanger);

	}

	private static boolean erUniktFilmNr(FilmarkivADT arkiv, int filmnr) {
		return (arkiv.finnFilm(filmnr) == null);
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public static void skrivUtFilm(Film film) {
		System.out.println(film.toString());
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public static void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		for (Film film : arkiv.soekTittel(delstreng)) {
			System.out.println(film.toString());
		}
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public static void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		for (Film film : arkiv.soekProdusent(delstreng)) {
			System.out.println(film.toString());
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public static void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer totalt: " + arkiv.antall());
		for (Sjanger sjanger : Sjanger.values()) {
			System.out.println("Antall " + sjanger.toString() + " filmer: " + arkiv.antall(sjanger));
		}
	}
	// osv ... andre metoder
}