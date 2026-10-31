import java.util.HashSet;
import java.util.Set;

public class PairTargetSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int x : nums) {
            int complement = target - x;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(x);
        }
        return false;
    }
}