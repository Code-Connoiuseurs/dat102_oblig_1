package no.hvl.data102.filmarkiv.adt;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
	
	
	Film finnFilm(int nr);
	
	/**
	* Hente en film med gitt nr fra arkivet
	* @param nr nummer på film som skal hentes.
	* @return film med gitt nr. Om nr ikke finnes, returneres null.
	*/
	
	void leggTilFilm(Film nyFilm);
	
	/**
	* Legger til en ny film.
	* @param nyFilm
	*/
	
	boolean slettFilm(int filmnr);
	
	/**
	* Sletter en fil med gitt nr
	* @param filmnr nr på film som skal slettes
	* @return true dersom filmen ble slettet, false ellers
	*/
	
	Film[] soekTittel(String delstreng);
	
	/**
	* Søker og henter Filmer med en gitt delstreng i tittelen.
	* @param delstreng som må være i tittel
	* @return tabell med filmer som har delstreng i tittel
	*/
	
	Film[] soekProdusent(String delstreng);
	
	/**
	* Søker og henter filmer med en gitt delstreng i filmprodusent
	* @param delstreng
	* @return
	*/
	
	int antall(Sjanger sjanger);
	
	/**
	* Finner antall filmer med gitt sjanger
	* @param sjanger
	* @return antall filmer av gitt sjanger.
	*/
	
	int antall();
	/**
	* @return antall filmer i arkivet
	*/
	}

