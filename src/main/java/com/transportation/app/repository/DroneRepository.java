package com.transportation.app.repository;

import com.transportation.app.com.transportation.app.models.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone,Long > {
}

