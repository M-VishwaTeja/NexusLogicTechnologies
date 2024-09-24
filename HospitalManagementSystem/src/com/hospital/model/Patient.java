package com.hospital.model;

public class Patient {
    private String name;
    private int doctorId;
    private String prescribedDrugs;

    public Patient(String name, int doctorId, String prescribedDrugs) {
        this.name = name;
        this.doctorId = doctorId;
        this.prescribedDrugs = prescribedDrugs;
    }

    public String getName() {
        return name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getPrescribedDrugs() {
        return prescribedDrugs;
    }
}
