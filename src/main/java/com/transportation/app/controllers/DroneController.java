package com.transportation.app.controllers;

import com.transportation.app.com.transportation.app.models.Drone;
import com.transportation.app.com.transportation.app.models.Medications;
import com.transportation.app.services.DroneServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DroneController {
    private final DroneServices service;
    @Autowired
    public DroneController(DroneServices service) {
        this.service = service;
    }

    @GetMapping(value = " /Drone")
    public List<Drone> get()
    {
        return service.get();
    }
    @PostMapping(value = "/Drone")
    @ResponseBody
    public Drone post( Drone drone){
      return   service.post(drone);
    }

    @GetMapping(value = "BatteryCapacity")
    public String battery(Long id){
        return service.checkBattery(id);
    }


    @GetMapping(value = "loadOnDrone")
    public List<Medications> loudOnDrone(Long droneId){
        return service.get(droneId);
    }
    @PostMapping(value="loaddroneItems")
    public String postMedicationsToDrone(Long id,List<Medications> meds){
        service.postMedicationItem(id,meds);
        return "added successfully";
    }
}
