package com.transportation.app.services;

import com.transportation.app.com.transportation.app.models.Drone;
import com.transportation.app.com.transportation.app.models.Medications;
import com.transportation.app.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record DroneServices(DroneRepository rep) {
    @Autowired
    public DroneServices {
    }
    // Register A Drone
    public Drone  post(Drone drone){
        return rep.save(drone);
    }
    // Get All Drone
    public List<Drone> get() {
        return rep.findAll();
    }

    // checking loaded medication items for a given drone;
    public List<Medications> get(Long id) {
        return rep.getById(id).getMedications();
    }

    //loading a drone with medication items;
    public  void postMedicationItem(Long id, List<Medications> med){

         rep.getById(id).setMedications(med);
    }
    //check drone battery level for a given drone;
    public String checkBattery(Long id) {
        var drone = rep.getById(id);

        if (drone.getBatteryCapacity().isEmpty()) {
            return "0%";
        }
        return drone.getBatteryCapacity();
    }
}