package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Classe ServiceClient. Elle impl�mente IServiceClient
 * Elle impl�mente les m�thodes CRUD d'un client et une m�thode qui retourne la liste de tous les clients
 *
 */
@Service("serviceClient")
public class ServiceClient implements IServiceClient {
	
	/**
	 * Interface IDAOClient inject� par Spring
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
	 * M�thode qui cr�e ou modifie un client en base  de donn�es
	 * @param client : le Client � cr�er ou modifier
	 */
	public void createOrUpdate(Client client) {
		dao.save(client);
	}

	/**
	 * M�thode qui supprime un client en base de donn�es
	 * @param client : le Client � supprimer
	 */
	public void delete(Client client) {
		dao.delete(client);
	}
	
	

}
