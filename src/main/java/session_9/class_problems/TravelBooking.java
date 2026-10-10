import java.util.Scanner;

abstract class TravelBookingItem {
    protected double distance;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBookingItem(double distance) {
        this.distance = distance;
    }

    public abstract double calculateBaseFare();

    public double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBookingItem {
    public BusBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 2.0;
    }
}

class TrainBooking extends TravelBookingItem {
    public TrainBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return distance * 1.5;
    }
}

class FlightBooking extends TravelBookingItem {
    public FlightBooking(double distance) {
        super(distance);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distance * 4.0);
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            TravelBookingItem booking = null;
            if (mode.equals("BUS")) {
                booking = new BusBooking(distance);
            } else if (mode.equals("TRAIN")) {
                booking = new TrainBooking(distance);
            } else if (mode.equals("FLIGHT")) {
                booking = new FlightBooking(distance);
            }

            if (booking != null) {
                double total = booking.calculateTotal();
                System.out.printf("%s: %.2f%n", mode, total);
            }
        }
        scanner.close();
    }
}
