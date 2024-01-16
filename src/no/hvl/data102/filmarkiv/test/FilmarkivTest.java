package no.hvl.data102.filmarkiv.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {
	@Test
	void test() {
		Filmarkiv filmArkiv = new Filmarkiv(10);
		assertTrue(filmArkiv.erTom());
		
		Film sherlock = new Film(123, "Mark Gatiss", "Sherlock", 2010, "BBC", Sjanger.DRAMA);
		
		filmArkiv.leggTilFilm(sherlock);
		assertTrue(filmArkiv.finnFilm(123).equals(sherlock));
		
		Film deadpool = new Film(321, "Tim Miller", "Deadpool", 2016, "Marvel", Sjanger.ACTION);
		
		filmArkiv.leggTilFilm(deadpool);
		
		Film[] sok = filmArkiv.soekTittel("Dead");
		assertTrue(sok[0].equals(deadpool));
		
		sok = filmArkiv.soekProdusent("Tim");
		assertTrue(sok[0].equals(deadpool));

		assertEquals(filmArkiv.antall(Sjanger.DRAMA), 1);
		
		assertTrue(filmArkiv.slettFilm(sherlock.getFilmNr()));
		assertEquals(filmArkiv.antall(), 1);
		assertTrue(filmArkiv.slettFilm(deadpool.getFilmNr()));
		assertTrue(filmArkiv.erTom());
	}
}
