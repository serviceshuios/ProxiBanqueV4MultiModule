package fr.gtm.proxibanquesi.domaine;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Transaction {

	/** Numéro d'identification du virement */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/** Date  du virement*/
	private Date dateVirement;
	/** Numéro d'identification du compte débité */
	private Integer sourceId;
	/** Numéro d'identification du compte crédité */
	private Integer destinationId;
	/** Numéro d'identification du montant du virement */
	private double montant;
	
	/**
	 * Constructeur de Transaction sans argument
	 */
	public Transaction() {
		super();
	}

	/**
	 * Constructeur de Transaction a partir des informations du virement.
	 * @param dateVirement
	 * @param sourceId
	 * @param destinationId
	 * @param montant
	 */
	public Transaction(Date dateVirement, Integer sourceId, Integer destinationId, double montant) {
		super();
		this.dateVirement = dateVirement;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.montant = montant;
	}

	/**
	 * Getter de la propriété id
	 * @return La propriété id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de la propriété id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de la propriété dateVirement
	 * @return La propriété dateVirement
	 */
	public Date getDateVirement() {
		return dateVirement;
	}

	/**
	 * Setter de la propriété dateVirement
	 * @param dateVirement
	 */
	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	/**
	 * Getter de la propriété sourceId
	 * @return La propriété sourceId
	 */
	public Integer getSourceId() {
		return sourceId;
	}

	/**
	 * Setter de la propriété sourceId
	 * @param sourceId
	 */
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * Getter de la propriété destinationId
	 * @return La propriété destinationId
	 */
	public Integer getDestinationId() {
		return destinationId;
	}

	/**
	 * Setter de la propriété destinationId
	 * @param destinationId
	 */
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	/**
	 * Getter de la propriété montant
	 * @return La propriété montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter de la propriété montant
	 * @param montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * Méthode permettant de retourner un String avec les propriétés de Virement
	 * @return String décrivant le virement
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", dateVirement=" + dateVirement + ", sourceId=" + sourceId
				+ ", destinationId=" + destinationId + ", montant=" + montant + "]";
	}
	
	
	
	
}

