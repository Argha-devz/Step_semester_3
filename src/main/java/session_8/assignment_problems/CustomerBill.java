abstract class CustomerBill {
    protected double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class StudentBill extends CustomerBill {
    public StudentBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90; // 10% discount
    }

    @Override
    public String getTypeName() {
        return "STUDENT";
    }
}

class StaffBill extends CustomerBill {
    public StaffBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95; // 5% discount
    }

    @Override
    public String getTypeName() {
        return "STAFF";
    }
}

class GuestBill extends CustomerBill {
    public GuestBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10.0; // full amount plus 10 service charge
    }

    @Override
    public String getTypeName() {
        return "GUEST";
    }
}