package abbaco.entities.models;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CashFlow {    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private String title;

    public CashFlow(UUID id, String title, int classificationId, Date creationDate, double cashAmount) {
        this.id = id;
        this.title = title;
        this.classificationId = classificationId;
        this.creationDate = creationDate;
        this.cashAmount = cashAmount;
    }
    private int classificationId;

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getClassificationId() {
        return this.classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
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
	@Temporal(TemporalType.DATE)
	private Date creationDate;
    private double cashAmount;
}