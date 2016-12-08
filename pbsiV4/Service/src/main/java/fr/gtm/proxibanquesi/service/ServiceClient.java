package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Classe ServiceClient. Elle implémente IServiceClient
 * Elle implémente les méthodes CRUD d'un client et une méthode qui retourne la liste de tous les clients
 *
 */
@Service("serviceClient")
public class ServiceClient implements IServiceClient {
	
	/**
	 * Interface IDAOClient injecté par Spring
	 */
	@Autowired
	private IDaoClient dao;

	/**
	 * Constructeur de ServiceClient sans argument
	 */
	public ServiceClient() {
		super();
	}

	/**
	 * Getter de l'attribut IDaoClient
	 * @return instance du DaoClient
	 */
	public IDaoClient getDao() {
		return dao;
	}

	/**
	 * Setter de l'attribut IDaoClient
	 * @param instance du DaoClient
	 */
	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}

	/**
	 * Methode qui retourne la liste de tous les clients
	 * @return List<Client> : retourne une liste de Clients
	 */
	public List<Client> findAll() {
		return dao.findAll();
	}


	/**
	 * Méthode qui crée ou modifie un client en base  de données
	 * @param client : le Client à créer ou modifier
	 */
	public void createOrUpdate(Client client) {
		dao.save(client);
	}

	/**
	 * Méthode qui supprime un client en base de données
	 * @param client : le Client à supprimer
	 */
	public void delete(Client client) {
		dao.delete(client);
	}
	
	

}
