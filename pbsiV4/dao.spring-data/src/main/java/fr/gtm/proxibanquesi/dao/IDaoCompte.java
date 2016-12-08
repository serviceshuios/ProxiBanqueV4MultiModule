package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Interface IDaoCompte qui hérite des méthodes de l'interface JpaRepository
 *
 */
@Repository("daoCompte")
public interface IDaoCompte extends JpaRepository<Compte, Integer> {

}
