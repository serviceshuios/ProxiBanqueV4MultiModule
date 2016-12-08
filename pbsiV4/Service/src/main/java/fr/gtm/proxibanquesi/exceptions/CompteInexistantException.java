package fr.gtm.proxibanquesi.exceptions;

public class CompteInexistantException extends Exception {

	@Override
	public String getMessage() {
		return "Ce compte n'existe pas.";
	}

	
	
}
