package org.trainingamalitech.librarymanagementsystem.controller.views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.services.ReservationController;
import org.trainingamalitech.librarymanagementsystem.model.Reservation;

import java.sql.Date;

public class ReservationViewController {

    @FXML private TextField reservationIdField;
    @FXML private TextField bookIsbnField;
    @FXML private TextField patronIdField;
    @FXML private TextField reservationDateField;

    @FXML private TableView<Reservation> reservationTable;
    @FXML private TableColumn<Reservation, String> reservationIdColumn;
    @FXML private TableColumn<Reservation, String> bookIsbnColumn;
    @FXML private TableColumn<Reservation, String> patronIdColumn;
    @FXML private TableColumn<Reservation, Date> reservationDateColumn;

    private ReservationController reservationController;

    @FXML
    public void initialize() {
        reservationController = new ReservationController();

        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        bookIsbnColumn.setCellValueFactory(new PropertyValueFactory<>("bookIsbn"));
        patronIdColumn.setCellValueFactory(new PropertyValueFactory<>("patronId"));
        reservationDateColumn.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));

        loadReservations();
    }

    @FXML
    private void handleAddReservation() {
        String reservationId = reservationIdField.getText();
        String bookIsbn = bookIsbnField.getText();
        String patronId = patronIdField.getText();
        Date reservationDate = Date.valueOf(reservationDateField.getText());

        Reservation reservation = new Reservation(reservationId, bookIsbn, patronId, reservationDate);
        reservationController.addReservation(reservation);

        loadReservations();
    }

    private void loadReservations() {
        reservationTable.getItems().setAll(reservationController.getAllReservations());
    }
}