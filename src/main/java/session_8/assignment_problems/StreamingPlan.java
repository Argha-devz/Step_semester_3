import java.time.LocalDate;

abstract class StreamingPlan {
    protected String name;
    protected String startDateStr;

    public StreamingPlan(String name, String startDateStr) {
        this.name = name;
        this.startDateStr = startDateStr;
    }

    public abstract int getValidityDays();

    public String calculateRenewalDate() {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate renewalDate = startDate.plusDays(getValidityDays());
        return renewalDate.toString();
    }

    public String getName() {
        return name;
    }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 30; // 30 days validity[cite: 3]
    }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 90; // 90 days validity[cite: 3]
    }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String name, String startDateStr) {
        super(name, startDateStr);
    }

    @Override
    public int getValidityDays() {
        return 365; // 365 days validity[cite: 3]
    }
}