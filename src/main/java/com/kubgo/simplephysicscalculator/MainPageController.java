package com.kubgo.simplephysicscalculator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("velocity-calculator.fxml"));
        VBox calculator = loader.load();
        mainPane.getChildren().add(calculator);
        StackPane.setAlignment(calculator, Pos.TOP_CENTER);
        VelocityCalculationsController controller = loader.getController();
        controller.removeErrors();
    }

    @FXML void onVelocityButton(){
        System.out.println("Dupa");
    }

}
