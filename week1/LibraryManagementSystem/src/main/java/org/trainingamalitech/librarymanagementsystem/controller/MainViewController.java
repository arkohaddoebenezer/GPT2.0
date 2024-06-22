package org.trainingamalitech.librarymanagementsystem.controller.views;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import org.trainingamalitech.librarymanagementsystem.LibraryManagementSystem;

import java.util.Objects;

public class MainViewController {

    @FXML
    private void handleManageBooks(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LibraryManagementSystem.class.getResource("book-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Books");
        stage.show();
    }

    @FXML
    private void handleManagePatrons(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LibraryManagementSystem.class.getResource("patron-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Patrons");
        stage.show();
    }

    @FXML
    private void handleManageTransactions(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LibraryManagementSystem.class.getResource("transaction-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Transactions");
        stage.show();
    }

    @FXML
    private void handleManageReservations(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(LibraryManagementSystem.class.getResource("reservation-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Manage Reservations");
        stage.show();
    }
}
