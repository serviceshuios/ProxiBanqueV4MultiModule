package fr.gtm.proxibanquesi.exceptions;

public class SoldeException extends Exception {

	@Override
	public String getMessage() {

		return "Solde insuffisant.";
	}

}
