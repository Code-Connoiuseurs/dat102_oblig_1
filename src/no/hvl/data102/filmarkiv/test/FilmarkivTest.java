package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {

	@Test
	void test() {

		// Lager en filmtabell med plass til 2 filmer.
//		FilmarkivADT<Film> nyTabell = new FilmArkiv<>(2);
		Filmarkiv f = new Filmarkiv(2);

		// Sjekker at den er tom.
		assertEquals(0, f.antall());

		// Legger til film
		Film f1 = new Film(1, "Sam Mendes", "Skyfall", 2012, Sjanger.ACTION, "Eon Productions");
		f.leggTilFilm(f1);

		// Nå skal det være 1 film i arkivet, og den skal ikke være tom
		assertEquals(1, f.antall());

		// Legger til film
		Film f2 = new Film(2, "Wes Anderson", "The Darjeeling Limited", 2007, Sjanger.COMEDY, "Eon Productions");
		Film f3 = new Film(3, "Woody Allen", "Midnight in Paris", 2011, Sjanger.COMEDY, "Eon Productions");
		Film f4 = new Film(4, "Christopher McQuarrie", "Mission Impossible: Dead Reckoning Part One", 2023,
				Sjanger.ACTION, "Eon Productions");
		f.leggTilFilm(f2);
		f.leggTilFilm(f3);
		f.leggTilFilm(f4);

		// Nå skal det være 4 film i arkivet, og den skal ikke være tom
		assertEquals(4, f.antall());

		
		// Sjekke om søk virker
		Filmarkiv tempTab = new Filmarkiv(soekTittel("Skyfall"));
		assertEquals("Skyfall", f.soekTittel("Skyfall"));
		assertEquals("Woody Allen", f.soekProdusent("Woody Allen"));

	}

}