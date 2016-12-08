package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

/** 
 * Classe abstraite representant un employe de la banque.
 */
@Entity
@Component
@Inheritance
@DiscriminatorColumn(name="ROLE")
public abstract class Employe {

	/**
	 * Numero d'identification
	 */
	@Id
	@SequenceGenerator(name="employeSeq", sequenceName="SEQ_EMPLOYE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="employeSeq")
	private Integer id;
	/**
	 * Nom de famille.
	 */
	private String nom;
	/**
	 * Prenom usuel.
	 */
	private String prenom;
	/**
	 * Identifiant de connection a l'application.
	 */
	private String login;
	/**
	 * Mot de passe utilise pour la connection.
	 */
	private String mdp;

	/**
	 * Getter de la propriété id
	 * @return La propriété id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de la propriété id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de la propriété nom
	 * @return La propriété nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de la propriété nom
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de la propriété prenom
	 * @return La propriété prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter de la propriété prenom
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de la propriété login
	 * @return La propriété login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Setter de la propriété login
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Getter de la propriété mdp
	 * @return La propriété mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * Setter de la propriété mdp
	 * @param mdp
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * Méthode permettant de retourner un String avec les propriétés d'Employ
	 * @return String décrivant l'employé
	 */
	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp + "]";
	}


}
