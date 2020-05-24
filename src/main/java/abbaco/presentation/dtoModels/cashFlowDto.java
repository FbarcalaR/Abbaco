package abbaco.presentation.dtoModels;

import java.util.Date;
    
public class CashFlowDto{
    private String id;
    private String title;
    private String classificationId;
	private Date creationDate;
    private double cashAmount;
    
	public CashFlowDto() {}

    public CashFlowDto(String id, String title, String classificationId, Date creationDate, double cashAmount) {
        this.id = id;
        this.title = title;
        this.classificationId = classificationId;
        this.creationDate = creationDate;
        this.cashAmount = cashAmount;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassificationId() {
        return this.classificationId;
    }

    public void setClassificationId(String classificationId) {
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


}