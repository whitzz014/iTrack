module com.example.itrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.itrack to javafx.fxml;
    exports com.example.itrack;
}