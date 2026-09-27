abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class CardPayment extends Payment {
    public CardPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% processing fee
    }

    @Override
    public String getTypeName() {
        return "CARD";
    }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% processing fee
    }

    @Override
    public String getTypeName() {
        return "WALLET";
    }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount; // No fee
    }

    @Override
    public String getTypeName() {
        return "BANKTRANSFER";
    }
}