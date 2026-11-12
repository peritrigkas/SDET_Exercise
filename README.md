# SDET_Exercise: Window Cleaner Booking System

A small in-memory customer and booking system for a window cleaner (SDET coding exercise, Part 1).
There is no user interface, database or HTTP API. The code is run through `Main` or the unit tests.

## What is implemented

### Data model (`src/main/java/org/example`)

| Class | Fields | Purpose |
|---|---|---|
| `Customer` (record) | `number`, `name`, `windows` | A customer and the number of windows at their property |
| `Booking` (record) | `number`, `customerNumber`, `date` | A booking made by a customer for a given date |

Sample data used in `Main` and the tests:

| Customer | Name | Windows |
|---|---|---|
| 1 | John | 10 |
| 2 | Paul | 5 |
| 3 | Ringo | 12 |
| 4 | George | 4 |

| Booking | Customer | Date |
|---|---|---|
| 1 | 4 | 2025-10-01 |
| 2 | 2 | 2026-01-10 |
| 3 | 1 | 2025-10-01 |
| 4 | 3 | 2025-10-01 |

### Features (`BookingService`)

1. **`totalWindowsOn(LocalDate date)`** returns the total number of windows to be cleaned on a date.
   It returns `0` if there are no bookings that day. For 2025-10-01 the result is `26`.
2. **`costOf(int bookingNumber)`** returns the cost of a booking: **£5 per property + £1 per window**.
   For bookings 1 to 4 the results are £9, £10, £15 and £17.
   - An unknown booking number throws `IllegalArgumentException`.
   - A booking that refers to a missing customer throws `IllegalStateException`.

## Requirements

- Java 21
- Maven 3.6+ (or run from an IDE such as IntelliJ IDEA)

## Running the tests

```bash
mvn test
```

The `BookingServiceTest` class has 5 tests:

- total windows on a busy day (26)
- total windows on a single-booking day (5)
- total windows on a day with no bookings (0)
- cost of each booking (9, 10, 15, 17)
- cost of an unknown booking throws `IllegalArgumentException`

Results are written to `target/surefire-reports`. In an IDE, right-click `BookingServiceTest` and choose **Run**.

## Running the booking service from `Main`

`Main` builds the sample data and prints the results of both features:

```
Windows on 2025-10-01: 26
Cost of booking 1 in GBP: 9
```

From the command line:

```bash
mvn compile
java -cp target/classes org.example.Main
```

Or run `Main.main()` from the IDE with the green run arrow next to `main`.

## Project layout

```
src/main/java/org/example/
    Booking.java          booking record
    Customer.java         customer record
    BookingService.java   the two features
    Main.java             runnable demo
src/test/java/org/example/
    BookingServiceTest.java
pom.xml
```
