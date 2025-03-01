package com.bank.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.mortgage.model.MortgageRate;

@Repository
public interface MortgageRepository extends JpaRepository<MortgageRate, Long> {

}
