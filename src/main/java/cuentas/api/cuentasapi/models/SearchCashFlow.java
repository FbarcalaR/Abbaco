package cuentas.api.cuentasapi.models;

import java.util.Date;

public class SearchCashFlow {
	private Date startDate;
	private Date endDate;
	private Double minCash;
	private Double maxCash;
	private String cashFlowDescription;
	private String cashFlowGroup;

    public SearchCashFlow() {
    }

    public SearchCashFlow(Date startDate, Date endDate, double minCash, double maxCash, String cashFlowDescription, String cashFlowGroup) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.minCash = minCash;
        this.maxCash = maxCash;
        this.cashFlowDescription = cashFlowDescription;
        this.cashFlowGroup = cashFlowGroup;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getMinCash() {
        return this.minCash;
    }

    public void setMinCash(double minCash) {
        this.minCash = minCash;
    }

    public double getMaxCash() {
        return this.maxCash;
    }

    public void setMaxCash(double maxCash) {
        this.maxCash = maxCash;
    }

    public String getCashFlowDescription() {
        return this.cashFlowDescription;
    }

    public void setCashFlowDescription(String cashFlowDescription) {
        this.cashFlowDescription = cashFlowDescription;
    }

    public String getCashFlowGroup() {
        return this.cashFlowGroup;
    }

    public void setCashFlowGroup(String cashFlowGroup) {
        this.cashFlowGroup = cashFlowGroup;
    }

    public SearchCashFlow startDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public SearchCashFlow endDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public SearchCashFlow minCash(double minCash) {
        this.minCash = minCash;
        return this;
    }

    public SearchCashFlow maxCash(double maxCash) {
        this.maxCash = maxCash;
        return this;
    }

    public SearchCashFlow cashFlowDescription(String cashFlowDescription) {
        this.cashFlowDescription = cashFlowDescription;
        return this;
    }

    public SearchCashFlow cashFlowGroup(String cashFlowGroup) {
        this.cashFlowGroup = cashFlowGroup;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", minCash='" + getMinCash() + "'" +
            ", maxCash='" + getMaxCash() + "'" +
            ", cashFlowDescription='" + getCashFlowDescription() + "'" +
            ", cashFlowGroup='" + getCashFlowGroup() + "'" +
            "}";
    }
	
}