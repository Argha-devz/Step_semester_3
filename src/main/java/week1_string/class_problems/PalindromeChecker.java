package string.assigment_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left++) != text.charAt(right--)) return false;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    public static void main(String[] args) {
        String[] testWords = {"madam", "hello"};
        for (String word : testWords) {
            boolean iter = isPalindromeIterative(word);
            boolean rec = isPalindromeRecursive(word);
            boolean arr = isPalindromeArrayReversal(word);
            System.out.println("\"" + word + "\" -> Iterative: " + (iter ? "Palindrome" : "Not Palindrome") +
                    " | Recursive: " + (rec ? "Palindrome" : "Not Palindrome") +
                    " | Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome"));
        }
    }
}