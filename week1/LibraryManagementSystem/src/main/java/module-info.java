module org.trainingamalitech.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;


    opens org.trainingamalitech.librarymanagementsystem to javafx.fxml;
    exports org.trainingamalitech.librarymanagementsystem;
    exports org.trainingamalitech.librarymanagementsystem.controller;
    opens org.trainingamalitech.librarymanagementsystem.controller to javafx.fxml;
}