package models;

public class Velocity {
    private double distance;
    private double time;
    private double acceleration;
    private double velocity;

    public Velocity(double distance, double time, double acceleration) {
        this.distance = distance;
        this.time = time;
        this.acceleration = acceleration;
    }

    public Velocity(double distance, double time) {
        this(distance, time, 0);
    }

    public Velocity() {
        this(0, 0, 0);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }
    public double calculateVelocity(){
        velocity = acceleration * time * time + distance / time;
        return velocity;
    }
}
