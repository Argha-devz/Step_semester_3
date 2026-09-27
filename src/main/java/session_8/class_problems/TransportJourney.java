abstract class TransportJourney {
    protected double distance;

    public TransportJourney(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTypeName();
}

class BusJourney extends TransportJourney {
    public BusJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        double fare = 2.0 + (0.10 * distance);
        return Math.min(fare, 10.0); // Max fare is $10
    }

    @Override
    public String getTypeName() {
        return "BUS";
    }
}

class TrainJourney extends TransportJourney {
    public TrainJourney(double distance) {
        super(distance);
    }

    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }

    @Override
    public String getTypeName() {
        return "TRAIN";
    }
}

class MetroJourney extends TransportJourney {
    private double peakHourFactor;

    public MetroJourney(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getTypeName() {
        return "METRO";
    }
}