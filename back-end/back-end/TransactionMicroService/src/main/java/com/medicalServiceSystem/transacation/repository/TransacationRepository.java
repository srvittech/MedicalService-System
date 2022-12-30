package com.medicalServiceSystem.transacation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalServiceSystem.transacation.model.Transacation;

@Repository
public interface TransacationRepository extends JpaRepository<Transacation, Long> {

}
