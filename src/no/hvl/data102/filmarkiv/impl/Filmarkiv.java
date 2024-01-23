package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	private Film[] filmTab;
	private int antall;

	public Filmarkiv(int antall) {
		this.filmTab = new Film[antall];
		this.antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		Film[] finnFilmTab = trimTab(filmTab, antall);
		for (Film film : finnFilmTab) {
			if (nr == film.getFilmnr()) {
				return film;
			}
		}
		return null;
	}

//		int i = 0;
//		while (i < filmTab.length) {
//			if (nr == filmTab[i].getFilmnr()) {
//				return filmTab[i];
//			} else {
//				i++;
//			}
//		}
//		System.out.println("Film ikke funnet.");
//		return null;
//	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall == filmTab.length) {
			filmTab = Arrays.copyOf(filmTab, filmTab.length * 2);
		}
		filmTab[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean funnet = false;
		int indeks = 0;
		while (indeks < antall && !funnet) {
			if (filmnr == filmTab[indeks].getFilmnr()) {
				funnet = true;
			} else {
				indeks++;
			}
		}
		if (!funnet) {
			return false;
		}

		filmTab[indeks] = filmTab[antall - 1];
		filmTab[antall - 1] = null;
		antall--;
		return true;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] soekTab = new Film[filmTab.length];
		int antallTreff = 0;

		for (Film film : filmTab) {
			if (film != null && film.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				soekTab[antallTreff] = film;
				antallTreff++;
			}
		}
		soekTab = trimTab(soekTab, antallTreff);
		return soekTab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] soekTab = new Film[filmTab.length];
		int antallTreff = 0;

		for (Film film : filmTab) {
			if (film != null && film.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				soekTab[antallTreff] = film;
				antallTreff++;
			}
		}
		soekTab = trimTab(soekTab, antallTreff);
		return soekTab;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int i = 0;
		Film[] trimFilmTab = trimTab(filmTab, antall);
		for (Film film : trimFilmTab) {
			if (film.getSjanger() == sjanger) {
				i++;
			}
		}
		return i;
	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimTab(Film[] tab, int n) {
		// n er antall elementer
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
	
	public String toString() {
		String x = "{ \n";
		Film[] trimFilmTab = trimTab(filmTab, antall);
		for (Film a : trimFilmTab) {
			x += "\t" + a.getFilmnr() + " " + a.getProdusent() + " " + a.getTittel() + " " +
					a.getAar() + " " + a.getSjanger() + " " + a.getFilmselskap() + "\n";
		}
		x += "}";
		return x;
	}
}
