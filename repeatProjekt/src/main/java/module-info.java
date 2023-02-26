module com.example.repeatprojekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.repeatprojekt to javafx.fxml;
    exports com.example.repeatprojekt;
}