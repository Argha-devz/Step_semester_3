import java.util.Scanner;

class StudentResult {
    private String name;
    private int[] marks;

    public StudentResult(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        double sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum / marks.length;
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade;
        if (avg >= 75) {
            grade = 'B';
        } else if (avg >= 60) {
            grade = 'C';
        } else if (avg >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String name = scanner.next();
            int[] marks = new int[3];
            for (int i = 0; i < 3; i++) {
                marks[i] = scanner.nextInt();
            }
            StudentResult student = new StudentResult(name, marks);
            student.printResultCard();
        }
        scanner.close();
    }
}