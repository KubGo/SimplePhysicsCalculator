package com.kubgo.simplephysicscalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Velocity;

public class VelocityCalculationsController {

    @FXML
    private Label velocity_lbl;
    @FXML
    private TextField distance_fld;
    @FXML
    private TextField time_fld;
    @FXML
    private Label time_err;
    @FXML
    private TextField acceleration_fld;
    @FXML
    private Button velocity_btn;
    @FXML
    private Label acceleration_err;
    @FXML
    private Label distance_err;


    private final Velocity velocity = new Velocity(0, 0, 0);

    @FXML
    protected void onVelocityButton(){
        if (checkAllFields()){
            double distance = Double.parseDouble(distance_fld.getText());
            double time = Double.parseDouble(time_fld.getText());
            String acceleration_text = acceleration_fld.getText();
            double acceleration = (acceleration_text.isEmpty()) ? 0.0 : Double.parseDouble(acceleration_text);
            velocity.setAllValues(distance, time, acceleration);
            double result = velocity.calculateVelocity();
            velocity_lbl.setText("%.3f".formatted(result));
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
        String acceleration_fldText = acceleration_fld.getText();
        if (!checkText(acceleration_fldText, false)){
            acceleration_err.setVisible(true);
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
        acceleration_err.setVisible(false);
    }
}
