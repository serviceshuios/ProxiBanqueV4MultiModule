package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Interface ServiceClient. Elle liste les méthodes CRUD d'un client et une méthode qui retourne la liste de tous les clients
 *
 */
public interface IServiceClient {
	
	
	/**
	 * Methode qui retourne la liste de tous les clients
	 * @return List<Client> : retourne une liste de Clients
	 */
	public List<Client> findAll();

	
	/**
	 * Méthode qui crée ou modifie un client en base de données
	 * @param client : le Client à créer ou modifier
	 */
	public void createOrUpdate(Client client);
	
	/**
	 * Méthode qui supprime un client en base de données
	 * @param client : le Client à supprimer
	 */
	public void delete(Client client);
}
