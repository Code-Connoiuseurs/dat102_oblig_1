package no.hvl.data102.filmarkiv.main;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.ui.Meny;

public class FilmArkiv2Main {
	public static void main(String[] args) {
		FilmarkivADT filmer = new Filmarkiv2();
		Meny meny = new Meny(filmer);
		meny.start();
	}
}
