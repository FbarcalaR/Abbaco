package abbaco.presentation.dtoModels;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
    
public class CashFlowDto{
    private Long id;
    @NotNull
    @Pattern(regexp = "^[0-9a-zA-ZñÑçÇ ]*$")
    private String title;
    @Pattern(regexp = "^[0-9a-zA-ZñÑçÇ ]*$")
    private String classification;
    @NotNull
    private Long classificationId;
    @NotNull
	private Date creationDate;
    @NotNull
    private double cashAmount;
    
	public CashFlowDto() {}

    public CashFlowDto(Long id, String title, Long classificationId, String classification, Date creationDate, double cashAmount) {
        this.id = id;
        this.title = title;
        this.classificationId = classificationId;
        this.classification = classification;
        this.creationDate = creationDate;
        this.cashAmount = cashAmount;
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

    public Long getClassificationId() {
        return this.classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassification() {
        return this.classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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