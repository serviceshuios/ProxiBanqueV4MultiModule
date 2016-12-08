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
 * Classe TestServiceCompte qui permet de tester les m�thodes findAll(),
 * virementIntra() et virementInter() de ServiceCompte ind�pendamment de
 * DaoCompte
 */
public class TestServiceCompte {
	/** Interface IDAOCompte simul� par Mockito */
	@Mock
	IDaoCompte dao;
	/** serviceCompte */
	ServiceCompte ser;

	/**
	 * M�thode se lancant avant tous les tests permettant d'initialiser la
	 * m�thode setUp()
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		ser = new ServiceCompte();
		ser.setDao(dao);
	}

	/**
	 * M�thode permettant de tester la m�thode findOne(), en v�rifiant que la
	 * m�thode findOne() de IDaoCompte a bien �t� appel�e
	 */
	@Test
	public void testCallFindOne() {
		ser.findOne(1);
		Mockito.verify(dao).findOne(1);
	}

	/**
	 * M�thode permettant de tester la m�thode findAll(), en v�rifiant que la m�thode findAll() 
	 * de IDaoCompte a bien �t� appel�e
	 */
	@Test
	public void testFindAllDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "service-context.xml", "ApplicationContext.xml" });
		ServiceCompte ser2 = (ServiceCompte) context.getBean("serviceCompte");
		System.out.println(ser2.findAll());
	}

	/**
	 * M�thode permettant de tester la m�thode virementIntra(), en v�rifiant que la m�thode ave() 
	 * de IDaoCompte, n�cessaire � la m�thode virementIntra(), a bien �t� appel�e
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
	 * M�thode permettant de tester la m�thode virementInter(), en v�rifiant que la m�thode ave() 
	 * de IDaoCompte, n�cessaire � la m�thode virementInter(), a bien �t� appel�e
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
