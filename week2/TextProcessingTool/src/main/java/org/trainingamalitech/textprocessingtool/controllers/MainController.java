package org.trainingamalitech.textprocessingtool.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {


        @FXML
        private TextArea textArea;
        @FXML
        private TextField regexField;
        @FXML
        private TextField replaceField;
        @FXML
        private TextArea resultArea;
        @FXML
        private Label statusLabel;

        private File currentFile;

        // File Menu Handlers
        @FXML
        private void handleOpen() {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                try {
                    String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
                    textArea.setText(content);
                    statusLabel.setText("File opened: " + file.getName());
                    currentFile = file;
                } catch (Exception e) {
                    statusLabel.setText("Failed to open file.");
                    e.printStackTrace();
                }
            }
        }

        @FXML
        private void handleSave() {
            if (currentFile != null) {
                try {
                    Files.write(Paths.get(currentFile.getPath()), textArea.getText().getBytes());
                    statusLabel.setText("File saved: " + currentFile.getName());
                } catch (Exception e) {
                    statusLabel.setText("Failed to save file.");
                    e.printStackTrace();
                }
            } else {
                handleSaveAs();
            }
        }

        @FXML
        private void handleSaveAs() {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                try {
                    Files.write(Paths.get(file.getPath()), textArea.getText().getBytes());
                    statusLabel.setText("File saved: " + file.getName());
                    currentFile = file;
                } catch (Exception e) {
                    statusLabel.setText("Failed to save file.");
                    e.printStackTrace();
                }
            }
        }

        @FXML
        private void handleExit() {
            System.exit(0);
        }

        // Edit Menu Handlers
        @FXML
        private void handleUndo() {
            textArea.undo();
        }

        @FXML
        private void handleRedo() {
            textArea.redo();
        }

        @FXML
        private void handleCut() {
            textArea.cut();
        }

        @FXML
        private void handleCopy() {
            textArea.copy();
        }

        @FXML
        private void handlePaste() {
            textArea.paste();
        }

        // Regex Menu Handlers
        @FXML
        private void handleInsertPattern() {
            textArea.insertText(textArea.getCaretPosition(), regexField.getText());
        }

        @FXML
        private void handleTestPattern() {
            String pattern = regexField.getText();
            String text = textArea.getText();

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);

            resultArea.clear();
            while (m.find()) {
                resultArea.appendText("Match: " + m.group() + " at position: " + m.start() + "\n");
            }

            statusLabel.setText("Pattern tested.");
        }

        @FXML
        private void handleFind() {
            String pattern = regexField.getText();
            String text = textArea.getText();

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);

            resultArea.clear();
            while (m.find()) {
                resultArea.appendText("Match: " + m.group() + " at position: " + m.start() + "\n");
            }

            statusLabel.setText("Find operation completed.");
        }

        @FXML
        private void handleReplace() {
            String pattern = regexField.getText();
            String replacement = replaceField.getText();
            String text = textArea.getText();

            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(text);

            String result = m.replaceAll(replacement);
            textArea.setText(result);

            statusLabel.setText("Replace operation completed.");
        }

        @FXML
        private void handleAbout() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText(null);
            alert.setContentText("Text Processing Tool\nVersion 1.0");
            alert.showAndWait();
        }

        @FXML
        private void handleHelp() {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Help");
            alert.setHeaderText(null);
            alert.setContentText("Help content goes here.");
            alert.showAndWait();
        }

        @FXML
        private void handleManageData() {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/textprocessingtool/textprocessingtool/DataManagementLayout.fxml"));
                VBox root = fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Data Management");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}