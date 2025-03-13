package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccelerationTest {

    @Test
    void calculateAccelerationWithoutInitialVelocity() {
        Acceleration acceleration = new Acceleration(10, 2);
        Assertions.assertEquals(5, acceleration.calculateAcceleration());
    }
    @Test
    void calculateAcceleration(){
        Acceleration acceleration = new Acceleration(10, 2, 4);
        Assertions.assertEquals(1, acceleration.calculateAcceleration());
    }
}