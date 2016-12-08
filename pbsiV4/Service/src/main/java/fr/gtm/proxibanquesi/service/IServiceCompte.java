package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;

/**
 * Interface ServiceCompte. Elle liste les méthodes CRUD d'un compte et une méthode qui retourne la liste de tous les comptes
 *
 */
public interface IServiceCompte {
	
	/**
	 * Methode qui retourne un compte à partir de son numéro
	 * @param numcompte : l'identifiant d'un compte
	 * @return Compte : retourne le compte
	 */
	public Compte findOne(Integer numcompte);
	
	/** Methode qui retourne tous les comptes
	 * @return List<Compte> : retourne une liste de Compte
	 */
	public List<Compte> findAll();
	
	/**
	 * Methode qui effectue une virement compte à compte d'un même client
	 * @param cDeb : compte à débiter 
	 * @param cCre : compte à créditer
	 * @param montant : montant du virement à effectuer
	 * @throws SoldeException 
	 */
	public void virementIntraClient(Compte cDeb, Compte cCre, double montant) throws SoldeException;
	
	/**
	 * Methode qui effectue une virement compte à compte d'un client à un autre client
	 * @param cDeb : compte à débiter 
	 * @param cCre : compte à créditer
	 * @param montant : montant du virement à effectuer
	 * @throws CompteInexistantException 
	 * @throws SoldeException 
	 */
	public void virementInterClient(Compte cDeb, Integer numCompteCre, double montant) throws SoldeException, CompteInexistantException;
	
	
	/**
	 * Méthode qui crée un compte en base de données
	 * @param compte : le compte à créer
	 */
	public void createOrUpdate(Compte compte);
	
	/**
	 * Méthode qui supprime un compte en base de données
	 * @param client : le compte à supprimer
	 */
	public void delete(Compte compte);
}
