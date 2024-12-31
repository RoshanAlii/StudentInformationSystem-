package com.example.studentinfo.entity;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String indexNo;
    private String name;
    private String dob;
    private double gpa;

    public Student() {
    }

    public Student(String indexNo, String name, String dob, double gpa) {
        this.indexNo = indexNo;
        this.name = name;
        this.dob = dob;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(String indexNo) {
        this.indexNo = indexNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
