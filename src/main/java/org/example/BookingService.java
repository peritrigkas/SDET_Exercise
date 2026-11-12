package org.example;

import java.time.LocalDate;
import java.util.List;

public class BookingService {

    static final int PRICE_PER_PROPERTY = 5;
    static final int PRICE_PER_WINDOW = 1;

    private final List<Customer> customers;
    private final List<Booking> bookings;

    public BookingService(List<Customer> customers, List<Booking> bookings) {
        this.customers = customers;
        this.bookings = bookings;
    }

    // Feature 1: total windows to be cleaned on a date
    public int totalWindowsOn(LocalDate date) {
        int total = 0;

        for (Booking booking : bookings) {
            if (booking.date().equals(date)) {
                Customer customer = findCustomer(booking.customerNumber());
                total = total + customer.windows();
            }
        }

        return total;
    }

    // Feature 2: cost of a booking = £5 per property + £1 per window
    public int costOf(int bookingNumber) {
        for (Booking booking : bookings) {
            if (booking.number() == bookingNumber) {
                Customer customer = findCustomer(booking.customerNumber());
                return PRICE_PER_PROPERTY + (customer.windows() * PRICE_PER_WINDOW);
            }
        }

        throw new IllegalArgumentException("No booking with number " + bookingNumber);
    }

    private Customer findCustomer(int customerNumber) {
        for (Customer customer : customers) {
            if (customer.number() == customerNumber) {
                return customer;
            }
        }

        throw new IllegalStateException("No customer with number " + customerNumber);
    }
}
