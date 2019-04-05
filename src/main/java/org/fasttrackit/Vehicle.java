package org.fasttrackit;

public class Vehicle {

    public static int vehicleCount;
    private String name;
    private String color;
    private double mileage;
    private double fuelLevel;
    private double totalTraveledDistance;

    public Vehicle() {
        vehicleCount++;
    }

    public double accelerate(double speed, double durationInHours) {
        System.out.println(name + " accelerated with " + speed + " km/h for " + durationInHours + " hours.");

        double traveledDistance = speed * durationInHours;
        System.out.println("Traveled distance: " + traveledDistance + " km.");
        totalTraveledDistance += traveledDistance;
        System.out.println("Total traveled distance: " + totalTraveledDistance);

        double spentFuel = traveledDistance * mileage / 100;
        fuelLevel -= spentFuel;
        System.out.println("Remaining fuel: " + fuelLevel);
        return traveledDistance;
    }

    public double accelerate(double speed) {
        return accelerate(speed, 1);
    }

    protected Vehicle clone() {
        Vehicle vehicle = new Vehicle();
        return vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public double getTotalTraveledDistance() {
        return totalTraveledDistance;
    }

    public void setTotalTraveledDistance(double totalTraveledDistance) {
        this.totalTraveledDistance = totalTraveledDistance;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
