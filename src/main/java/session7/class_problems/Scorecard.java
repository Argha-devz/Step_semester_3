class Scorecard {
    private final boolean[] results;
    private int currentIndex;

    public Scorecard(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.currentIndex = 0;
    }
    public void recordAnswer(boolean isCorrect) {
        if (currentIndex < results.length) {
            results[currentIndex] = isCorrect;
            currentIndex++;
        }
    }
    public int getScore() {
        int score = 0;
        for (int i = 0; i < currentIndex; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }
}
public class Main {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Score: " + sc.getScore()); // 3
    }
}