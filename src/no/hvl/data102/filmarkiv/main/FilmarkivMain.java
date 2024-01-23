package no.hvl.data102.filmarkiv.main;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.ui.Meny;

public class FilmarkivMain {
	public static void main(String[] args) {
		FilmarkivADT filmer = new Filmarkiv(100);
		Meny meny = new Meny(filmer);
		meny.start();
	}
}
