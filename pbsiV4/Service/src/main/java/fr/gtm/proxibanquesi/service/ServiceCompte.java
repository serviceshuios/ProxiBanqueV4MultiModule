package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;

/**
 * Classe ServiceCompte. Elle impl�mente IServiceCompte Elle impl�mente les
 * m�thodes CRUD d'un compte et une m�thode qui retourne la liste de tous les
 * comptes
 *
 */
@Service("serviceCompte")
@Transactional
public class ServiceCompte implements IServiceCompte {

	
	/**
	 * Interface IDAOCompte inject� par Spring
	 */
	@Autowired
	private IDaoCompte dao;
	
	/**
	 * Constructeur de ServiceCompte sans argument
	 */
	public ServiceCompte() {
		super();
	}

	/**
	 * Getter de l'attribut IDaoCompte
	 * @return instance du DaoCompte
	 */
	public IDaoCompte getDao() {
		return dao;
	}

	/**
	 * Setter de l'attribut IDaoCompte
	 * @param instance du DaoCompte
	 */
	public void setDao(IDaoCompte dao) {
		this.dao = dao;
	}

	/**
	 * Methode qui retourne un compte � partir de son num�ro
	 * @param numcompte : l'identifiant d'un compte
	 * @return Compte : retourne le compte
	 */
	public Compte findOne(Integer numcompte) {
		return dao.findOne(numcompte);
	}

	/** Methode qui retourne tous les comptes
	 * @return List<Compte> : retourne une liste de Compte
	 */
	public List<Compte> findAll() {
		return dao.findAll();
	}
	
	/**
	 * Methode qui effectue une virement compte � compte d'un m�me client
	 * @param cDeb : compte � d�biter 
	 * @param cCre : compte � cr�diter
	 * @param montant : montant du virement � effectuer
	 */
	public void virementIntraClient(Compte cDeb, Compte cCre, double montant) throws SoldeException {
		if (cDeb instanceof CompteEpargne && cDeb.getSolde() >= montant || cDeb instanceof CompteCourant && cDeb.getSolde()+ ((CompteCourant)cDeb).getAutorisationDecouvert() >= montant) {
			cDeb.setSolde(cDeb.getSolde()-montant);
			cCre.setSolde(cCre.getSolde()+montant);
			dao.save(cDeb);
			dao.save(cCre);
		} else {
			throw new SoldeException();
		}
		
	}

	/**
	 * Methode qui effectue une virement compte � compte d'un client � un autre client
	 * @param cDeb : compte � d�biter 
	 * @param cCre : compte � cr�diter
	 * @param montant : montant du virement � effectuer
	 */
	public void virementInterClient(Compte cDeb, Integer numCompteCre, double montant) throws SoldeException, CompteInexistantException {
		Compte cCre = dao.findOne(numCompteCre);
		if (null==cCre) throw new CompteInexistantException();
		if (cDeb instanceof CompteEpargne && cDeb.getSolde() >= montant || cDeb instanceof CompteCourant && cDeb.getSolde()+ ((CompteCourant)cDeb).getAutorisationDecouvert() >= montant) {
			cDeb.setSolde(cDeb.getSolde()-montant);
			cCre.setSolde(cCre.getSolde()+montant);
			dao.save(cDeb);
			dao.save(cCre);
		} else {
			throw new SoldeException();
		}
	}	
	
	/**
	 * M�thode qui cr�e un compte en base de donn�es
	 * @param compte : le compte � cr�er
	 */
	public void createOrUpdate(Compte compte) {
		dao.save(compte);
	}
	
	/**
	 * M�thode qui supprime un compte en base de donn�es
	 * @param compte : le compte � supprimer
	 */
	public void delete(Compte compte) {
		dao.delete(compte);
	}
	
	

	


	

}
