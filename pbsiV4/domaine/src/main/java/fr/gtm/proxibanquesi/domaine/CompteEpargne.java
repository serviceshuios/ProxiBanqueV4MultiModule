package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Classe repr�sentant un compte �pargne, h�ritant de la classe abstraite Compte, avec un taux de r�muneration d�clar� � 3%.
 */
@Entity
@DiscriminatorValue("EPARGNE")
public class CompteEpargne extends Compte {

	/** Taux de r�mun�ration du compte �pargne */
	private double tauxRemuneration = 0.03;
	
	/**
	 * Constructeur de CompteEpargne sans argument
	 */
	public CompteEpargne() {
		super();
	}
	/**
	 * Constructeur permettant cr�er un compte �pargne avec un solde
	 * @param solde : le solde du compte �pargne � cr�er
	 */
	public CompteEpargne(double solde) {
		super();
		setSolde(solde);
	}

	/**
	 * Getter de la propri�t� tauxRemuneration
	 * @return La propri�t� tauxRemuneration
	 */
	public double getTauxRemuneration() {
		return tauxRemuneration;
	}
	/**
	 * Setter de la propri�t� tauxRemuneration
	 * @param tauxRemuneration
	 */
	public void setTauxRemuneration(double tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
	

	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet CompteEpargne
	 * @return String le string Epargne
	 */
	@Override
	public String toString() {
		return "Epargne";
	}

}
