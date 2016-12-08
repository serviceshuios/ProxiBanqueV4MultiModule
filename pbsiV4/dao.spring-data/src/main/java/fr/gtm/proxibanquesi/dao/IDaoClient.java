package fr.gtm.proxibanquesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Interface IDaoClient qui h�rite des m�thodes de l'interface JpaRepository
 *
 */
@Repository("daoClient")
public interface IDaoClient extends JpaRepository<Client, Integer> {

}
