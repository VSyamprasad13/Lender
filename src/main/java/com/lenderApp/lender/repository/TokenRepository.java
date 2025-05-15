package com.lenderApp.lender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, String>{

	Optional<Token> findByTokenValue(String tokenValue);

}
