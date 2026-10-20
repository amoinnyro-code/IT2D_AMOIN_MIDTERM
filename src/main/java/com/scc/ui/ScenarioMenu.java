package com.scc.ui;

import com.scc.dao.ScenarioDao;
import com.scc.model.ScenarioEntity;

import java.util.List;
import java.util.Scanner;

public class ScenarioMenu {
    private final Scanner scanner;
    private final ScenarioDao scenarioDao;

    public ScenarioMenu() {
        this.scanner = new Scanner(System.in);
        this.scenarioDao = new ScenarioDao();
    }

    public void displayMenuHeader() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("             CAR RENTAL FLEET TRACKER             ");
        System.out.println("--------------------------------------------------");
        System.out.println("[1] Add New Vehicle");
        System.out.println("[2] View Fleet Vehicles");
        System.out.println("[3] Exit System");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter choice: ");
    }

    public int getChoice() {
        if (scanner.hasNextInt()) {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear newline buffer
            return choice;
        } else {
            scanner.nextLine(); // Clear invalid input
            return -1;
        }
    }

    public void addRecord() {
        System.out.println("\n--- ADD NEW VEHICLE ---");

        System.out.print("Enter Model Name: ");
        String modelName = scanner.nextLine();

        System.out.print("Enter License Plate Number: ");
        String plateNo = scanner.nextLine();

        double dailyRate = 0.0;
        while (true) {
            System.out.print("Enter Daily Rate: ");
            if (scanner.hasNextDouble()) {
                dailyRate = scanner.nextDouble();
                scanner.nextLine(); // Clear leftover newline
                break;
            } else {
                System.out.println("Invalid amount. Please enter a valid number.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter Status (AVAILABLE / RENTED): ");
        String status = scanner.nextLine().trim().toUpperCase();

        ScenarioEntity newEntity = new ScenarioEntity(modelName, plateNo, dailyRate, status);
        scenarioDao.addRecord(newEntity);

        System.out.println("\nSUCCESS: Vehicle registered to fleet!");
    }

    public void viewRecords() {
        List<ScenarioEntity> entities = scenarioDao.getAllRecords();

        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("                              RENTAL FLEET VEHICLES                             ");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("+-----+--------------------+--------------+--------------+------------------+");
        System.out.println("| ID  | MODEL NAME         | PLATE NO     | DAILY RATE   | STATUS           |");
        System.out.println("+-----+--------------------+--------------+--------------+------------------+");

        for (ScenarioEntity e : entities) {
            System.out.printf("| %-3d | %-18s | %-12s | %-12.2f | %-16s |\n",
                    e.getId(),
                    e.getModelName(),
                    e.getPlateNo(),
                    e.getDailyRate(),
                    e.getStatus()
            );
        }

        System.out.println("+-----+--------------------+--------------+--------------+------------------+");
        System.out.println("Total Records Displayed: " + entities.size());
        System.out.println("--------------------------------------------------------------------------------\n");
    }
}