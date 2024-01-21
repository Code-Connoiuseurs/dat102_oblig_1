package filmarkiv.impl;

import java.util.Objects;

public class Film {

	private int filmNr;
	private String produsent; // navn på filmskaperen
	private String filmTittel;
	private int lanseringAar; // lanserings år
	private Sjanger sjanger;
	private String filmSelskap;

	public Film() {

	}

	public Film(int filmNr, String produsent, String filmTittel, int lanseringAar, Sjanger sjanger,
			String filmSelskap) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.filmTittel = filmTittel;
		this.lanseringAar = lanseringAar;
		this.sjanger = sjanger;
		this.filmSelskap = filmSelskap;

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

	public String getFilmTittel() {
		return filmTittel;
	}

	public void setFilmTittel(String filmTittel) {
		this.filmTittel = filmTittel;
	}

	public int getLanseringAar() {
		return lanseringAar;
	}

	public void setLanseringAar(int lanseringAar) {
		this.lanseringAar = lanseringAar;
	}

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmSelskap, filmTittel, lanseringAar, produsent, sjanger);
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
		return filmNr == other.filmNr && Objects.equals(filmSelskap, other.filmSelskap)
				&& Objects.equals(filmTittel, other.filmTittel) && lanseringAar == other.lanseringAar
				&& Objects.equals(produsent, other.produsent) && sjanger == other.sjanger;
	}

	// bruker til debugging
	@Override
	public String toString() {
		return "Film [filmNr=" + filmNr + ", produsent=" + produsent + ", filmTittel=" + filmTittel + ", lanseringAar="
				+ lanseringAar + ", sjanger=" + sjanger + ", filmSelskap=" + filmSelskap + "]";
	}
}
