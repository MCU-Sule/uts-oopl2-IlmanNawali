module com.example.uts_1972003 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.uts_1972003 to javafx.fxml;
    exports com.example.uts_1972003;
}