package com.lenderApp.lender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
