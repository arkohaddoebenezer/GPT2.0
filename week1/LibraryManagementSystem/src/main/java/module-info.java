module org.trainingamalitech.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;

    opens org.trainingamalitech.librarymanagementsystem to javafx.fxml;
    exports org.trainingamalitech.librarymanagementsystem;
    exports org.trainingamalitech.librarymanagementsystem.controllers;
    opens org.trainingamalitech.librarymanagementsystem.controllers to javafx.fxml;
    exports org.trainingamalitech.librarymanagementsystem.services;
    opens org.trainingamalitech.librarymanagementsystem.services to javafx.fxml;
}
