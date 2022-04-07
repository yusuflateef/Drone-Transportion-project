package com.transportation.app.com.transportation.app.models;

import javax.persistence.*;

@Entity
@Table(name="Medications")
public class Medications {
    public Medications(String name, long weight, String code, String image, Drone drone) {
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
        this.drone = drone;
    }

    public Medications() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        var formatter  = new TextFormatter();
        if(!formatter.CheckNamePattern(name)){
            var textMessage="invalid name{allowed only letters, numbers, ‘-‘, ‘_’}";
            this.name= textMessage;
        }
        this.name = name;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        var textFormatter= new TextFormatter();
        if(textFormatter.CheckPatternCode(code)==true){
            this.code = code;
        }
        this.code="wrong Input ";

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medications(Long id, String name, long weight, String code, String image) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.code = code;
        this.image = image;
    }
    @Id
    @SequenceGenerator(name="medications_Sequence",sequenceName="medications_Sequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="medications_Sequence")
    private  Long id;
    private String name; //(allowed only letters, numbers, ‘-‘, ‘_’);
    private long weight;
    private String code;// (allowed only upper case letters, underscore and numbers);
    private String image;// (picture of the medication case).
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false,insertable = false, updatable = false)
    private Drone drone;
}
