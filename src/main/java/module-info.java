module com.unasat.ihateschool4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;


    opens com.unasat.ihateschool4 to javafx.fxml;
    exports com.unasat.ihateschool4;
}