package com.pirai.busreservation;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* @author  santhosh
 * @version 14-11-2023
 * @code    Java Program for Bus Reservation System
 */
public class Booking {
	public String passengerName;
	public int busNo;
	public Date date;
	public String destination;
	
	//creating a constructor cause of collecting data
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Name of passenger: ");
		passengerName = scanner.next();
		System.out.println("Enter bus No: ");
		busNo = scanner.nextInt();
		System.out.println("Enter destination: ");
		destination = scanner.next();
		//typeconvertion String to date
		System.out.println("Enter date dd-MM-yyyy");
		String dateInput = scanner.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		//incase of if you didin't give correct formate it causr of parse Exception
		//so used in try catch block
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			System.out.println("ParseException is Handled");
		}
		
	}
	//using isAvailable() method cause of checking for availability 
	//for booking and it return true or false
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
	    // To find the capacity of the given busno
	    int capacity = 0;
	    for (Bus bus : buses) {
	        // If condition is used for checking if the given busno is equal to the current busno
	        if (bus.getDestination().equalsIgnoreCase(destination)&&bus.getBusNo() == busNo)
	            capacity = bus.getCapacity();
	    }
	    int booked = 0;

	    for (Booking b : bookings) {
	        // If condition is used for checking if the given destination is contained in the current booking's destination
	        
	            // If condition is used for checking if the given busno and date are equal to the current busno and date
	            if (b.busNo == busNo && b.date.equals(date)) {
	                booked++;
	            }
	        
	    }
	    // Using ternary operator for checking if booked value is less than capacity
	    // If true, return true; otherwise, return false
	    return booked < capacity ? true : false;
	}
}