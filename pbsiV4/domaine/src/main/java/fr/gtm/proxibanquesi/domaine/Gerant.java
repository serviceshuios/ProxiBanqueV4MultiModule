package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Classe representant un gerant d'agence.
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Employe {

	/**
	 * Liste des clients a la charge du conseiller.
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Conseiller> listeConseillers;
	
	/**
	 * Constructeur de Conseiller sans argument
	 */
	public Gerant() {
	}
	
	/** Constructeur a partir d'un nom et d' un prenom.
	 * @param nom
	 * @param prenom
	 */
	public Gerant(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	/**
	 * Getter de la propriété listeConseiller
	 * @return La propriété listeConseiller
	 */
	public List<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	/**
	 * Setter de la propriété listeConseiller
	 * @param listeConseiller
	 */
	public void setListeConseillers(List<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}


}
