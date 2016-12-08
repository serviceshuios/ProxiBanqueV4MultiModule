package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe représentant un compte épargne, héritant de la classe abstraite Compte, avec un taux de rémuneration déclaré à 3%.
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	/** Taux de rémunération du compte épargne */
	private double tauxRemuneration = 0.03;
	
	/**
	 * Constructeur de CompteEpargne sans argument
	 */
	public CompteEpargne() {
		super();
	}
	/**
	 * Constructeur permettant créer un compte épargne avec un solde
	 * @param solde : le solde du compte épargne à créer
	 */
	public CompteEpargne(double solde) {
		super();
		setSolde(solde);
	}

	/**
	 * Getter de la propriété tauxRemuneration
	 * @return La propriété tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	/**
	 * Setter de la propriété tauxRemuneration
	 * @param tauxRemuneration
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	

	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet CompteEpargne
	 * @return String le string Epargne
	 */
	@Override
	public String toString() {
		return "Epargne";
	}

}
