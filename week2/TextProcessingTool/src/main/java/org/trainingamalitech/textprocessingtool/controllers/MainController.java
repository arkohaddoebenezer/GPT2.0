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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.trainingamalitech.textprocessingtool.controllers.modules.RegexPattern;

public class MainController {

    @FXML
    private TextArea textArea;
    @FXML
    private TextField regexField;
    @FXML
    private TextField replaceField;
    @FXML
    private TextFlow  resultFlow;
    @FXML
    private Label statusLabel;
    @FXML
    private CheckBox matchCase;

    private File currentFile;

    private List<RegexPattern> regexPatterns;

    public MainController() {
        regexPatterns = new ArrayList<>();
    }

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

    @FXML
    private void handleTestPattern() {
        String pattern = regexField.getText();
        String text = textArea.getText();


        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        resultFlow.getChildren().clear();
        int occurrence = 0;
        while (m.find()) {
            resultFlow.getChildren().add(new Text("Match: " + m.group() + " at position: " + m.start() + "\n"));
            occurrence++;

        }
        RegexPattern regexPattern = new RegexPattern(pattern);
        regexPatterns.add(regexPattern);
        statusLabel.setText("Found "+occurrence+" match(es).");
    }

    @FXML
    private void handleSavePattern() {
        String pattern = regexField.getText();
        RegexPattern regexPattern = new RegexPattern(pattern);
        if (!regexPatterns.contains(regexPattern)) {
            regexPatterns.add(regexPattern);
            statusLabel.setText("Saved Pattern.");
        } else {
            statusLabel.setText("Pattern already exists.");
        }
    }
    @FXML
    private void handleReadPatterns() {
        resultFlow.getChildren().clear();
        for (RegexPattern regexPattern : regexPatterns) {
            Text resultText = new Text(regexPattern + "\n");
            resultFlow.getChildren().add(resultText);
        }
        statusLabel.setText("History.");
    }

    @FXML
    private void handleDeletePattern() {
        String pattern = regexField.getText();
        regexPatterns.removeIf(regexPattern -> regexPattern.getPattern().equals(pattern));
        statusLabel.setText("Deleted History");
    }


    @FXML
    private void handleSearch() {
    String pattern = regexField.getText();
    String text = textArea.getText();

    if (!matchCase.isSelected()) {
        pattern = pattern.toLowerCase();
        text = text.toLowerCase();
    }

    try {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);

        resultFlow.getChildren().clear();

        int lastEnd = 0;
        int occurrence = 0;

        while (m.find()) {
            if (m.start() > lastEnd) {
                Text nonMatchText = new Text(text.substring(lastEnd, m.start()));
                resultFlow.getChildren().add(nonMatchText);
            }

            Text matchText = new Text(m.group());
            matchText.setFill(Color.RED);
            resultFlow.getChildren().add(matchText);
            lastEnd = m.end();
            occurrence += 1;
        }

        if (lastEnd < text.length()) {
            Text remainingText = new Text(text.substring(lastEnd));
            resultFlow.getChildren().add(remainingText);
        }

        statusLabel.setText("Found " + occurrence + " match(es).");

    } catch (PatternSyntaxException e) {
        statusLabel.setText("Invalid regex pattern: " + e.getDescription());
    }
}


 
    @FXML
    private void handleReplace() {
        String pattern = regexField.getText();
        String replacement = replaceField.getText();
        String text = textArea.getText();
    
        if(!matchCase.isSelected()){
            pattern = pattern.toLowerCase();
            text = text.toLowerCase();
        }
    
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(text);
    
        resultFlow.getChildren().clear();
    
        int lastEnd = 0;
        int occurrence = 0;
        StringBuilder result = new StringBuilder();
    
        while (m.find()) {
            if (m.start() > lastEnd) {
                Text nonMatchText = new Text(text.substring(lastEnd, m.start()));
                resultFlow.getChildren().add(nonMatchText);
                result.append(nonMatchText.getText());
            }
    
            Text matchText = new Text(replacement);
            matchText.setFill(Color.GREEN);
            resultFlow.getChildren().add(matchText);
            result.append(matchText.getText());
            lastEnd = m.end();
            occurrence += 1;
        }
    
        if (lastEnd < text.length()) {
            Text remainingText = new Text(text.substring(lastEnd));
            resultFlow.getChildren().add(remainingText);
            result.append(remainingText.getText());
        }
        statusLabel.setText("Replaced " + occurrence + " match(es).");
    }    

    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("Text Processor By Ebenezer Arkoh-Addo");
        alert.showAndWait();
    }

    @FXML
    private void handleHelp() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("This is a simple text processing tool that allows you to search, replace and test regular expressions.");
        alert.showAndWait();
    }
}
