package com.transportation.app.repository;

import com.transportation.app.com.transportation.app.models.Medications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepository extends JpaRepository<Medications,Long> {
}
