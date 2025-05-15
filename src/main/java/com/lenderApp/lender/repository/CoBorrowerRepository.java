package com.lenderApp.lender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.CoBorrower;

@Repository
public interface CoBorrowerRepository extends JpaRepository<CoBorrower, Long> {

}
