package org.trainingamalitech.textprocessingtool.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import org.trainingamalitech.textprocessingtool.models.Data;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DataManagementController {
    @FXML
    private ListView<Data> listView;
    @FXML
    private Button addEntryButton;
    @FXML
    private Button updateEntryButton;
    @FXML
    private Button deleteEntryButton;

    private ObservableList<Data> dataList;
    private Set<Data> dataSet;

    @FXML
    public void initialize() {
        dataList = FXCollections.observableArrayList();
        dataSet = new HashSet<>();
        listView.setItems(dataList);
    }

    @FXML
    private void handleAddEntry() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Entry");
        dialog.setHeaderText("Add new data entry");
        dialog.setContentText("Please enter data:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(data -> {
            Data newData = new Data(data);
            if (dataSet.add(newData)) {
                dataList.add(newData);
            } else {
                showAlert("Duplicate Entry", "Data entry already exists.");
            }
        });
    }

    @FXML
    private void handleUpdateEntry() {
        Data selectedData = listView.getSelectionModel().getSelectedItem();
        if (selectedData != null) {
            TextInputDialog dialog = new TextInputDialog(selectedData.getData());
            dialog.setTitle("Update Entry");
            dialog.setHeaderText("Update selected data entry");
            dialog.setContentText("Please enter new data:");

            dialog.showAndWait().ifPresent(newData -> {
                dataSet.remove(selectedData);
                selectedData.setData(newData);
                dataSet.add(selectedData);
                listView.refresh();
            });
        } else {
            showAlert("No Selection", "Please select a data entry to update.");
        }
    }

    @FXML
    private void handleDeleteEntry() {
        Data selectedData = listView.getSelectionModel().getSelectedItem();
        if (selectedData != null) {
            dataSet.remove(selectedData);
            dataList.remove(selectedData);
        } else {
            showAlert("No Selection", "Please select a data entry to delete.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
