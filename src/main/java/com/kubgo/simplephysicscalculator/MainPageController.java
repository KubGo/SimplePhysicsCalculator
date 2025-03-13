package com.kubgo.simplephysicscalculator;

import com.kubgo.simplephysicscalculator.controllerUtils.ErrorThrowingControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class MainPageController {

    @FXML
    private Button velocity_calculator_btn;
    @FXML
    private Button acceleration_calculator_btn;
    @FXML
    private StackPane mainPane;
    @FXML
    private Label calculator_name_lbl;

    @FXML
    public void setVelocity_calculator_pane() throws IOException {
        calculator_name_lbl.setText("Velocity calculator");
        set_calculator("velocity-calculator.fxml");
    }



    @FXML
    public void setAcceleration_calculator_pane() throws IOException {
        calculator_name_lbl.setText("Acceleration calculator");
        set_calculator("acceleration-calculator.fxml");
    }

    private void set_calculator(String resource_name) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource_name));
        VBox calculator = loader.load();
        if (!mainPane.getChildren().isEmpty()){
            mainPane.getChildren().removeLast();
        }
        mainPane.getChildren().add(calculator);
        StackPane.setAlignment(calculator, Pos.TOP_CENTER);
        ErrorThrowingControllerInterface controller = loader.getController();
        controller.removeErrors();
    }

}
