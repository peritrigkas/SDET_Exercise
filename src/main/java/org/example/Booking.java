package org.example;

import java.time.LocalDate;

public record Booking(int number, int customerNumber, LocalDate date) {
}
