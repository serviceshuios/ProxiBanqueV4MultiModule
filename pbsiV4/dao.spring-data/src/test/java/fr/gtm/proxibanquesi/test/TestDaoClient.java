package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Classe TestDaoClient qui permet de tester les méthodes findAll(), save() et delete()  de DaoClient
 *
 */
@Transactional
public class TestDaoClient {
	/** Interface IDAOClient */
	private static IDaoClient dao;
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
		dao = (IDaoClient) context.getBean("daoClient");
	}

	/**
	 * Méthode permettant de tester la méthode save(), en vérifiant que l'objet Client
	 * créé est présent dans la base de données
	 */	
	@Test
	public void testSave() {
		Client newClient = new Client("create","test","lambda","01234","beta","0123456789","gamma@teta.fr");
		dao.save(newClient);
		assertNotNull(dao.findOne(newClient.getId()));
	}
	
	/**
	 * Méthode permettant de tester la méthode save(), en vérifiant que l'objet Client
	 * supprimé n'est pas dans la base de données
	 */	
	@Test
	public void testDelete() {
		Client newClient = dao.findAll().get(0);
		dao.delete(newClient);
		assertNull(dao.findOne(newClient.getId()));
	}

}
