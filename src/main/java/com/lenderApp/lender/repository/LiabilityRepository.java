package com.lenderApp.lender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Liabilities;

@Repository
public interface LiabilityRepository extends JpaRepository<Liabilities, Long> {
	
}
