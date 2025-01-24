package busreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {
    private int busNumber;          // Selected bus number by the user
    private String passengerName;   // Name of the passenger
    private boolean acPreference;   // AC preference of the passenger
    private String date;            // Travel date
    private String busOwner;        // Bus owner's name

    // Constructor to initialize the booking
    public Booking() {
        Scanner scan = new Scanner(System.in);

        // Get AC preference and validate input
        while (true) {
            System.out.print("❓ Do you want an AC bus? (true/false): ");
            try {
                this.acPreference = scan.nextBoolean();
                scan.nextLine();  // Consume the newline character after the boolean input
                break;  // Exit loop if input is valid
            } catch (Exception e) {
                System.out.println("⚠️ Invalid input! Please enter 'true' for AC or 'false' for non-AC.");
                scan.nextLine();  // Consume the invalid input
            }
        }

        // Get passenger name with proper input handling (separate line input)
        System.out.print("🧍 Enter Passenger Name: ");
        this.passengerName = scan.nextLine();  // nextLine() is used to handle the full name input

        // Get bus number (ensure it is entered on a separate line)
        System.out.print("🚌 Enter Bus Number: ");
        while (!scan.hasNextInt()) {
            System.out.println("❌ Invalid bus number! Please enter a valid number.");
            scan.nextLine(); // Consume the invalid input
        }
        this.busNumber = scan.nextInt();
        scan.nextLine(); // Consume newline after the bus number input

        // Get travel date and validate
        System.out.print("📅 Enter Travel Date (YYYY-MM-DD): ");
        this.date = scan.nextLine();

        // Get bus owner and validate
        System.out.print("👤 Enter Bus Owner's Name: ");
        this.busOwner = scan.nextLine();
    }

    // Method to check bus availability and validate user inputs
    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        for (Bus bus : buses) {
            // Step 1: Validate Bus Number
            if (bus.getBusNumber() == busNumber) {

                // Step 2: Validate Bus Owner
                if (!bus.getOwner().equalsIgnoreCase(busOwner)) {
                    System.out.println("❌ Invalid owner details! Please contact the correct bus owner.");
                    return false;  // Stop booking process
                }

                // Step 3: Validate AC preference
                if (bus.isAc() != acPreference) {
                    System.out.println("⚠️ Sorry, we only have AC buses available. Please book accordingly.");
                    return false;  // Stop booking process
                }

                // Step 4: Validate Date Availability
                if (!bus.getDate().equals(date)) {
                    System.out.println("❌ No buses available on the selected date. Please choose another date.");
                    return false;  // Stop booking process
                }

                // Step 5: Validate Seat Availability
                if (bus.getCapacity() > 0) {
                    bus.setCapacity(bus.getCapacity() - 1);  // Reduce seat count
                    System.out.println("🎉 Seat successfully booked for " + passengerName + " on " + date + "!");
                    return true;  // Proceed with booking
                } else {
                    System.out.println("⚠️ Sorry, no seats available on this bus! 🪑");
                    return false;  // Stop booking process
                }
            }
        }
        // If bus number doesn't match any bus
        System.out.println("❌ Invalid bus number! Please try again.");
        return false;  // Stop booking process
    }
}
