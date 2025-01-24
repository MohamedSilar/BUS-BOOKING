# Bus-booking

Bus Reservation System
A simple Bus Reservation System built using Java. This system allows users to book tickets for buses, with various validations in place to ensure correct inputs and availability.

Features:
Bus Information: Displays details about available buses such as bus number, AC/non-AC status, travel date, and bus owner.
Booking Process: Allows users to book tickets by providing their name, selecting the bus, and specifying the date of travel.
AC Preference Validation: Ensures that users are only booking AC buses, as only AC buses are available in this system.
Bus Owner Verification: Ensures that users input the correct bus owner's details before proceeding with the booking.
Date Availability Check: Validates that the bus is available on the selected travel date.
Error Handling: Provides clear error messages for invalid inputs, such as incorrect bus numbers, bus owner names, or non-AC bookings.
How It Works:
The system displays available buses with their details.
Users can choose to book tickets by entering their name, bus number, travel date, and bus owner information.
The system verifies that the bus is available on the selected date, checks if the bus is an AC bus (since only AC buses are available), and ensures that the bus owner’s name matches.
If everything is correct, the booking is confirmed, and the seat is booked.
If any error occurs, the user is prompted with a helpful message.
Technologies Used:
Java: Object-oriented programming language.
ArrayList: Used to manage the buses and bookings.
Scanner: For taking input from the user.
Setup:
Clone this repository to your local machine.
Compile and run the Busdemo.java class.
Follow the prompts to book your tickets.
