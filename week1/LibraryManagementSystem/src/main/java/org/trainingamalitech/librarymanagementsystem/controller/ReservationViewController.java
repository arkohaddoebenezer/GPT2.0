package org.trainingamalitech.librarymanagementsystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.services.ReservationService;
import org.trainingamalitech.librarymanagementsystem.model.Reservation;

import java.sql.Date;

public class ReservationViewController {

    @FXML private TextField resourceTypeField;
    @FXML private TextField resourceIdField;
    @FXML private TextField patronIdField;
    @FXML private TextField reservationDateField;

    @FXML private TableView<Reservation> reservationTable;
    @FXML private TableColumn<Reservation, String> reservationIdColumn;
    @FXML private TableColumn<Reservation, String> resourceIdColumn;
    @FXML private TableColumn<Reservation, String> resourceTypeColumn;
    @FXML private TableColumn<Reservation, String> patronIdColumn;
    @FXML private TableColumn<Reservation, Date> reservationDateColumn;

    private ReservationService reservationService;

    @FXML
    public void initialize() {
        reservationService = new ReservationService();
        reservationIdColumn.setCellValueFactory(new PropertyValueFactory<>("reservationId"));
        resourceIdColumn.setCellValueFactory(new PropertyValueFactory<>("resourceId"));
        resourceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("resourceType"));
        patronIdColumn.setCellValueFactory(new PropertyValueFactory<>("patronId"));
        reservationDateColumn.setCellValueFactory(new PropertyValueFactory<>("reservationDate"));

        loadReservations();
    }

    @FXML
    private void handleAddReservation() {
        String resourceId = resourceIdField.getText();
        String resourceType = resourceTypeField.getText();
        String patronId = patronIdField.getText();
        String reservationDate = reservationDateField.getText();
        Reservation reservation = new Reservation(resourceId,resourceType,patronId, reservationDate);
        reservationService.addReservation(reservation);
        loadReservations();
    }
    public void handleUpdateReservation(ActionEvent actionEvent) {
        String resourceId = resourceIdField.getText();
        String resourceType = resourceTypeField.getText();
        String patronId = patronIdField.getText();
        String reservationDate = reservationDateField.getText();
        Reservation reservation = new Reservation(resourceId,resourceType,patronId, reservationDate);
        loadReservations();
    }

    private void loadReservations() {
        reservationTable.getItems().setAll(reservationService.getAllReservations());
    }


}
