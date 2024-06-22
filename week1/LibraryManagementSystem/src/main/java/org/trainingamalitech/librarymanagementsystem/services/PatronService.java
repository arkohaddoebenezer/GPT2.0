package org.trainingamalitech.librarymanagementsystem.controller;

import org.trainingamalitech.librarymanagementsystem.model.Patron;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatronController {

    // Method to add a new patron
    public void addPatron(Patron patron) {
        String sql = "INSERT INTO Patron (id, name, address, phoneNumber) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patron.getId());
            statement.setString(2, patron.getName());
            statement.setString(3, patron.getAddress());
            statement.setString(4, patron.getPhoneNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a list of all patrons
    public List<Patron> getAllPatrons() {
        List<Patron> patrons = new ArrayList<>();
        String sql = "SELECT * FROM Patron";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Patron patron = new Patron();
                patron.setId(resultSet.getString("id"));
                patron.setName(resultSet.getString("name"));
                patron.setAddress(resultSet.getString("address"));
                patron.setPhoneNumber(resultSet.getString("phoneNumber"));

                patrons.add(patron);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patrons;
    }

    // Method to update a patron's information
    public void updatePatron(Patron patron) {
        String sql = "UPDATE Patron SET name = ?, address = ?, phoneNumber = ? WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, patron.getName());
            statement.setString(2, patron.getAddress());
            statement.setString(3, patron.getPhoneNumber());
            statement.setString(4, patron.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a patron
    public void deletePatron(String id) {
        String sql = "DELETE FROM Patron WHERE id = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
