package control_flow.assigment_problems;

public class VotingChecker {
    public static void checkVotingEligibility(int age) {
        boolean isEligible = (age >= 18);
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        checkVotingEligibility(20);
        checkVotingEligibility(16);
    }
}
```[cite: 3]
