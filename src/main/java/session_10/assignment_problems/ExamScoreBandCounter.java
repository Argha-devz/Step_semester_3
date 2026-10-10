public class ExamScoreBandCounter {
    public static int countInBand(int[] scores, int low, int high) {
        int first = findFirstGreaterOrEqual(scores, low);
        if (first == -1) return 0;
        int last = findFirstGreaterThan(scores, high);
        if (last == -1) last = scores.length;
        return last - first;
    }

    private static int findFirstGreaterOrEqual(int[] scores, int target) {
        int left = 0, right = scores.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int findFirstGreaterThan(int[] scores, int target) {
        int left = 0, right = scores.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}