package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;


public class Tekstgrensesnitt {
	
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm(FilmarkivADT filmarkiv) {
		Scanner filmScanner = new Scanner(System.in);  // Create a Scanner object
		int filmnr;
		int aar;
		
		while (true) {
			System.out.println("Skriv inn filmnr: ");
			String filmnrRaw = filmScanner.nextLine();  // Read user input
			try {
				filmnr = Integer.parseInt(filmnrRaw);
				if (filmarkiv.finnFilm(filmnr) == null) {
					break;	
				} else {
					System.out.println("Det finnes allerede en film med den IDen.");
				}
			} catch(NumberFormatException ex) {
				System.out.println("Ikke gyldig filmnr. Forsøk igjen.");
			}
		}
	    
	    System.out.println("Skriv inn regissør: ");
	    String produsent = filmScanner.nextLine();  // Read user input
	    
	    System.out.println("Skriv inn tittel: ");
	    String tittel = filmScanner.nextLine();  // Read user input
	    
	    while (true) {
	    	System.out.println("Skriv inn lanseringsår: ");
	    	String aarRaw = filmScanner.nextLine();  // Read user input
	    	try {
				aar = Integer.parseInt(aarRaw);
				break;
			} catch(Exception ex) {
				System.out.println("Ikke gyldig år. Forsøk igjen.");
			}
		}
	    
	    System.out.println("Skriv inn sjanger: ");
	    String sjanger = filmScanner.nextLine();  // Read user input
	    
	    System.out.println("Skriv inn filmselskap: ");
	    String filmselskap = filmScanner.nextLine();  // Read user input
	    
	    filmScanner.close();
	    Film f = new Film(filmnr, produsent, tittel, aar, Sjanger.finnSjanger(sjanger), filmselskap);
	    System.out.println(f.toString());
	    return f;
	}

	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println("Filmnr: " + film.getFilmnr() + ", Regissør: " + film.getProdusent() + 
				", Tittel: " + film.getTittel() + ", Lanseringsår: " + film.getAar() + ", Sjanger: " + 
				film.getSjanger() + ", Filmselskap: " + film.getFilmselskap() + ".");
	}

	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		for (Film film : arkiv.soekTittel(delstreng)) {
			System.out.println(film);
		}
	}

	// Skriver ut alle Filmer av en produsent (produsent er delstreng)
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		for (Film film : arkiv.soekProdusent(delstreng)) {
			System.out.println(film);
		}
	}

	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Det er totalt: " + arkiv.antall() + " filmer i arkivet."); 
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.ACTION) + " actionfilmer i arkivet.");
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.DRAMA) + " actionfilmer i arkivet.");
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.HISTORY) + " historiefilmer i arkivet.");
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.COMEDY) + " komedier i arkivet.");
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.HORROR) + " skrekkfilmer i arkivet.");
		System.out.println("Det er totalt: " + arkiv.antall(Sjanger.SCIFI) + " sci-fi filmer i arkivet.");
	}
	
}