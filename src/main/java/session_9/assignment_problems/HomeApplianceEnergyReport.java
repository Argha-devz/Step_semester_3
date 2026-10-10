import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;
    protected boolean saverRequested;

    public Appliance(double hours, boolean saverRequested) {
        this.hours = hours;
        this.saverRequested = saverRequested;
    }

    public abstract double getPower();
    public abstract boolean supportsSaver();

    public double calculateUnits() {
        double units = (getPower() * hours) / 1000.0;
        if (saverRequested && supportsSaver() && this instanceof SaverMode) {
            units = ((SaverMode) this).applySaver(units);
        }
        return units;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 150.0;
    }

    @Override
    public boolean supportsSaver() {
        return false;
    }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 1500.0;
    }

    @Override
    public boolean supportsSaver() {
        return true;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    public TV(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 100.0;
    }

    @Override
    public boolean supportsSaver() {
        return false;
    }
}

class WashingMachine extends Appliance implements SaverMode {
    public WashingMachine(double hours, boolean saverRequested) {
        super(hours, saverRequested);
    }

    @Override
    public double getPower() {
        return 500.0;
    }

    @Override
    public boolean supportsSaver() {
        return true;
    }

    @Override
    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String appName = scanner.next();
            double hours = scanner.nextDouble();
            boolean saverRequested = false;
            if (scanner.hasNext()) {
                String nextToken = scanner.next();
                if (nextToken.equals("SAVER")) {
                    saverRequested = true;
                }
            }

            Appliance appliance = null;
            if (appName.equals("FRIDGE")) {
                appliance = new Fridge(hours, saverRequested);
            } else if (appName.equals("AC")) {
                appliance = new AirConditioner(hours, saverRequested);
            } else if (appName.equals("TV")) {
                appliance = new TV(hours, saverRequested);
            } else if (appName.equals("WASHER")) {
                appliance = new WashingMachine(hours, saverRequested);
            }

            if (appliance != null) {
                if (saverRequested && !appliance.supportsSaver()) {
                    System.out.println(appName + ": saver mode not supported");
                    continue;
                }
                double units = appliance.calculateUnits();
                double cost = units * 8.0;
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f%n", appName, units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
        scanner.close();
    }
}
