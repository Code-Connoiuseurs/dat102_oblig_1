package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;

	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}

	public void start() {
		// legg inn en del forhåndsdefinerte filmer for å teste metodene
		Film f1 = new Film(1, "Sam Mendes", "Skyfall", 2012, Sjanger.ACTION, "Eon Productions");
		Film f2 = new Film(2, "Wes Anderson", "The Darjeeling Limited", 2007, Sjanger.COMEDY, "Eon Productions");
		Film f3 = new Film(3, "Woody Allen", "Midnight in Paris", 2011, Sjanger.COMEDY, "Eon Productions");
		Film f4 = new Film(4, "Christopher McQuarrie", "Mission Impossible: Dead Reckoning Part One", 2023,
				Sjanger.HORROR, "Eon Productions");
		filmarkiv.leggTilFilm(f1);
		filmarkiv.leggTilFilm(f2);
		filmarkiv.leggTilFilm(f3);
		filmarkiv.leggTilFilm(f4);
		
//		for (Film film : filmarkiv) {
//			
//		}
		
//		filmarkiv.leggTilFilm(tekstgr.lesFilm(filmarkiv));
//		tekstgr.skrivUtFilm(f1);
		System.out.println(filmarkiv.toString());
		tekstgr.skrivUtStatistikk(filmarkiv);
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, "miSSion");
		tekstgr.skrivUtFilmProdusent(filmarkiv, "Woody");
		System.out.println(filmarkiv.antall());
		
		
	}
}