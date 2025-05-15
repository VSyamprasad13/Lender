package com.lenderApp.lender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Borrower;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, Long>{

}
