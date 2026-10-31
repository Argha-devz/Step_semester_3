import java.util.Arrays;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        int[] count = new int[7];

        for (int roll : rolls) {
            count[roll]++;
        }

        StringBuilder countsOutput = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            countsOutput.append(v).append(":").append(count[v]);
            if (v < 6) {
                countsOutput.append("  ");
            }
        }
        System.out.println(countsOutput.toString());

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            while (count[v] > 0) {
                sorted[idx++] = v;
                count[v]--;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] sampleRolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sortedSample = diceSort(sampleRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedSample));

        System.out.println();

        int[] customRolls = {3, 3, 2, 5, 6, 1, 2, 3};
        int[] sortedCustom = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}