package com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.model.Appointment;

public class AppointmentDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/HospitalDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vishwa@624";

    private static final String INSERT_APPOINTMENT_SQL = "INSERT INTO Appointments (patient_id, doctor_id, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM Appointments";
    private static final String DELETE_APPOINTMENT_SQL = "DELETE FROM Appointments WHERE id = ?";
    private static final String UPDATE_APPOINTMENT_SQL = "UPDATE Appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, appointment_time = ?, status = ? WHERE id = ?";

    // Add a new appointment
    public void addAppointment(Appointment appointment) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setString(3, appointment.getAppointmentDate());
            preparedStatement.setString(4, appointment.getAppointmentTime());
            preparedStatement.setString(5, appointment.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPOINTMENTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int patientId = rs.getInt("patient_id");
                int doctorId = rs.getInt("doctor_id");
                String appointmentDate = rs.getString("appointment_date");
                String appointmentTime = rs.getString("appointment_time");
                String status = rs.getString("status");
                appointments.add(new Appointment(id, patientId, doctorId, appointmentDate, appointmentTime, status));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return appointments;
    }

    // Update an appointment
    public void updateAppointment(Appointment appointment) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPOINTMENT_SQL)) {
            preparedStatement.setInt(1, appointment.getPatientId());
            preparedStatement.setInt(2, appointment.getDoctorId());
            preparedStatement.setString(3, appointment.getAppointmentDate());
            preparedStatement.setString(4, appointment.getAppointmentTime());
            preparedStatement.setString(5, appointment.getStatus());
            preparedStatement.setInt(6, appointment.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Delete an appointment
    public void deleteAppointment(int id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPOINTMENT_SQL)) {
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
