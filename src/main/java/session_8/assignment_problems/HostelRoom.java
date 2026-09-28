abstract class HostelRoom {
    protected double units;

    public HostelRoom(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getTypeName();
}

class SingleRoom extends HostelRoom {
    public SingleRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8.0; // 8 per unit[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "SINGLE";
    }
}

class SharedRoom extends HostelRoom {
    private int occupants;

    public SharedRoom(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6.0) / occupants; // 6 per unit, divided equally[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "SHARED";
    }
}

class ACRoom extends HostelRoom {
    public ACRoom(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10.0) + 200.0; // 10 per unit, plus fixed charge of 200[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "AC";
    }
}