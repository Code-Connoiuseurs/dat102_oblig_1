package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.impl.Filmarkiv;

public class FilmarkivMain {

	public static void main(String[] args) {
		Filmarkiv filma = new Filmarkiv(100);
		Meny meny = new Meny(filma);
		meny.start();
		
		}
	}
