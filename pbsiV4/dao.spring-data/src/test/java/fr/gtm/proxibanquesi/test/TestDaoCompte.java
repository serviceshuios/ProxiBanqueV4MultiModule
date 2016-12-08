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
 * Classe TestDaoCompte qui permet de tester les m�thodes findOne(), createCompte() et findAll() de DaoCompte
 *
 */
@Transactional
public class TestDaoCompte {
	/** Interface IDAOCompte */
	private static IDaoCompte dao;
	/** Interface ApplicationContext */
	private static ApplicationContext context;

	/**
	 * M�thode se lancant avant tous les tests permettant de charger la d�finition du contexte 
	 * � partir d'un fichier XML contenu dans le classpath.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoCompte) context.getBean("daoCompte");
	}

	/**
	 * M�thode permettant de tester la m�thode findOne(), en v�rifiant que le compte, ayant 
	 * pour num�ro de compte 1, est pr�sent dans la base de donn�es
	 */
	@Test
	public void testFindOneIsNotNull() {
		assertNotNull(dao.findOne(1));
	}
	
	/**
	 * M�thode permettant de tester la m�thode findOne(), en v�rifiant que l'objet retourn�
	 * est de type Compte
	 */
	@Test
	public void testFindOneReturnCompte(){
		assertTrue(dao.findOne(1) instanceof Compte);
	}
	
	/**
	 * M�thode permettant de tester la m�thode createCompte(), en v�rifiant que l'objet Compte
	 * cr�� est pr�sent dans la base de donn�es
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
	 * M�thode permettant de tester la m�thode findAll(), en v�rifiant que la liste retourn� 
	 * n'est pas nulle
	 */
	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
		assertNotNull(dao.findAll());
	}

}
