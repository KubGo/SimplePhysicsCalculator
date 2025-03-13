package com.kubgo.simplephysicscalculator;

import com.kubgo.simplephysicscalculator.controllerUtils.ErrorThrowingControllerInterface;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Acceleration;

public class AccelerationCalculatorController implements ErrorThrowingControllerInterface {
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

    private final Acceleration acceleration = new Acceleration();

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
