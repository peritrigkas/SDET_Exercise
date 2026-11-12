package org.example;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookingService service = new BookingService(
                List.of(
                        new Customer(1, "John", 10),
                        new Customer(2, "Paul", 5),
                        new Customer(3, "Ringo", 12),
                        new Customer(4, "George", 4)),
                List.of(
                        new Booking(1, 4, LocalDate.parse("2025-10-01")),
                        new Booking(2, 2, LocalDate.parse("2026-01-10")),
                        new Booking(3, 1, LocalDate.parse("2025-10-01")),
                        new Booking(4, 3, LocalDate.parse("2025-10-01"))));

        System.out.println("Windows on 2025-10-01: " + service.totalWindowsOn(LocalDate.parse("2025-10-01")));
        System.out.println("Cost of booking 1 in GBP: " + service.costOf(1));
    }
}
