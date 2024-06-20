package org.trainingamalitech.librarymanagementsystem.controller.views;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.trainingamalitech.librarymanagementsystem.controller.PatronController;
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

    private PatronController patronController;

    @FXML
    public void initialize() {
        patronController = new PatronController();

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
        patronController.addPatron(patron);

        loadPatrons();
    }

    private void loadPatrons() {
        patronTable.getItems().setAll(patronController.getAllPatrons());
    }
}
