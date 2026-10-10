import java.util.Scanner;

interface NightService {
    double applyNightSurge(double baseFare);
}

abstract class Cab {
    protected int km;
    protected static final double MIN_FARE = 100.0;

    public Cab(int km) {
        this.km = km;
    }

    public abstract double calculateBaseFare();
}

class MiniCab extends Cab {
    public MiniCab(int km) {
        super(km);
    }

    @Override
    public double calculateBaseFare() {
        double fare = km * 10.0;
        return Math.max(fare, MIN_FARE);
    }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(int km) {
        super(km);
    }

    @Override
    public double calculateBaseFare() {
        double fare = km * 14.0;
        return Math.max(fare, MIN_FARE);
    }

    @Override
    public double applyNightSurge(double baseFare) {
        return baseFare * 1.2;
    }
}

class SUVCab extends Cab implements NightService {
    public SUVCab(int km) {
        super(km);
    }

    @Override
    public double calculateBaseFare() {
        double fare = km * 18.0;
        return Math.max(fare, MIN_FARE);
    }

    @Override
    public double applyNightSurge(double baseFare) {
        return baseFare * 1.2;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String cabType = scanner.next();
            int km = scanner.nextInt();
            String time = scanner.next();

            if (cabType.equals("MINI") && time.equals("NIGHT")) {
                System.out.println("MINI: night service not available");
                continue;
            }

            Cab cab = null;
            if (cabType.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equals("SUV")) {
                cab = new SUVCab(km);
            }

            if (cab != null) {
                double fare = cab.calculateBaseFare();
                if (time.equals("NIGHT") && cab instanceof NightService) {
                    fare = ((NightService) cab).applyNightSurge(fare);
                }
                total += fare;
                System.out.printf("%s: %.2f%n", cabType, fare);
            }
        }
        System.out.printf("Total: %.2f%n", total);
        scanner.close();
    }
}