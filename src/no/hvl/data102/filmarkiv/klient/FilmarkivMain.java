package no.hvl.data102.filmarkiv.klient;

public class FilmarkivMain {
	public static void main(String[] args) {
		FilarkivADT filmer = new Filmarkiv(100);
		Meny meny = new Meny(filmer);
		meny.start(;)
	}
}
