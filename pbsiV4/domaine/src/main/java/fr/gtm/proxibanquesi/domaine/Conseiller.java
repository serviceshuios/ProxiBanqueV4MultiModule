package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/** 
 * Classe representant un conseiller de l'agence, héritant de la classe abstraite Employe.
 */
@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Employe {

	/**
	 * Liste des clients a la charge du conseiller.
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Client> listeClients;

	/**
	 * Constructeur de Conseiller sans argument
	 */
	public Conseiller() {
	}
	
	/** Constructeur a partir d'un nom et d' un prenom.
	 * @param nom
	 * @param prenom
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	/**
	 * Getter de la propriété listeClient
	 * @return La propriété listeClient
	 */
	public List<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * Setter de la propriété listeClient
	 * @param listeClient
	 */
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
}
