module com.thrya.kantorkeuangan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.thrya.kantorkeuangan to javafx.fxml;
    exports com.thrya.kantorkeuangan;
}