package com.coforge.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private LocalDate dob;

    private String location;

    public Employee() {
        super();
    }

    public Employee(int id, String name, LocalDate dob, String location) {
        super();
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.location = location;
    }

    public Employee(String name, LocalDate dob, String location) {
        super();
        this.name = name;
        this.dob = dob;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    // Optional: Remove this setter if you always use auto-generated IDs
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id +
                ", name=" + name +
                ", dob=" + dob +
                ", location=" + location + "]";
    }
}