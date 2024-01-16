package no.hvl.data102.filmarkiv.impl;

import java.util.Arrays;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private Film[] filmSamling;
//	private int antall;

	public Filmarkiv(int antall) {
		this.filmSamling = new Film[antall];
	}

	@Override
	public Film finnFilm(int nr) {
		for (Film film : filmSamling) {
			if (film.getFilmNr() == nr)
				return film;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall() >= filmSamling.length) {
			filmSamling = Arrays.copyOf(filmSamling, (filmSamling.length * 2) + 1);
		}
		filmSamling[antall()] = nyFilm;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i <= filmSamling.length; i++) {
			if (filmSamling[i] != null && filmSamling[i].getFilmNr() == filmnr) {
				filmSamling[i] = filmSamling[antall()+1];
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] sok = new Film[filmSamling.length];
		int ant = 0;
		for (Film film : filmSamling) {
			if (film != null && film.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				sok[ant] = film;
				ant++;
			}
		}
		sok = trimTab(sok, ant);
		return sok;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] sok = new Film[filmSamling.length];
		int ant = 0;
		for (Film film : filmSamling) {
			if (film != null && film.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				sok[ant] = film;
				ant++;
			}
		}
		sok = trimTab(sok, ant);
		return sok;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		if (erTom()) return 0;
		for (Film film : filmSamling) {
			if (film != null && film.getSjanger() == sjanger) antall++;
		}
		return antall;
	}
	
	public boolean erTom() {
		return antall() == 0;
	}

	@Override
	public int antall() {
		int antall = 0;
		for (Film film : filmSamling) {
			if (film != null)
				antall++;
		}
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
}
