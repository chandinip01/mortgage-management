package com.bank.mortgage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.mortgage.model.MortgageCheck;
import com.bank.mortgage.model.MortgageRate;
import com.bank.mortgage.repository.MortgageRepository;

@Service
public class MortgageService {

	private final MortgageRepository mortgageRepo;

	// Constructor Dependency-Injection
	public MortgageService(MortgageRepository mortgageRepo) {
		this.mortgageRepo = mortgageRepo;
	}

	/**
	 * 
	 * @param mortgageRate
	 * @return mortgageRate
	 */

	// adding data to MortgageRate Object using h2-database.
	public MortgageRate addMortgageRates(MortgageRate mortgageRate) {
		return this.mortgageRepo.save(mortgageRate);
	}

	/**
	 * 
	 * @return mortgageRateList
	 */
	// return data from h2-database.
	public List<MortgageRate> getInterestRates() {
		List<MortgageRate> mortgageRateList = mortgageRepo.findAll();

		// returning only current interest Rates.
		// return
		// mortgageRateList.stream().map(MortgageRate::getInterestRate).collect(Collectors.toList());

		return mortgageRateList;
	}

	/**
	 * 
	 * @param mortgageCheck
	 * @return boolean
	 */

	// eligibility check for Loan approval.
	public boolean checkMortgageEligibilty(MortgageCheck mortgageCheck) {
		double maxAffordableLoan = mortgageCheck.getIncome() * 4;
		double homeValue = mortgageCheck.getHomeValue();
		double loanValue = mortgageCheck.getLoanValue();
		return (loanValue <= maxAffordableLoan && loanValue <= homeValue) ? true : false;
	}

}
