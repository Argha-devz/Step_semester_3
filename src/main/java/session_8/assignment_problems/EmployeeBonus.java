abstract class EmployeeBonus {
    protected String name;
    protected double monthlySalary;

    public EmployeeBonus(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
    public abstract String getTypeName();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends EmployeeBonus {
    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10; // 10% of monthly salary[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "FULLTIME";
    }
}

class PartTimeEmployee extends EmployeeBonus {
    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05; // 5% of monthly salary[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "PARTTIME";
    }
}

class InternEmployee extends EmployeeBonus {
    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000.0; // fixed bonus of 2,000[cite: 3]
    }

    @Override
    public String getTypeName() {
        return "INTERN";
    }
}
