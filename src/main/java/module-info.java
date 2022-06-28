module com.project.project2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;


    opens com.project.project2 to javafx.fxml;
    exports com.project.project2;
}