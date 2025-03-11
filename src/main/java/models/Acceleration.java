package models;

public class Acceleration {
    private double distance;
    private double time;
    private double initialVelocity;
    private double acceleration;

    public Acceleration(double distance, double time, double velocity) {
        this.distance = distance;
        this.time = time;
        this.initialVelocity = velocity;
    }

    public Acceleration(double distance, double time) {
        this(distance, time, 0);
    }

    public Acceleration() {
        this(0,0,0);
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public double getAcceleration() {
        return acceleration;
    }
    public void setAllValues(double distance, double time, double initialVelocity){
        setDistance(distance);
        setTime(time);
        setInitialVelocity(initialVelocity);
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public double calculateAcceleration(){
        acceleration = 2 * (distance - initialVelocity * time) / time / time;
        return acceleration;
    }
}
