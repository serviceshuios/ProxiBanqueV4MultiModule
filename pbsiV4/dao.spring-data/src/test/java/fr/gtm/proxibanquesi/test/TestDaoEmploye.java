package fr.gtm.proxibanquesi.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoEmploye;
import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Classe TestDaoEmploye qui permet de tester la méthode testFindAndMdp() de DaoEmploye
 *
 */
@Transactional
public class TestDaoEmploye {
	/** Interface IDAOEmploye */
	private static IDaoEmploye dao;
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
		dao = (IDaoEmploye) context.getBean("daoEmploye");
	}

	
//	@Test
//	public void testCreate() {
//		Conseiller cons = new Conseiller("Titi", "titi");
//		cons.setLogin("titi");
//		cons.setMdp("titi");
//		dao.save(cons);
//		assertNotNull(dao.findOne(cons.getId()));
//		Gerant ger = new Gerant("Tata", "tata");
//		ger.setLogin("tata");
//		ger.setMdp("tata");
//		dao.save(ger);
//		assertNotNull(dao.findOne(ger.getId()));
//	}
	
	
	/**
	 * Méthode permettant de tester la méthode testFindAndMdp(), en vérifiant que le gérant, ayant pour login : ger et
	 * mot de passe : ger, se trouve dans la base de données.
	 */
	@Test
	public void testFindByLogAndMdp() {
		Employe emp = dao.findByLoginAndMdp("ger", "ger");
		
		System.out.println(emp);
	}
}
