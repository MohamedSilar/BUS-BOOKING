package busreservation;

import java.util.ArrayList;
import java.util.Scanner;

public class Busdemo {
    public static void main(String[] args) {
        // Initialize buses and bookings
        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int userinput = 0;

        // Main loop for user interaction
        while (true) {
            System.out.println("\n🌟 WELCOME TO BLUEBUS! 🌟");
            System.out.println("-----------------------------");
            System.out.println("1. 🚌 ADD A NEW BUS\n2. 📋 VIEW AVAILABLE BUSES\n3. 🎟️ BOOK TICKETS\n4. 🚪 EXIT");
            System.out.print("Enter your choice: ");
            userinput = scan.nextInt();

            switch (userinput) {
                case 1:
                    addBus(buses);
                    break;
                case 2:
                    displayBuses(buses);
                    break;
                case 3:
                    if (buses.isEmpty()) {
                        System.out.println("⚠️ No buses available! Please add buses first. 🚌");
                    } else {
                        Booking booking = new Booking();
                        if (booking.isAvailable(bookings, buses)) {
                            bookings.add(booking);
                            System.out.println("✅ --Your booking is Confirmed-- 🎉");
                        } else {
                            System.out.println("❌ Booking process terminated due to input errors.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("🙏 THANK YOU FOR CHOOSING BLUEBUS! HAVE A GREAT DAY! 🌟");
                    scan.close();
                    return;
                default:
                    System.out.println("❌ --You Entered an Invalid Option--");
            }
        }
    }

    // Method to add a new bus
    private static void addBus(ArrayList<Bus> buses) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Bus Number: ");
        int busNumber = scan.nextInt();
        System.out.print("Is the bus AC? (true/false): ");
        boolean ac = scan.nextBoolean();
        System.out.print("Enter the Bus Capacity: ");
        int capacity = scan.nextInt();
        scan.nextLine(); // Consume newline
        System.out.print("Enter Bus Owner's Name: ");
        String owner = scan.nextLine();
        System.out.print("Enter Available Date for the Bus (YYYY-MM-DD): ");
        String date = scan.nextLine();

        buses.add(new Bus(busNumber, ac, capacity, owner, date));
        System.out.println("🚍 --Bus added successfully-- ✨");
    }

    // Method to display available buses
    private static void displayBuses(ArrayList<Bus> buses) {
        if (buses.isEmpty()) {
            System.out.println("❌ No buses available! 🚌");
        } else {
            System.out.println("📋 Available Buses:");
            for (Bus b : buses) {
                b.displaybuses();
            }
        }
    }
}
