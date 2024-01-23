package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

		private int antall;
		private LinearNode<Film> start;

		@Override
		public Film finnFilm(int nr) {
			return null;
		}
		
		@Override
		public void leggTilFilm(Film nyFilm) {
			if (antall == start.length) {
			}
			start[antall] = nyFilm;
			antall++;
		}
		
		@Override
		public boolean slettFilm(int filmnr) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public Film[] soekTittel(String delstreng) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Film[] soekProdusent(String delstreng) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int antall(Sjanger sjanger) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public int antall() {
			return antall;
		}
}
