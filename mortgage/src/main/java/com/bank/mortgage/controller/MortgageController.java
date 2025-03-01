package com.bank.mortgage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.mortgage.model.MortgageCheck;
import com.bank.mortgage.model.MortgageRate;
import com.bank.mortgage.service.MortgageService;

/**
 * This MortgageController class that holds REST APIs end points of Mortgage Management System.
 * Management.
 * 
 * @author Chandini Pillalamarri
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class MortgageController {

	private final MortgageService mortgageService;

	public MortgageController(MortgageService mortgageService) {
		this.mortgageService = mortgageService;

	}

	/**
	 * 
	 * @param mortgageRate
	 * @return mortgageRate Description: endpoint to add the MortgageRate objects.
	 */

	@RequestMapping(value = "/add/interest-rates", method = RequestMethod.POST)
	ResponseEntity<Map<String, Object>> addMortgageRates(@RequestBody MortgageRate mortgageRate) {
		Map<String, Object> addedMortgagesMap = new HashMap();
		addedMortgagesMap.put("data", mortgageService.addMortgageRates(mortgageRate));
		return ResponseEntity.status(HttpStatus.OK).body(addedMortgagesMap);
	}

	/**
	 * 
	 * @return interestRates
	 * 
	 */

	@GetMapping(value = "/interest-rates")
	ResponseEntity<Map<String, Object>> getInterestRates() {
		Map<String, Object> interestsMap = new HashMap();
		interestsMap.put("data", mortgageService.getInterestRates());
		return ResponseEntity.status(HttpStatus.OK).body(interestsMap);
	}

	@PostMapping("/mortgage-check")
	ResponseEntity<String> checkMortgageEligibilty(@RequestBody MortgageCheck mortgageRequest) {
		boolean eligible = mortgageService.checkMortgageEligibilty(mortgageRequest);
		if (eligible) {
			return ResponseEntity.status(HttpStatus.OK).body("Mortgage approved.");
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Mortgage not approved as Limit exceeds.");
		}
	}

}
