package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un compte courant, h�ritant de la classe abstraite Compte, avec autorisation de d�couvert d�clar�e de 1000 euro.
 */
@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	// Propri�t�s
	/** Autorisation de d�couvert */
	private double autorisationDecouvert = 1000;
	
	/**
	 * Constructeur de CompteCourant sans argument
	 */
	public CompteCourant() {
		super();
	}
	
	/**
	 * Constructeur de CompteCourant permettant cr�er un compte courant avec un solde
	 * @param solde : le solde du compte courant � cr�er
	 */
	public CompteCourant(double solde) {
		super();
		setSolde(solde);
	}

	/**
	 * Getter de la propri�t� autorisationDecouvert
	 * @return La propri�t� autorisationDecouvert
	 */
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	/**
	 * Setter de la propri�t� autorisationDecouvert
	 * @param d
	 */
	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}


	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet CompteCourant
	 * @return String le string Courant
	 */
	@Override
	public String toString() {
		return "Courant";
	}

}