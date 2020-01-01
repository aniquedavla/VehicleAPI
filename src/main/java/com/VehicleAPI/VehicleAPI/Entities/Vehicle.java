package com.VehicleAPI.VehicleAPI.Entities;

import javax.persistence.*;

//Vehicle table
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="year")
    private int year;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    //json of class data
    @Override
    public String toString() {
        return "Vehicle [id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + "]";
    }}
