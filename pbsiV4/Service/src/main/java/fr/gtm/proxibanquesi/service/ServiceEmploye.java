package fr.gtm.proxibanquesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoEmploye;
import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Classe ServiceEmploye. Elle impl�mente IServiceEmploye
 * Elle impl�mente les m�thodes CRUD d'un employ�.
 *
 */
@Service("serviceEmploye")
public class ServiceEmploye implements IServiceEmploye {

	/**
	 * Interface IDAOEmploye inject� par Spring
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
	 * Methode qui retourne un employ� � partir de son login et de son mot de passe
	 * @param login : login de l'employ�
	 * @param mdp : mot de passe de l'employ�
	 * @return Employe : retourne l'employ�
	 */
	public Employe findByLoginAndMdp(String login, String mdp) {
		return dao.findByLoginAndMdp(login, mdp);
	}

	/**
	 * Methode qui retourne un employ� � partir de son identifiant
	 * @param id : identifiant de l'employ�
	 * @return Employe : retourne l'employ�
	 */
	public void createOrUpdate(Employe employe) {
		dao.save(employe);
	}

	/**
	 * M�thode qui cr�e un employ� en base de donn�es
	 * @param employe : employ� � cr�er
	 */
	public Employe findOne(Integer id) {
		return dao.findOne(id);
	}

}
