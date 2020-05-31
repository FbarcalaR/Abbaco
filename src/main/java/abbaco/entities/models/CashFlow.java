package abbaco.entities.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import abbaco.entities.configuration.RandomIdGenerator;

@Entity
@Table(name = "cashflows")
public class CashFlow {
    @Id
    @GeneratedValue(generator = RandomIdGenerator.generatorName)
    @GenericGenerator(name = RandomIdGenerator.generatorName, strategy = "abbaco.entities.configuration.RandomIdGenerator")
    private Long id;
    private String title;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
    private double cashAmount;

    @ManyToOne
    private CashFlowClassifier cashFlowClassifier;

    
    public CashFlow() {}

    public CashFlow(Long id, String title, Date creationDate, double cashAmount, CashFlowClassifier cashFlowClassifier) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.cashAmount = cashAmount;
        this.cashFlowClassifier = cashFlowClassifier;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public CashFlowClassifier getCashFlowClassifier() {
        return this.cashFlowClassifier;
    }

    public void setCashFlowClassifier(CashFlowClassifier cashFlowClassifier) {
        this.cashFlowClassifier = cashFlowClassifier;
    }

}