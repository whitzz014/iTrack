module com.example.itrack {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;



    opens com.example.itrack to javafx.fxml;
    exports com.example.itrack;
    exports com.example.itrack.Pojo;
    opens com.example.itrack.Pojo to javafx.fxml;
    exports com.example.itrack.Tables;
    opens com.example.itrack.Tables to javafx.fxml;
    //exports com.example.itrack.DAO;
     //opens com.example.itrack.DAO to javafx.fxml;
}