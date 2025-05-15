package com.lenderApp.lender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lenderApp.lender.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUserID(Long userID);


//	Users findByMobile(Long userID);
}
