package filmarkiv.impl;

import filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {

	private LinearNode<Film> start;
	private int antall;

	public LinearNode<Film> getStart() {
		return start;
	}

	public Filmarkiv2() {
		this.start = null;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> node = start;

		while (node != null) {
			Film filmen = node.getData();

			if (filmen.getFilmNr() == nr) {
				return filmen;
			}
			node = node.getNeste();
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (start == null) {
			start = new LinearNode<Film>(nyFilm);
		} else {
			LinearNode<Film> node = start;
			while (node.getNeste() != null) {
				node = node.getNeste();
			}
			node.setNeste(new LinearNode<>(nyFilm));
		}
	}

	@Override
	public boolean slettFilm(int filmnr) {
		if (start == null) {
			return false;
		}
		LinearNode<Film> node = start;

		while (node != null && node.getData().getFilmNr() != filmnr) {
			node = node.getNeste();
		}
		if (node != null) {
			start = node.getNeste();
		}
		return true;
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
		// TODO Auto-generated method stub
		return 0;
	}
}
