package com.hospital.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.hospital.model.Pharmacy;

public class PharmacyDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/HospitalDB";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Vishwa@624";

    private static final String INSERT_DRUG_SQL = "INSERT INTO Pharmacy (drug_name, quantity) VALUES (?, ?)";
    private static final String SELECT_ALL_DRUGS = "SELECT * FROM Pharmacy";
    private static final String DELETE_DRUG_SQL = "DELETE FROM Pharmacy WHERE id = ?";
    private static final String UPDATE_DRUG_SQL = "UPDATE Pharmacy SET drug_name = ?, quantity = ? WHERE id = ?";

    // Add a new drug
    public void addDrug(Pharmacy pharmacy) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DRUG_SQL)) {
            preparedStatement.setString(1, pharmacy.getDrugName());
            preparedStatement.setInt(2, pharmacy.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Get all drugs
    public List<Pharmacy> getAllDrugs() {
        List<Pharmacy> drugs = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DRUGS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String drugName = rs.getString("drug_name");
                int quantity = rs.getInt("quantity");
                drugs.add(new Pharmacy(id, drugName, quantity));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return drugs;
    }

    // Update drug details
    public void updateDrug(Pharmacy pharmacy) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DRUG_SQL)) {
            preparedStatement.setString(1, pharmacy.getDrugName());
            preparedStatement.setInt(2, pharmacy.getQuantity());
            preparedStatement.setInt(3, pharmacy.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    // Delete a drug
    public void deleteDrug(int id) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DRUG_SQL)) {
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
