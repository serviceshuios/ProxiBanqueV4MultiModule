package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Transaction;


/**
 * Interface IDaoTransaction qui hérite des méthodes de l'interface JpaRepository
 *
 */
@Repository("daoTransaction")
public interface IDaoTransaction extends JpaRepository<Transaction, Integer> {

}
