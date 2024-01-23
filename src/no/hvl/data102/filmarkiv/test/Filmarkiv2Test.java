package no.hvl.data102.filmarkiv.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {
	private Filmarkiv2 filmArkiv;
	private Film sherlock;
	private Film deadpool;
	private Film joker;
	private Film parasite;
	
	@BeforeEach
	void initTests() {		
		filmArkiv = new Filmarkiv2();
		
		sherlock = new Film(123, "Sherlock", "Mark Gatiss", "BBC", 2010,  Sjanger.DRAMA);
		deadpool = new Film(321,  "Deadpool", "Tim Miller", "Marvel", 2016,  Sjanger.ACTION);
		joker 	 = new Film(890, "Joker", "Todd Phillips", "Warner Bros", 2019,  Sjanger.DRAMA);
		parasite = new Film(567, "Parasite", "Bong Joon Ho", "CJ Entertainment", 2019,  Sjanger.DRAMA);
		
		filmArkiv.leggTilFilm(sherlock);
		filmArkiv.leggTilFilm(deadpool);
		filmArkiv.leggTilFilm(joker);
		filmArkiv.leggTilFilm(parasite);
	}
	
	@Test
	void testFinnFilm() {		
		assertTrue(filmArkiv.finnFilm(123).equals(sherlock));
	}
	
	@Test
	void testSoekTittel() {
		Film[] sok = filmArkiv.soekTittel("Dead");
		assertTrue(sok[0].equals(deadpool));
	}
	
	@Test
	void testSoekProdusent() {		
		Film[] sok = filmArkiv.soekProdusent("Tim");
		assertTrue(sok[0].equals(deadpool));
	}
	
	@Test
	void testAntallAvSjanger() {		
		assertEquals(filmArkiv.antall(Sjanger.DRAMA), 3);
	}
	
	@Test
	void testSlettFilm() {		
		assertTrue(filmArkiv.slettFilm(sherlock.getFilmNr()));
		assertEquals(filmArkiv.finnFilm(sherlock.getFilmNr()), null);
	}
	
	@Test
	void testErTom() {
		filmArkiv.slettFilm(123);
		filmArkiv.slettFilm(321);
		filmArkiv.slettFilm(890);
		filmArkiv.slettFilm(567);
		assertTrue(filmArkiv.erTom());
	}
}
