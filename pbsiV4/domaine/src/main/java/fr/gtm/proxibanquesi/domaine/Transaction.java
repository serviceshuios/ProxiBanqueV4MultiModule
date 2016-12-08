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

	/** Num�ro d'identification du virement */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/** Date  du virement*/
	private Date dateVirement;
	/** Num�ro d'identification du compte d�bit� */
	private Integer sourceId;
	/** Num�ro d'identification du compte cr�dit� */
	private Integer destinationId;
	/** Num�ro d'identification du montant du virement */
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
	 * Getter de la propri�t� id
	 * @return La propri�t� id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de la propri�t� id
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de la propri�t� dateVirement
	 * @return La propri�t� dateVirement
	 */
	public Date getDateVirement() {
		return dateVirement;
	}

	/**
	 * Setter de la propri�t� dateVirement
	 * @param dateVirement
	 */
	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	/**
	 * Getter de la propri�t� sourceId
	 * @return La propri�t� sourceId
	 */
	public Integer getSourceId() {
		return sourceId;
	}

	/**
	 * Setter de la propri�t� sourceId
	 * @param sourceId
	 */
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * Getter de la propri�t� destinationId
	 * @return La propri�t� destinationId
	 */
	public Integer getDestinationId() {
		return destinationId;
	}

	/**
	 * Setter de la propri�t� destinationId
	 * @param destinationId
	 */
	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	/**
	 * Getter de la propri�t� montant
	 * @return La propri�t� montant
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter de la propri�t� montant
	 * @param montant
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de Virement
	 * @return String d�crivant le virement
	 */
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", dateVirement=" + dateVirement + ", sourceId=" + sourceId
				+ ", destinationId=" + destinationId + ", montant=" + montant + "]";
	}
	
	
	
	
}

