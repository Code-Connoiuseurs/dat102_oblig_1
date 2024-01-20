package filmarkiv.impl;

import java.util.Arrays;
import filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	
	private Film[] filmTab;
	private int antall;
	
	public Filmarkiv(int antall) {
		this.filmTab = new Film[antall];
		this.antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {	
	 for(int i = 0; i < filmTab.length; i++) {
		 if(filmTab[i].getFilmNr() == nr) {
			 return filmTab[i];
		   }
	     }
	   return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
	 if(antall >= filmTab.length) {
		 utvidTab();
		 }
	 
		filmTab[antall] = nyFilm;
		antall++;
	  }
	
	public void utvidTab() {
	  filmTab = Arrays.copyOf(filmTab, filmTab.length * 2);
	}

	@Override
	public boolean slettFilm(int filmnr) {
	  for(int i = 0; i < filmTab.length; i++) {
		if(filmTab[i] != null && filmTab[i].getFilmNr() == filmnr) {
			filmTab[i] = filmTab[antall - 1];
				antall--;
				return true;
		 }
	  }
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		Film[] funnetFilmer = new Film[antall];
		int t = 0;
		
		for(int i = 0; i < antall; i++) {
			if(filmTab[i].getFilmTittel().contains(delstreng)) {
				funnetFilmer[t++] = filmTab[i];
			}
		}
		
		return trimTab(funnetFilmer, t);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] funnetProdusent = new Film[antall];
		int p = 0;
		
		for(int i = 0; i < antall; i++) {
			if(filmTab[i].getProdusent().contains(delstreng)) {
				funnetProdusent[p++] = filmTab[i];
			}
		}
		return trimTab(funnetProdusent, p);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		 
		 for(int i = 0; i < this.antall; i++) {	
			 if(filmTab[i].getSjanger() == sjanger) {	
				 antall++;
			 }
		 }
		
		return antall;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int elementer) {
		Film[] nyTab = new Film[elementer];
		int i = 0;
		
		while(i < elementer) {
			nyTab[i] = tab[i];
			i++;
	}
		return nyTab;
	}
}
