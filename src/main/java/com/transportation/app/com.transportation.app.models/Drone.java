package com.transportation.app.com.transportation.app.models;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Entity
@Table
public class Drone {
    @Id
    @SequenceGenerator(name="Drone_Sequence" ,
                    sequenceName="Drone_Sequence",
                        allocationSize=1 )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                 generator="Drone_Sequence")
    private long id;
    @Max(100)
    private long serialNumber ;
    private Model model ;// (Lightweight, Middleweight, Cruiserweight, Heavyweight);
    @Size(max=500)
    private String  weight; // limit (500gr max);
    @Size(min = 250)
    private String batteryCapacity; //(percentage);
    private  States state; //- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Medications> medications  = new ArrayList<>();

    public List<Medications> getMedications() {
        return medications;
    }

    public void setMedications(List<Medications> medications) {
        this.medications = medications;
    }

    public Drone(long id,long serialNumber, Model model, String weight, String batteryCapacity, States state, List<Medications> medications) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.medications = medications;
    }

    public Drone() {
    }

    public Drone(long serialNumber,  Model model, String weight, String batteryCapacity, States state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public Drone(long id, long serialNumber, Model model, String weight, String batteryCapacity, States state) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.model = model;
        this.weight = weight;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.id=id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public Drone(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", serialNumber=" + serialNumber +
                ", model='" + model + '\'' +
                ", weight='" + weight + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
