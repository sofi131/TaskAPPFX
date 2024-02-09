module com.ceica.taskappfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ceica.taskappfx to javafx.fxml;
    exports com.ceica.taskappfx;
}