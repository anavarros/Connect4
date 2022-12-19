module com.aetxabao.connect4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.anavarros.connect4 to javafx.fxml;
    exports com.anavarros.connect4;
}