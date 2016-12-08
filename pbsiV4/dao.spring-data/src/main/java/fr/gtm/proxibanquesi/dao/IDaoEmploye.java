package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Interface IDaoEmploye qui h�rite des m�thodes de l'interface JpaRepository
 *
 */
@Repository("daoEmploye")
public interface IDaoEmploye extends JpaRepository<Employe, Integer> {

	public Employe findByLoginAndMdp(String login, String mdp); 
	
}
