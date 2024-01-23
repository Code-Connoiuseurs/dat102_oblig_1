package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class  FilmarkivTest {
	
	// Lager en filmtabell med plass til 2 filmer.
	Filmarkiv f = new Filmarkiv(2);
	Film f1 = new Film(1, "Sam Mendes", "Skyfall", 2012, Sjanger.ACTION, "Eon Productions");
	Film f2 = new Film(2, "Wes Anderson", "The Darjeeling Limited", 2007, Sjanger.COMEDY, "Eon Productions");
	Film f3 = new Film(3, "Woody Allen", "Midnight in Paris", 2011, Sjanger.COMEDY, "Eon Productions");
	Film f4 = new Film(4, "Christopher McQuarrie", "Mission Impossible: Dead Reckoning Part One", 2023,
					Sjanger.HORROR, "Eon Productions");
			
	@BeforeEach
	void initiate() {
		f.leggTilFilm(f1);
		f.leggTilFilm(f2);
		f.leggTilFilm(f3);
		f.leggTilFilm(f4);
	}
	
	@Test
	void finnFilm() {
		assertEquals(f.finnFilm(1), f1);
	}
	
	@Test
	void leggTilFilm() {
		// Sletter alle filmene i arkivet
		f.slettFilm(1);
		f.slettFilm(2);
		f.slettFilm(3);
		f.slettFilm(4);
		
		f.leggTilFilm(f1); // Legger til en film.
		assertEquals(1, f.antall()); // Nå skal det være 1 film i arkivet, og den skal ikke være tom
	}
	
	@Test
	void slettFilm() {
		// Sletter filmene i arkivet.
		f.slettFilm(1);
		f.slettFilm(2);
		f.slettFilm(3);
		f.slettFilm(4);
		// Sjekker at den er tom.
		assertEquals(0, f.antall());
	}
	
	
	@Test
	void soekTittel() {
		assertEquals(1, f.soekTittel("Skyfall").length);
	}
	
	@Test
	void soekProdusent() {
		assertEquals(1, f.soekProdusent("Woody").length);
	}
	
	@Test
	void antallSjanger() {
		// Sjekker antall filmer i hver sjanger.
		assertEquals(2, f.antall(Sjanger.COMEDY));
		assertEquals(1, f.antall(Sjanger.ACTION));
		assertEquals(0, f.antall(Sjanger.DRAMA));
	}
	
	@Test
	void antall() {
		// Sjekker totalt antall filmer i arkivet.
		assertEquals(4, f.antall());
	}
}