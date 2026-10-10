import java.util.Scanner;

public class LeapYearDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int year = scanner.nextInt();
            boolean isLeap = false;
            if (year % 4 == 0) {
                if (year % 100 == 0) {
                    if (year % 400 == 0) {
                        isLeap = true;
                    }
                } else {
                    isLeap = true;
                }
            }
            if (isLeap) {
                System.out.println("Leap year");
            } else {
                System.out.println("Not a leap year");
            }
        }
        scanner.close();
    }
}