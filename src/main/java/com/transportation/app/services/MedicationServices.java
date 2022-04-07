package com.transportation.app.services;

import com.transportation.app.repository.MedicationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicationServices {
    private final MedicationsRepository medications;
    @Autowired
    public MedicationServices(MedicationsRepository medications) {
        this.medications = medications;
    }
}
