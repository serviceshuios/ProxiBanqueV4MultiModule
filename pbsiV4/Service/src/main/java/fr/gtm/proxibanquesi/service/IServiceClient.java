package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Interface ServiceClient. Elle liste les m�thodes CRUD d'un client et une m�thode qui retourne la liste de tous les clients
 *
 */
public interface IServiceClient {
	
	
	/**
	 * Methode qui retourne la liste de tous les clients
	 * @return List<Client> : retourne une liste de Clients
	 */
	public List<Client> findAll();

	
	/**
	 * M�thode qui cr�e ou modifie un client en base de donn�es
	 * @param client : le Client � cr�er ou modifier
	 */
	public void createOrUpdate(Client client);
	
	/**
	 * M�thode qui supprime un client en base de donn�es
	 * @param client : le Client � supprimer
	 */
	public void delete(Client client);
}
