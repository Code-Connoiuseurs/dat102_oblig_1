package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

// Vi velger å implementere Tekstgrensesnitt med statiske metoder sånn at vi ikke trenger å initsialisere den
public class Tekstgrensesnitt {
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public static Film lesFilm(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input informasjon for film:");
		
		int filmNr = Integer.parseInt(scanner.next("filmNr: "));
		String tittel = scanner.next("Tittel: ");
		String produsent = scanner.next("Produsent: ");
		String filmselskap = scanner.next("Filmselskap: ");
		int lanseringsAr = Integer.parseInt(scanner.next("Lanseringsår: "));
		Sjanger sjanger = Sjanger.finnSjanger(scanner.next("Sjanger"));
		scanner.close();

		return new Film(filmNr, tittel, produsent, filmselskap, lanseringsAr, sjanger);

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