package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Interface ServiceEmploye. Elle liste les méthodes CRUD d'un employé.
 *
 */
public interface IServiceEmploye {

	
	/**
	 * Methode qui retourne un employé à partir de son login et de son mot de passe
	 * @param login : login de l'employé
	 * @param mdp : mot de passe de l'employé
	 * @return Employe : retourne l'employé
	 */
	public Employe findByLoginAndMdp(String login, String mdp);
	
	/**
	 * Methode qui retourne un employé à partir de son identifiant
	 * @param id : identifiant de l'employé
	 * @return Employe : retourne l'employé
	 */
	public Employe findOne(Integer id);
	
	/**
	 * Méthode qui crée un employé en base de données
	 * @param employe : employé à créer
	 */
	public void createOrUpdate(Employe employe);
}
