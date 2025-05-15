package com.lenderApp.lender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.OtpStore;

@Repository
public interface OtpStoreRepository extends JpaRepository<OtpStore, Long>{
	Optional<OtpStore> findByMobile(Long mobile);
}
