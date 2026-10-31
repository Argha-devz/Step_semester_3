import java.util.Arrays;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        if (marks == null || marks.length <= 1) {
            return 0;
        }

        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int swaps1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1) + "  swaps = " + swaps1);

        int[] marks2 = {80, 70, 60};
        int swaps2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2) + "  swaps = " + swaps2);

        int[] customMarks = {30, 85, 20, 95, 65};
        int customSwaps = prizeTable(customMarks);
        System.out.println(Arrays.toString(customMarks) + "  swaps = " + customSwaps);
    }
}