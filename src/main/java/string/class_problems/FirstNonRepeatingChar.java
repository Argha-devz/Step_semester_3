package string.assigment_problems;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }
        for (char c : text.toCharArray()) {
            if (freq[c] == 1) return c;
        }
        return '_'; // Indicates none found
    }

    public static void main(String[] args) {
        String[] tests = {"swiss", "aabbcc"};
        for (String test : tests) {
            char result = findFirstNonRepeatingChar(test);
            if (result == '_') {
                System.out.println("\"" + test + "\" -> No Non-Repeating Character Found");
            } else {
                System.out.println("\"" + test + "\" -> First Non-Repeating Character: '" + result + "'");
            }
        }
    }
}