module com.example.demo {

    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}