package com.scc;

import com.scc.dao.DatabaseConnection;
import com.scc.ui.ScenarioMenu;

public class Main {
    public static void main(String[] args) {
        // Initialize SQLite database table on startup
        DatabaseConnection.initializeDatabase();

        ScenarioMenu menu = new ScenarioMenu();
        boolean running = true;

        while (running) {
            menu.displayMenuHeader();
            int choice = menu.getChoice();

            switch (choice) {
                case 1:
                    menu.addRecord();
                    break;
                case 2:
                    menu.viewRecords();
                    break;
                case 3:
                    System.out.println("\nExiting system... Thank you!");
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}