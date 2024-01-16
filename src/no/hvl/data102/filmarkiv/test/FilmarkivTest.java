package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {

	@Test
	void test() {
		Filmarkiv f = new Filmarkiv(1);
		Film film1 = new Film(1, "Scott", "Alien", 1979, Sjanger.SCIFI, "20th Century Studios");
		Film film2 = new Film(2, "Spielberg", "Jaws", 1975, Sjanger.HORROR, "Universal Pictures");
		Film film3 = new Film(3, "Anderson", "Grand Budapest Hotel", 2014, Sjanger.COMEDY, "Searchlight Pictures");
		Film film4 = new Film(4, "Ritchie", "Snatch", 2000, Sjanger.COMEDY, "Columbia Pictures");

		// Sjekker at antall er 0 før filmer legges til i arkivet.
		assertEquals(f.antall(), 0);

		// Legger til filmer i arkivet.
		f.leggTilFilm(film1);
		f.leggTilFilm(film2);
		f.leggTilFilm(film3);
		f.leggTilFilm(film4);

		// Sjekker at antall stemmer etter å ha lagt til filmer.
		assertEquals(f.antall(), 4);

		// Sletter filmene fra arkivet.
		assertTrue(f.slettFilm(1));
		assertTrue(f.slettFilm(2));
		assertTrue(f.slettFilm(3));
		assertTrue(f.slettFilm(4));

		// Sjekker at antall stemmer etter å ha slettet filmer.
		assertEquals(f.antall(), 0);

		// Legger til filmer i arkivet igjen.
		f.leggTilFilm(film1);
		f.leggTilFilm(film2);
		f.leggTilFilm(film3);
		f.leggTilFilm(film4);

		// Søker etter filmtittel i arkivet og sjekker at størrelsen på
		// tabellen med søkeresultater stemmer.
		Film[] tittelTreff = f.soekTittel("Jaws");
		assertEquals(1, tittelTreff.length);

		tittelTreff = f.soekTittel("Toy Story");
		assertEquals(0, tittelTreff.length);

		tittelTreff = f.soekTittel("A");
		assertEquals(4, tittelTreff.length);

		// Søker etter produsenter i arkivet og sjekker at størrelsen på
		// tabellen med søkeresultater stemmer.
		Film[] produsentTreff = f.soekProdusent("Scott");
		assertEquals(1, produsentTreff.length);

		produsentTreff = f.soekProdusent("Shyamalan");
		assertEquals(0, produsentTreff.length);

		produsentTreff = f.soekProdusent("S");
		assertEquals(3, produsentTreff.length);
		
		// Tester antall(Sjanger sjanger)
		assertEquals(2, f.antall(Sjanger.COMEDY));
		assertEquals(0, f.antall(Sjanger.DRAMA));
		

	}

}
