package org.trainingamalitech.textprocessingtool;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.trainingamalitech.textprocessingtool.controllers.MainController;

import java.io.IOException;

public class TextProcessingTool extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TextProcessingTool.class.getResource("MainLayout.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Text Processing Tool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}