package com.kubgo.simplephysicscalculator;

import com.kubgo.simplephysicscalculator.controllerUtils.ErrorThrowingControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import models.Acceleration;
import net.synedra.validatorfx.Validator;

import java.net.URL;
import java.util.ResourceBundle;

public class AccelerationCalculatorController implements ErrorThrowingControllerInterface, Initializable {
    @FXML
    private TextField distance_fld;
    @FXML
    private TextField time_fld;
    @FXML
    private TextField initial_velocity_fld;
    @FXML
    private Label acceleration_lbl;
    @FXML
    private Label initial_velocity_err;
    @FXML
    private Label time_err;
    @FXML
    private Label distance_err;
    @FXML
    private Button acceleration_btn;

    private Validator validator = new Validator();

    private Acceleration acceleration = new Acceleration();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validator.createCheck()
                .dependsOn("distance", distance_fld.textProperty())
                . withMethod(c -> {
                    String value = c.get("distance");
                    if (!isNumeric(value) && !value.isEmpty()){
                        c.error("Please enter numeric value");
                    }
                })
                .decorates(distance_fld)
                .immediate();

        validator.createCheck()
                .dependsOn("time", time_fld.textProperty())
                .withMethod(c -> {
                    String value = c.get("time");
                    if (!isNumeric(value) && !value.isEmpty()){
                        c.error("Time must be numeric value");
                        } else if (Double.parseDouble(value) < 0) {
                        c.error("Time must be positive number");
                    }
                })
                .decorates(time_fld)
                .immediate();
    }

    public static boolean isNumeric(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    @FXML
    protected void onAccelerationButton(){
        if (checkAllFields()){
            double distance = Double.parseDouble(distance_fld.getText());
            double time = Double.parseDouble(time_fld.getText());
            String initial_velocity_text = initial_velocity_fld.getText();
            double initial_velocity = (initial_velocity_text.isEmpty()) ? 0 : Double.parseDouble(initial_velocity_text);
            acceleration.setAllValues(distance, time, initial_velocity);
            double result = acceleration.calculateAcceleration();
            acceleration_lbl.setText("%.3f".formatted(result));
        }
    }

    private Boolean checkText(String text, Boolean isRequired){
        if (text == null || text.isEmpty()){
            return !isRequired;
        }
        try {
            double d = Double.parseDouble(text);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    private boolean checkAllFields(){
        String distance_fldText = distance_fld.getText();
        if (!checkText(distance_fldText, true)){
            distance_err.setVisible(true);
            return false;
        }
        String acceleration_fldText = initial_velocity_fld.getText();
        if (!checkText(acceleration_fldText, false)){
            initial_velocity_err.setVisible(true);
            return false;
        }
        String time_fldText = time_fld.getText();
        if (!checkText(time_fldText, true)){
            time_err.setVisible(true);
        }
        double time = Double.parseDouble(time_fldText);
        if (time <=0.0){
            time_err.setVisible(true);
            return false;
        }
        removeErrors();
        return true;
    }
    public void removeErrors(){
        time_err.setVisible(false);
        distance_err.setVisible(false);
        initial_velocity_err.setVisible(false);
    }
}
