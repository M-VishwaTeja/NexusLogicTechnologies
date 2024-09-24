package com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.model.Patient;

public class PatientDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/HospitalDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vishwa@624";

    private static final String INSERT_PATIENT_SQL = "INSERT INTO Patients (name, doctor_id, prescribed_drugs) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_PATIENTS = "SELECT * FROM Patients";
    private static final String DELETE_PATIENT_SQL = "DELETE FROM Patients WHERE id = ?";
    private static final String UPDATE_PATIENT_SQL = "UPDATE Patients SET name = ?, doctor_id = ?, prescribed_drugs = ? WHERE id = ?";

    // Add a new patient
    public void addPatient(Patient patient) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PATIENT_SQL)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setInt(2, patient.getDoctorId());
            preparedStatement.setString(3, patient.getPrescribedDrugs());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Get all patients
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PATIENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int doctorId = rs.getInt("doctor_id");
                String drugs = rs.getString("prescribed_drugs");
                patients.add(new Patient(id, name, doctorId, drugs));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return patients;
    }

    // Update a patient's details
    public void updatePatient(Patient patient) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PATIENT_SQL)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setInt(2, patient.getDoctorId());
            preparedStatement.setString(3, patient.getPrescribedDrugs());
            preparedStatement.setInt(4, patient.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Delete a patient by id
    public void deletePatient(int id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PATIENT_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
            }
        }
    }
}
