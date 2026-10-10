import java.util.Scanner;

public class WordReverserAndPalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;
        String word = scanner.next();

        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(word);
        System.out.println(reversed);

        if (word.equals(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
        scanner.close();
    }
}