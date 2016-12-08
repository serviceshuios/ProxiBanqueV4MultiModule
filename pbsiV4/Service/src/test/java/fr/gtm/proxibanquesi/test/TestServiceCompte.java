package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.exceptions.SoldeException;
import fr.gtm.proxibanquesi.service.ServiceCompte;

/**
 * Classe TestServiceCompte qui permet de tester les méthodes findAll(),
 * virementIntra() et virementInter() de ServiceCompte indépendamment de
 * DaoCompte
 */
public class TestServiceCompte {
	/** Interface IDAOCompte simulé par Mockito */
	@Mock
	IDaoCompte dao;
	/** serviceCompte */
	ServiceCompte ser;

	/**
	 * Méthode se lancant avant tous les tests permettant d'initialiser la
	 * méthode setUp()
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ser = new ServiceCompte();
		ser.setDao(dao);
	}

	/**
	 * Méthode permettant de tester la méthode findOne(), en vérifiant que la
	 * méthode findOne() de IDaoCompte a bien été appelée
	 */
	@Test
	public void testCallFindOne() {
		ser.findOne(1);
		Mockito.verify(dao).findOne(1);
	}

	/**
	 * Méthode permettant de tester la méthode findAll(), en vérifiant que la méthode findAll() 
	 * de IDaoCompte a bien été appelée
	 */
	@Test
	public void testFindAllDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "service-context.xml", "ApplicationContext.xml" });
		ServiceCompte ser2 = (ServiceCompte) context.getBean("serviceCompte");
		System.out.println(ser2.findAll());
	}

	/**
	 * Méthode permettant de tester la méthode virementIntra(), en vérifiant que la méthode ave() 
	 * de IDaoCompte, nécessaire à la méthode virementIntra(), a bien été appelée
	 */
	@Test
	public void testCallVirementIntra() {
		CompteCourant cDeb = new CompteCourant(500);
		CompteCourant cCre = new CompteCourant(200);
		try {
			ser.virementIntraClient(cDeb, cCre, 200);
		} catch (SoldeException e) {
			e.getMessage();
			fail();
		}
		Mockito.verify(dao).save(cCre);
		Mockito.verify(dao).save(cDeb);
	}

	/**
	 * Méthode permettant de tester la méthode virementInter(), en vérifiant que la méthode ave() 
	 * de IDaoCompte, nécessaire à la méthode virementInter(), a bien été appelée
	 */
	@Test
	public void estCallVirementInter() {
		CompteCourant cDeb = new CompteCourant(500);
		CompteCourant cCre = new CompteCourant(200);
		try {
			ser.virementIntraClient(cDeb, cCre, 2000);
		} catch (SoldeException e) {
			e.getMessage();
			fail();
		}
		Mockito.verify(dao, Mockito.times(0)).save(cCre);
		Mockito.verify(dao, Mockito.times(0)).save(cDeb);
	}

}
