package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Interface ServiceEmploye. Elle liste les m�thodes CRUD d'un employ�.
 *
 */
public interface IServiceEmploye {

	
	/**
	 * Methode qui retourne un employ� � partir de son login et de son mot de passe
	 * @param login : login de l'employ�
	 * @param mdp : mot de passe de l'employ�
	 * @return Employe : retourne l'employ�
	 */
	public Employe findByLoginAndMdp(String login, String mdp);
	
	/**
	 * Methode qui retourne un employ� � partir de son identifiant
	 * @param id : identifiant de l'employ�
	 * @return Employe : retourne l'employ�
	 */
	public Employe findOne(Integer id);
	
	/**
	 * M�thode qui cr�e un employ� en base de donn�es
	 * @param employe : employ� � cr�er
	 */
	public void createOrUpdate(Employe employe);
}
