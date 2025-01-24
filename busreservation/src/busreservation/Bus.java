package busreservation;

public class Bus {
    private int busNumber;      // Unique bus number
    private boolean ac;         // Whether the bus is AC or non-AC
    private int capacity;       // Total seat capacity
    private String owner;       // Owner's name
    private String date;        // Available date for the bus

    // Constructor to initialize a bus
    public Bus(int busNumber, boolean ac, int capacity, String owner, String date) {
        this.busNumber = busNumber;
        this.ac = ac;
        this.capacity = capacity;
        this.owner = owner;
        this.date = date;
    }

    // Getter for bus number
    public int getBusNumber() {
        return busNumber;
    }

    // Getter for AC status
    public boolean isAc() {
        return ac;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Setter for capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter for owner's name
    public String getOwner() {
        return owner;
    }

    // Getter for the date
    public String getDate() {
        return date;
    }

    // Method to display bus details
    public void displaybuses() {
        System.out.println("🚍 Bus Number: " + busNumber +
                           ", AC: " + (ac ? "Yes" : "No") +
                           ", Available Seats: " + capacity +
                           ", Owner: " + owner +
                           ", Date: " + date);
    }
}
