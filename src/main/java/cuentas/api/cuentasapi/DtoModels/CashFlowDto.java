package cuentas.api.cuentasapi.DtoModels;

import java.util.Date;

public class CashFlowDto {
	private int id;
	private Date creationDate;
	private double cash;
	private String cashFlowDescription;
	private String cashFlowGroup;


	public CashFlowDto() {
	}

	public CashFlowDto(int id, Date creationDate, double cash, String cashFlowDescription, String cashFlowGroup) {
		this.id=id;
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

	public CashFlowDto id(int id) {
		this.id = id;
		return this;
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

	public String getCashFlowGroup() {
		return this.cashFlowGroup;
	}

	public void setCashFlowGroup(String cashFlowGroup) {
		this.cashFlowGroup = cashFlowGroup;
	}

	public CashFlowDto creationDate(Date creationDate) {
		this.creationDate = creationDate;
		return this;
	}

	public CashFlowDto cash(double cash) {
		this.cash = cash;
		return this;
	}

	public CashFlowDto cashFlowDescription(String cashFlowDescription) {
		this.cashFlowDescription = cashFlowDescription;
		return this;
	}

	public CashFlowDto cashFlowGroup(String cashFlowGroup) {
		this.cashFlowGroup = cashFlowGroup;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
			" creationDate='" + getCreationDate() + "'" +
			", cash='" + getCash() + "'" +
			", cashFlowDescription='" + getCashFlowDescription() + "'" +
			", cashFlowGroup='" + getCashFlowGroup() + "'" +
			"}";
	}

	
	
}