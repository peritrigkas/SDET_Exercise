package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BookingServiceTest {

    private BookingService service;

    @BeforeEach
    void setUp() {
        service = new BookingService(
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
    }

    @Test
    void totalWindowsOnBusyDay() {
        int total = service.totalWindowsOn(LocalDate.parse("2025-10-01"));
        System.out.println("Windows on 2025-10-01: " + total);
        assertEquals(26, total);
    }

    @Test
    void totalWindowsOnSingleBookingDay() {
        int total = service.totalWindowsOn(LocalDate.parse("2026-01-10"));
        System.out.println("Windows on 2026-01-10: " + total);
        assertEquals(5, total);
    }

    @Test
    void totalWindowsOnDayWithNoBookings() {
        int total = service.totalWindowsOn(LocalDate.parse("2030-01-01"));
        System.out.println("Windows on 2030-01-01: " + total);
        assertEquals(0, total);
    }

    @Test
    void costOfEachBooking() {
        for (int bookingNumber = 1; bookingNumber <= 4; bookingNumber++) {
            System.out.println("Cost of booking " + bookingNumber + " in GBP: " + service.costOf(bookingNumber));
        }
        assertEquals(9, service.costOf(1));
        assertEquals(10, service.costOf(2));
        assertEquals(15, service.costOf(3));
        assertEquals(17, service.costOf(4));
    }

    @Test
    void costOfUnknownBookingThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.costOf(99));
    }
}
