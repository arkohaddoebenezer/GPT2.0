package org.trainingamalitech.librarymanagementsystem.services;

import org.trainingamalitech.librarymanagementsystem.model.Reservation;
import org.trainingamalitech.librarymanagementsystem.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    // Method to add a new reservation
    public void addReservation(Reservation reservation) {
        String sql = "INSERT INTO Reservation (reservationId, bookIsbn, patronId, reservationDate) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, reservation.getReservationId());
            statement.setString(2, reservation.getBookIsbn());
            statement.setString(3, reservation.getPatronId());
            statement.setDate(4, new java.sql.Date(reservation.getReservationDate().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to get a list of all reservations
    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM Reservation";

        try (Connection connection = DatabaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(resultSet.getString("reservationId"));
                reservation.setBookIsbn(resultSet.getString("bookIsbn"));
                reservation.setPatronId(resultSet.getString("patronId"));
                reservation.setReservationDate(resultSet.getDate("reservationDate"));

                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    // Method to delete a reservation
    public void deleteReservation(String reservationId) {
        String sql = "DELETE FROM Reservation WHERE reservationId = ?";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, reservationId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
