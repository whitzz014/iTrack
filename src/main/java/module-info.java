module com.example.itrack {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.itrack to javafx.fxml;
    exports com.example.itrack;
}