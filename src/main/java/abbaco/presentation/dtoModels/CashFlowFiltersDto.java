package abbaco.presentation.dtoModels;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CashFlowFiltersDto {
    private String title;
    private Long classificationId;
    private Date minDate;
    private Date maxDate;
    private double minCashAmount;
    private double maxCashAmount;

    public CashFlowFiltersDto() {
    }

    public CashFlowFiltersDto(String title, Long classificationId, Date minDate, Date maxDate, double minCashAmount,
            double maxCashAmount) {
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

    public void setMinDate(String minDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date date;
        try {
            date = format.parse(minDate);
            this.minDate = date;
        } catch (ParseException e) {
            date = null;
        }
    }

    public Date getMaxDate() {
        return this.maxDate;
    }

    public void setMaxDate(String maxDate) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Date date;
        try {
            date = format.parse(maxDate);
            this.maxDate = date;
        } catch (ParseException e) {
            date = null;
        }
    }

    public double getMinCashAmount() {
        return this.minCashAmount;
    }

    public void setMinCashAmount(String minCashAmount) {
        this.minCashAmount = Double.parseDouble(minCashAmount);
    }

    public double getMaxCashAmount() {
        return this.maxCashAmount;
    }

    public void setMaxCashAmount(String maxCashAmount) {
        this.maxCashAmount = Double.parseDouble(maxCashAmount);
    }
}
