package org.trainingamalitech.librarymanagementsystem.controller.views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.services.PatronService;
import org.trainingamalitech.librarymanagementsystem.model.Patron;

public class PatronViewController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneNumberField;

    @FXML
    private TableView<Patron> patronTable;
    @FXML
    private TableColumn<Patron, String> idColumn;
    @FXML
    private TableColumn<Patron, String> nameColumn;
    @FXML
    private TableColumn<Patron, String> addressColumn;
    @FXML
    private TableColumn<Patron, String> phoneNumberColumn;

    private PatronService patronService;

    @FXML
    public void initialize() {
        patronService = new PatronService();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        loadPatrons();
    }

    @FXML
    private void handleAddPatron() {
        String id = idField.getText();
        String name = nameField.getText();
        String address = addressField.getText();
        String phoneNumber = phoneNumberField.getText();

        Patron patron = new Patron(id, name, address, phoneNumber);
        patronService.addPatron(patron);

        loadPatrons();
    }

    private void loadPatrons() {
        patronTable.getItems().setAll(patronService.getAllPatrons());
    }
}
