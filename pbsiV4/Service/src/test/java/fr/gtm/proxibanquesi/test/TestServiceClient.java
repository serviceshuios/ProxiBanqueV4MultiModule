package fr.gtm.proxibanquesi.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.service.ServiceClient;


/**
 * Classe TestServiceClient qui permet de tester la m�thodes findAll() de ServiceClient
 * ind�pendamment de DaoCompte
 */
public class TestServiceClient {
	/** Interface IDAOClient simul� par Mockito */
	@Mock
	IDaoClient dao;
	/** serviceClient */
	ServiceClient ser;

	/**
	 * M�thode se lancant avant tous les tests permettant d'initialiser la m�thode setUp()
	 */
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		ser = new ServiceClient();
		ser.setDao(dao);
	}
	
	/**
	 * M�thode permettant de tester la m�thode findAll(), en v�rifiant que la m�thode findAll() 
	 * de IDaoCompte a bien �t� appel�e
	 */
	@Test
	public void testCallFindAll(){
		ser.findAll();
		Mockito.verify(dao).findAll();
		
	}
	
}
