package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;

/**
 * Interface ServiceCompte. Elle liste les m�thodes CRUD d'un compte et une m�thode qui retourne la liste de tous les comptes
 *
 */
public interface IServiceCompte {
	
	/**
	 * Methode qui retourne un compte � partir de son num�ro
	 * @param numcompte : l'identifiant d'un compte
	 * @return Compte : retourne le compte
	 */
	public Compte findOne(Integer numcompte);
	
	/** Methode qui retourne tous les comptes
	 * @return List<Compte> : retourne une liste de Compte
	 */
	public List<Compte> findAll();
	
	/**
	 * Methode qui effectue une virement compte � compte d'un m�me client
	 * @param cDeb : compte � d�biter 
	 * @param cCre : compte � cr�diter
	 * @param montant : montant du virement � effectuer
	 * @throws SoldeException 
	 */
	public void virementIntraClient(Compte cDeb, Compte cCre, double montant) throws SoldeException;
	
	/**
	 * Methode qui effectue une virement compte � compte d'un client � un autre client
	 * @param cDeb : compte � d�biter 
	 * @param cCre : compte � cr�diter
	 * @param montant : montant du virement � effectuer
	 * @throws CompteInexistantException 
	 * @throws SoldeException 
	 */
	public void virementInterClient(Compte cDeb, Integer numCompteCre, double montant) throws SoldeException, CompteInexistantException;
	
	
	/**
	 * M�thode qui cr�e un compte en base de donn�es
	 * @param compte : le compte � cr�er
	 */
	public void createOrUpdate(Compte compte);
	
	/**
	 * M�thode qui supprime un compte en base de donn�es
	 * @param client : le compte � supprimer
	 */
	public void delete(Compte compte);
}
