package abbaco.usecases;

import java.util.Date;

public class CashFlowFiltersSvc {
    private String title;
    private Long classificationId;
    private Date minDate;
    private Date maxDate;
    private Double minCashAmount;
    private Double maxCashAmount;

    public CashFlowFiltersSvc() {}

    public CashFlowFiltersSvc(String title, Long classificationId, Date minDate, Date maxDate, Double minCashAmount,
            Double maxCashAmount) {
        this.title = title;
        this.classificationId = classificationId;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.minCashAmount = minCashAmount;
        this.maxCashAmount = maxCashAmount;
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

    public Date getMinDate() {
        return this.minDate;
    }

    public void setMinDate(Date minDate) {
        this.minDate = minDate;
    }

    public Date getMaxDate() {
        return this.maxDate;
    }

    public void setMaxDate(Date maxDate) {
        this.maxDate = maxDate;
    }

    public Double getMinCashAmount() {
        return this.minCashAmount;
    }

    public void setMinCashAmount(Double minCashAmount) {
        this.minCashAmount = minCashAmount;
    }

    public Double getMaxCashAmount() {
        return this.maxCashAmount;
    }

    public void setMaxCashAmount(Double maxCashAmount) {
        this.maxCashAmount = maxCashAmount;
    }

    public Boolean isNull(){
        return  title == null &&
                classificationId == null &&
                minDate == null &&
                maxDate == null &&
                minCashAmount == null &&
                maxCashAmount == null;
    }

}