abstract class ParkingVehicle {
    protected int hours;

    public ParkingVehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getTypeName();
}

class Bike extends ParkingVehicle {
    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10.0; // 10 per hour[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "BIKE";
    }
}

class Car extends ParkingVehicle {
    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        if (hours <= 1) {
            return 30.0;
        } else {
            return 30.0 + (hours - 1) * 20.0; // 30 for first hour, plus 20 for each additional[cite: 3]
        }
    }

    @Override
    public String getTypeName() {
        return "CAR";
    }
}

class Truck extends ParkingVehicle {
    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        double charge = hours * 50.0;
        return Math.max(charge, 100.0); // 50 per hour, minimum charge of 100[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "TRUCK";
    }
}