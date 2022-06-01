module com.example.registrationappwithspring {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.registrationappwithspring to javafx.fxml;
    exports com.example.registrationappwithspring;
}