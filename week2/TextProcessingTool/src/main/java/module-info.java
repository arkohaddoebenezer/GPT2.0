module org.trainingamalitech.textprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.trainingamalitech.textprocessingtool to javafx.fxml;
    exports org.trainingamalitech.textprocessingtool;
    exports org.trainingamalitech.textprocessingtool.controllers;
    opens org.trainingamalitech.textprocessingtool.controllers to javafx.fxml;
}