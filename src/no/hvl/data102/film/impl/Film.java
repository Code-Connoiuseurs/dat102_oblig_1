package no.hvl.data102.film.impl;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String tittel;
	private String produsent;
	private String filmselskap;
	private int lanseringsAr;
	private Sjanger sjanger;
	
	public Film() {
		
	}
	public Film(int filmNr, String tittel, String produsent, String filmselskap, int lanseringsAr, Sjanger sjanger) {
		super();
		this.filmNr = filmNr;
		this.tittel = tittel;
		this.produsent = produsent;
		this.filmselskap = filmselskap;
		this.lanseringsAr = lanseringsAr;
		this.sjanger = sjanger;
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
	@Override
	public String toString() {
		return "Film [filmNr=" + filmNr + ", tittel=" + tittel + ", produsent=" + produsent + ", filmselskap="
				+ filmselskap + ", lanseringsAr=" + lanseringsAr + ", sjanger=" + sjanger + "]";
	}
	
	
	
}
