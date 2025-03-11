package models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VelocityTest {

    @Test
    void calculateVelocity() {
        Velocity velocity = new Velocity(10, 2);
        Assertions.assertEquals(5.0,velocity.calculateVelocity(), 0.01);
    }
    @Test
    void calculateVelocityWithAcceleration(){
        Velocity velocity = new Velocity(10, 2, 1);
        Assertions.assertEquals(6, velocity.calculateVelocity(), 0.01);
    }
}