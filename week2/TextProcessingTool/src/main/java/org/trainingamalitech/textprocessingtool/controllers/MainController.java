package org.trainingamalitech.textprocessingtool.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;

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
    private TextFlow resultFlow;
    @FXML
    private Label statusLabel;
    @FXML
    private CheckBox matchCase;

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

        resultFlow.getChildren().clear();

        while (m.find()) {
            resultFlow.getChildren().add(new Text("Match: " + m.group() + " at position: " + m.start() + "\n"));
        }

        statusLabel.setText("Pattern tested.");
    }

    @FXML
    private void handleSearch() {
        String pattern = regexField.getText();
        String text = textArea.getText();
        if(!matchCase.isSelected()){
            pattern = pattern.toLowerCase();
            text = text.toLowerCase();
        }
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        resultFlow.getChildren().clear();
        
        int lastEnd = 0;
        while (m.find()) {
            
            if (m.start() > lastEnd) {
                Text nonMatchText = new Text(text.substring(lastEnd, m.start()));
                resultFlow.getChildren().add(nonMatchText);
            }
            
            Text matchText = new Text(m.group());

            matchText.setFill(Color.RED);
            resultFlow.getChildren().add(matchText);
            lastEnd = m.end();
        }
        
        // Add remaining text after the last match
        if (lastEnd < text.length()) {
            Text remainingText = new Text(text.substring(lastEnd));
            resultFlow.getChildren().add(remainingText);
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
}
