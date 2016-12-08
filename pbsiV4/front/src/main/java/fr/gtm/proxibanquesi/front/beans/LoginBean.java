package fr.gtm.proxibanquesi.front.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.domaine.Employe;
import fr.gtm.proxibanquesi.domaine.Gerant;
import fr.gtm.proxibanquesi.service.IServiceEmploye;

@ManagedBean
@Scope
@Component
public class LoginBean {
	/** employé */
	private Employe employe;
	/** nouveau client */
	private Client nouveauClient;
	
	/**
	 * Interface IServiceEmploye injecté par Spring
	 */
	@Autowired
	private IServiceEmploye serv;
	
	/**
	 * Methode appelée avant l'initialisation du bean 
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean login");
		employe = new Conseiller();
		nouveauClient = new Client();
		System.out.println("Employe : " + employe);
	}
	/**
	 * Methode appelée avant la destruction du bean du bean 
	 */
	@PreDestroy
	public void finBean() {
		System.out.println("Destruction bean login");
	}
	
	/**
	 * Constructeur de LoginBean sans argument
	 */
	public LoginBean() {
		super();
	}

	/**
	 * getter de l'attribut employe
	 * @return l'instance employe
	 */
	public Employe getEmploye() {
		return employe;
	}

	/**
	 * setter de l'attribut employe
	 * @param employe
	 */
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	/**
	 * getter de l'attribut IServiceEmploye
	 * @return l'instance IServiceEmploye
	 */
	public IServiceEmploye getServ() {
		return serv;
	}

	/**
	 * setter de l'attribut IServiceEmploye
	 * @param IServiceEmploye
	 */
	public void setServ(IServiceEmploye serv) {
		this.serv = serv;
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
	 * Méthode qui permet l'authentification d'un employé, interrogation de la base de données
	 * @return une chaine de caratere referencant une page xhtml /faces/accueil.xhtml
	 */
	public String authentification() {
		System.out.println(employe.getLogin() + " " + employe.getMdp() );
		if (serv.findByLoginAndMdp(employe.getLogin(), employe.getMdp()) != null) {
		employe = serv.findByLoginAndMdp(employe.getLogin(), employe.getMdp());
		}
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).login(employe.getLogin(), employe.getMdp());
		} catch (ServletException e) {
			e.printStackTrace();
			return "/faces/erreur.xhtml";
		}
		if (employe instanceof Conseiller) {
		return "/faces/cons/client.xhtml";
		} else if (employe instanceof Gerant) {
			return "/faces/ger/cons.xhtml";
		}
		return "/faces/erreur.xhtml";
	}
	
	/**
	 * Méthode qui permet de se déconnecter à sa session
	 * @return une chaine de caratere referencant une page xhtml /faces/accueil.xhtml
	 */
	public String logout() {
		employe = new Conseiller();
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
		} catch (ServletException e) {
			e.printStackTrace();
			return "/faces/erreur.xhtml";
		}
		return "/faces/accueil.xhtml";
	}
	
	/**
	 * Methode de creation d'un nouveau client 
	 * @return une chaine de caratere referencant une page xhtml client
	 */
	public String create() {
		System.out.println("appel create client");
		System.out.println("nouveau client :" + nouveauClient);
		((Conseiller) employe).getListeClients().add(nouveauClient);
		serv.createOrUpdate(employe);
		employe = serv.findOne(employe.getId());
		addMessage("Ajout client effectué");
		return "/faces/cons/client.xhtml";
	}
	
	/**
	 * Methode d'affichage de notifications
	 *  @param summary : message a émettre
	 */
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
