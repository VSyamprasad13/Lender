package com.lenderApp.lender.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Assets;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long> {

}
