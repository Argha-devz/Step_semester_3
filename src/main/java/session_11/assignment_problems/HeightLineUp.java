import java.util.Arrays;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        if (heights == null || heights.length == 0) {
            return;
        }

        int n = heights.length;
        int passCount = 1;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + passCount + ": " + Arrays.toString(heights));
            passCount++;

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println();

        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out.println();

        int[] customInput = {6, 3, 8, 2, 9, 1};
        lineUp(customInput);
    }
}