package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;
import fr.gtm.proxibanquesi.service.IServiceClient;
import fr.gtm.proxibanquesi.service.IServiceCompte;

@ManagedBean
@Scope()
@Component
public class CompteBean implements Serializable {
	/** Clé identifie de manière unique la Classe */
	private static final long serialVersionUID = 1L;
	/** compte sélectionné */
	private Compte selectedCompte;
	/** liste des compte */
	private List<Compte> compteList;
	/** compte crédité lors d'un virement */
	private Compte destination;
	/** montant d'un virement */
	private double montant;
	/** identifiant d'un compte crédité lors d'un virement */
	private int idCompteExterneDestination;
	/** compte courant */
	private CompteCourant nouveauCompteCourant;
	/** compte epargne */
	private CompteEpargne nouveauCompteEpargne;
	/** type de compte à créditer */
	private String typeCompteACree;
	/** option d'un compte : Courant : decouvert autorisé et Epargne : taux de rénumération */
	private double option;
	/** solde d'un compte */
	private double solde;

	/**
	 * Interface IServiceCompte injecté par Spring
	 */
	@Autowired
	private IServiceCompte iservCompte;

	/**
	 * Interface IServiceClient injecté par Spring
	 */
	@Autowired
	private IServiceClient iservClient;

	/**
	 * Pointe vers le ClientBean
	 */
	@Value("#{clientBean}")
	private ClientBean ownerBean;

	/**
	 * Methode appelée avant l'initialisation du bean 
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean compte");
		System.out.println("Owner= " + ownerBean.getSelectedClient());
		selectedCompte = null;
		destination = null;
		nouveauCompteCourant = new CompteCourant();
		nouveauCompteEpargne = new CompteEpargne();
	}

	/**
	 * Methode appelée avant la destruction du bean du bean 
	 */
	@PreDestroy
	public void finBean() {
		System.out.println("Destruction du bean compte");
	}

	/**
	 * Constructeur de CompteBean sans argument
	 */
	public CompteBean() {
		super();
	}

	/**
	 * getter de l'attribut selectedCompte 
	 * @return l'instance selectedCompte
	 */
	public Compte getSelectedCompte() {
		return selectedCompte;
	}
	/**
	 * setter de l'attribut selectedCompte
	 * @param selectedCompte
	 */
	public void setSelectedCompte(Compte selectedCompte) {
		this.selectedCompte = selectedCompte;
	}
	/**
	 * getter de l'attribut compteList
	 * @return l'instance compteList
	 */
	public List<Compte> getCompteList() {
		return compteList;
	}

	/**
	 * setter de l'attribut compteList
	 * @param compteList
	 */
	public void setCompteList(ArrayList<Compte> compteList) {
		this.compteList = compteList;
	}

	/**
	 * getter de l'attribut ownerBean 
	 * @return l'instance ownerBean
	 */
	public ClientBean getOwnerBean() {
		return ownerBean;
	}

	/**
	 * setter de l'attribut ownerBean
	 * @param ownerBean
	 */
	public void setOwnerBean(ClientBean ownerBean) {
		this.ownerBean = ownerBean;
	}
	/**
	 * getter de l'attribut serialversionuid 
	 * @return l'instance serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * getter de l'attribut destination 
	 * @return l'instance destination
	 */
	public Compte getDestination() {
		return destination;
	}

	/**
	 * setter de l'attribut destination
	 * @param destination
	 */
	public void setDestination(Compte destination) {
		this.destination = destination;
	}

	/**
	 * getter de l'attribut montant 
	 * @return l'instance montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * setter de l'attribut montant
	 * @param montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * getter de l'attribut CompteExterneDestination
	 * @return l'instance CompteExterneDestination
	 */
	public int getIdCompteExterneDestination() {
		return idCompteExterneDestination;
	}
	/**
	 * setter de l'attribut CompteExterneDestination
	 * @param CompteExterneDestination
	 */
	public void setIdCompteExterneDestination(int idCompteExterneDestination) {
		this.idCompteExterneDestination = idCompteExterneDestination;
	}

	

	/**
	 * getter de l'attribut IServiceCompte
	 * @return l'instance iserviceCompte
	 */
	public IServiceCompte getIservCompte() {
		return iservCompte;
	}
	/**
	 * setter de l'attribut IServiceCompte
	 * @param IServiceCompte
	 */
	public void setIservCompte(IServiceCompte iservCompte) {
		this.iservCompte = iservCompte;
	}

	/**
	 * getter de l'attribut nouveauCompteCourant
	 * @return l'instance nouveauCompteCourant
	 */
	public CompteCourant getNouveauCompteCourant() {
		return nouveauCompteCourant;
	}

	/**
	 * setter de l'attribut nouveauCompteCourant
	 * @param nouveauCompteCourant
	 */
	public void setNouveauCompteCourant(CompteCourant nouveauCompteCourant) {
		this.nouveauCompteCourant = nouveauCompteCourant;
	}

	/**
	 * getter de l'attribut nouveauCompteEpargne
	 * @return l'instance nouveauCompteEpargne
	 */
	public CompteEpargne getNouveauCompteEpargne() {
		return nouveauCompteEpargne;
	}

	/**
	 * setter de l'attribut nouveauCompteEpargne
	 * @param nouveauCompteEpargne
	 */
	public void setNouveauCompteEpargne(CompteEpargne nouveauCompteEpargne) {
		this.nouveauCompteEpargne = nouveauCompteEpargne;
	}
	/**
	 * getter de l'attribut compteACre
	 * @return l'instance compteACre
	 */
	public String getTypeCompteACree() {
		return typeCompteACree;
	}

	/**
	 * setter de l'attribut compteACre
	 * @param compteACre
	 */
	public void setTypeCompteACree(String typeCompteACree) {
		this.typeCompteACree = typeCompteACree;
	}

	/**
	 * getter de l'attribut option
	 * @return l'instance option
	 */
	public double getOption() {
		return option;
	}
	
	/**
	 * setter de l'attribut coption
	 * @param option
	 */
	public void setOption(double option) {
		this.option = option;
	}

	/**
	 * getter de l'attribut solde
	 * @return l'instance solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * setter de l'attribut solde
	 * @param solde
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	/**
	 * getter de l'attribut IServiceClient
	 * @return l'instance iserviceClient
	 */
	public IServiceClient getIservClient() {
		return iservClient;
	}

	/**
	 * setter de l'attribut IServiceClient
	 * @param IServiceClient
	public void setIservClient(IServiceClient iservClient) {
		this.iservClient = iservClient;
	}

	
	/**
	 * Méthode permettant de valider les virements
	 * @return
	 */
	public String virementInit() {
		System.out.println("Owner= " + ownerBean.getSelectedClient());
		compteList = ownerBean.getSelectedClient().getListeComptes();

		if (compteList.size() == 2) {

			if (selectedCompte.toString().equalsIgnoreCase("COURANT")) {
				if (compteList.get(0).toString().equalsIgnoreCase("COURANT")) {
					destination = compteList.get(1);
				} else {
					destination = compteList.get(0);
				}
			} else if (selectedCompte.toString().equalsIgnoreCase("EPARGNE")) {
				if (compteList.get(0).toString().equalsIgnoreCase("EPARGNE")) {
					destination = compteList.get(1);
				} else {
					destination = compteList.get(0);
				}
			} else {
				addMessage("erreur type de compte inconnu");
			}
		} else {
			addMessage("erreur pas 2 comptes presents");
		}
		System.out.println(destination);
		return "compte";
	}

	/**
	 * Methode de mise à jour des infos compte
	 * @return une chaine de caratere referençant une page xhtml compte
	 */
	public String update() {

		System.out.println("appel update compte");
		addMessage("Mise a jour compte effectuée");
		return "compte";
	}

	/**
	 * Methode permettant de valider le virementIntra
	 * @return une chaine de caratere referençant une page xhtml compte
	 */
	public String virement() {
		System.out.println("appel virement compte");
		try {
			iservCompte.virementIntraClient(selectedCompte, destination, montant);
		} catch (SoldeException e) {
			addMessage(e.getMessage());
			return "compte";
		}
		addMessage("Virement effectué");
		return "compte";
	}

	/**
	 * Methode permettant de valider le virementInter
	 * @return une chaine de caratere referençant une page xhtml compte
	 */
	public void virementExterne() {
		System.out.println("appel virement externe compte");
		try {
			iservCompte.virementInterClient(selectedCompte, idCompteExterneDestination, montant);
			addMessage("Virement effectué");
		} catch (SoldeException e) {
			addMessage(e.getMessage());
		} catch (CompteInexistantException e) {
			addMessage(e.getMessage());
		}

	}

	/**
	 * Methode de creation d'un nouveau compte
	 * @return une chaine de caratere referençant une page xhtml client
	 */
	public String create() {
		System.out.println("typeCompteACree : " + typeCompteACree);
		System.out.println("option " + option);
		compteList = ownerBean.getSelectedClient().getListeComptes();
		System.out.println(ownerBean.getSelectedClient().getListeComptes());

		if (typeCompteACree.equalsIgnoreCase("COURANT")) {
			nouveauCompteCourant.setDateOuverture(new Date());
			nouveauCompteCourant.setAutorisationDecouvert(option);
			nouveauCompteCourant.setSolde(solde);

			iservCompte.createOrUpdate(nouveauCompteCourant);
			compteList.add(nouveauCompteCourant);
			iservClient.createOrUpdate(ownerBean.getSelectedClient());

		} else if (typeCompteACree.equalsIgnoreCase("EPARGNE")) {
			nouveauCompteEpargne.setDateOuverture(new Date());
			nouveauCompteEpargne.setTauxRemuneration(option);
			nouveauCompteEpargne.setSolde(solde);
			iservCompte.createOrUpdate(nouveauCompteEpargne);
			compteList.add(nouveauCompteEpargne);
			iservClient.createOrUpdate(ownerBean.getSelectedClient());
		} else {
			addMessage("erreur");
		}
		addMessage("Ajout compte effectué");
		return "client";
	}

	/**
	 * Methode de supression d'un compte en base de données
	 * @return une chaine de caratere referencant la page xhtml client 
	 */
	public String delete() {
		compteList = ownerBean.getSelectedClient().getListeComptes();
		compteList.remove(selectedCompte);
		System.out.println(compteList);
		System.out.println(ownerBean.getSelectedClient().getListeComptes());
		iservClient.createOrUpdate(ownerBean.getSelectedClient());
		iservCompte.delete(selectedCompte);
		selectedCompte = null;

		addMessage("Supression de compte effectuée");
		return "compte";
	}

	/**
	 * Methode d'affichage de notifications
	 *  @param summary : message a émettre
	 */
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	/**
	 * Methode permettant de detecter la selection d'une ligne compte en table
	 * dans la vue client
	 * @param event :l'évènement selection
	 */
	public void onCompteSelect(SelectEvent event) {
		this.selectedCompte = (Compte) event.getObject();
		System.out.println("compte selectionné" + selectedCompte);
	}

	/**
	 * Methode permettant de detecter la déselection d'une ligne compte en table
	 * dans la vue client
	 * @param event :l'évènement déselection
	 */
	public void onCompteUnselect(UnselectEvent event) {
		System.out.println("unselect");
		this.selectedCompte = null;
	}

	/**
	 * Methode permettant de detecter la déselection d'une ligne compte en table
	 * dans la vue client
	 * @param event :l'évènement select
	 */
	public void rowSelect(SelectEvent event) {
		this.selectedCompte = (Compte) event.getObject();
	}

}
