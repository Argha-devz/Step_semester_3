import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;
    double getTransportFee();
}

abstract class Student {
    protected String name;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateFee();
    public String getName() {
        return name;
    }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000.0 + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 40000.0 + 60000.0;
    }
}

class ScholarStudent extends Student implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double calculateFee() {
        return 20000.0 + getTransportFee();
    }

    @Override
    public double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String token1 = scanner.next();
            String type = token1;
            if (token1.equals("DAY")) {
                String token2 = scanner.next();
                type = token1 + "_" + token2;
            }
            String name = scanner.next();

            Student student = null;
            if (type.equals("DAY_SCHOLAR") || type.equals("DAY SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else if (type.equals("SCHOLAR")) {
                student = new ScholarStudent(name);
            }

            if (student != null) {
                double fee = student.calculateFee();
                totalCollected += fee;
                System.out.printf("%s: %.2f%n", student.getName(), fee);
            }
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
        scanner.close();
    }
}