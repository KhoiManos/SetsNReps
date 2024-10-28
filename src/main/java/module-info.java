module com.example.setsnreps {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;

    opens io.github.khoimanos to javafx.fxml;
    exports io.github.khoimanos;
}