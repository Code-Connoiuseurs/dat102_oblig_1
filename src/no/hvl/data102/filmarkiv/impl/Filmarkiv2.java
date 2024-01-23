package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.film.impl.Film;
import no.hvl.data102.film.impl.Sjanger;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

/**
 * En implementasjon av filmarkiv datatypen som bruker en lenket struktur
 */
public class Filmarkiv2 implements FilmarkivADT {
	
	private class LinearNode<T> {
		public T data;
		public LinearNode<T> neste;
		
		public LinearNode(T data, LinearNode<T> neste) {
			this.data = data;
			this.neste = neste;
		}
		public LinearNode(T data) {
			this(data, null);
		}
		
		public int getSize() {
			LinearNode<T> node = this;
			int size = 0;
			while (node != null) {
				size++;
				node = node.neste;
			}
			return size;
		}
	}
	
	private LinearNode<Film> filmSamlingStart;

	public Filmarkiv2() {
		this.filmSamlingStart = null;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> node = filmSamlingStart;
		while (node != null) {
			if (node.data.getFilmNr() == nr) return node.data;
			node = node.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> prevStart = filmSamlingStart;
		filmSamlingStart = new LinearNode<Film>(nyFilm);
		filmSamlingStart.neste = prevStart;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		LinearNode<Film> node = filmSamlingStart;
		while (node != null) {
			if (node.data.getFilmNr() == filmnr) {
				node.data = filmSamlingStart.data; // Vi bytter ut noden vi skal slette med den første noden
				filmSamlingStart = filmSamlingStart.neste;
				return true;
			}
			node = node.neste;
		}
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> node = filmSamlingStart;
		LinearNode<Film> sok = new LinearNode<Film>(null, null);
		while (node != null) {
			if (node.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
				LinearNode<Film> newNode = new LinearNode<Film>(node.data, sok.neste);
				sok = newNode;
			}
			node = node.neste;
		}
		return toArray(sok);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> node = filmSamlingStart;
		LinearNode<Film> sok = new LinearNode<Film>(null, null);
		while (node != null) {
			if (node.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())) {
				LinearNode<Film> newNode = new LinearNode<Film>(node.data, sok.neste);
				sok = newNode;
			}
			node = node.neste;
		}
		return toArray(sok);
	}

	@Override
	public int antall(Sjanger sjanger) {
		int antall = 0;
		LinearNode<Film> node = filmSamlingStart;
		while (node != null) {
			if (node.data.getSjanger() == sjanger) {
				antall++;
			}
			node = node.neste;
		}
		return antall;
	}
	
	public boolean erTom() {
		return (filmSamlingStart == null);
	}

	@Override
	public int antall() {
		int antall = 0;
		LinearNode<Film> node = filmSamlingStart;
		while (node != null) {
			antall++;
			node = node.neste;
		}
		return antall;
	}
	
	public Film[] toArray(LinearNode<Film> startNode) {
		Film[] array = new Film[startNode.getSize()];
		LinearNode<Film> node = startNode;
		int index = 0;
		while ((index < (startNode.getSize())) && (node != null)) {
			array[index] = node.data;
			index++;
			node = node.neste;
		}
		return array;
	}
	
}
