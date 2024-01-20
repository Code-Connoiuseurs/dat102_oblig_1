package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {
	
	
	Filmarkiv liste = new Filmarkiv(3);
	Film film1 = new Film(1, "Alice", "The Enigmatic quest", 2023, Sjanger.Romance, "Enigma studios");
	Film film2 = new Film(2, "David", "Echoes of Eternity", 2021, Sjanger.Fantasy, "DreamScape studios");
	Film film3= new Film(3, "Emily", "Midnight Serenade", 2023, Sjanger.Romance, "Moonlight Productions");
	
		@Test
		void TestAntall() {
		// sjekker om listen er tom før filmer blir lagt til i Filmarkivet
		assertEquals(liste.antall(), 0);	
		}
		
		@Test
		void antallFilmer() {
			
			liste.leggTilFilm(film1);
			liste.leggTilFilm(film2);
			liste.leggTilFilm(film3);
			
			// sjekker om filmene ble lagt til
			assertEquals(liste.antall(), 3);
		}
		
		@Test
		void SlettTest() {
			
			liste.leggTilFilm(film1);
			liste.leggTilFilm(film2);
			liste.leggTilFilm(film3);

		    assertTrue(liste.slettFilm(1));
		    assertTrue(liste.slettFilm(2));
		    assertTrue(liste.slettFilm(3));
		    
		    assertEquals(liste.antall(), 0);
		}
		
		@Test
		void SokTittel() {
			
			liste.leggTilFilm(film1);
			liste.leggTilFilm(film2);
			liste.leggTilFilm(film3);
			
		    Film[] funnetTittel = liste.soekTittel("Echoes");
		    System.out.println(Arrays.toString(funnetTittel));
		    assertEquals(2, funnetTittel.length);

		    funnetTittel = liste.soekTittel("Midnight");
		    System.out.println(Arrays.toString(funnetTittel));
		    assertEquals(3, funnetTittel.length);

		    funnetTittel = liste.soekTittel("quest");
		    System.out.println(Arrays.toString(funnetTittel));
		    assertEquals(1, funnetTittel.length);
		    
		}
		
		@Test
		void SokProdusent() {
			
			liste.leggTilFilm(film1);
			liste.leggTilFilm(film2);
			liste.leggTilFilm(film3);

			Film[] funnetProdusent = liste.soekProdusent("David");
		    assertEquals(2, funnetProdusent.length);

		    funnetProdusent = liste.soekProdusent("Emily");
		    assertEquals(3, funnetProdusent.length);

		    funnetProdusent = liste.soekProdusent("Alice");
		    assertEquals(1, funnetProdusent.length);
		}
		
		@Test
		void antallSjanger() {
			
			liste.leggTilFilm(film1);
			liste.leggTilFilm(film2);
			liste.leggTilFilm(film3);
			
			assertEquals(0, liste.antall(Sjanger.DRAMA));
			assertEquals(1, liste.antall(Sjanger.Fantasy));
			assertEquals(2, liste.antall(Sjanger.Romance));
		}
}
