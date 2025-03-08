module com.kubgo.simplephysicscalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.kubgo.simplephysicscalculator to javafx.fxml;
    exports com.kubgo.simplephysicscalculator;
}