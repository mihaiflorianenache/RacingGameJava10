package org.fasttrackit.cheater;

import org.fasttrackit.Vehicle;

public class UFO extends Vehicle {

    @Override
    public double accelerate(double speed, double durationInHours) {
        System.out.println("Accelerating as UFO");
        System.out.println(getName() + " accelerated with " + speed +
                " km/h for " + durationInHours + " hours.");

        double traveledDistance = 2 * speed * durationInHours;
        System.out.println("Traveled distance: " + traveledDistance + " km.");
        return traveledDistance;
    }

    public void concealCheating() {
        System.out.println("I'm not cheating!");
    }

    @Override
    public UFO clone() {
        return new UFO();
    }
}