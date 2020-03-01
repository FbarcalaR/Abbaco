package cuentas.api.cuentasapi.models;

import java.util.Date;

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
	private int id;
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	private double cash;
	private String cashFlowDescription;
	private int cashFlowGroup;


	public CashFlow() {
	}

	public CashFlow(int id, Date creationDate, double cash, String cashFlowDescription, int cashFlowGroup) {
		this.id = id;
		this.creationDate = creationDate;
		this.cash = cash;
		this.cashFlowDescription = cashFlowDescription;
		this.cashFlowGroup = cashFlowGroup;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getCash() {
		return this.cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public String getCashFlowDescription() {
		return this.cashFlowDescription;
	}

	public void setCashFlowDescription(String cashFlowDescription) {
		this.cashFlowDescription = cashFlowDescription;
	}

	public int getCashFlowGroup() {
		return this.cashFlowGroup;
	}

	public void setCashFlowGroup(int cashFlowGroup) {
		this.cashFlowGroup = cashFlowGroup;
	}

	public CashFlow id(int id) {
		this.id = id;
		return this;
	}

	public CashFlow creationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public CashFlow cash(double cash) {
		this.cash = cash;
		return this;
	}

	public CashFlow cashFlowDescription(String cashFlowDescription) {
		this.cashFlowDescription = cashFlowDescription;
		return this;
	}

	public CashFlow cashFlowGroup(int cashFlowGroup) {
		this.cashFlowGroup = cashFlowGroup;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", creationDate='" + getCreationDate() + "'" +
			", cash='" + getCash() + "'" +
			", cashFlowDescription='" + getCashFlowDescription() + "'" +
			", cashFlowGroup='" + getCashFlowGroup() + "'" +
			"}";
	}
	
}