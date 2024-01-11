package backend.handson.q2;

import backend.handson.LogBack;

import java.util.Iterator;

public class Main {
    public static final String FEMALE_GENDER = "Female";
    public static final String MALE_GENDER = "Male";
    public static final String ECONOMY_CLASS = "Economy";
    public static final String BUSINESS_CLASS = "Business";


    public static void main(String[] args) {
        TicketReservation reservation = new TicketReservation();

        // Book some flights
        reservation.bookFlight("Alice", "Smith", 30, FEMALE_GENDER, ECONOMY_CLASS, "C1");
        reservation.bookFlight("Bob", "Johnson", 45, MALE_GENDER, BUSINESS_CLASS, "C2");
        reservation.bookFlight("Charlie", "Lee", 25, MALE_GENDER, ECONOMY_CLASS, "C3");
        reservation.bookFlight("Rob", "Star", 25, MALE_GENDER, ECONOMY_CLASS, "C4");
        // ... (book more flights as needed)

        // Print the confirmed and waiting lists
        LogBack.outputLogger("Confirmed passengers:","INFO");
        printList(reservation.getConfirmedList().iterator());
        LogBack.outputLogger("\nWaiting list passengers:","INFO");
        printList(reservation.getWaitingList().iterator());

        // Cancel a flight
        boolean cancellation = reservation.cancel("C2");
        LogBack.outputLogger("\nCancellation successful: {}" , cancellation ? "SUCCESS" : "FAILURE");

        // Print the updated lists
        LogBack.outputLogger("\nUpdated confirmed passengers:","INFO");
        printList(reservation.getConfirmedList().iterator());
        LogBack.outputLogger("\nUpdated Waiting List passengers:","INFO");
        printList(reservation.getWaitingList().iterator());
    }

    public static void printList(Iterator<Passenger> iterator){
        while (iterator.hasNext()){
            LogBack.outputLogger(iterator.next().getFirstName(),"INFO");
        }
    }
}