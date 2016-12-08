package fr.gtm.proxibanquesi.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.service.ServiceClient;


/**
 * Classe TestServiceClient qui permet de tester la méthodes findAll() de ServiceClient
 * indépendamment de DaoCompte
 */
public class TestServiceClient {
	/** Interface IDAOClient simulé par Mockito */
	@Mock
	IDaoClient dao;
	/** serviceClient */
	ServiceClient ser;

	/**
	 * Méthode se lancant avant tous les tests permettant d'initialiser la méthode setUp()
	 */
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		ser = new ServiceClient();
		ser.setDao(dao);
	}
	
	/**
	 * Méthode permettant de tester la méthode findAll(), en vérifiant que la méthode findAll() 
	 * de IDaoCompte a bien été appelée
	 */
	@Test
	public void testCallFindAll(){
		ser.findAll();
		Mockito.verify(dao).findAll();
		
	}
	
}
