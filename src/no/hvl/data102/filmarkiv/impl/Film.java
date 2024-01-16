package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lanseringsAr;
	private Sjanger sjanger;
	private String filmselskap;
	
	public Film() {
		
	}
	public Film(int filmNr, String produsent, String tittel, int lanseringsAr, String filmselskap, Sjanger sjanger) {
		super();
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsAr = lanseringsAr;
		this.sjanger = sjanger;
		this.filmselskap = filmselskap;
	}
	
	public int getFilmNr() {
		return filmNr;
	}
	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}
	public String getProdusent() {
		return produsent;
	}
	public void setProdusent(String produsent) {
		this.produsent = produsent;
	}
	public String getTittel() {
		return tittel;
	}
	public void setTittel(String tittel) {
		this.tittel = tittel;
	}
	public int getLanseringsAr() {
		return lanseringsAr;
	}
	public void setLanseringsAr(int lanseringsAr) {
		this.lanseringsAr = lanseringsAr;
	}
	public String getFilmselskap() {
		return filmselskap;
	}
	public void setFilmselskap(String filmselskap) {
		this.filmselskap = filmselskap;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmselskap, lanseringsAr, produsent, tittel);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr && Objects.equals(filmselskap, other.filmselskap)
				&& Objects.equals(lanseringsAr, other.lanseringsAr) && Objects.equals(produsent, other.produsent)
				&& Objects.equals(tittel, other.tittel);
	}
	public Sjanger getSjanger() {
		return sjanger;
	}
	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}
	
	
	
}
