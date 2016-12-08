package fr.gtm.proxibanquesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoEmploye;
import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Classe ServiceEmploye. Elle implémente IServiceEmploye
 * Elle implémente les méthodes CRUD d'un employé.
 *
 */
@Service("serviceEmploye")
public class ServiceEmploye implements IServiceEmploye {

	/**
	 * Interface IDAOEmploye injecté par Spring
	 */
	@Autowired
	IDaoEmploye dao;
	
	/**
	 * Constructeur de ServiceEmploye sans argument
	 */
	public ServiceEmploye() {
		super();
	}
	
	/**
	 * Getter de l'attribut IDaoEmploye
	 * @return instance du DaoEmploye
	 */
	public IDaoEmploye getDao() {
		return dao;
	}
	/**
	 * Setter de l'attribut IDaoEmploye
	 * @param instance du DaoEmploye
	 */
	public void setDao(IDaoEmploye dao) {
		this.dao = dao;
	}

	/**
	 * Methode qui retourne un employé à partir de son login et de son mot de passe
	 * @param login : login de l'employé
	 * @param mdp : mot de passe de l'employé
	 * @return Employe : retourne l'employé
	 */
	public Employe findByLoginAndMdp(String login, String mdp) {
		return dao.findByLoginAndMdp(login, mdp);
	}

	/**
	 * Methode qui retourne un employé à partir de son identifiant
	 * @param id : identifiant de l'employé
	 * @return Employe : retourne l'employé
	 */
	public void createOrUpdate(Employe employe) {
		dao.save(employe);
	}

	/**
	 * Méthode qui crée un employé en base de données
	 * @param employe : employé à créer
	 */
	public Employe findOne(Integer id) {
		return dao.findOne(id);
	}

}
