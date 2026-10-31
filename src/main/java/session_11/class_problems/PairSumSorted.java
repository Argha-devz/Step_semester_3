public class PairSumSorted {
    public static class PairResult {
        public boolean found;
        public int first;
        public int second;

        public PairResult(boolean found, int first, int second) {
            this.found = found;
            this.first = first;
            this.second = second;
        }
    }

    public static PairResult pairSumSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new PairResult(true, nums[left], nums[right]);
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new PairResult(false, 0, 0);
    }
}