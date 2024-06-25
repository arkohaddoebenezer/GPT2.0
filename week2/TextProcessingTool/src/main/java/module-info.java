module org.trainingamalitech.textprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.trainingamalitech.textprocessingtool to javafx.fxml;
    exports org.trainingamalitech.textprocessingtool;
}