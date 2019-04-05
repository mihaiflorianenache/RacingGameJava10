package org.fasttrackit;

import org.fasttrackit.Domain.TopWinner;
import org.fasttrackit.Service.TopWinnerService;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private TopWinnerService topWinnerService = new TopWinnerService();
    private Track[] tracks = new Track[10];
    private List<Vehicle> competitors = new ArrayList<>();

    public void start() throws Exception {
        addCompetitors(getCompetitorCountFromUser());
        displayCompetitors();
        addTracks();
        displayAvailableTracks();
        int numberFromUser = getTrackNumberFromUser();

        Track track = tracks[numberFromUser - 1];
        System.out.println("Selected track: " + track.getName());
        boolean noWinnerYet = true;
        int competitorsWithoutFuel = 0;

        while (noWinnerYet && competitorsWithoutFuel < competitors.size()) {
            for (Vehicle vehicle : competitors) {
                double speed = getAccelerationSpeedFromUser();
                vehicle.accelerate(speed);

                if (vehicle.getFuelLevel() <= 0) {
                    competitorsWithoutFuel++;
                }

                if (vehicle.getTotalTraveledDistance() >= track.getLength()) {
                    System.out.println("Congrats! The winner is " + vehicle.getName());

                    TopWinner topWinner = new TopWinner();
                    topWinner.setName(vehicle.getName());
                    topWinner.setWonRaces(1);
                    topWinnerService.createTopWinner(topWinner);
                    noWinnerYet = false;
                    break;
                }
            }
        }
    }

    private int getTrackNumberFromUser() {
        System.out.println("Give number between 1 and "+competitors.size());
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println("Please re-enter");
            return getTrackNumberFromUser();
        }
    }

    private double getAccelerationSpeedFromUser() {
        System.out.println("Please enter acceleration speed:");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid decimal number.");
            return getAccelerationSpeedFromUser();
        }
    }

    private void addCompetitors(int competitorCount) {
        for (int i = 0; i < competitorCount; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setName(getVehicleNameFromUser());
            vehicle.setFuelLevel(80);
            vehicle.setMileage(
                    ThreadLocalRandom.current().nextDouble(5, 15)
            );

            System.out.println("Vehicle mileage: " + vehicle.getMileage());
            competitors.add(vehicle);
        }
    }

    private String getVehicleNameFromUser() {
        System.out.println("Please enter a vehicle name:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Your vehicle name is: " + name);
        return name;
    }

    private int getCompetitorCountFromUser() {
        System.out.println("Please enter number of players:");
        Scanner scanner = new Scanner(System.in);
        try {
            int numberOfPlayers = scanner.nextInt();
            if(numberOfPlayers<1) return getCompetitorCountFromUser();
            System.out.println("Selected number of players: " + numberOfPlayers);
            return numberOfPlayers;
        } catch (InputMismatchException exception) {
            System.out.println("Please enter a valid integer.");
            return getCompetitorCountFromUser();
        }
    }

    private void displayCompetitors() {
        System.out.println("Welcome! Today's competitors are:");
        for (int i = 0; i < competitors.size(); i++) {
            System.out.println(competitors.get(i).getName());
        }
    }

    private void addTracks() {
        Track track1 = new Track("Highway", 300);
        Track track2 = new Track("Seaside", 100);

        tracks[0] = track1;
        tracks[1] = track2;
    }

    private void displayAvailableTracks() {
        System.out.println("Available tracks:");

        for (Track track : tracks) {
            if (track != null) {
                System.out.println(track.getName());
            }
        }
    }
}
