package com.VehicleAPI.VehicleAPI.Entities;

import javax.persistence.*;
import java.util.Objects;

//Vehicle table
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="year")
    private Integer year;

    @Column(name="make")
    private String make;

    @Column(name="model")
    private String model;

    @Column(name = "serial-number")
    private Integer serialNumber;

    public Integer getId() {
        return id;
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

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return id.equals(vehicle.id) &&
                year.equals(vehicle.year) &&
                serialNumber.equals(vehicle.serialNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, serialNumber);
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", year=" + year +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
