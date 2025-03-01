package com.bank.mortgage.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MortgageRate {

	@Id
	private double interestRate;
	private int maturityPeriod;
	private Date lastUpdate;

	public MortgageRate() {
		super();
	}

	public MortgageRate(int maturityPeriod, double interestRate, Date lastUpdate) {
		super();
		this.maturityPeriod = maturityPeriod;
		this.interestRate = interestRate;
		this.lastUpdate = lastUpdate;
	}

	public int getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(int maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "MortgageRate [interestRate=" + interestRate + ", maturityPeriod=" + maturityPeriod + ", lastUpdate="
				+ lastUpdate + "]";
	}

}
