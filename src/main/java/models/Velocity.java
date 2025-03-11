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
    public void setAllValues(double distance, double time, double acceleration){
        setDistance(distance);
        setAcceleration(acceleration);
        setTime(time);
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double calculateVelocity(){
        double initial_velocity = (distance - 0.5 * acceleration * time * time) / time;
        velocity = initial_velocity + acceleration * time;
        setVelocity(velocity);
        return velocity;
    }
}
