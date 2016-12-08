package fr.gtm.proxibanquesi.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoTransaction;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Transaction;


/**
 * Classe d'aspect transversale procédant à l'interception, log et persitence en base de données des virements
 */
@Aspect
public class SecurityInterceptor {

	/**
	 * Interface IDAOTransaction injecté par Spring
	 */
	@Autowired
	private IDaoTransaction dao;

	final Logger mylog = Logger.getLogger(SecurityInterceptor.class);

	
	/**
	 * Constructeur de SecurityInterceptor sans argument
	 */
	public SecurityInterceptor() {
		super();
		System.out.println("Interceptor cree");
	}

	/**
	 * Point de branchement de l'interceptor qui
	 * intercepte toutes les méthodes du ServiceCompte.
	 *et log la transaction pour les deux méthoes de virement. 
	 */
	@Pointcut("execution(* fr.gtm.proxibanquesi.service.ServiceCompte.*(. .))")
	public void secure() {
	}

	/**
	 * Méthode appelée au lancement du virement récupérant les arguments transmit au ServiceCompte et
	 * persistence d'une nouvelle entrée transaction
	 * @param joinpoint
	 */
	@Before("secure()")
	public void logAvant(JoinPoint jp) {
		Compte source, destination;
		int idDest;
		double montant;
		Object res[] = jp.getArgs();

		if (jp.getSignature().getName().equals("virementIntraClient")) {
			mylog.info("Interception virement intra-client");
			if (res.length != 0) {
				source = (Compte) res[0];
				destination = (Compte) res[1];
				montant = (Double) res[2];
				Transaction trans = new Transaction(new Date(), source.getNumCompte(), destination.getNumCompte(), montant);
				dao.save(trans);
				mylog.info(trans);
			}
		}

		if (jp.getSignature().getName().equals("virementInterClient")) {
			mylog.info("Interception virement inter-clients");
			if (res.length != 0) {
				source = (Compte) res[0];
				idDest = (Integer) res[1];
				montant = (Double) res[2];
				Transaction trans = new Transaction(new Date(), source.getNumCompte(), idDest, montant);
				dao.save(trans);
				mylog.info(trans);
			}
		}
	}
}


