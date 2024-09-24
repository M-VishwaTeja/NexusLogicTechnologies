package com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.model.Doctor;

public class DoctorDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/HospitalDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vishwa@624";

    private static final String INSERT_DOCTOR_SQL = "INSERT INTO Doctors (name, specialization, contact) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_DOCTORS = "SELECT * FROM Doctors";

    public void addDoctor(Doctor doctor) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DOCTOR_SQL)) {
            preparedStatement.setString(1, doctor.getName());
            preparedStatement.setString(2, doctor.getSpecialization());
            preparedStatement.setString(3, doctor.getContact());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DOCTORS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String specialization = rs.getString("specialization");
                String contact = rs.getString("contact");
                doctors.add(new Doctor(name, specialization, contact));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return doctors;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            e.printStackTrace();
        }
    }
}
