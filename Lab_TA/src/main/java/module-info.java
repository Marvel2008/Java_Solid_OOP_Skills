module com.lab.lab_ta {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.xml;

    opens com.lab.lab_ta to javafx.fxml;
    exports com.lab.lab_ta;
}