package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Component;

/**
 * Classe repr�sentant un client de la banque. 
 */
@Entity
@Component
public class Client {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Num�ro d'identification du client. */
	@Id
	@SequenceGenerator(name="clientSeq", sequenceName="SEQ_CLIENT", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientSeq")
	private Integer id;
	/**
	 * Nom de famille du client.
	 */
	private String nom;
	/**
	 * Prenom d'usage du client.
	 */
	private String prenom;
	/**
	 * Numero, type et nom de voie de l'adresse du client.
	 */
	private String adresse;
	/**
	 * Code postal de la ville de residence du client.
	 */
	private String codePostal;
	/**
	 * Nom de la ville de residence du client.
	 */
	private String ville;
	/**
	 * Numero de telephone du client.
	 */
	private String telephone;
	/**
	 * Adresse email du client.
	 */
	private String email;
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Compte> listeComptes;
	

	/**
	 * Constructeur de Client sans argument
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur de Client a partir des informations personnelles d'un client.
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 * @param email
	 */
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String email) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}

	/**
	 * Getter de la propri�t� nom
	 * @return La propri�t� nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Setter de la propri�t� nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de la propri�t� prenom
	 * @return La propri�t� prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Setter de la propri�t� prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de la propri�t� adresse
	 * @return La propri�t� adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Setter de la propri�t� adresse
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter de la propri�t� code postal
	 * @return La propri�t� code postal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Setter de la propri�t� code postal
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter de la propri�t� ville
	 * @return La propri�t� ville
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Setter de la propri�t� ville
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter de la propri�t� telephone
	 * @return La propri�t� telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Setter de la propri�t� telephone
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de la propri�t� id
	 * @return La propri�t� id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de la propri�t� id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de la propri�t� email
	 * @return La propri�t� email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de la propri�t� email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter de la propri�t� Liste<Compte>
	 * @return La propri�t� listeCompte
	 */
	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	/**
	 * Setter de la propri�t� email
	 * @param listeComptes
	 */
	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de Client
	 * @return String d�crivant le client
	 */
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + ", liste des comptes: " + listeComptes + "]";
	}

}