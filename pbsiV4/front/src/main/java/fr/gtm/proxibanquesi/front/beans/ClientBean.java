package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
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

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.service.IServiceClient;
import fr.gtm.proxibanquesi.service.IServiceEmploye;

/**
 * Classe qui implémente l'interface SerializableSe Permet de creer un
 *         nouveau client en base, d'afficher la liste des clients, de modifier
 *         les information clients et de supprimer un client
 */
@ManagedBean
@Scope
@Component
public class ClientBean implements Serializable {

	/** Clé identifie de manière unique la Classe */
	private static final long serialVersionUID = 1L;
	/** client sélectionné */
	private Client selectedClient;
	/** nouveau client */
	private Client nouveauClient;
	/** liste des clients */
	private List<Client> clientList;

	/**
	 * Interface IServiceClient injecté par Spring
	 */
	@Autowired
	private IServiceClient serviceClient;
	
	/**
	 * Interface IServiceClient injecté par Spring
	 */
	@Autowired
	private IServiceEmploye serviceEmploye;
	
	/**
	 * Pointe vers le LoginBean
	 */
	@Value("#{loginBean}")
	private LoginBean ownerBean;

	/**
	 * Methode appelée avant l'initialisation du bean 
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean client");
		nouveauClient = new Client();
		selectedClient = null;
	}

	/**
	 * Methode appelée avant la destruction du bean du bean 
	 */
	@PreDestroy
	public void finBean() {
		System.out.println("Destruction bean client");
	}

	/**
	 * Constructeur de ClientBean sans argument
	 */
	public ClientBean() {
		super();
	}
	
	/**
	 * getter de l'attribut selectedClient
	 * @return l'instance selectedClient
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * setter de l'attribut selectedClient
	 * @param selectedClient
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	/**
	 * getter de l'attribut clientList 
	 * @return l'instance liste des clients
	 */
	public List<Client> getClientList() {
		return clientList;
	}

	/**
	 * setter de l'attribut clientList
	 * @param clientList
	 */
	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	/**
	 * getter de l'attribut nouveauClient 
	 * @return l'instance nouveauClient
	 */
	public Client getNouveauClient() {
		return nouveauClient;
	}

	/**
	 * setter de l'attribut nouveauClient
	 * @param nouveauClient
	 */
	public void setNouveauClient(Client nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	/**
	 * getter de l'attribut serviceClient 
	 * @return l'instance serviceClient
	 */
	public IServiceClient getServiceClient() {
		return serviceClient;
	}

	/**
	 * setter de l'attribut serviceClient
	 * @param serviceClient
	 */
	public void setServiceClient(IServiceClient serviceClient) {
		this.serviceClient = serviceClient;
	}

	/**
	 * Methode de mise à jour des infos client
	 * @return une chaine de caratere referençant une page xhtml client
	 */
	public String update() {

		System.out.println("appel mise a jour client");
		serviceClient.createOrUpdate(selectedClient);
		addMessage("Mise a jour client effectuée");
		return "client";
	}

	/**
	 * Methode de creation d'un nouveau client
	 * @return une chaine de caratere referençant une page xhtml client
	 */
	public String create() {
		System.out.println("appel create client");
		System.out.println("nouveau client :" + nouveauClient);
		Conseiller conseiller = (Conseiller) ownerBean.getEmploye();
		clientList = (List<Client>) conseiller.getListeClients();
		serviceClient.createOrUpdate(nouveauClient);
		clientList.add(nouveauClient);
		serviceEmploye.createOrUpdate(conseiller);
		addMessage("Ajout client effectué");
		return "client";
	}

	/**
	 * Méthode de redirection vers la page de gestion de comptes 
	 * @return une chaine de caratere referençant une page xhtml client
	 */
	public String afficherComptes() {
		if (selectedClient != null)
			return "compte";
		else
			addMessage("Erreur : pas de client selectionné!");
		return "client";
	}

	/**
	 * Methode de supression d'un client en base de données
	 * @return une chaine de caratere referencant la page xhtml client 
	 */
	public String delete() {
		Conseiller conseiller = (Conseiller) ownerBean.getEmploye();
		clientList = (List<Client>) conseiller.getListeClients();
		System.out.println(clientList);
		System.out.println(selectedClient);
		System.out.println(clientList.remove(selectedClient));
		System.out.println(clientList);
		serviceEmploye.createOrUpdate(conseiller);
		serviceClient.delete(selectedClient);
		addMessage("Supression client effectuée");
		return "client";
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
	 * Methode permettant de detecter la selection d'une ligne client en table
	 * dans la vue client
	 * @param event :l'évènement selection
	 */
	public void onClientSelect(SelectEvent event) {
		this.selectedClient = (Client) event.getObject();
		System.out.println("client selectionné" + selectedClient);
	}


}
