package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant un compte courant, héritant de la classe abstraite Compte, avec autorisation de découvert déclarée de 1000 euro.
 */
@Entity
@DiscriminatorValue("COURANT")
public class CompteCourant extends Compte {

	// Propriétés
	/** Autorisation de découvert */
	private double autorisationDecouvert = 1000;
	
	/**
	 * Constructeur de CompteCourant sans argument
	 */
	public CompteCourant() {
		super();
	}
	
	/**
	 * Constructeur de CompteCourant permettant créer un compte courant avec un solde
	 * @param solde : le solde du compte courant à créer
	 */
	public CompteCourant(double solde) {
		super();
		setSolde(solde);
	}

	/**
	 * Getter de la propriété autorisationDecouvert
	 * @return La propriété autorisationDecouvert
	 */
	public double getAutorisationDecouvert() {
		return autorisationDecouvert;
	}
	/**
	 * Setter de la propriété autorisationDecouvert
	 * @param d
	 */
	public void setAutorisationDecouvert(double autorisationDecouvert) {
		this.autorisationDecouvert = autorisationDecouvert;
	}


	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet CompteCourant
	 * @return String le string Courant
	 */
	@Override
	public String toString() {
		return "Courant";
	}

}