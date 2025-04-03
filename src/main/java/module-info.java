module com.unasat.ihateschool4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.unasat.ihateschool4 to javafx.fxml;
    exports com.unasat.ihateschool4;
}