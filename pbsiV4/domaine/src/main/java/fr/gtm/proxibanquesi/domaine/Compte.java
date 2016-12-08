package fr.gtm.proxibanquesi.domaine;



import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

/**
 * Classe abstraite représentant un compte en banque générique.
 */
@Entity
@Component
@Inheritance
@DiscriminatorColumn(name="TYPE_COMPTE")
public abstract class Compte {

	/** Numéro du compte */
	@Id
	@SequenceGenerator(name="compteSeq", sequenceName="SEQ_COMPTE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="compteSeq")
	private Integer numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
	/** Numéro d'identification du client auquel le compte appartient */
	@Transient
	private Client client;

	
	/**
	 * Constructeur de Compte sans argument
	 */
	public Compte() {
		super();
	}
	/**
	 * Getter de la propriété numCompte
	 * @return La propriété numCompte
	 */
	public Integer getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propriété numCompte
	 * @param numCompte
	 */
	public void setNumCompte(Integer numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propriété solde 
	 * @return La propriété solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propriété solde
	 * @param solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	/**
	 * Getter de la propriété dateOuverture
	 * @return La propriété dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propriété dateOuverture
	 * @param dateOuverture
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	/**
	 * Getter de la propriété Client
	 * @return La propriété Client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * Setter de la propriété Client
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet Compte
	 * @return String décrivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}
	
}
