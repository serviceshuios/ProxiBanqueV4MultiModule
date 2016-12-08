package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe TestDaoCompte qui permet de tester les méthodes findOne(), createCompte() et findAll() de DaoCompte
 *
 */
@Transactional
public class TestDaoCompte {
	/** Interface IDAOCompte */
	private static IDaoCompte dao;
	/** Interface ApplicationContext */
	private static ApplicationContext context;

	/**
	 * Méthode se lancant avant tous les tests permettant de charger la définition du contexte 
	 * à partir d'un fichier XML contenu dans le classpath.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoCompte) context.getBean("daoCompte");
	}

	/**
	 * Méthode permettant de tester la méthode findOne(), en vérifiant que le compte, ayant 
	 * pour numéro de compte 1, est présent dans la base de données
	 */
	@Test
	public void testFindOneIsNotNull() {
		assertNotNull(dao.findOne(1));
	}
	
	/**
	 * Méthode permettant de tester la méthode findOne(), en vérifiant que l'objet retourné
	 * est de type Compte
	 */
	@Test
	public void testFindOneReturnCompte(){
		assertTrue(dao.findOne(1) instanceof Compte);
	}
	
	/**
	 * Méthode permettant de tester la méthode createCompte(), en vérifiant que l'objet Compte
	 * créé est présent dans la base de données
	 */
	@Test
	public void testCreateCompte() {
		CompteCourant compte = new CompteCourant(5000);
		compte.setDateOuverture(new Date());
		dao.save(compte);
		assertNotNull(dao.findOne(compte.getNumCompte()));
		CompteEpargne compte2 = new CompteEpargne(5000);
		compte2.setDateOuverture(new Date());
		dao.save(compte2);
		assertNotNull(dao.findOne(compte2.getNumCompte()));
	}
	
	/**
	 * Méthode permettant de tester la méthode findAll(), en vérifiant que la liste retourné 
	 * n'est pas nulle
	 */
	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
		assertNotNull(dao.findAll());
	}

}
