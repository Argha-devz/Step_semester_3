class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String initialCombination) {
        this.lockerNumber = lockerNumber;
        this.combination = initialCombination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combination.equals(currentCode)) {
            this.combination = newCode;
            return true;
        }
        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class Main {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        boolean res1 = l.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\", \"5678\") -> " + (res1 ? "success" : "rejected"));
        boolean res2 = l.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\", \"9999\") -> " + (res2 ? "success" : "rejected, code is still \"5678\""));
    }
}