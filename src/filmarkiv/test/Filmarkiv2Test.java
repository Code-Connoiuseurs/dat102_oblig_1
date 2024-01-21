package filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import filmarkiv.impl.Film;
import filmarkiv.impl.Filmarkiv2;
import filmarkiv.impl.LinearNode;
import filmarkiv.impl.Sjanger;

public class Filmarkiv2Test {

	Filmarkiv2 filmarkiv = new Filmarkiv2();

	Film film1 = new Film(1, "Alice", "The Enigmatic quest", 2023, Sjanger.Romance, "Enigma studios");
	Film film2 = new Film(2, "David", "Echoes of Eternity", 2021, Sjanger.Fantasy, "DreamScape studios");
	Film film3 = new Film(3, "Emily", "Midnight Serenade", 2023, Sjanger.Romance, "Moonlight Productions");

	@Test
	public void testLeggTilFilm() {

		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		filmarkiv.leggTilFilm(film3);

	}

	@Test
	public void sjekkListe() {

		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		filmarkiv.leggTilFilm(film3);

		LinearNode<Film> n = filmarkiv.getStart();
		assertEquals(film1, n.getData());
		assertEquals(film2, n.getNeste().getData());
		assertEquals(film3, n.getNeste().getNeste().getData());
		// assertEquals(null, n.getNeste().getNeste().getNeste().getData());
	}

	@Test
	public void testFinnFilm() {

		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		filmarkiv.leggTilFilm(film3);

		assertEquals(film1, filmarkiv.finnFilm(1));
		assertEquals(film2, filmarkiv.finnFilm(2));
		assertEquals(film3, filmarkiv.finnFilm(3));
		// assertNull(filmarkiv.finnFilm(4));

	}

	@Test
	public void testSelttFilm() {

		filmarkiv.leggTilFilm(film1);
		filmarkiv.leggTilFilm(film2);
		filmarkiv.leggTilFilm(film3);
		
		System.out.println("Før:\n");
	    printFilmList(filmarkiv.getStart());

		filmarkiv.slettFilm(1);
		filmarkiv.slettFilm(2);
		filmarkiv.slettFilm(3);
		
		 System.out.println("Etter:");
		    printFilmList(filmarkiv.getStart());

	}

	private void printFilmList(LinearNode<Film> start) {
		 LinearNode<Film> node = start;
		    while (node != null) {
		        System.out.println(node.getData());
		        node = node.getNeste();
		    }
		    System.out.println();
		}
		
	}
