package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.dao.IDaoTransaction;
import fr.gtm.proxibanquesi.domaine.Transaction;



@ManagedBean
@Scope
@Component
public class GraphicBean implements Serializable{

	/** Clé identifie de manière unique la Classe */
	private static final long serialVersionUID = 1L;
	/** Classe lineChartModel */
	private LineChartModel dateModel;
	
	/**
	 * Interface IDaoTransaction injecté par Spring
	 */
	@Autowired
	IDaoTransaction transacDao;
	
	/**
	 * Constructeur de GraphicBean sans argument
	 */
	public GraphicBean() {
		super();
	}
	
	/**
	 * Methode appelée avant l'initialisation du bean 
	 */
	@PostConstruct
    public void init() {
        createDateModel();
        System.out.println("creation bean graph");
    }
	
	/**
	 * Méthode permettant  modèle de données
	 */
	private void createDateModel() {
		System.out.println("create data model");
        dateModel = new LineChartModel();
        
        LineChartSeries serie = new LineChartSeries();
        ArrayList<Transaction> list = (ArrayList<Transaction>) transacDao.findAll();
        System.out.println(list);
        serie.setLabel("Transactions");
        for(int i=0;i<list.size();i++)
        {
        	Transaction temp=list.get(i);
        serie.set(temp.getDateVirement().toString(), temp.getMontant());
        }
        System.out.println(serie);
        dateModel.addSeries(serie);
        dateModel.setTitle("Historique des transactions");
        dateModel.setZoom(true);
        dateModel.getAxis(AxisType.Y).setLabel("Montant (euros)");
        DateAxis axis = new DateAxis("Dates");
        axis.setTickAngle(-50);
        axis.setMax("2016-01-31");
        axis.setTickFormat("%b %#d, %y");
        dateModel.getAxes().put(AxisType.X, axis);
          
    }
	
	/**
	 * getter de l'attribut dateModel
	 * @return l'instance selectedClient
	 */
	public LineChartModel getDateModel() {
		System.out.println("get data model");
		return dateModel;
	}
	
	/**
	 * setter de l'attribut dateModel
	 * @param dateModel
	 */
	public void setDateModel(LineChartModel dateModel) {
		this.dateModel = dateModel;
	}
	
}


