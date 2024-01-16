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
		for (Film f : filmTab) {
			if (f.getFilmnr() == nr) {
				return f;
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (antall >= filmTab.length) {
			utvidTabell();
		}
		filmTab[antall] = nyFilm;
		antall++;
	}

	private void utvidTabell() {
		filmTab = Arrays.copyOf(filmTab, (filmTab.length * 2));
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < filmTab.length; i++) {
			if (filmTab[i].getFilmnr() == filmnr) {
				filmTab[i] = filmTab[antall - 1];
				antall--;
				return true;
			}
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] result = new Film[filmTab.length];
		int antallTreff = 0;

		for (Film f : filmTab) {
			if (f.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				result[antallTreff] = f;
				antallTreff++;
			}
		}
		result = trimTab(result, antallTreff);
		return result;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] result = new Film[filmTab.length];
		int antallTreff = 0;

		for (Film f : filmTab) {
			if (f.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				result[antallTreff] = f;
				antallTreff++;
			}
		}
		result = trimTab(result, antallTreff);
		return result;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;

		for (Film f : filmTab) {
			if (f.getSjanger() == sjanger) {
				antall++;
			}
		}
		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimTab(Film[] tab, int antall) {
		// antall er antall elementer
		Film[] nytab = new Film[antall];
		int i = 0;
		while (i < antall) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}

}
